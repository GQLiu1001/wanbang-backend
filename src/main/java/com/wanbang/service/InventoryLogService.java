package com.wanbang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanbang.common.InventoryLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 11965
* @description 针对表【inventory_log(库存操作日志表)】的数据库操作Service
* @createDate 2025-02-24 15:24:52
*/
public interface InventoryLogService extends IService<InventoryLog> {

    IPage<InventoryLog> getLog(Integer page, Integer size, String startStr, String endStr, Integer operationType);


}
