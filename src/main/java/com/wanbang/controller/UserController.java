package com.wanbang.controller;

import com.wanbang.common.Result;
import com.wanbang.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@CrossOrigin
@RestController
public class UserController {
    @Resource
    private  SysUserService sysUserService;
    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Long id) {
        Integer i = sysUserService.deleteUser(id);
        if (i > 0) {
            return Result.success();
        }
        return Result.fail();
    }
}
