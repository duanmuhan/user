package com.cgs.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResourceMappingBO {
    private Long roleId;
    private String roleName;
    private Long resourceId;
    private String resourceName;
    private Long systemId;
    private Long systemName;
    private Integer valid;
    private Long ctime;
    private Long utime;
}
