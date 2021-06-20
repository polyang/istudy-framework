package com.github.polyang.istudy.framework.starter.session.generator.impl;

import com.github.polyang.istudy.framework.starter.session.generator.MicroSessionIdGenerator;

import java.util.UUID;

/**
 * @Description: 默认的sessionId生成器
 * @Author: polyang
 * @Date: 2021/6/19 14:59
 */
public class GeneralMicroSessionIdGenerator implements MicroSessionIdGenerator {

    @Override
    public String getSessionId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
