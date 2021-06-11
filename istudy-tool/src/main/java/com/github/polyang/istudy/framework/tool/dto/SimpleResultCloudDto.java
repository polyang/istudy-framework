package com.github.polyang.istudy.framework.tool.dto;

/**
 * 服务之间通信的简单返回结果
 * @author polyang
 * @date 2021/6/11 15:56
 */
public class SimpleResultCloudDto extends ResultCloudDto {

    private static final long serialVersionUID = -8733611853453231374L;

    private String key;

    public SimpleResultCloudDto() {
    }

    public SimpleResultCloudDto(Boolean success, String message) {
        super(success, message);
    }

    public SimpleResultCloudDto(Boolean success, String message, String key) {
        super(success, message);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
