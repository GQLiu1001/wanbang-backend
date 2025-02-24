package com.wanbang.common;

import java.util.Date;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InventoryLog other = (InventoryLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInventoryItemId() == null ? other.getInventoryItemId() == null : this.getInventoryItemId().equals(other.getInventoryItemId()))
            && (this.getOperationType() == null ? other.getOperationType() == null : this.getOperationType().equals(other.getOperationType()))
            && (this.getQuantityChange() == null ? other.getQuantityChange() == null : this.getQuantityChange().equals(other.getQuantityChange()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getSourceWarehouse() == null ? other.getSourceWarehouse() == null : this.getSourceWarehouse().equals(other.getSourceWarehouse()))
            && (this.getTargetWarehouse() == null ? other.getTargetWarehouse() == null : this.getTargetWarehouse().equals(other.getTargetWarehouse()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInventoryItemId() == null) ? 0 : getInventoryItemId().hashCode());
        result = prime * result + ((getOperationType() == null) ? 0 : getOperationType().hashCode());
        result = prime * result + ((getQuantityChange() == null) ? 0 : getQuantityChange().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getSourceWarehouse() == null) ? 0 : getSourceWarehouse().hashCode());
        result = prime * result + ((getTargetWarehouse() == null) ? 0 : getTargetWarehouse().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", inventoryItemId=").append(inventoryItemId);
        sb.append(", operationType=").append(operationType);
        sb.append(", quantityChange=").append(quantityChange);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", sourceWarehouse=").append(sourceWarehouse);
        sb.append(", targetWarehouse=").append(targetWarehouse);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}