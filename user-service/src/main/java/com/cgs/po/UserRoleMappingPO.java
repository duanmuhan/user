package com.cgs.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleMappingPO {

    private Long userId;
    private String userName;
    private Long roleId;
    private Long roleName;
    private Integer valid;
    private Long ctime;
    private Long utime;
}
