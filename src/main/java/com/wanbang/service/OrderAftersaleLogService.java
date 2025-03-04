package com.wanbang.service;

import com.wanbang.common.ItemAftersaleChange;
import com.wanbang.common.OrderAftersaleLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanbang.req.AftersalePostReq;
import com.wanbang.resp.AftersaleLogDetailResp;

import java.util.List;

/**
* @author 11965
* @description 针对表【order_aftersale_log(订单售后日志表)】的数据库操作Service
* @createDate 2025-03-03 08:41:33
*/
public interface OrderAftersaleLogService extends IService<OrderAftersaleLog> {


    Integer addLog(AftersalePostReq req, ItemAftersaleChange item);

    void changeStatus(Long id);

    List<AftersaleLogDetailResp> getAftersaleList(Integer orderId);
}
