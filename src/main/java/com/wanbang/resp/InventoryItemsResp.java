package com.wanbang.resp;

import com.wanbang.common.InventoryLog;
import lombok.Data;

import java.util.List;
//返回产品列表
@Data
public class InventoryItemsResp {
    private int total;
    private int page;
    private int size;
    private List<InventoryLog> items;
}
