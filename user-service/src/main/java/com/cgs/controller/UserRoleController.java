package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import com.cgs.dto.UserRoleMappingDTO;
import com.cgs.service.UserRoleMappingService;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value = UrlConstant.SSO_URL_PREFIX)
public class UserRoleController {

    @Autowired
    private UserRoleMappingService userRoleMappingService;

    @RequestMapping(value = UrlConstant.ROLE_QUERY,method = RequestMethod.POST)
    public Response queryRoleByUserId(@RequestBody @Valid UserRoleMappingDTO userRoleDTO, BindingResult result){
        Response response = new Response();

        return response;
    }
}
