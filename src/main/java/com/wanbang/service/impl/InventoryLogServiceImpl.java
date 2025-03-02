package com.wanbang.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.InventoryLog;
import com.wanbang.enums.ResultCode;
import com.wanbang.exception.WanbangException;
import com.wanbang.mapper.InventoryItemMapper;
import com.wanbang.req.PostInboundReq;
import com.wanbang.service.InventoryLogService;
import com.wanbang.mapper.InventoryLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public Integer postInboundLog(Integer operatorId, String modelNumber, Integer operationType , PostInboundReq postInboundReq) {
        InventoryLog inventoryLog = new InventoryLog();
        Long inventoryItemId = inventoryItemMapper.findInventoryItemId(modelNumber);
        if (inventoryItemId == null) {
            throw new WanbangException(ResultCode.FAIL);
        }
        System.out.println("inventoryItemId"+inventoryItemId);
        inventoryLog.setInventoryItemId(inventoryItemId);
        inventoryLog.setOperationType(1);
        inventoryLog.setQuantityChange(postInboundReq.getTotalPieces());
        inventoryLog.setOperatorId(Long.valueOf(operatorId));
        inventoryLog.setTargetWarehouse(postInboundReq.getWarehouseNum());
        inventoryLog.setRemark(postInboundReq.getRemark());
        inventoryLog.setUpdateTime(new Date());
        inventoryLog.setCreateTime(new Date());
        Integer j = inventoryLogMapper.insert(inventoryLog);
        System.out.println("j"+j);
        return j;
    }


}




