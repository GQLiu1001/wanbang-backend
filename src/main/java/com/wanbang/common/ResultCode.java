package com.wanbang.common;

public enum ResultCode {

    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器内部错误"),
    VALIDATION_ERROR(422, "参数验证失败");

    private final int code;
    private final String message;

    // 构造方法（枚举的构造方法必须是私有的）
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 获取 code
    public int getCode() {
        return code;
    }

    // 获取 message
    public String getMessage() {
        return message;
    }

    // 可选：重写 toString 方法，用于更友好的字符串表示
    @Override
    public String toString() {
        return "ResultCode{code=" + code + ", message='" + message + "'}";
    }
}