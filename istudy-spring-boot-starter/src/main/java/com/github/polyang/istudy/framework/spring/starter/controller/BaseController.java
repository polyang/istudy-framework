package com.github.polyang.istudy.framework.spring.starter.controller;

/**
 * 基础controller
 * @author polyang
 * @date 2021/6/11 18:17
 */
public class BaseController {

    /**
     * 标记响应结果为成功
     * @return 响应对象
     */
    protected ResponseContent markSuccess() {
        ResponseContent response = new ResponseContent();
        response.setSuccess(true);
        response.setCode(ResponseCodeEnum.SUCCESS.getCode());
        response.setMessage(ResponseCodeEnum.SUCCESS.getMessage());
        return response;
    }

    /**
     * 标记响应结果为成功并携带响应数据
     * @param data 响应数据
     * @return 响应对象
     */
    protected ResponseContent markSuccess(Object data) {
        ResponseContent response = this.markSuccess();
        response.setData(data);
        return response;
    }

    /**
     * 标记响应结果为失败
     * @param message 失败消息
     * @return  响应对象
     */
    protected ResponseContent markFailure(String message) {
        ResponseContent response = new ResponseContent();
        response.setSuccess(false);
        response.setCode(ResponseCodeEnum.FAILURE.getCode());
        response.setMessage(message);
        return response;
    }

    /**
     * 标记响应结果为失败并携带响应数据
     * @param message 失败消息
     * @param data 响应数据
     * @return  响应对象
     */
    protected ResponseContent markFailure(String message, Object data) {
        ResponseContent response = this.markFailure(message);
        response.setData(data);
        return response;
    }

    /**
     * 标记响应结果为失败
     * @param code 响应编码
     * @param message 失败消息
     * @return  响应对象
     */
    protected ResponseContent markFailure(int code, String message) {
        ResponseContent response = new ResponseContent();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 标记响应结果为失败并携带响应数据
     * @param message 失败消息
     * @param data 响应数据
     * @return  响应对象
     */
    protected ResponseContent markFailure(int code, String message, Object data) {
        ResponseContent response = this.markFailure(code, message);
        response.setData(data);
        return response;
    }

}
