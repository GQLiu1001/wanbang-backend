package com.wanbang.req;

import lombok.Data;

import java.util.Date;
//查询订单 可选手机号
@Data
public class OrderListReq {
    private int page;//第几页
    private int size;//每页多少
    private Date startTime;
    private Date endTime;
    private String phone;
}
