package com.github.polyang.istudy.framework.spring.starter.utils;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * web工具类
 * @author polyang
 * @date 2021/6/12 17:32
 **/
public class WebUtil extends WebUtils {

	public static HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(requestAttributes == null) {
			return null;
		}
		return ((ServletRequestAttributes)requestAttributes).getRequest();
	}

}
