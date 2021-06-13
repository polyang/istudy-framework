package com.github.polyang.istudy.framework.spring.starter.dto;

import java.io.Serializable;

/**
 * 接口响应结果
 * @author polyang
 * @date 2021/6/11 18:02
 */
public class BaseResult implements Serializable {

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

    public BaseResult() {
        this.success = false;
        this.code = ResultCodeEnum.FAILURE.getCode();
        this.message = ResultCodeEnum.FAILURE.getMessage();
    }

    public BaseResult(boolean success, String message) {
        this.success = success;
        this.code = success ? ResultCodeEnum.SUCCESS.getCode() : ResultCodeEnum.FAILURE.getCode();
        this.message = message;
    }

    public void setErrorMessage(String message) {
        this.success = false;
        this.code = ResultCodeEnum.FAILURE.getCode();
        this.message = message;
    }

    public void setSuccessMessage(String message) {
        this.success = true;
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = message;
    }

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

}
