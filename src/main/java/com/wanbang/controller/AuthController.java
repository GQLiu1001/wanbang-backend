package com.wanbang.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.wanbang.common.Result;
import com.wanbang.req.ForgetPasswordReq;
import com.wanbang.req.LoginReq;
import com.wanbang.req.RegisterReq;
import com.wanbang.resp.LoginResp;
import com.wanbang.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "认证接口", description = "用户登录相关接口")
@RequestMapping("/api/auth")
@RestController
@CrossOrigin
public class AuthController {
    @Resource
    private SysUserService sysUserService;

    @Operation(summary = "用户登录", description = "根据用户名和密码进行登录认证")
    @PostMapping("/login")
    public Result<LoginResp> login(@RequestBody LoginReq loginReq) {
        String username = loginReq.getUsername();
        String password = loginReq.getPassword();
        LoginResp loginResp = sysUserService.login(username, password);
        if (loginResp == null) {
            return Result.fail();
        }
        StpUtil.login(loginResp.getId());
        return Result.success(loginResp);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterReq registerReq) {
        String username = registerReq.getUsername();
        System.out.println("password = " + registerReq.getPassword());
        String password = SaSecureUtil.md5(registerReq.getPassword());
        System.out.println("password = " + password);
        String phone = registerReq.getPhone();
        Integer i = sysUserService.registry(username, password, phone);
        if (i > 0) {
            return Result.success();
        }
        return Result.fail("注册失败");
    }

    @Operation(summary = "用户忘记密码")
    @PostMapping("/reset-password")
    public Result resetPassword(@RequestBody ForgetPasswordReq forgetPasswordReq) {
        String username = forgetPasswordReq.getUsername();
        String phone = forgetPasswordReq.getPhone();
        System.out.println("password = " + forgetPasswordReq.getNewPassword() );
        String password = SaSecureUtil.md5(forgetPasswordReq.getNewPassword());
        System.out.println("password = " + password);
        Integer i = sysUserService.changePassword(username, phone, password);
        if (i > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Operation(summary = "用户登出")
    @PostMapping("/logout")
    public Result logout(@RequestHeader("satoken") String token) {
        System.out.println(token);
        StpUtil.logout();
        return Result.success();
    }

}