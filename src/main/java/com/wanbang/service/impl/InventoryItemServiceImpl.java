package com.wanbang.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.InventoryItem;
import com.wanbang.req.InventoryItemsChangeReq;
import com.wanbang.req.PostInboundReq;
import com.wanbang.resp.InventoryItemsResp;
import com.wanbang.service.InventoryItemService;
import com.wanbang.mapper.InventoryItemMapper;
import com.wanbang.vo.UserInfoVO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 11965
* @description 针对表【inventory_item(瓷砖库存表)】的数据库操作Service实现
* @createDate 2025-02-24 15:24:52
*/
@Service
public class InventoryItemServiceImpl extends ServiceImpl<InventoryItemMapper, InventoryItem>
    implements InventoryItemService{
    @Resource
    private InventoryItemMapper inventoryItemMapper;
    @Override
    public IPage<InventoryItem> getItems(Integer page, Integer size,Integer category,Integer surface) {
        IPage<InventoryItem> pageParam = new Page<>(page, size);
        IPage<InventoryItem> result = inventoryItemMapper.selectItemsList(pageParam,category,surface);
        System.out.println(result);
        return result;
    }

    @Override
    public Integer changeItems(Integer id, InventoryItemsChangeReq req) {
        InventoryItem item = new InventoryItem();
        BeanUtils.copyProperties(req,item);
        item.setUpdateTime(new Date());
        item.setId(Long.valueOf(id));
        System.out.println(item);
        LambdaUpdateWrapper<InventoryItem> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(InventoryItem::getId, item.getId());
        int update = inventoryItemMapper.update(item, updateWrapper);
        System.out.println(update);
        return update;
    }

    @Override
    public Integer deleteById(Integer id) {
        LambdaUpdateWrapper<InventoryItem> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(InventoryItem::getId, id);
        int update = inventoryItemMapper.delete(wrapper);
        System.out.println(update);
        return update;
    }

    @Override
    public Integer postInboundItem(PostInboundReq postInboundReq) {
        String modelNumber = postInboundReq.getModelNumber();
        LambdaUpdateWrapper<InventoryItem> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(InventoryItem::getModelNumber, modelNumber);
        boolean exists = inventoryItemMapper.exists(wrapper);
        if (exists) {
            Integer k = inventoryItemMapper.updateTotalPieces(modelNumber,postInboundReq.getTotalPieces());
            if (k > 0) {
                return k;
            }
            return 0;
        }else {
            InventoryItem item = new InventoryItem();
            System.out.println(item);
            BeanUtils.copyProperties(postInboundReq, item);
            item.setCreateTime(new Date());
            item.setUpdateTime(new Date());
            int update = inventoryItemMapper.insert(item);
            System.out.println("update:" + update);
            return update;
        }
    }
}




