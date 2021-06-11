package com.github.polyang.istudy.framework.spring.starter.controller;

import java.io.Serializable;

/**
 * controller响应结果
 * @author polyang
 * @date 2021/6/11 18:02
 */
public class ResponseContent implements Serializable {

    private static final long serialVersionUID = 7486696925513447576L;

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 响应编码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应内容
     */
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
