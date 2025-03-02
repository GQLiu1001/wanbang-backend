package com.wanbang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.InventoryItem;
import com.wanbang.common.InventoryLog;
import com.wanbang.enums.ResultCode;
import com.wanbang.exception.WanbangException;
import com.wanbang.mapper.InventoryItemMapper;
import com.wanbang.req.PostInboundReq;
import com.wanbang.req.PostTransferReq;
import com.wanbang.service.InventoryLogService;
import com.wanbang.mapper.InventoryLogMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
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
    public Integer itemReversal(InventoryLog inventoryLog) {
        // 冲正记录
        System.out.println("需要冲正的记录"+inventoryLog);
        Long inventoryItemId = inventoryLog.getInventoryItemId();
        Integer quantityChange =inventoryLog.getQuantityChange();
        Long operatorId = inventoryLog.getOperatorId();
        Integer sourceWarehouse =inventoryLog.getSourceWarehouse();
        Integer targetWarehouse =inventoryLog.getTargetWarehouse();
        Integer operationType = inventoryLog.getOperationType();

        InventoryLog inventoryLog1 = new InventoryLog();
        inventoryLog1.setInventoryItemId(inventoryItemId);
        inventoryLog1.setOperationType(4);
        inventoryLog1.setOperatorId(operatorId);
        //如果是调库 源库目标库调换 数量不变
        if (operationType == 3){
            inventoryLog1.setQuantityChange(quantityChange);
            inventoryLog1.setSourceWarehouse(targetWarehouse);
            inventoryLog1.setTargetWarehouse(sourceWarehouse);
        }
        //如果是出库 入库 不用改变仓库 数量相反
        inventoryLog1.setQuantityChange(-quantityChange);
        inventoryLog1.setTargetWarehouse(targetWarehouse);
        inventoryLog1.setSourceWarehouse(sourceWarehouse);
        inventoryLog1.setRemark("冲正记录");
        inventoryLog1.setCreateTime(new Date());
        inventoryLog1.setUpdateTime(new Date());
        int insert = inventoryLogMapper.insert(inventoryLog1);
        System.out.println("insert = " + insert);
        return insert;
    }

    @Override
    public Integer postInboundLog(Long operatorId, String modelNumber , PostInboundReq postInboundReq) {
        InventoryLog inventoryLog = new InventoryLog();
        Long inventoryItemId = inventoryItemMapper.findInventoryItemId(modelNumber);
        if (inventoryItemId == null) {
            throw new WanbangException(ResultCode.FAIL);
        }
        System.out.println("inventoryItemId"+inventoryItemId);
        inventoryLog.setInventoryItemId(inventoryItemId);
        inventoryLog.setOperationType(1);
        inventoryLog.setQuantityChange(postInboundReq.getTotalPieces());
        inventoryLog.setOperatorId(operatorId);
        inventoryLog.setTargetWarehouse(postInboundReq.getWarehouseNum());
        inventoryLog.setRemark(postInboundReq.getRemark());
        inventoryLog.setUpdateTime(new Date());
        inventoryLog.setCreateTime(new Date());
        Integer j = inventoryLogMapper.insert(inventoryLog);
        System.out.println("j"+j);
        return j;
    }

    @Override
    public Integer transfer(PostTransferReq postTransferReq) {
        LambdaQueryWrapper<InventoryItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(InventoryItem::getId, postTransferReq.getInventoryItemId());
        InventoryItem inventoryItem = inventoryItemMapper.selectOne(wrapper);

        InventoryLog inventoryLog = new InventoryLog();
        BeanUtils.copyProperties(postTransferReq, inventoryLog);
        inventoryLog.setUpdateTime(new Date());
        inventoryLog.setCreateTime(new Date());
        inventoryLog.setQuantityChange(inventoryItem.getTotalPieces());
        inventoryLog.setOperationType(3);
        System.out.println("inventoryLog = " + inventoryLog);
        Integer j = inventoryLogMapper.insert(inventoryLog);
        System.out.println("j"+j);
        return j;
    }


}




