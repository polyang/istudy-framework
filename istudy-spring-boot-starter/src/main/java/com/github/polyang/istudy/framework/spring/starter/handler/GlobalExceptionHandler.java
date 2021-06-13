package com.github.polyang.istudy.framework.spring.starter.handler;

import com.github.polyang.istudy.framework.spring.starter.dto.BaseResult;
import com.github.polyang.istudy.framework.spring.starter.dto.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局异常处理
 * @author: polyang
 * @date: 2021/6/12 22:39
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handler(Exception e, HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) {
        BaseResult result = new BaseResult();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.SERVER_ERROR.getCode());
        result.setMessage(ResultCodeEnum.SERVER_ERROR.getMessage());
        if (e instanceof NoHandlerFoundException) {
            result.setCode(ResultCodeEnum.NOT_FOUND.getCode());
            result.setMessage(e.getMessage());
        } else {
            logger.error("接口请求发生异常", e);
        }
        return result;
    }

}
