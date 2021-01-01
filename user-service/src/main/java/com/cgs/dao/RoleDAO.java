package com.cgs.dao;

import com.cgs.po.RolePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO {

    String TABLE_NAME = " role_info ";

    String COLUMNS = "role_id, role_name, description, ctime, utime";

    @Insert(" insert into " + TABLE_NAME + "(" + COLUMNS + ")"
            + "values (#{role.roleId},#{role.roleName},#{role.description},#{role.valid},#{role.ctime},#{role.utime})")
    public void insertRole(@Param("role")RolePO rolePO);

}
