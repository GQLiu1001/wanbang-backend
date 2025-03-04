package com.wanbang.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.wanbang.common.Result;
import com.wanbang.req.AftersalePostReq;
import com.wanbang.service.OrderAftersaleLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@SaIgnore
@Tag(name = "售后相关接口")
@RequestMapping("/api/aftersales")
@RestController
@CrossOrigin
public class AftersaleController {
    @Resource
    OrderAftersaleLogService orderAftersaleLogService;

    @Operation(summary = "创建售后")
    @PostMapping
    public Result aftersale(@RequestBody AftersalePostReq req) {
        //  "order_id": 1,
        //  "aftersale_type": 1,
        //  "aftersale_status": 1,
        //  "items": [
        //    {
        //      "order_item_id": 2,
        //      "quantity_change": -5,
        //      "amount_change": -175.00
        //    }
        //  ],
        //  "resolution_result": "客户部分退货",
        //  "aftersale_operator": 1
        return Result.success();


    }
}
