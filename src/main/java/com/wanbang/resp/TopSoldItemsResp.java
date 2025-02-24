package com.wanbang.resp;

import lombok.Data;
//卖得最火的商品
@Data
public class TopSoldItemsResp {
    private String model_number;//产品型号
    private Integer salesAmount;//卖出的数量

}
