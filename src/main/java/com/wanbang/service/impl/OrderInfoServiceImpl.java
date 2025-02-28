package com.wanbang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.OrderInfo;
import com.wanbang.dto.SalesInfoDTO;
import com.wanbang.mapper.InventoryItemMapper;
import com.wanbang.resp.SalesTrendResp;
import com.wanbang.resp.TodaySaleAmountResp;
import com.wanbang.resp.TopSoldItemsResp;
import com.wanbang.resp.TotalSaleAmountResp;
import com.wanbang.service.OrderInfoService;
import com.wanbang.mapper.OrderInfoMapper;
import com.wanbang.util.YearMonthUtil;
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
    public List<SalesTrendResp> TopSalesTrend(Integer year, Integer month , Integer length) {
        List<String> dates = YearMonthUtil.format(year, month, length);
        System.out.println(dates);
        List<SalesTrendResp> salesTrendResps = new ArrayList<>();
        dates.forEach(date -> {
            System.out.println(date);
            SalesInfoDTO salesInfoDTO = orderInfoMapper.getTopSalesTrend(date);
            SalesTrendResp salesTrendResp = new SalesTrendResp();
            salesTrendResp.setDates(date);
            if (salesInfoDTO != null) {
                salesTrendResp.setAdjustedAmount(salesInfoDTO.getAdjustedAmount());
            }else {
                salesTrendResp.setAdjustedAmount(0);
            }
            if (salesInfoDTO != null) {
                salesTrendResp.setAdjustedQuantity(salesInfoDTO.getAdjustedQuantity());
            }else {
                salesTrendResp.setAdjustedQuantity(0);
            }
            salesTrendResps.add(salesTrendResp);
            System.out.println(salesTrendResps);
        });
        System.out.println(salesTrendResps);
        return salesTrendResps;
    }

    @Override
    public TodaySaleAmountResp getTodaySales(String dateStr) {
        System.out.println(dateStr);
        TodaySaleAmountResp resp = orderInfoMapper.getTodaySales(dateStr);
        System.out.println(resp);
        return resp;
    }

    @Override
    public TotalSaleAmountResp getTotalSales() {
        TotalSaleAmountResp resp = orderInfoMapper.getTotalSaleAmount();
        System.out.println(resp);
        return resp;
    }


}




