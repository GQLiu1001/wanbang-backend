package com.wanbang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.OrderItem;
import com.wanbang.req.OrderItemChangeReq;
import com.wanbang.req.OrderItemPostReq;
import com.wanbang.service.OrderItemService;
import com.wanbang.mapper.OrderItemMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 11965
* @description 针对表【order_item(订单项表)】的数据库操作Service实现
* @createDate 2025-03-03 08:41:33
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>
    implements OrderItemService{
    @Resource
    private OrderItemMapper orderItemMapper;
    @Override
    public Integer outbound(List<OrderItemPostReq> items,Long orderId) {
        items.forEach(item->{
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            BeanUtils.copyProperties(item,orderItem);
            orderItem.setAdjustedQuantity(item.getQuantity());
            orderItem.setCreateTime(new Date());
            orderItem.setUpdateTime(new Date());
            Integer i = orderItemMapper.insert(orderItem);
            System.out.println("order物品插入= " + i);
        });
        return 1;
    }

    @Override
    public List<OrderItem> getDetailList(Long id) {
        LambdaQueryWrapper<OrderItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderItem::getOrderId,id);
        List<OrderItem> orderItems = orderItemMapper.selectList(wrapper);
        System.out.println("orderItems = " + orderItems);
        return orderItems;
    }

    @Override
    public Integer updateOrderItem(Long id, OrderItemChangeReq orderItemChangeReq) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setAdjustedQuantity(orderItemChangeReq.getQuantity());
        orderItem.setPricePerPiece(orderItemChangeReq.getPricePerPiece());
        orderItem.setSubtotal(orderItemChangeReq.getSubtotal());
        orderItem.setUpdateTime(new Date());
        System.out.println("修改后的orderItem = " + orderItem);
        int i = orderItemMapper.updateById(orderItem);
        System.out.println("i = " + i);
        return i;
    }
}




