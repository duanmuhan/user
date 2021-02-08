package com.cgs.service;

import com.cgs.constant.Constant;
import com.cgs.dao.UserRoleMappingDAO;
import com.cgs.dto.UserRoleMappingDTO;
import com.cgs.po.UserRoleMappingPO;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午11:58
 */
@Service
@Slf4j
public class UserRoleMappingService {

    @Autowired
    private UserRoleMappingDAO userRoleMappingDAO;

    public Integer addUserRole(UserRoleMappingDTO userRoleDTO){
        UserRoleMappingPO userRoleMappingPO = new UserRoleMappingPO();
        userRoleMappingPO.setRoleId(userRoleDTO.getRoleId());
        userRoleMappingPO.setUserId(userRoleDTO.getUserId());
        userRoleMappingPO.setRoleName(userRoleDTO.getRoleName());
        userRoleMappingPO.setUserName(userRoleDTO.getUserName());
        userRoleMappingPO.setUtime(System.currentTimeMillis());
        userRoleMappingPO.setCtime(System.currentTimeMillis());
        userRoleMappingPO.setValid(Constant.VALID);
        userRoleMappingDAO.insertUserRollMapping(userRoleMappingPO);
        return 1;
    }

    public UserRoleMappingDTO queryUserRoleMappingByUserId(Long userId){
        UserRoleMappingPO userRoleMappingPO = userRoleMappingDAO.queryUserRoleMappingByUserId(userId);
        if (ObjectUtils.isEmpty(userRoleMappingPO)){
            return null;
        }
        UserRoleMappingDTO dto = new UserRoleMappingDTO();
        dto.setRoleId(userRoleMappingPO.getRoleId());
        dto.setRoleName(userRoleMappingPO.getRoleName());
        dto.setUserId(userRoleMappingPO.getUserId());
        dto.setUserName(userRoleMappingPO.getUserName());
        return dto;
    }

}
