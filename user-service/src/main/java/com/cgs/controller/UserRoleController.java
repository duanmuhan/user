package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import com.cgs.dto.UserRoleMappingDTO;
import com.cgs.service.UserRoleMappingService;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = UrlConstant.USER_ROLE_MAPPING_ADD,method = RequestMethod.POST)
    public Response addUserRoleMapping(@RequestBody @Valid UserRoleMappingDTO userRoleDTO, BindingResult result){
        Response response = new Response();
        if (result.hasErrors()){
            for (FieldError fieldError : result.getFieldErrors()){
                response.setCode(ErrorCode.PARAM_ERROR.getCode());
                response.setMessage(fieldError.getDefaultMessage());
                return response;
            }
        }
        userRoleMappingService.addUserRole(userRoleDTO);
        return response;
    }

    @RequestMapping(value = UrlConstant.USER_ROLE_MAPPING_QUERY_BY_USER_ID,method = RequestMethod.GET)
    public Response queryUserRoleById(@RequestParam("userId") Long userId){
        if (ObjectUtils.isEmpty(userId)){
            return ResponseUtils.buildResponseByCode(ErrorCode.PARAM_ERROR,"params is null");
        }
        UserRoleMappingDTO dto = userRoleMappingService.queryUserRoleMappingByUserId(userId);
        return ResponseUtils.buildResponseByCode(ErrorCode.OK,dto);
    }
}
