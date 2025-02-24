package com.wanbang.resp;

import com.wanbang.common.InventoryItem;
import lombok.Data;

import java.util.List;
//返回调库 入库 出库记录resp
@Data
public class InventoryLogResp {
    private int total;
    private int page;
    private int size;
    private List<InventoryItem> items;
}
