package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(tags = "验证码相关接口")
@Slf4j
public class ValidateCodeController {


    @RequestMapping(value = UrlConstant.PIC_VALIDATOR,method = RequestMethod.GET)
    @ResponseBody
    public Response validateCode(HttpServletRequest servletRequest){
        return new Response();
    }
}
