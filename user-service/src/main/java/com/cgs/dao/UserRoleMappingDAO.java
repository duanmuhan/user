package com.cgs.dao;

import com.cgs.po.RolePO;
import com.cgs.po.UserRoleMappingPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMappingDAO {

    String TABLE_NAME = " user_role_mapping ";

    String COLUMNS = " user_id, user_name, role_id, role_name,valid, ctime, utime ";

    @Results( id = "resultMap",value = {
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "roleId",column = "role_id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "valid",column = "valid"),
            @Result(property = "ctime",column = "ctime"),
            @Result(property = "utime",column = "utime")
    })

    @Insert(" insert into " + TABLE_NAME + "(" + COLUMNS + ")" + " values " +
            " values" +
            " (#{userRole.userId}, #{userRole.userName}, #{userRole.roleId}," +
            " #{userRole.roleName}, #{userRole.systemId}, #{userRole.systemName}," +
            " #{userRole.valid}, #{userRole.ctime}, #{userRole.utime} )")
    public void insertUserRollMapping(@Param("userRole") UserRoleMappingPO userRoleMappingPO);


    @Select("select * from " + TABLE_NAME + " where user_id = #{userId} ")
    @ResultMap(value = "resultMap")
    public UserRoleMappingPO queryUserRoleMappingByUserId(@Param("userId") Long userId);


}
