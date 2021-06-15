package com.github.polyang.istudy.framework.starter.security.base.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 在线的会话
 * @Author: polyang
 * @Date: 2021/6/14 21:55
 */
public class OnlineSession implements Serializable {

    private static final long serialVersionUID = -4682547627207252247L;

    /**
     * 用户主键
     */
    private String userKey;
    /**
     * 在线的用户会话
     */
    private List<OnlineSessionItem> onlineList = new ArrayList<>();

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public List<OnlineSessionItem> getOnlineList() {
        return onlineList == null ? new ArrayList<>() : onlineList;
    }

    public void setOnlineList(List<OnlineSessionItem> onlineList) {
        this.onlineList = onlineList;
    }
}
