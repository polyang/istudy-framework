package com.github.polyang.istudy.starter.security.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 登录用户
 * @Author: polyang
 * @Date: 2021/6/13 23:21
 */
public class SecurityUser implements Serializable {

    private static final long serialVersionUID = 1571185931019079894L;
    /**
     * 用户key
     */
    private String userKey;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 系统类型
     */
    private List<OnlineSession> onlineSessionList;

    public SecurityUser() {
        onlineSessionList = new ArrayList<>();
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OnlineSession> getOnlineSessionList() {
        return onlineSessionList;
    }

    public void setOnlineSessionList(List<OnlineSession> onlineSessionList) {
        this.onlineSessionList = onlineSessionList;
    }
}
