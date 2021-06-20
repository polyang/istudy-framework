package com.github.polyang.istudy.framework.starter.session.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 微会话
 * @Author: polyang
 * @Date: 2021/6/19 10:48
 */
public class MicroSession implements Serializable {

    private static final long serialVersionUID = -8851090447535039194L;

    /**
     * 会话id
     */
    private String id;
    /**
     * 会话创建时间
     */
    private long createTime;
    /**
     * 会话最后更新时间
     */
    private long lastUpdateTime;
    /**
     * 会话最大非活动时间（秒）：超过该时间会话即销毁
     */
    private long maxInactiveIntervalInSeconds;
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
    private Map<String, Object> attributes = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getMaxInactiveIntervalInSeconds() {
        return maxInactiveIntervalInSeconds;
    }

    public void setMaxInactiveIntervalInSeconds(long maxInactiveIntervalInSeconds) {
        this.maxInactiveIntervalInSeconds = maxInactiveIntervalInSeconds;
    }

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

    public void addAllAttribute(Map<String, Object> attributes) {
        this.attributes.putAll(attributes);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void setAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public void removeAttribute(String key) {
        this.attributes.remove(key);
    }

}
