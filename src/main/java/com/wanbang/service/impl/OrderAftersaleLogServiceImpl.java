package com.wanbang.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.ItemAftersaleChange;
import com.wanbang.common.OrderAftersaleLog;
import com.wanbang.req.AftersalePostReq;
import com.wanbang.service.OrderAftersaleLogService;
import com.wanbang.mapper.OrderAftersaleLogMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author 11965
* @description 针对表【order_aftersale_log(订单售后日志表)】的数据库操作Service实现
* @createDate 2025-03-03 08:41:33
*/
@Service
public class OrderAftersaleLogServiceImpl extends ServiceImpl<OrderAftersaleLogMapper, OrderAftersaleLog>
    implements OrderAftersaleLogService{
    @Resource
    private OrderAftersaleLogMapper orderAftersaleLogMapper;

    @Override
    public Integer addLog(AftersalePostReq req, ItemAftersaleChange item) {
        OrderAftersaleLog orderAftersaleLog = new OrderAftersaleLog();
        BeanUtils.copyProperties(req, orderAftersaleLog);
        orderAftersaleLog.setOrderItemId(item.getOrderItemId());
        BeanUtils.copyProperties(item, orderAftersaleLog);
        orderAftersaleLog.setCreateTime(new Date());
        orderAftersaleLog.setAftersaleOperator(StpUtil.getLoginIdAsLong());
        System.out.println("orderAftersaleLog = " + orderAftersaleLog);
        int i = orderAftersaleLogMapper.insert(orderAftersaleLog);
        System.out.println("对售后订单的每次修改 = " + i);
        return i;
    }
}




