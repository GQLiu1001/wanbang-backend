package com.wanbang.req;

import lombok.Data;
//查询库存物品列表
//可通过类型和表面查看产品清单
@Data
public class InventoryItemsReq {
    private int page;//第几页
    private int size;//每页多少
    private int category; //什么类型
    private int surface; //什么表面
}
