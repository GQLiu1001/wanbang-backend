package com.wanbang.dto;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

@Data
public class SalesInfoDTO {

    //总共销售数量
    private Integer adjustedQuantity;
    //总共钱数
    private Integer adjustedAmount;
}
