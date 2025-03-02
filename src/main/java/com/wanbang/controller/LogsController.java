package com.wanbang.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanbang.common.InventoryLog;
import com.wanbang.common.Result;
import com.wanbang.req.PostInboundReq;
import com.wanbang.req.PostTransferReq;
import com.wanbang.resp.InventoryLogResp;
import com.wanbang.service.InventoryItemService;
import com.wanbang.service.InventoryLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@SaIgnore
@Tag(name = "订单记录相关接口")
@RequestMapping("/api/logs")
@RestController
public class  LogsController {
    @Resource
    private InventoryLogService inventoryLogService;
    @Resource
    private InventoryItemService inventoryItemService;
    @Operation(summary = "查询出入转库记录")
    @GetMapping
    public Result<InventoryLogResp> logs(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "operation_type") Integer operationType,
            @RequestParam(value = "start_time" , required = false) String startStr,
            @RequestParam(value = "end_time", required = false) String endStr
            ) {
        if (startStr != null) {
            startStr = startStr.substring(0, 10);
        }
        System.out.println(startStr);
        if (endStr != null) {
            endStr = endStr.substring(0, 10);
        }
        System.out.println(endStr);
        IPage<InventoryLog> resp =  inventoryLogService.getLog(page,size,startStr,endStr,operationType);
        InventoryLogResp respResp = new InventoryLogResp();
        respResp.setSize(resp.getSize());
        respResp.setPage(resp.getCurrent());
        respResp.setTotal(resp.getTotal());
        respResp.setItems(resp.getRecords());
        System.out.println(respResp);
        return Result.success(respResp);
    }
    @Transactional(rollbackFor = Exception.class)  // 添加这一行
    @Operation(summary = "创建入库记录")
    @PostMapping("/inbound")
    public Result inbound(@RequestBody PostInboundReq postInboundReq) {
        //方法主要有两个作用 1.入库更新items 如果没有就新insert一个
        //                2.创建一个入库logs
        //postInboundReq
        //可去除operator_id 使用到items (inventory_item表)
        // 其中operatorId inventory_item_id(数据库查询出) source_warehouse(warehouseNum) quantity_change(totalPieces) remark(新增log)
        //可重复使用到logs (inventory_log表)
        System.out.println(postInboundReq);
        //先更新库存
        Integer i = inventoryItemService.postInboundItem(postInboundReq);
        System.out.println("i"+i);
        if (i <= 0){
            return Result.fail(i);
        }
        //再根据传入的型号 找到itemId 创建Log
        Integer j = inventoryLogService.postInboundLog(postInboundReq.getOperatorId(),
                postInboundReq.getModelNumber(),postInboundReq);
        System.out.println("j"+j);
        if (j <= 0){
            return Result.fail(j);
        }
        return Result.success();
    }
    @Transactional(rollbackFor = Exception.class)  // 添加这一行
    @Operation(summary = "创建调库记录")
    @PostMapping("/transfer")
    public Result transfer(@RequestBody PostTransferReq postTransferReq) {
        //方法主要有两个作用 1.调库更新items的信息 (改个warehouse_num)
        // (提供了inventory_item_id和quantity_change和source_warehouse和target_warehouse)
        //                2.创建一个log
        if ((postTransferReq.getSourceWarehouse() >=6 || postTransferReq.getSourceWarehouse() <= 0)
                ||
                (postTransferReq.getTargetWarehouse() >=6 || postTransferReq.getTargetWarehouse() <= 0)) {
            return Result.fail();
        }
        System.out.println("postTransferReq = " + postTransferReq);
        Integer i =inventoryItemService.transfer( postTransferReq.getSourceWarehouse(),
                postTransferReq.getInventoryItemId(), postTransferReq.getTargetWarehouse());
        if (i<=0){
            return Result.fail();
        }
            Integer j =inventoryLogService.transfer(postTransferReq);
        if (j<=0){
            return Result.fail(j);
        }
        return Result.success();
    }

}
