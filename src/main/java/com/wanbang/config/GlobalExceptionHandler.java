package com.wanbang.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.util.SaResult;
import com.wanbang.common.Result;
import com.wanbang.common.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理未登录异常
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 返回 401 状态码
    public Result handleNotLoginException(NotLoginException e) {
        return Result.fail(ResultCode.UNAUTHORIZED);
    }
    // 全局异常拦截
    @ExceptionHandler
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }
}

