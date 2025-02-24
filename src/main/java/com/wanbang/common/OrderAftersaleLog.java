package com.wanbang.common;

import java.math.BigDecimal;
import lombok.Data;

/**
 * 订单售后日志表
 * @TableName order_aftersale_log
 */
@Data
public class OrderAftersaleLog {
    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 售后类型（1=买多退货退款 2=买少补货补款）
     */
    private Integer aftersaleType;

    /**
     * 售后状态（1=新建 2=已解决）
     */
    private Integer aftersaleStatus;

    /**
     * 数量变化（负数表示退货，正数表示补货）
     */
    private Integer quantityChange;

    /**
     * 金额变化（负数表示退款，正数表示补款）
     */
    private BigDecimal amountChange;

    /**
     * 处理结果说明
     */
    private String resolutionResult;

    /**
     * 售后处理人ID
     */
    private Long aftersaleOperator;

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
        OrderAftersaleLog other = (OrderAftersaleLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getAftersaleType() == null ? other.getAftersaleType() == null : this.getAftersaleType().equals(other.getAftersaleType()))
            && (this.getAftersaleStatus() == null ? other.getAftersaleStatus() == null : this.getAftersaleStatus().equals(other.getAftersaleStatus()))
            && (this.getQuantityChange() == null ? other.getQuantityChange() == null : this.getQuantityChange().equals(other.getQuantityChange()))
            && (this.getAmountChange() == null ? other.getAmountChange() == null : this.getAmountChange().equals(other.getAmountChange()))
            && (this.getResolutionResult() == null ? other.getResolutionResult() == null : this.getResolutionResult().equals(other.getResolutionResult()))
            && (this.getAftersaleOperator() == null ? other.getAftersaleOperator() == null : this.getAftersaleOperator().equals(other.getAftersaleOperator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getAftersaleType() == null) ? 0 : getAftersaleType().hashCode());
        result = prime * result + ((getAftersaleStatus() == null) ? 0 : getAftersaleStatus().hashCode());
        result = prime * result + ((getQuantityChange() == null) ? 0 : getQuantityChange().hashCode());
        result = prime * result + ((getAmountChange() == null) ? 0 : getAmountChange().hashCode());
        result = prime * result + ((getResolutionResult() == null) ? 0 : getResolutionResult().hashCode());
        result = prime * result + ((getAftersaleOperator() == null) ? 0 : getAftersaleOperator().hashCode());
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
        sb.append(", aftersaleType=").append(aftersaleType);
        sb.append(", aftersaleStatus=").append(aftersaleStatus);
        sb.append(", quantityChange=").append(quantityChange);
        sb.append(", amountChange=").append(amountChange);
        sb.append(", resolutionResult=").append(resolutionResult);
        sb.append(", aftersaleOperator=").append(aftersaleOperator);
        sb.append("]");
        return sb.toString();
    }
}