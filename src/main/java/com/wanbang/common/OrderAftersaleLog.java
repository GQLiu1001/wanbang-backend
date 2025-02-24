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


}