package com.cgs.user;

import lombok.Data;

@Data
public class UserLogEntity {
    private Long userId;
    private String loginTime;
    private String logoutTime;
    private Integer eventType;
}
