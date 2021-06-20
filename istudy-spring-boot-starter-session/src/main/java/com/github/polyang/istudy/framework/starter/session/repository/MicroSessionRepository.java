package com.github.polyang.istudy.framework.starter.session.repository;

import com.github.polyang.istudy.framework.starter.session.bo.MicroSession;

/**
 * @Description: 微会话存储操作
 * @Author: polyang
 * @Date: 2021/6/19 11:15
 */
public interface MicroSessionRepository {

    /**
     * 保存session
     * @param session
     */
    void saveSession(MicroSession session);

    /**
     * 刷新session
     * @param session
     */
    void refreshSession(MicroSession session);

    /**
     * 获取session
     * @param sessionId
     */
    MicroSession getSession(String sessionId);

    /**
     * 移除session
     * @param sessionId
     */
    void removeSession(String sessionId);

    /**
     * session是否存在
     * @param sessionId
     * @return
     */
    boolean isExist(String sessionId);
}
