package com.wanbang.resp;

import com.wanbang.vo.UserInfoVO;
import lombok.Data;

import java.util.List;

//返回所有用户列表
@Data
public class UserListResp {
    private Long total;
    private Long page;
    private Long size;
    private List<UserInfoVO> items;
}
