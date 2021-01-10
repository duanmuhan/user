package com.cgs.dao;

import com.cgs.po.RolePO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO {

    String TABLE_NAME = " role_info ";

    String COLUMNS = "role_id, role_name, description, ctime, utime";

    @Results( id = "resultMap",value = {
            @Result(property = "roleId",column = "role_id"),
            @Result(property = "roleName",column = "role_name"),
            @Result(property = "description",column = "description"),
            @Result(property = "ctime",column = "ctime"),
            @Result(property = "utime",column = "utime")
    })

    @Insert(" insert into " + TABLE_NAME + "(" + COLUMNS + ")"
            + "values (#{role.roleId},#{role.roleName},#{role.description},#{role.valid},#{role.ctime},#{role.utime})")
    public void insertRole(@Param("role")RolePO rolePO);

    @Select("select * from " + TABLE_NAME + " where valid = 1 ")
    @ResultMap(value = "resultMap")
    List<RolePO> queryRole();
}
