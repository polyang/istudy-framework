package com.github.polyang.istudy.framework.starter.session.manager.impl;

import com.github.polyang.istudy.framework.starter.session.generator.MicroSessionIdGenerator;
import com.github.polyang.istudy.framework.starter.session.generator.impl.GeneralMicroSessionIdGenerator;
import com.github.polyang.istudy.framework.starter.session.manager.MicroSessionManager;
import com.github.polyang.istudy.framework.starter.session.repository.MicroSessionRepository;

/**
 * @Description: session管理抽象实现
 * @Author: polyang
 * @Date: 2021/6/19 14:51
 */
public abstract class BaseMicroSessionManagerImpl implements MicroSessionManager {

    private long maxInactiveIntervalInSeconds = 1800L;

    private MicroSessionIdGenerator microSessionIdGenerator = new GeneralMicroSessionIdGenerator();

    private MicroSessionRepository sessionRepository;

    public long getMaxInactiveIntervalInSeconds() {
        return maxInactiveIntervalInSeconds;
    }

    public void setMaxInactiveIntervalInSeconds(long maxInactiveIntervalInSeconds) {
        this.maxInactiveIntervalInSeconds = maxInactiveIntervalInSeconds;
    }

    public MicroSessionIdGenerator getMicroSessionIdGenerator() {
        return microSessionIdGenerator;
    }

    public void setMicroSessionIdGenerator(MicroSessionIdGenerator microSessionIdGenerator) {
        this.microSessionIdGenerator = microSessionIdGenerator;
    }

    public MicroSessionRepository getSessionRepository() {
        return sessionRepository;
    }

    public void setSessionRepository(MicroSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
}
