package com.cgs.dao;

import com.cgs.po.RolePO;
import com.cgs.po.UserRoleMappingPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMappingDAO {

    String TABLE_NAME = " user_role_mapping ";

    String COLUMNS = " user_id, user_name, role_id, role_name,valid, ctime, utime ";

    @Insert(" insert into " + TABLE_NAME + "(" + COLUMNS + ")" + " values " +
            " values" +
            " (#{userRole.userId}, #{userRole.userName}, #{userRole.roleId}," +
            " #{userRole.roleName}, #{userRole.systemId}, #{userRole.systemName}," +
            " #{userRole.valid}, #{userRole.ctime}, #{userRole.utime} )")
    public void insertUserRollMapping(@Param("userRole") UserRoleMappingPO userRoleMappingPO);


    public RolePO

}
