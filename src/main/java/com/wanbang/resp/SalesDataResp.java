package com.wanbang.resp;

import lombok.Data;
//销售表格 一段时间的每个月营业额
@Data
public class SalesDataResp {
    private String[] dates;//横坐标时间
    private Integer[] salesValue;//纵坐标数量
}
