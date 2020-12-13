package com.cgs.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceBO {
    private Long resourceId;
    private String resourceName;
    private Integer type;
    private Long systemId;
    private String systemName;
    private Long ctime;
    private Long utime;
}
