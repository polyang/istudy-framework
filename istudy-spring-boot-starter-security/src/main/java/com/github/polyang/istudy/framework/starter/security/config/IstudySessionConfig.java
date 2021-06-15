package com.github.polyang.istudy.framework.starter.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

/**
 * spring session配置（需要自己加上@EnableRedisHttpSession来开启spring redis session）
 * @author huangbaoliang
 * @date 2021/6/15 20:00
 */
@Configuration
public class IstudySessionConfig {

    @Bean
    public HttpSessionIdResolver httpSessionStrategy() {
        // 设置从header中获取会话标识
        return new HeaderHttpSessionIdResolver("istudy-auth-token");
    }

}
