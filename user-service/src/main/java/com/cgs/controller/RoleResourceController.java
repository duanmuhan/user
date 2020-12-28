package com.cgs.controller;

import com.cgs.constant.UrlConstant;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author caoguangshu
 * @date 2020/11/30
 * @time 上午1:04
 */
@Controller
@Api(tags = "资源和角色配置接口")
@Slf4j
@RequestMapping(value = UrlConstant.SSO_URL_PREFIX)
public class RoleResourceController {

}
