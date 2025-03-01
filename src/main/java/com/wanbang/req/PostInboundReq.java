package com.wanbang.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.math.BigDecimal;

//创建入库记录
@Data
public class PostInboundReq {
    //operator_type 为请求参数

    @JsonProperty("operator_id")
    private Integer operatorId;

    @JsonProperty("model_number")
    private String modelNumber;

    private String manufacturer;

    private String specification;

    @JsonProperty("warehouse_num")
    private Integer warehouseNum;

    private Integer category;

    private Integer surface;

    @JsonProperty("total_pieces")
    private Integer totalPieces;

    @JsonProperty("pieces_per_box")
    private Integer piecesPerBox;

    @JsonProperty("price_per_piece")
    private BigDecimal pricePerPiece;

    private String remark;
}
