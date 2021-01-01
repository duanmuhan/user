package com.cgs.dao;

import org.springframework.stereotype.Repository;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:00
 */
@Repository
public interface ResourceDAO {

    String TABLE = "resource_info";

    String COLUMNS = "resource_id, resource_name, valid, description";


}
