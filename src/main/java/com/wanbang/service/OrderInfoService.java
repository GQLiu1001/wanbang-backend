package com.wanbang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanbang.common.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanbang.common.OrderItem;
import com.wanbang.dto.OrderInfoDTO;
import com.wanbang.req.OrderItemChangeReq;
import com.wanbang.req.OrderPostReq;
import com.wanbang.resp.SalesTrendResp;
import com.wanbang.resp.TodaySaleAmountResp;
import com.wanbang.resp.TopSoldItemsResp;
import com.wanbang.resp.TotalSaleAmountResp;


import java.math.BigDecimal;
import java.util.List;

/**
* @author 11965
* @description 针对表【order_info(订单主表)】的数据库操作Service
* @createDate 2025-03-03 08:41:33
*/
public interface OrderInfoService extends IService<OrderInfo> {
    List<TopSoldItemsResp> TopSales();

    List<SalesTrendResp> TopSalesTrend(Integer year, Integer month, Integer length);

    TodaySaleAmountResp getTodaySales(String dateStr);

    TotalSaleAmountResp getTotalSales();
    Long outbound(OrderPostReq orderPostReq);

    IPage<OrderInfoDTO> getOrderList(Integer page, Integer size, String startStr, String endStr, String customerPhone);


    Integer updateOrderItem(OrderItem originItem, BigDecimal subtotal);
}
