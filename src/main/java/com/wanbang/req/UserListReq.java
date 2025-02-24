package com.wanbang.req;

import lombok.Data;
//查询所有用户
@Data
public class UserListReq {
    private int page;
    private int size;
}
