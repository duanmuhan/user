package com.cgs.service;

import com.cgs.dao.RoleDAO;
import com.cgs.dao.UserRoleMappingDAO;
import com.cgs.po.RolePO;
import com.cgs.po.UserRoleMappingPO;
import com.cgs.request.RoleRequest;
import com.cgs.utils.UserIdGenerateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caoguangshu
 * @date 2021/1/1
 * @time 下午11:45
 */
@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UserRoleMappingDAO userRoleMappingDAO;

    public void addRole(RoleRequest roleRequest){
        Long roleId = UserIdGenerateUtils.getRoleId();
        RolePO rolePO = new RolePO();
        rolePO.setRoleId(roleId);
        rolePO.setRoleName(roleRequest.getRoleName());
        rolePO.setDescription(roleRequest.getDescription());
        rolePO.setValid(1);
        rolePO.setCtime(System.currentTimeMillis());
        rolePO.setUtime(System.currentTimeMillis());
        roleDAO.insertRole(rolePO);
    }

    public void deleteRole(RoleRequest roleRequest){

    }
}
