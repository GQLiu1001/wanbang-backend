package com.wanbang.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanbang.common.LoginDTO;
import com.wanbang.common.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanbang.common.UserInfoVO;
import com.wanbang.resp.LoginResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 11965
* @description 针对表【sys_user(系统用户表)】的数据库操作Mapper
* @createDate 2025-02-24 15:24:52
* @Entity com.wanbang.common.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    LoginDTO login(String username, String password);


    IPage<UserInfoVO> selectUserListWithRole(IPage<UserInfoVO> page);


    Integer updateUserAvatar(Integer id, String url);
}




