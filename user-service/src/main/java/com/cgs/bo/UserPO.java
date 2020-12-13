package com.cgs.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    private String systemName;

    private Long ctime;

    private Long utime;
}
