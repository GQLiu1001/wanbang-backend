package com.wanbang.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AftersaleOrderLogResp {
    @JsonProperty("order_item_id")
    private Long orderItemId;

    @JsonProperty("quantity_change")
    private Integer quantityChange;

    @JsonProperty("amount_change")
    private Double amountChange;

}
