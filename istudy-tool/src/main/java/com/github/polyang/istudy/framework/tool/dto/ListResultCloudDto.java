package com.github.polyang.istudy.framework.tool.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务之间通信的列表返回结果
 * @author polyang
 * @date 2021/6/11 16:09
 */
public class ListResultCloudDto<T> extends ResultCloudDto{

    private static final long serialVersionUID = -8844508987864505215L;

    private List<T> list = new ArrayList<>();

    public ListResultCloudDto() {
    }

    public ListResultCloudDto(Boolean success, String message) {
        super(success, message);
    }

    public ListResultCloudDto(Boolean success, String message, List<T> list) {
        super(success, message);
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
