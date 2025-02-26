package com.wanbang.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// 销售趋势响应类
@Data
public class SalesTrendResp {
    private List<String> dates; // 日期列表，如 ["2024-09", "2024-10", "2024-11", "2024-12", "2025-01"]
    private List<Integer> salesValues; // 销售数量列表，如 [100, 150, 200, 250, 300]
    @JsonProperty("amounts")
    private List<Integer> adjustedAmounts; // 调整后的销售金额列表，如 [5000, 7500, 10000, 12500, 15000]
}