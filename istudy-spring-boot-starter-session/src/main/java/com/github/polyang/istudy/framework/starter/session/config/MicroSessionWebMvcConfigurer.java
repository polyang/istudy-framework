package com.github.polyang.istudy.framework.starter.session.config;

import com.github.polyang.istudy.framework.starter.session.interceptor.MicroSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: polyang
 * @Date: 2021/6/19 17:06
 */
@Order(Integer.MIN_VALUE)
@Configuration
public class MicroSessionWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private MicroSessionInterceptor microSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(microSessionInterceptor).addPathPatterns("/**");
    }

}
