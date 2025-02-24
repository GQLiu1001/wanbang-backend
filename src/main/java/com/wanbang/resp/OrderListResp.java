package com.wanbang.resp;

import com.wanbang.common.InventoryLog;
import com.wanbang.common.OrderInfo;
import lombok.Data;

import java.util.List;
@Data
public class OrderListResp {
    private int total;
    private int page;
    private int size;
    private List<OrderInfo> items;
}
