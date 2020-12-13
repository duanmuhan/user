package com.cgs.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午4:08
 */
@Data
public class UserRoleDTO {

    @NotNull(message = "userId 不能为空")
    private Long userId;
    @NotNull(message = "userName 不能为空")
    private String userName;
    @NotNull(message = "roleId不能为空")

    @NotNull(message = "系统id不能为空")
    private Long systemId;
    @NotNull(message = "系统名称不能为空")
    private Long systemName;

    private Long roleId;
    @NotNull(message = "roleName不能为空")
    private Long roleName;
}
