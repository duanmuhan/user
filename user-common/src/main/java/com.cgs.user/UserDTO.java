package com.cgs.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String passWord;
    private String telPhone;
    private String picUrl;
    private Integer status;
    private Integer vip;
    private String mail;
}
