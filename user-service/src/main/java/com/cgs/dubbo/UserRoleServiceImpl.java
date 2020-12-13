package com.cgs.dubbo;

import com.cgs.client.UserRoleService;
import constant.Response;
import org.springframework.stereotype.Service;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:58
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public Response queryUserByUserId(Long userId) {
        return null;
    }
}
