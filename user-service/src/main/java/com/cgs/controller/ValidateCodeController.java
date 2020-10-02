package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import com.cgs.service.ValidateCodeService;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Api(tags = "验证码相关接口")
@Slf4j
public class ValidateCodeController {

    @Autowired
    private ValidateCodeService validateCodeService;

    @RequestMapping(value = UrlConstant.PIC_VALIDATOR,method = RequestMethod.GET)
    @ResponseBody
    public Response validateCode(HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        try{

        }catch (Exception e){

        }
        return new Response();
    }
}
