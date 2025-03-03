package com.wanbang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.OrderItem;
import com.wanbang.service.OrderItemService;
import com.wanbang.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

/**
* @author 11965
* @description 针对表【order_item(订单项表)】的数据库操作Service实现
* @createDate 2025-03-03 08:41:33
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>
    implements OrderItemService{

}




