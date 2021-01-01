package com.cgs.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author caoguangshu
 * @date 2020/12/28
 * @time 上午2:47
 */
@Data
public class RoleRequest {

    @NotNull(message = "角色名称不能为空")
    private String roleName;
    @NotNull(message = "角色描述不能为空")
    private String description;
}
