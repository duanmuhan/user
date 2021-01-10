package com.cgs.service;

import com.cgs.dao.ResourceDAO;
import com.cgs.po.ResourcePO;
import com.cgs.request.ResourceRequest;
import com.cgs.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoguangshu
 * @date 2021/1/2
 * @time 上午12:42
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceDAO resourceDAO;

    public void addResource(ResourceRequest resource){
        ResourcePO po = new ResourcePO();
        po.setResourceId(resource.getResourceId());
        po.setName(resource.getResourceName());
        po.setDescription(resource.getDescription());
        po.setValid(1);
        resourceDAO.addResource(po);
    }

    List<ResourceVO> queryResourceList(){
        return new ArrayList<>();
    }
}
