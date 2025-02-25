package com.wanbang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanbang.common.LoginDTO;
import com.wanbang.common.SysRole;
import com.wanbang.common.SysUser;
import com.wanbang.common.SysUserRole;
import com.wanbang.mapper.SysUserRoleMapper;
import com.wanbang.resp.LoginResp;
import com.wanbang.service.SysUserService;
import com.wanbang.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author 11965
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2025-02-24 15:24:52
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public LoginResp login(String username, String password) {
        LoginDTO loginDTO = sysUserMapper.login(username,password);
        Integer roleId = loginDTO.getRoleId();
        System.out.println("从数据库查出的loginDTO"+loginDTO);
        LoginResp loginResp = new LoginResp();
        BeanUtils.copyProperties(loginDTO,loginResp);
        loginResp.setRoleKey(roleId == 1 ? "admin":"employee");
        System.out.println("返回给前端的loginResp"+loginResp);
        return loginResp;
    }

    @Override
    public Integer deleteUser(Long id) {
        int i = sysUserMapper.deleteById(id);
        System.out.println("sysUserMapper的删除结果"+i);
        return i;
    }

    @Override
    public Integer registry(String username, String password, String phone) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        sysUser.setPhone(phone);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.insert(sysUser);
        if (i <= 0){
            return 0;
        }
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setRoleId(2L);
        int j = sysUserRoleMapper.insert(sysUserRole);
        return i + j;
    }


}




