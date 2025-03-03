package com.wanbang.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanbang.common.OrderInfo;
import com.wanbang.common.OrderItem;
import com.wanbang.common.Result;

import com.wanbang.dto.OrderInfoDTO;
import com.wanbang.req.OrderItemPostReq;
import com.wanbang.req.OrderPostReq;
import com.wanbang.resp.OrderDetailResp;
import com.wanbang.resp.OrderListResp;
import com.wanbang.service.InventoryItemService;
import com.wanbang.service.InventoryLogService;
import com.wanbang.service.OrderInfoService;
import com.wanbang.service.OrderItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SaIgnore
@Tag(name = "订单相关接口")
@RequestMapping("/api/orders")
@RestController
public class OrderController {
    @Resource
    private InventoryItemService inventoryItemService;
    @Resource
    private InventoryLogService inventoryLogService;
    @Resource
    private OrderInfoService orderInfoService;
    @Resource
    private OrderItemService orderItemService;

    @Transactional(rollbackFor = Exception.class)
    @Operation(summary = "创建订单")
    @PostMapping
    public Result addOrder(@RequestBody OrderPostReq orderPostReq) {
        //order_info表单需要:
        //customer_phone operator_id order_remark  total_amount  adjusted_amount
        //aftersale_status
        //order_item表单需要:
        //order_id item_id model_number  quantity price_per_piece subtotal(小记金额)
        //adjusted_quantity
        //创建一个请求之后，先向数据库插入一个log 出库 在log中也要同时修改item
        //log 出库需要什么? inventory_item_id operation_type quantity_change operator_id source_warehouse remark
        //item 修改需要什么? inventory_item_id(id) quantity_change(total_pieces)
        //再向order_info 和 order_item 插入记录
        Integer i = inventoryLogService.outbound(orderPostReq.getItems());
        Integer j = inventoryItemService.outbound(orderPostReq.getItems());
        Long orderId = orderInfoService.outbound(orderPostReq);
        Integer l = orderItemService.outbound(orderPostReq.getItems(),orderId);
        return Result.success();
    }

    @Operation(summary = "查询订单列表")
    @GetMapping
    public Result<OrderListResp> getAllOrders(
            @RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "10") Integer size,
            @RequestParam(value = "start_time",required = false) String startTime,@RequestParam(value = "end_time",required = false) String endTime,
            @RequestParam(value = "customer_phone",required = false) String customerPhone
    ) {
        String startStr = null;
        String endStr = null;
        if (startTime != null ) {

            startStr = startTime.substring(0, 10);
            System.out.println("startStr = " + startStr);
        }
        if (endTime != null ) {

             endStr = endTime.substring(0, 10);
            System.out.println("endStr = " + endStr);
        }

        IPage<OrderInfoDTO> resp= orderInfoService.getOrderList(page,size,startStr,endStr,customerPhone);
        OrderListResp orderListResp = new OrderListResp();
        orderListResp.setItems(resp.getRecords());
        orderListResp.setTotal(resp.getTotal());
        orderListResp.setPage(resp.getCurrent());
        orderListResp.setSize(resp.getSize());
        System.out.println("orderListResp = " + orderListResp);
        return Result.success(orderListResp);

    }

    @Operation(summary = "查询订单详细")
    @GetMapping("/{id}")
    public Result<OrderDetailResp> orderDetail(@PathVariable("id")Long id){
        OrderDetailResp resp = new OrderDetailResp();
        OrderInfo byId = orderInfoService.getById(id);
        System.out.println("byId = " + byId);
        BeanUtils.copyProperties(byId,resp);
        List<OrderItem> list = orderItemService.getDetailList(id);
        System.out.println("list = " + list);
        resp.setItems(list);
        return Result.success(resp);
    }

}
