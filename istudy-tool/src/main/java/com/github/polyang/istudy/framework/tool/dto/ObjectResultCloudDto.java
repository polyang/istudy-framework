package com.github.polyang.istudy.framework.tool.dto;

/**
 * 服务之间通信的对象返回结果
 * @author polyang
 * @date 2021/6/11 16:02
 */
public class ObjectResultCloudDto<T> extends ResultCloudDto {

    private static final long serialVersionUID = -8124087739523636158L;

    private T object;

    public ObjectResultCloudDto() {
    }

    public ObjectResultCloudDto(Boolean success, String message) {
        super(success, message);
    }

    public ObjectResultCloudDto(Boolean success, String message, T object) {
        super(success, message);
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
