package com.wanbang.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanbang.common.InventoryItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanbang.resp.InventoryItemsResp;

import java.util.List;

/**
* @author 11965
* @description 针对表【inventory_item(瓷砖库存表)】的数据库操作Mapper
* @createDate 2025-02-24 15:24:52
* @Entity com.wanbang.common.InventoryItem
*/
public interface InventoryItemMapper extends BaseMapper<InventoryItem> {

    IPage<InventoryItem> selectItemsList(IPage<InventoryItem> pageParam, Integer category, Integer surface);
}




