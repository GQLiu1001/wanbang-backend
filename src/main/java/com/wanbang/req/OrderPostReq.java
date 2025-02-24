package com.wanbang.req;

import com.wanbang.common.OrderInfo;
import lombok.Data;
//创建订单请求
@Data
public class OrderPostReq {
    private String   modelNumber;//产品型号
    private OrderInfo orderInfo;
}
