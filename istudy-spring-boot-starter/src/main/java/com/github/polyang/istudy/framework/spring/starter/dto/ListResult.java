package com.github.polyang.istudy.framework.spring.starter.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 接口列表返回结果
 * @Author: polyang
 * @Date: 2021/6/13 09:22
 */
public class ListResult<T> extends BaseResult {

    private static final long serialVersionUID = 6404396323942011830L;

    private List<T> data = new ArrayList<>();

    public ListResult() {
    }

    public ListResult(Boolean success, String message) {
        super(success, message);
    }

    public void setSuccessData(List<T> data) {
        this.setSuccessData("成功", data);
    }

    public void setSuccessData(String message, List<T> data) {
        super.setSuccessMessage(message);
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
