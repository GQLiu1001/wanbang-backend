package com.wanbang.req;

import com.wanbang.common.InventoryLog;
import lombok.Data;
//修改 入库 调库 出库
@Data
public class InventoryLogChangeReq {
    private InventoryLog inventoryLog;
}
