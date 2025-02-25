package com.wanbang.common;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 库存操作日志表
 * @TableName inventory_log
 */
@Data
public class InventoryLog {
    /**
     * 日志ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 库存项ID
     */
    private Long inventoryItemId;

    /**
     * 操作类型（1=入库 2=出库 3=调拨）
     */
    private Integer operationType;

    /**
     * 数量变化
     */
    private Integer quantityChange;

    /**
     * 操作人ID
     */
    private Long operatorId;

    /**
     * 源仓库编码
     */
    private Integer sourceWarehouse;

    /**
     * 目标仓库编码
     */
    private Integer targetWarehouse;

    /**
     * 操作备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}