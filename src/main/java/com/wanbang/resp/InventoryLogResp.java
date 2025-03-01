package com.wanbang.resp;

import com.wanbang.common.InventoryItem;
import com.wanbang.common.InventoryLog;
import lombok.Data;

import java.util.List;
//返回调库 入库 出库记录resp
@Data
public class InventoryLogResp {
    private Long total;
    private Long page;
    private Long size;
    private List<InventoryLog> items;
}
