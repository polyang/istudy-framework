package com.github.polyang.istudy.framework.spring.starter.controller;

import com.github.polyang.istudy.framework.spring.starter.dto.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author polyang
 * @date 2021/6/13 09:52
 **/
@RestController
@ConditionalOnClass(HttpServletRequest.class)
public class MyErrorController implements ErrorController {

    private final static Logger LOG = LoggerFactory.getLogger(MyErrorController.class);

    @Resource
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public BaseResult myError(HttpServletRequest request, WebRequest webRequest){
        BaseResult result = new BaseResult();
        HttpStatus statusCode = getStatus(request);
        Map<String, Object> errorMap = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults().including(ErrorAttributeOptions.Include.MESSAGE));
        LOG.error("错误信息：{}", errorMap);
        result.setSuccess(false);
        result.setCode(statusCode.value());
        result.setMessage(statusCode.getReasonPhrase());
        return result;
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
