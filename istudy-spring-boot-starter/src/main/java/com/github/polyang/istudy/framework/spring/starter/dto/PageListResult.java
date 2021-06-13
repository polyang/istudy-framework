package com.github.polyang.istudy.framework.spring.starter.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 接口分页列表返回结果
 * @Author: polyang
 * @Date: 2021/6/13 09:22
 */
public class PageListResult<T> extends BaseResult {

    private static final long serialVersionUID = 6404396323942011830L;

    private List<T> data = new ArrayList<>();
    /**
     * 当前页
     */
    private Long current;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 总行数
     */
    private Long totalRows;

    public PageListResult() {
    }

    public PageListResult(Boolean success, String message) {
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

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }
}
