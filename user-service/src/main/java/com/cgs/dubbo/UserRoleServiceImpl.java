package com.cgs.dubbo;

import com.cgs.client.UserRoleService;
import com.cgs.dao.UserDAO;
import com.cgs.user.UserDTO;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:58
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Response queryUserByUserId(Long userId) {
        return null;
    }

    @Override
    public Response<UserDTO> modifyUserRoleByUserId(Long userId) {

        return ResponseUtils.buildResponseByCode(ErrorCode.OK,new UserDTO());
    }
}
