package com.wanbang.req;

import com.wanbang.common.InventoryLog;
import lombok.Data;
//调库创建
@Data
public class PostTransferReq {
    private InventoryLog inventoryLog;
}
