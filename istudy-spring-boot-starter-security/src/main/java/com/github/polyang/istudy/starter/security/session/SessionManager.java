package com.github.polyang.istudy.starter.security.session;

import com.github.polyang.istudy.starter.security.bo.SecurityUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: polyang
 * @Date: 2021/6/14 20:49
 */
@Component
public class SessionManager {

    @Resource
    private RedisTemplate<String, SecurityUser> redisTemplate;



}
