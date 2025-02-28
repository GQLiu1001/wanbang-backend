package com.wanbang.mapper;

import com.wanbang.common.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanbang.dto.SalesInfoDTO;
import com.wanbang.resp.SalesTrendResp;
import com.wanbang.resp.TodaySaleAmountResp;
import com.wanbang.resp.TopSoldItemsResp;
import com.wanbang.resp.TotalSaleAmountResp;

import java.util.List;

/**
* @author 11965
* @description 针对表【order_info(订单服务表)】的数据库操作Mapper
* @createDate 2025-02-24 15:24:52
* @Entity com.wanbang.common.OrderInfo
*/
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<TopSoldItemsResp> TopSales();

    SalesInfoDTO getTopSalesTrend(String date);

    TodaySaleAmountResp getTodaySales(String dateStr);

    TotalSaleAmountResp getTotalSaleAmount();
}




