package com.cgs.dubbo;

import com.cgs.client.UserAuthService;
import com.cgs.service.UserService;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @Override
    public Response auth(String token) {
        Response response = null;
        if (StringUtils.isEmpty(token) || !redisTemplate.hasKey(token)){
            response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"未登陆系统");
            return response;
        }
        return response;
    }

    @Override
    public Response queryUserById(Long userId) {

        return new Response();
    }
}
