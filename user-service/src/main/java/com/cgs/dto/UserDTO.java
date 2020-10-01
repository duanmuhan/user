package com.cgs.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {

    @NotNull(message = "用户名称不能为空")
    @Length(max = 20,message = "用户名称长度不得超过20")
    private String userName;

    @NotNull(message = "用户名称不能为空")
    @Length(max = 20, message = "密码长度不得超过20")
    private String passWord;

    @NotNull(message = "电话号码不能为空")
    private String telPhone;

    private String authCode;

    private String picUrl;
    @NotNull(message = "邮箱名称不能为空")
    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱必须符合邮箱格式")
    private String mail;

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("test");
        userDTO.setTelPhone("15210092031");
        userDTO.setAuthCode("12345");
        userDTO.setPassWord("123123");
        userDTO.setPicUrl("123123");
        userDTO.setMail("123123123123");

        String str = JSON.toJSONString(userDTO);
        System.out.println(str);
    }
}


