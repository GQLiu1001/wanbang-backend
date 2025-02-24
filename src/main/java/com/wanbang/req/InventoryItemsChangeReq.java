package com.wanbang.req;

import com.wanbang.common.InventoryItem;
import lombok.Data;
//产品修改
@Data
public class InventoryItemsChangeReq {
    private InventoryItem items;
}
