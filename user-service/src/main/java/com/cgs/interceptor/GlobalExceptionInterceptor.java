package com.cgs.interceptor;

import constant.ErrorCode;
import constant.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author caoguangshu
 * @date 2020/12/28
 * @time 上午2:20
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionInterceptor implements HandlerInterceptor {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response<Object> handlerException(HttpServletRequest request, Exception e) {
        log.error("系统异常", e);
        Response<Object> httpResponse = new Response<Object>(ErrorCode.EXCEPTION.getCode(), "系统异常",null);
        return httpResponse;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Object> validExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> list = e.getBindingResult().getFieldErrors();
        StringBuilder sb = new StringBuilder();
        list.forEach(fieldError -> sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";"));
        log.error("参数错误：{}", sb.toString());
        Response<Object> httpResponse = new Response<Object>(ErrorCode.EXCEPTION.getCode(), sb.toString(),null);
        return httpResponse;
    }
}
