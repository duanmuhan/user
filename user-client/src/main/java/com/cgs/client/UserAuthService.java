package com.cgs.client;

import constant.Response;

/**
 * @author caoguangshu
 * @date 2020/11/30
 * @time 上午1:17
 */
public interface UserAuthService {

    public Response auth(String token);

    public Response queryUserById(Long userId);
}
