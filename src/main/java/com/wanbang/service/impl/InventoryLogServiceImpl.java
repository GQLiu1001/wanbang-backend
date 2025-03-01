package com.wanbang.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.InventoryLog;
import com.wanbang.mapper.InventoryItemMapper;
import com.wanbang.service.InventoryLogService;
import com.wanbang.mapper.InventoryLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author 11965
* @description 针对表【inventory_log(库存操作日志表)】的数据库操作Service实现
* @createDate 2025-02-24 15:24:52
*/
@Service
public class InventoryLogServiceImpl extends ServiceImpl<InventoryLogMapper, InventoryLog>
    implements InventoryLogService{
    @Resource
    private InventoryLogMapper inventoryLogMapper;
    @Resource
    private InventoryItemMapper inventoryItemMapper;
    @Override
    public IPage<InventoryLog> getLog(Integer page, Integer size, String startStr, String endStr, Integer operationType) {
        IPage<InventoryLog> iPage = new Page<>(page, size);
        IPage<InventoryLog> pages = inventoryLogMapper.getLog(iPage,startStr,endStr,operationType);
        System.out.println(pages);
        return pages;
    }


}




