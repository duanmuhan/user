package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import com.cgs.dto.UserRoleDTO;
import com.cgs.service.UserRoleService;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午2:47
 */
@Controller
@Api(tags = "用户和角色配置接口")
@Slf4j
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = UrlConstant.ROLL_ADD,method = RequestMethod.POST)
    public Response addRoleByUserId(@RequestBody @Valid UserRoleDTO userRoleDTO,BindingResult result){
        Response response = new Response();

        return response;
    }
}
