package com.cgs.controller;

import com.cgs.utils.ResponseUtils;
import com.cgs.constant.UrlConstant;
import com.cgs.dto.UserDTO;
import com.cgs.service.UserService;
import constant.ErrorCode;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@Api(tags = "用户相关接口")
@Slf4j
@RequestMapping(value = UrlConstant.SSO_URL_PREFIX)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = UrlConstant.REGISTRY,method = RequestMethod.POST)
    @ResponseBody
    public Response register(@RequestBody @Valid UserDTO user,
                             BindingResult result,
                             HttpServletRequest servletRequest,
                             HttpServletResponse servletResponse){
        Response response = null;
        try {
            if (result.hasErrors()){
                response = ResponseUtils.buildResponseByCode(ErrorCode.PARAM_ERROR,result.getAllErrors().get(0).getDefaultMessage());
                return response;
            }
            response = userService.register(user,servletRequest,servletResponse);
        }catch (Exception e){
            log.error("register exception:{}", e);
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION, e);
        }
        return response;
    }

    @RequestMapping(value = UrlConstant.LOGIN,method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestParam("userName") String userName,
                          @RequestParam("passWord") String password,
                          HttpServletRequest servletRequest,
                          HttpServletResponse servletResponse){
        Response response = null;
        try {
            response = userService.login(userName,password,servletRequest,servletResponse);
        }catch (Exception e){
            log.error("login exception:{}", e);
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION, e);
        }
        return response;
    }

    @RequestMapping(value = UrlConstant.LOGOUT,method = RequestMethod.GET)
    @ResponseBody
    public Response logout(HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        Response response = null;
        try {
            response = userService.logout(servletRequest);
        }catch (Exception e){
            log.error("logout exception:{}",e);
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,e);
        }
        return response;
    }

    @RequestMapping(value = UrlConstant.AUTH,method = RequestMethod.POST)
    @ResponseBody
    public Response auth(HttpServletRequest servletRequest){
        Response response = null;
        try {
            response = userService.auth(servletRequest);
        }catch (Exception e){
            log.error("auth exception:{}",e);
            response =  ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,e);
        }
        return response;
    }

    @RequestMapping(value = UrlConstant.DETAIL,method = RequestMethod.POST)
    public Response detail(@RequestParam("userId") Long userId){
        if (ObjectUtils.isEmpty(userId)){
            return ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,"userId不能为空");
        }
        return userService.detail(userId);
    }
}
