package com.cgs.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caoguangshu
 * @date 2020/12/13
 * @time 下午2:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {

    private Long userId;

    private String userName;

    private String passWord;

    private String telPhone;

    private String picUrl;

    private String mail;

    private Long systemId;

    private Long roleId;

    private Integer loginStatus;

    private String systemName;

    private Long ctime;

    private Long utime;
}
