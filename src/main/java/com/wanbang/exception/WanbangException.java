package com.wanbang.exception;

public class WanbangException extends RuntimeException {
    private Integer code;  // 错误码
    private String message; // 错误消息

    /**
     * 构造方法：使用默认的错误码和消息
     */
    public WanbangException() {
        super("发生错误");
        this.code = 500; // 默认服务器错误码
        this.message = "发生错误";
    }

    /**
     * 构造方法：使用指定的错误码和消息
     * @param code 错误码
     * @param message 错误消息
     */
    public WanbangException(Integer code, String message) {
        super(message); // 将消息传递给父类 RuntimeException
        this.code = code;
        this.message = message;
    }

    /**
     * 构造方法：使用指定的错误码、消息和异常原因
     * @param code 错误码
     * @param message 错误消息
     * @param cause 异常原因
     */
    public WanbangException(Integer code, String message, Throwable cause) {
        super(message, cause); // 将消息和原因传递给父类
        this.code = code;
        this.message = message;
    }

    // getters 和 setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 提供一个静态方法创建常见的异常实例
     * @param code 错误码
     * @param message 错误消息
     * @return WanbangException 实例
     */
    public static WanbangException of(Integer code, String message) {
        return new WanbangException(code, message);
    }
}