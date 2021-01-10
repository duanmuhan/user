package com.cgs.dao;

import com.cgs.po.RoleResourceMappingPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午2:57
 */
@Repository
public interface RoleResourceMappingDAO {

    String TABLE_NAME = "role_resource_mapping";

    String COLUMNS = "role_id, role_name, resource_id, resource_name, valid, ctime, utime ";


    @Results( id = "resultMap",value = {
            @Result(property = "roleId",column = "resource_id"),
            @Result(property = "roleName",column = "name"),
            @Result(property = "resourceId",column = "resource_id"),
            @Result(property = "resourceName",column = "resource_name"),
            @Result(property = "valid",column = "valid"),
            @Result(property = "ctime",column = "ctime"),
            @Result(property = "utime",column = "utime"),
    })


    @Insert("insert into " + TABLE_NAME + "(" + COLUMNS + ")"
            + " values (#{roleResourceMapping.roleId}, #{roleResourceMapping.roleName}, #{roleResourceMapping.resourceId}, #{roleResourceMapping.resourceName}" +
            ", #{roleResourceMapping.valid}, #{roleResourceMapping.ctime} , #{roleResourceMapping.utime}  )")
    public void addRoleResourceMapping(@Param("roleResourceMapping") RoleResourceMappingPO roleResourceMappingPO);

    @Select("select * from " + TABLE_NAME + " where valid = 1 ")
    @ResultMap(value = "resultMap")
    public List<RoleResourceMappingPO> queryRoleResourceMappingList();

    @Select("select * from " + TABLE_NAME + " where valid = 1 and role_id = #{roleId}")
    @ResultMap(value = "resultMap")
    public List<RoleResourceMappingPO> queryRoleResourceMappingByRoleId(@Param("roleId") Long roleId);

    @Select("select * from " + TABLE_NAME + " where valid = 1 and resource_id = #{resourceId}")
    @ResultMap(value = "resultMap")
    public List<RoleResourceMappingPO> queryRoleResourceMappingByResourceId(@Param("resourceId") Long resourceId);
}
