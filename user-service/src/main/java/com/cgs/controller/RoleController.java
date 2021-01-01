package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import com.cgs.request.RoleRequest;
import com.cgs.service.RoleService;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caoguangshu
 * @date 2020/11/30
 * @time 上午1:04
 */
@Controller
@Api(tags = "用户角色相关接口")
@Slf4j
@RequestMapping(value = UrlConstant.SSO_URL_PREFIX)
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = UrlConstant.ROLE_ADD,method = RequestMethod.POST)
    @ResponseBody
    public Response roleAdd(@RequestBody RoleRequest roleRequest){
        roleService.addRole(roleRequest);
        return ResponseUtils.buildResponseByCode(ErrorCode.OK,"添加成功");
    }
}
