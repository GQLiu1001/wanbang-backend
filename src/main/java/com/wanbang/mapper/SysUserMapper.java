package com.wanbang.mapper;

import com.wanbang.common.LoginDTO;
import com.wanbang.common.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanbang.resp.LoginResp;

/**
* @author 11965
* @description 针对表【sys_user(系统用户表)】的数据库操作Mapper
* @createDate 2025-02-24 15:24:52
* @Entity com.wanbang.common.SysUser
*/
public interface SysUserMapper extends BaseMapper<SysUser> {

    LoginDTO login(String username, String password);
}




