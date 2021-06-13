package com.github.polyang.istudy.framework.spring.starter.dto;

/**
 * @Description: 接口简单响应结果
 * @Author: polyang
 * @Date: 2021/6/13 09:18
 */
public class SimpleResult extends BaseResult {

    private static final long serialVersionUID = -2491325657481662102L;

    private String data;

    public SimpleResult() {
    }

    public SimpleResult(Boolean success, String message) {
        super(success, message);
    }

    public void setSuccessData(String data) {
        this.setSuccessData("成功", data);
    }

    public void setSuccessData(String message, String data) {
        super.setSuccessMessage(message);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
