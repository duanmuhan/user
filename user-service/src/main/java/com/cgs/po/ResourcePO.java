package com.cgs.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2021/1/2
 * @time 上午1:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourcePO {

    private String resourceId;
    private String name;
    private String description;
    private Integer valid;

}
