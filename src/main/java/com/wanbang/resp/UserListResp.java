package com.wanbang.resp;

import com.wanbang.common.UserInfoVO;
import lombok.Data;

import java.util.List;

//返回所有用户列表
@Data
public class UserListResp {
    private int total;
    private int page;
    private int size;
    private List<UserInfoVO> items;
}
