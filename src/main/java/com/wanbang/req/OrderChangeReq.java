package com.wanbang.req;

import com.wanbang.common.OrderInfo;
import lombok.Data;
//修改订单
@Data
public class OrderChangeReq {
    private OrderInfo orderInfo;
}
