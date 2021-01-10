package com.cgs.dao;

import com.cgs.po.ResourcePO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:00
 */
@Repository
public interface ResourceDAO {

    String TABLE_NAME = "resource_info";

    String COLUMNS = "resource_id, resource_name, valid, description";


    @Results( id = "resultMap",value = {
            @Result(property = "resourceId",column = "resource_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "description",column = "description"),
            @Result(property = "valid",column = "valid")
    })

    @Insert("insert into " + TABLE_NAME + "(" + COLUMNS + ")"
            + " values (#{resource.resourceId}, #{resource.name}, #{resource.description}, #{resource.valid} )")
    void addResource(@Param("resource") ResourcePO resourcePO);

    @Select("select * from " + TABLE_NAME + " where valid = 1 ")
    @ResultMap(value = "resultMap")
    List<ResourcePO> queryAllResources();
}
