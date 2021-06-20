package com.github.polyang.istudy.framework.starter.session.param;

import java.util.Map;

/**
 * @Description: 微会话创建参数
 * @Author: polyang
 * @Date: 2021/6/19 13:18
 */
public class CreateMicroSessionParam {

    /**
     * 会话ip
     */
    private String ip;
    /**
     * 会话渠道
     */
    private int channel;
    /**
     * 用户key（如果已经登录）
     */
    private String userKey;
    /**
     * 用户手机号（如果已经登录）
     */
    private String userPhone;
    /**
     * 属性
     */
    private Map<String, Object> attributes;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
