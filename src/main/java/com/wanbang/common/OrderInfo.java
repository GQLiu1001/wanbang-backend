package com.wanbang.common;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单服务表
 * @TableName order_info
 */
@Data
public class OrderInfo {
    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 订单编号（雪花算法生成）
     */
    private String orderNo;

    /**
     * 库存商品ID
     */
    private Long itemId;

    /**
     * 原始购买数量
     */
    private Integer quantity;

    /**
     * 调整后的数量（多退少补后）
     */
    private Integer adjustedQuantity;

    /**
     * 原始订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 调整后的总金额（多退少补后）
     */
    private BigDecimal adjustedAmount;

    /**
     * 客户手机号
     */
    private String customerPhone;

    /**
     * 操作人ID
     */
    private Long operatorId;

    /**
     * 订单备注
     */
    private String orderRemark;

    /**
     * 售后类型（1=买多退货退款 2=买少补货补款）
     */
    private Integer aftersaleType;

    /**
     * 售后状态（1=新建 2=已解决）
     */
    private Integer aftersaleStatus;

    /**
     * 处理结果说明
     */
    private String resolutionResult;

    /**
     * 售后处理人ID
     */
    private Long aftersaleOperator;

    /**
     * 订单创建时间
     */
    private Date orderCreateTime;

    /**
     * 订单更新时间
     */
    private Date orderUpdateTime;

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
        OrderInfo other = (OrderInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getAdjustedQuantity() == null ? other.getAdjustedQuantity() == null : this.getAdjustedQuantity().equals(other.getAdjustedQuantity()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getAdjustedAmount() == null ? other.getAdjustedAmount() == null : this.getAdjustedAmount().equals(other.getAdjustedAmount()))
            && (this.getCustomerPhone() == null ? other.getCustomerPhone() == null : this.getCustomerPhone().equals(other.getCustomerPhone()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getOrderRemark() == null ? other.getOrderRemark() == null : this.getOrderRemark().equals(other.getOrderRemark()))
            && (this.getAftersaleType() == null ? other.getAftersaleType() == null : this.getAftersaleType().equals(other.getAftersaleType()))
            && (this.getAftersaleStatus() == null ? other.getAftersaleStatus() == null : this.getAftersaleStatus().equals(other.getAftersaleStatus()))
            && (this.getResolutionResult() == null ? other.getResolutionResult() == null : this.getResolutionResult().equals(other.getResolutionResult()))
            && (this.getAftersaleOperator() == null ? other.getAftersaleOperator() == null : this.getAftersaleOperator().equals(other.getAftersaleOperator()))
            && (this.getOrderCreateTime() == null ? other.getOrderCreateTime() == null : this.getOrderCreateTime().equals(other.getOrderCreateTime()))
            && (this.getOrderUpdateTime() == null ? other.getOrderUpdateTime() == null : this.getOrderUpdateTime().equals(other.getOrderUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getAdjustedQuantity() == null) ? 0 : getAdjustedQuantity().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getAdjustedAmount() == null) ? 0 : getAdjustedAmount().hashCode());
        result = prime * result + ((getCustomerPhone() == null) ? 0 : getCustomerPhone().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getOrderRemark() == null) ? 0 : getOrderRemark().hashCode());
        result = prime * result + ((getAftersaleType() == null) ? 0 : getAftersaleType().hashCode());
        result = prime * result + ((getAftersaleStatus() == null) ? 0 : getAftersaleStatus().hashCode());
        result = prime * result + ((getResolutionResult() == null) ? 0 : getResolutionResult().hashCode());
        result = prime * result + ((getAftersaleOperator() == null) ? 0 : getAftersaleOperator().hashCode());
        result = prime * result + ((getOrderCreateTime() == null) ? 0 : getOrderCreateTime().hashCode());
        result = prime * result + ((getOrderUpdateTime() == null) ? 0 : getOrderUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", itemId=").append(itemId);
        sb.append(", quantity=").append(quantity);
        sb.append(", adjustedQuantity=").append(adjustedQuantity);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", adjustedAmount=").append(adjustedAmount);
        sb.append(", customerPhone=").append(customerPhone);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", orderRemark=").append(orderRemark);
        sb.append(", aftersaleType=").append(aftersaleType);
        sb.append(", aftersaleStatus=").append(aftersaleStatus);
        sb.append(", resolutionResult=").append(resolutionResult);
        sb.append(", aftersaleOperator=").append(aftersaleOperator);
        sb.append(", orderCreateTime=").append(orderCreateTime);
        sb.append(", orderUpdateTime=").append(orderUpdateTime);
        sb.append("]");
        return sb.toString();
    }
}