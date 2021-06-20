package com.github.polyang.istudy.framework.starter.session.interceptor;

import com.github.polyang.istudy.framework.starter.session.bo.MicroSession;
import com.github.polyang.istudy.framework.starter.session.manager.MicroSessionManager;
import com.github.polyang.istudy.framework.starter.session.param.CreateMicroSessionParam;
import com.github.polyang.istudy.framework.tools.WebTool;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: polyang
 * @Date: 2021/6/19 17:00
 */
@Component
public class MicroSessionInterceptor extends HandlerInterceptorAdapter {

    private static final String TOKEN_KEY = "micro-token";

    @Resource
    private MicroSessionManager microSessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TOKEN_KEY);
        MicroSession sessionExist = microSessionManager.getSession(token);
        if (sessionExist == null) {
            CreateMicroSessionParam createParam = new CreateMicroSessionParam();
            createParam.setIp(WebTool.getRequestIp(request));
            createParam.setChannel(1);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("abc", System.currentTimeMillis());
            createParam.setAttributes(attributes);
            MicroSession session = microSessionManager.createSession(createParam);
            response.setHeader(TOKEN_KEY, session.getId());
        } else {
            // 如果距离上次更新时间距离当前时间已经超过了maxInactiveIntervalInSeconds的五分之一，则重置“上次更新时间”字段值和session有效期
            if (sessionExist.getLastUpdateTime() + (sessionExist.getMaxInactiveIntervalInSeconds() / 5 * 1000 * 60) <= System.currentTimeMillis()) {
                sessionExist.setLastUpdateTime(System.currentTimeMillis());
                microSessionManager.updateSession(sessionExist);
            }
        }
        return true;
    }
}
