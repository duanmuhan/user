package com.cgs.service;

import com.cgs.dao.ResourceDAO;
import com.cgs.po.ResourcePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caoguangshu
 * @date 2021/1/2
 * @time 上午12:42
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceDAO resourceDAO;

    public void addResource(ResourcePO resource){

    }
}
