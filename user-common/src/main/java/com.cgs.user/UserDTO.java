package com.cgs.user;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDTO implements Serializable {
    private Long userId;
    private String userName;
    private String maskPhone;
    private String picUrl;
    private Integer status;
    private Integer vip;
    private String mail;
    private RoleDTO roleList;

}
