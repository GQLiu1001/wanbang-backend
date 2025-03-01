package com.wanbang.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
//创建调库记录
@Data
public class PostTransferReq {
    //operate_type 请求参数
    @JsonProperty("inventory_item_id")
    private Integer inventory_item_id;
    @JsonProperty("operator_id")
    private Integer operator_id;
    @JsonProperty("source_warehouse")
    private Integer source_warehouse;
    @JsonProperty("target_warehouse")
    private Integer target_warehouse;
    @JsonProperty("quantity_change")
    private Integer quantity_change;
    private String remark;

}
