package com.cgs.client;

import com.cgs.user.UserDTO;
import constant.Response;

/**
 * @author caoguangshu
 * @date 2020/11/30
 * @time 上午1:03
 */
public interface UserRoleService {

    public Response<UserDTO> queryUserByUserId(Long userId);

    public Response<UserDTO> modifyUserRoleByUserId(Long userId);
}
