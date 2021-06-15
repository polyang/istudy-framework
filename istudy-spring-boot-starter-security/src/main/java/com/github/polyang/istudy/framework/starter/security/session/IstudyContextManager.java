package com.github.polyang.istudy.framework.starter.security.session;

import com.github.polyang.istudy.framework.starter.security.base.bo.OnlineSession;
import com.github.polyang.istudy.framework.starter.security.base.bo.OnlineSessionItem;
import com.github.polyang.istudy.framework.starter.security.context.IstudyContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 上下文管理
 * @author huangbaoliang
 * @date 2021/6/15 17:22
 */
@Component
public class IstudyContextManager {

    private static final String REDIS_ONLINE_SESSION_KEY = "istudy:online:user:sessions";
    private static final String REDIS_USER_ATTRIBUTE_KEY = "istudy-user-context";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void updateContext(HttpSession session, IstudyContext context) {
        // 设置用户信息
        session.setAttribute(REDIS_USER_ATTRIBUTE_KEY, context);
        // 设置在线用户会话
        OnlineSessionItem onlineSessionItem = new OnlineSessionItem();
        onlineSessionItem.setSessionId(session.getId());
        onlineSessionItem.setLoginSystemType(context.getLoginSystemType());
        saveOrUpdateOnlineSession(session, context.getUserKey(), onlineSessionItem);
    }

    public OnlineSession getOnlineSession(String userKey) {
        return (OnlineSession) stringRedisTemplate.opsForHash().get(REDIS_ONLINE_SESSION_KEY, userKey);
    }

    public void setOnlineSession(String userKey, OnlineSession onlineSession) {
        stringRedisTemplate.opsForHash().put(REDIS_ONLINE_SESSION_KEY, userKey, onlineSession);
    }

    public void saveOrUpdateOnlineSession(HttpSession session, String userKey, OnlineSessionItem onlineSessionItemParam) {
        OnlineSession onlineSession = getOnlineSession(userKey);
        if (onlineSession == null) {
            onlineSession = new OnlineSession();
        }
        onlineSession.setUserKey(userKey);
        List<OnlineSessionItem> onlineList = onlineSession.getOnlineList();
        boolean exists = false;
        if (onlineList.size() > 0) {
            for (OnlineSessionItem onlineSessionItem : onlineList) {
                if (onlineSessionItem.getSessionId().equals(session.getId())) {
                    exists = true;
                }
            }
        }
        if (!exists) {
            onlineList.add(onlineSessionItemParam);
            onlineSession.setOnlineList(onlineList);
            setOnlineSession(userKey, onlineSession);
        }
    }

    public void deleteOnlineSession(HttpSession session) {
        String sessionId = session.getId();
        IstudyContext context = getContext(session);
        if (context != null) {
            String userKey = context.getUserKey();
            OnlineSession onlineSession = getOnlineSession(userKey);
            if (onlineSession != null) {
                List<OnlineSessionItem> onlineList = onlineSession.getOnlineList();
                if (onlineList.size() > 0) {
                    List<OnlineSessionItem> newOnlineList = new ArrayList<>();
                    for (OnlineSessionItem onlineSessionItem : onlineList) {
                        if (!onlineSessionItem.getSessionId().equals(sessionId)) {
                            newOnlineList.add(onlineSessionItem);
                        }
                    }
                    onlineSession.setOnlineList(newOnlineList);
                }
                setOnlineSession(userKey, onlineSession);
            }
        }
    }

    public IstudyContext getContext(HttpSession session) {
        return (IstudyContext) session.getAttribute(REDIS_USER_ATTRIBUTE_KEY);
    }

}
