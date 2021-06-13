package com.github.polyang.istudy.framework.spring.starter.param;

import java.io.Serializable;

/**
 * @Description: 分页参数
 * @Author: polyang
 * @Date: 2021/6/13 12:35
 */
public class BasePageParam implements Serializable {

    private static final long serialVersionUID = -3047226427881640574L;

    /**
     * 当前页
     */
    private Long current;
    /**
     * 每页条数
     */
    private Long pageSize;

    public Long getCurrent() {
        return current == null || current < 1L ? 1L : current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getPageSize() {
        return pageSize == null || pageSize < 1L ? 10L : pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
