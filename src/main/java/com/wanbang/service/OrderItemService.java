package com.wanbang.service;

import com.wanbang.common.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanbang.req.OrderItemPostReq;

import java.util.List;

/**
* @author 11965
* @description 针对表【order_item(订单项表)】的数据库操作Service
* @createDate 2025-03-03 08:41:33
*/
public interface OrderItemService extends IService<OrderItem> {

    Integer outbound(List<OrderItemPostReq> items,Long orderId);
}
