package com.wanbang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanbang.common.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanbang.common.UserInfoVO;
import com.wanbang.req.UserInfoChangeReq;
import com.wanbang.resp.LoginResp;

import java.util.List;

/**
* @author 11965
* @description 针对表【sys_user(系统用户表)】的数据库操作Service
* @createDate 2025-02-24 15:24:52
*/
public interface SysUserService extends IService<SysUser> {

    LoginResp login(String username, String password);

    Integer deleteUser(Long id);

    Integer registry(String username, String password, String phone);

    Integer changePassword(String username, String phone, String password);

    IPage<UserInfoVO> getUserList(int page, int size);

    Integer updateUser(Long id, UserInfoChangeReq userInfoChangeReq);
}
