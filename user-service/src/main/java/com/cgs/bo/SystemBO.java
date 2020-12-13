package com.cgs.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午3:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemBO {
    private Long systemId;
    private String systemName;
    private Integer type;
    private String description;
    private Long ctime;
    private Long utime;
}
