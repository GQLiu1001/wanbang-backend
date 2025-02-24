package com.wanbang.common;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 瓷砖库存表
 * @TableName inventory_item
 */
@Data
public class InventoryItem {
    /**
     * 库存ID
     */
    private Long id;

    /**
     * 产品型号
     */
    private String modelNumber;

    /**
     * 制造厂商
     */
    private String manufacturer;

    /**
     * 规格（如：600x600mm）
     */
    private String specification;

    /**
     * 表面处理（1=抛光 2=哑光 3=釉面 4=通体大理石 5=微晶石 6=岩板）
     */
    private Integer surface;

    /**
     * 分类（1=墙砖 2=地砖）
     */
    private Integer category;

    /**
     * 仓库编码
     */
    private Integer warehouseNum;

    /**
     * 总片数
     */
    private Integer totalPieces;

    /**
     * 单片价格（单位：元）
     */
    private BigDecimal pricePerPiece;

    /**
     * 每箱片数
     */
    private Integer piecesPerBox;

    /**
     * 备注
     */
    private String remark;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
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
        InventoryItem other = (InventoryItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelNumber() == null ? other.getModelNumber() == null : this.getModelNumber().equals(other.getModelNumber()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getSurface() == null ? other.getSurface() == null : this.getSurface().equals(other.getSurface()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getWarehouseNum() == null ? other.getWarehouseNum() == null : this.getWarehouseNum().equals(other.getWarehouseNum()))
            && (this.getTotalPieces() == null ? other.getTotalPieces() == null : this.getTotalPieces().equals(other.getTotalPieces()))
            && (this.getPricePerPiece() == null ? other.getPricePerPiece() == null : this.getPricePerPiece().equals(other.getPricePerPiece()))
            && (this.getPiecesPerBox() == null ? other.getPiecesPerBox() == null : this.getPiecesPerBox().equals(other.getPiecesPerBox()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModelNumber() == null) ? 0 : getModelNumber().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getSurface() == null) ? 0 : getSurface().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getWarehouseNum() == null) ? 0 : getWarehouseNum().hashCode());
        result = prime * result + ((getTotalPieces() == null) ? 0 : getTotalPieces().hashCode());
        result = prime * result + ((getPricePerPiece() == null) ? 0 : getPricePerPiece().hashCode());
        result = prime * result + ((getPiecesPerBox() == null) ? 0 : getPiecesPerBox().hashCode());
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
        sb.append(", modelNumber=").append(modelNumber);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", specification=").append(specification);
        sb.append(", surface=").append(surface);
        sb.append(", category=").append(category);
        sb.append(", warehouseNum=").append(warehouseNum);
        sb.append(", totalPieces=").append(totalPieces);
        sb.append(", pricePerPiece=").append(pricePerPiece);
        sb.append(", piecesPerBox=").append(piecesPerBox);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}