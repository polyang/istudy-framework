package com.github.polyang.istudy.starter.security.listener;

import com.github.polyang.istudy.starter.security.session.IstudyContextManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听会话
 * @author huangbaoliang
 * @date 2021/6/15 19:54
 */
@Component
public class IstudyAuthHttpSessionListener implements HttpSessionListener {

    @Resource
    private IstudyContextManager contextManager;

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 删除在线用户信息
        contextManager.deleteOnlineSession(se.getSession());
    }
}
