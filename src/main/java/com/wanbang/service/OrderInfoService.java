package com.wanbang.service;

import com.wanbang.common.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanbang.resp.SalesTrendResp;
import com.wanbang.resp.TopSoldItemsResp;

import java.util.List;

/**
* @author 11965
* @description 针对表【order_info(订单服务表)】的数据库操作Service
* @createDate 2025-02-24 15:24:52
*/
public interface OrderInfoService extends IService<OrderInfo> {

    List<TopSoldItemsResp> TopSales();

    List<SalesTrendResp> TopSalesTrend(Integer year, Integer month, Integer length);
}
