package com.github.polyang.istudy.framework.starter.session.repository.impl;

import com.github.polyang.istudy.framework.starter.session.bo.MicroSession;
import com.github.polyang.istudy.framework.starter.session.repository.MicroSessionRepository;
import com.google.gson.Gson;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 微会话存储操作：redis实现方式
 * @Author: polyang
 * @Date: 2021/6/19 11:45
 */
public class RedisMicroSessionRepository implements MicroSessionRepository {

    private StringRedisTemplate stringRedisTemplate;

    private static final String KEY_PREFIX = "MICRO:SESSION:";

    public RedisMicroSessionRepository(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void saveSession(MicroSession session) {
        stringRedisTemplate.opsForValue().set(KEY_PREFIX + session.getId(), new Gson().toJson(session), session.getMaxInactiveIntervalInSeconds(), TimeUnit.SECONDS);
    }

    @Override
    public void refreshSession(MicroSession session) {
        stringRedisTemplate.expire(KEY_PREFIX + session.getId(), session.getMaxInactiveIntervalInSeconds(), TimeUnit.SECONDS);
    }

    @Override
    public MicroSession getSession(String sessionId) {
        if (this.isExist(sessionId)) {
            String microSessionStr = stringRedisTemplate.opsForValue().get(KEY_PREFIX + sessionId);
            return new Gson().fromJson(microSessionStr, MicroSession.class);
        }
        return null;
    }

    @Override
    public void removeSession(String sessionId) {
        stringRedisTemplate.delete(KEY_PREFIX + sessionId);
    }

    @Override
    public boolean isExist(String sessionId) {
        Boolean exists = stringRedisTemplate.hasKey(KEY_PREFIX + sessionId);
        return exists != null && exists;
    }
}
