package com.wanbang.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.wanbang.common.Result;
import com.wanbang.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "用户信息接口", description = "用户信息相关接口")
@RequestMapping("/api/users")
@CrossOrigin
@RestController
public class UserController {
    @Resource
    private  SysUserService sysUserService;
    @SaCheckRole("admin")
    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        List<String> roleList = StpUtil.getRoleList(id);
        System.out.println(roleList);
        StpUtil.checkRole("admin");
        Integer i = sysUserService.deleteUser(id);
        if (i > 0) {
            return Result.success();
        }
        return Result.fail();
    }
}
