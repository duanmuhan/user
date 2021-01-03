package com.cgs.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author caoguangshu
 * @date 2021/1/3
 * @time 下午5:59
 */
@Data
public class ResourceRequest {

    @NotNull(message = "resourceId不能为空")
    private String resourceId;

    @NotNull(message = "resourceName不能为空")
    private String resourceName;

    @NotNull(message = "资源描述不能为空")
    private String description;
}
