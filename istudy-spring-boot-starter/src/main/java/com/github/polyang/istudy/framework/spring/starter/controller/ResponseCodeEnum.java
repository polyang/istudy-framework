package com.github.polyang.istudy.framework.spring.starter.controller;

/**
 * 响应code常量
 * @author polyang
 * @date 2021/6/11 18:11
 */
public enum ResponseCodeEnum {

    SUCCESS(200, "成功"),
    FAILURE(400, "业务异常"),
    UN_AUTHORIZED(401, "请求未授权"),
    PERMISSION_DENIED(403, "访问无权限"),
    NOT_FOUND(404, "没找到请求"),
    SERVER_ERROR(500, "服务器异常");

    private int code;
    private String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
