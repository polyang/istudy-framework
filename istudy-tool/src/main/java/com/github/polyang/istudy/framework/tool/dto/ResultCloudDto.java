package com.github.polyang.istudy.framework.tool.dto;

import java.io.Serializable;

/**
 * 服务之间通信的基础返回结果
 * @author polyang
 * @date 2021/6/11 15:39
 */
public class ResultCloudDto implements Serializable {

    private static final long serialVersionUID = -4581516869158158924L;

    /**
     * 成功的标识
     */
    private Boolean success;
    /**
     * 成功或失败的消息
     */
    private String message;

    public ResultCloudDto() {
        this.success = false;
        this.message = "发生未知错误";
    }

    public ResultCloudDto(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setErrorMessage(String message) {
        this.success = false;
        this.message = message;
    }

    public void setSuccessMessage(String message) {
        this.success = true;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
