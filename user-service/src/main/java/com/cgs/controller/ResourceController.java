package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import com.cgs.request.ResourceRequest;
import com.cgs.service.ResourceService;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caoguangshu
 * @date 2020/11/30
 * @time 上午1:04
 */
@Controller
@Api(tags = "资源相关接口")
@Slf4j
@RequestMapping(value = UrlConstant.SSO_URL_PREFIX)
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = UrlConstant.RESOURCE_ADD)
    public Response addResource(@RequestBody ResourceRequest request){
        resourceService.addResource(request);
        return ResponseUtils.buildResponseByCode(ErrorCode.OK,"添加成功");
    }

    @RequestMapping(value = UrlConstant.RESOURCE_QUERY)
    public Response queryResource(HttpServletRequest httpServletRequest){

    }
}
