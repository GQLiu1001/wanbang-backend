package com.wanbang.req;

import com.wanbang.common.OrderAftersaleLog;
import com.wanbang.common.OrderInfo;
import lombok.Data;
//创建售后订单
@Data
public class AftersalePostReq {
    private OrderAftersaleLog orderAftersaleLog;

}
