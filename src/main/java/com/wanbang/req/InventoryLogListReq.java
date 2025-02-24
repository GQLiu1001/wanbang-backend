package com.wanbang.req;

import lombok.Data;

import java.util.Date;
//调库 入库 出库记录查询
@Data
public class InventoryLogListReq {
    private int page;//第几页
    private int size;//每页多少
    private Date startTime;
    private Date endTime;
}
