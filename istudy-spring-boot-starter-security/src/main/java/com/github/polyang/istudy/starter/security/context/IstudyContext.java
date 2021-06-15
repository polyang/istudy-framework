package com.github.polyang.istudy.starter.security.context;

import java.io.Serializable;

/**
 * 用户上下文信息
 * @author huangbaoliang
 * @date 2021/6/15 17:10
 */
public class IstudyContext implements Serializable {

    private static final long serialVersionUID = 2083908483485664482L;

    /**
     * 用户主键
     */
    private String userKey;
    /**
     * 用户昵称
     */
    private String userNickName;
    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 登录模式（如普通用户模式，管理员模式等等）
     */
    private Integer loginMode;
    /**
     * 登录系统类型（如web系统、APP系统等等）
     */
    private Integer loginSystemType;
    /**
     * 登录ip
     */
    private String loginIp;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(Integer loginMode) {
        this.loginMode = loginMode;
    }

    public Integer getLoginSystemType() {
        return loginSystemType == null ? 0 : loginSystemType;
    }

    public void setLoginSystemType(Integer loginSystemType) {
        this.loginSystemType = loginSystemType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
