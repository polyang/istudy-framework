package com.github.polyang.istudy.starter.security.base.bo;

/**
 * 在线的会话详细项
 * @author huangbaoliang
 * @date 2021/6/15 18:20
 */
public class OnlineSessionItem {

    /**
     * 登录系统类型（如web系统、APP系统等等）
     */
    private Integer loginSystemType;
    /**
     * 会话ID
     */
    private String sessionId;

    public Integer getLoginSystemType() {
        return loginSystemType == null ? 0 : loginSystemType;
    }

    public void setLoginSystemType(Integer loginSystemType) {
        this.loginSystemType = loginSystemType;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
