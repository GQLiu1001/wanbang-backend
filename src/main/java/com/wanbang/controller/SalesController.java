package com.wanbang.controller;

import com.wanbang.common.Result;
import com.wanbang.resp.SalesTrendResp;
import com.wanbang.resp.TopSoldItemsResp;
import com.wanbang.service.OrderInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "获取卖品相关信息接口")
@RequestMapping("/api/sales")
@RestController
public class SalesController {
    @Resource
    private OrderInfoService orderInfoService;
    @Operation(summary = "获取最热门的五件卖品")
    @GetMapping
    public Result<List<TopSoldItemsResp>> TopSales(){
        List<TopSoldItemsResp> itemsResp = orderInfoService.TopSales();
        if (itemsResp != null) {
            return Result.success(itemsResp);
        }
        return Result.fail();
    }
    @Operation(summary = "获取销售趋势表单")
    @GetMapping("/trend/{year}/{month}")
    public Result<SalesTrendResp> TopSalesTrend(
            @PathVariable("year") String year , @PathVariable("month") String month){
        SalesTrendResp resp = orderInfoService.TopSalesTrend(year,month);
        if (resp != null) {
            return Result.success(resp);
        }
        return Result.fail();
    }
}
