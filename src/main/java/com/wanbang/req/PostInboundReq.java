package com.wanbang.req;

import com.wanbang.common.InventoryItem;
import com.wanbang.common.InventoryLog;
import lombok.Data;
//创建入库
@Data
public class PostInboundReq {
    private InventoryItem item;
}
