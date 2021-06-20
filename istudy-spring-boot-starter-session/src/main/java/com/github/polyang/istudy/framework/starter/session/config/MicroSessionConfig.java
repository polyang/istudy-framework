package com.github.polyang.istudy.framework.starter.session.config;

import com.github.polyang.istudy.framework.starter.session.manager.MicroSessionManager;
import com.github.polyang.istudy.framework.starter.session.manager.impl.GeneralMicroSessionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: polyang
 * @Date: 2021/6/19 16:41
 */
@Configuration
public class MicroSessionConfig {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /*@Bean
    @ConditionalOnMissingBean
    public MicroSessionIdGenerator microSessionIdGenerator() {
        return new GeneralMicroSessionIdGenerator();
    }

    @Bean
    @ConditionalOnMissingBean
    public MicroSessionRepository microSessionRepository() {
        return new RedisMicroSessionRepository(stringRedisTemplate);
    }*/

    @Bean
    @ConditionalOnMissingBean
    public MicroSessionManager microSessionManager(){
        return new GeneralMicroSessionManager(stringRedisTemplate);
    }

}
