package com.github.polyang.istudy.framework.starter.session.manager;

import com.github.polyang.istudy.framework.starter.session.bo.MicroSession;
import com.github.polyang.istudy.framework.starter.session.param.CreateMicroSessionParam;

/**
 * @Description: session管理
 * @Author: polyang
 * @Date: 2021/6/19 13:14
 */
public interface MicroSessionManager {

    /**
     * 创建安全码并生成session信息
     *
     * @return
     */
    public MicroSession createSession(CreateMicroSessionParam param) ;

    /**
     * 获取Session
     *
     * @param sessionId
     * @return
     */
    public MicroSession getSession(String sessionId) ;

    /**
     * 更新Session
     *
     * @param session
     */
    public void updateSession(MicroSession session) ;

    /**
     * 清除Session
     *
     * @param sessionId
     */
    public void removeSession(String sessionId) ;

    /**
     * 刷新Session
     *
     * @param sessionId
     */
    public void refreshSession(String sessionId) ;

    /**
     * Session是否存在
     *
     * @param sessionId
     * @return
     */
    public boolean isSessionExist(String sessionId) ;
    
}
