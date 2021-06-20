package com.github.polyang.istudy.framework.starter.session.manager.impl;

import com.github.polyang.istudy.framework.starter.session.bo.MicroSession;
import com.github.polyang.istudy.framework.starter.session.param.CreateMicroSessionParam;
import com.github.polyang.istudy.framework.starter.session.repository.impl.RedisMicroSessionRepository;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Description: session管理普通实现
 * @Author: polyang
 * @Date: 2021/6/19 14:46
 */
public class GeneralMicroSessionManager extends BaseMicroSessionManagerImpl {

    private StringRedisTemplate stringRedisTemplate;

    public GeneralMicroSessionManager(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        super.setSessionRepository(new RedisMicroSessionRepository(stringRedisTemplate));
    }

    @Override
    public MicroSession createSession(CreateMicroSessionParam param) {
        MicroSession session = new MicroSession();
        session.setId(getMicroSessionIdGenerator().getSessionId());
        session.setCreateTime(System.currentTimeMillis());
        session.setLastUpdateTime(System.currentTimeMillis());
        session.setMaxInactiveIntervalInSeconds(getMaxInactiveIntervalInSeconds());
        session.setIp(param.getIp());
        session.setChannel(param.getChannel());
        session.setUserKey(param.getUserKey());
        session.setUserPhone(param.getUserPhone());
        session.setAttributes(param.getAttributes());
        getSessionRepository().saveSession(session);
        return session;
    }

    @Override
    public MicroSession getSession(String sessionId) {
        return getSessionRepository().getSession(sessionId);
    }

    @Override
    public void updateSession(MicroSession session) {
        getSessionRepository().saveSession(session);
    }

    @Override
    public void removeSession(String sessionId) {
        getSessionRepository().removeSession(sessionId);
    }

    @Override
    public void refreshSession(String sessionId) {
        MicroSession session = getSession(sessionId);
        if (session != null) {
            getSessionRepository().refreshSession(session);
        }
    }

    @Override
    public boolean isSessionExist(String sessionId) {
        return getSessionRepository().isExist(sessionId);
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
