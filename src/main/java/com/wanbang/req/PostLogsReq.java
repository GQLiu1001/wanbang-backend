package com.wanbang.req;

import com.wanbang.common.InventoryItem;
import lombok.Data;
//创建入库
@Data
public class PostLogsReq {
    private InventoryItem item;
}
