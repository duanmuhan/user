package com.cgs.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午2:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePO {
    private Long roleId;
    private String roleName;
    private String description;
    private Integer valid;
    private Long ctime;
    private Long utime;
}
