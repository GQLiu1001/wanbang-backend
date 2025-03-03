package com.wanbang.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.wanbang.common.OrderInfo;
import com.wanbang.common.Result;
import com.wanbang.req.OrderItemPostReq;
import com.wanbang.req.OrderPostReq;
import com.wanbang.service.InventoryItemService;
import com.wanbang.service.InventoryLogService;
import com.wanbang.service.OrderInfoService;
import com.wanbang.service.OrderItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
