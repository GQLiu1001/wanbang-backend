package com.wanbang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanbang.common.InventoryItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanbang.common.InventoryLog;
import com.wanbang.common.ItemAftersaleChange;
import com.wanbang.req.InventoryItemsChangeReq;
import com.wanbang.req.InventoryLogChangeReq;
import com.wanbang.req.OrderItemPostReq;
import com.wanbang.req.PostInboundReq;
import com.wanbang.resp.InventoryItemsResp;
import com.wanbang.resp.ItemModelResp;

import java.math.BigDecimal;
import java.util.List;

/**
* @author 11965
* @description 针对表【inventory_item(瓷砖库存表)】的数据库操作Service
* @createDate 2025-02-24 15:24:52
*/
public interface InventoryItemService extends IService<InventoryItem> {

    IPage<InventoryItem> getItems(Integer page, Integer size, Integer category, Integer surface);

    Integer changeItems(Integer id, InventoryItemsChangeReq req);

    Integer deleteById(Integer id);

    Integer postInboundItem(PostInboundReq postInboundReq);

    Integer transfer(Integer sourceWarehouse,Long inventoryItemId, Integer targetWarehouse);


    Integer itemReversal(InventoryLog req);

    Integer outbound(List<OrderItemPostReq> items);


    Integer aftersale(ItemAftersaleChange item);

    ItemModelResp getItemModel(String modelNumber);
}
