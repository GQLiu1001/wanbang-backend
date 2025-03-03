package com.wanbang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.OrderInfo;
import com.wanbang.service.OrderInfoService;
import com.wanbang.mapper.OrderInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 11965
* @description 针对表【order_info(订单主表)】的数据库操作Service实现
* @createDate 2025-03-03 08:41:33
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{

}




