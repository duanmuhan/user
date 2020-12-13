package com.cgs.service;

import com.cgs.dao.UserRoleMappingDAO;
import com.cgs.dto.UserRoleDTO;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午11:58
 */
@Service
@Slf4j
public class UserRoleService {

    @Autowired
    private UserRoleMappingDAO userRoleMappingDAO;

    public Response addUserRole(UserRoleDTO userRoleDTO){



        return ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,null);
    }
}
