package com.github.polyang.istudy.starter.security.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 在线的会话
 * @Author: polyang
 * @Date: 2021/6/14 21:55
 */
public class OnlineSession implements Serializable {

    private static final long serialVersionUID = -4682547627207252247L;

    /**
     * 客户端类型
     */
    private Integer clientType;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * 会话开始时间
     */
    private Date sessionStartTime;
    /**
     * 会话结束时间
     */
    private Date sessionEndTime;

    public OnlineSession() {
        clientType = 0;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(Date sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public Date getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(Date sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }
}
