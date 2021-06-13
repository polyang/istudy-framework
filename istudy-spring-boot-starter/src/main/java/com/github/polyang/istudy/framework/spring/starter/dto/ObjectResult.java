package com.github.polyang.istudy.framework.spring.starter.dto;

/**
 * @Description: 接口对象返回结果
 * @Author: polyang
 * @Date: 2021/6/13 09:20
 */
public class ObjectResult<T> extends BaseResult {

    private static final long serialVersionUID = -6489704730356784726L;

    private T data;

    public ObjectResult() {
    }

    public ObjectResult(Boolean success, String message) {
        super(success, message);
    }

    public void setSuccessData(T data) {
        this.setSuccessData("成功", data);
    }

    public void setSuccessData(String message, T data) {
        super.setSuccessMessage(message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
