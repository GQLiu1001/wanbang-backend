package com.wanbang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.OrderInfo;
import com.wanbang.dto.SalesInfoDTO;
import com.wanbang.mapper.InventoryItemMapper;
import com.wanbang.resp.SalesTrendResp;
import com.wanbang.resp.TopSoldItemsResp;
import com.wanbang.service.OrderInfoService;
import com.wanbang.mapper.OrderInfoMapper;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author 11965
* @description 针对表【order_info(订单服务表)】的数据库操作Service实现
* @createDate 2025-02-24 15:24:52
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    public List<TopSoldItemsResp> TopSales() {
        List<TopSoldItemsResp> topSoldItemsResp = orderInfoMapper.TopSales();
        System.out.println(topSoldItemsResp);
        return topSoldItemsResp;
    }

    @Override
    public SalesTrendResp TopSalesTrend(String year, String month) {
        String yearMonth = year + "-" + month;
        System.out.println(yearMonth);
        SalesTrendResp topSalesTrend = orderInfoMapper.getTopSalesTrend(yearMonth);
        System.out.println(topSalesTrend);
        return topSalesTrend;
    }


}




