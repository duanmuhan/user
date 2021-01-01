package com.cgs.vo;

import lombok.Data;

import java.util.List;

/**
 * @author caoguangshu
 * @date 2021/1/2
 * @time 上午12:44
 */
@Data
public class UserInfoVO {
    private UserVO user;
    private List<RoleVO> roleList;
    private List<ResourceVO> resourceList;
}
