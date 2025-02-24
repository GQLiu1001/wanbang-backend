package com.wanbang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.InventoryItem;
import com.wanbang.service.InventoryItemService;
import com.wanbang.mapper.InventoryItemMapper;
import org.springframework.stereotype.Service;

/**
* @author 11965
* @description 针对表【inventory_item(瓷砖库存表)】的数据库操作Service实现
* @createDate 2025-02-24 15:24:52
*/
@Service
public class InventoryItemServiceImpl extends ServiceImpl<InventoryItemMapper, InventoryItem>
    implements InventoryItemService{

}




