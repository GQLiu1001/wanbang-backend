package com.wanbang.common;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO)
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


}