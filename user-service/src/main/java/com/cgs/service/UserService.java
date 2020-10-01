package com.cgs.service;

import com.cgs.constant.Constant;
import com.cgs.dao.UserDAO;
import com.cgs.dto.UserDTO;
import com.cgs.user.User;
import com.cgs.utils.ResponseUtils;
import constant.ErrorCode;
import constant.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RedisTemplate redisTemplate;


    public Response register(UserDTO user, HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        Response response = new Response();
        try {
            User storeUser = convertUser(user);
            String token = generateUserToken(storeUser.getPassWord());
            redisTemplate.opsForValue().set(token,"",60 * 30 , TimeUnit.SECONDS);
            servletResponse.addHeader("token",token);
            userDAO.insert(storeUser);
        }catch (Exception e){
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,e.getMessage());
        }
        return response;
    }

    public Response login(String userName, String passWord, HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        Response response = new Response();
        try {
            User user = userDAO.queryUserByUserName(userName);
            if (ObjectUtils.isEmpty(user)){
                response = new Response(ErrorCode.LOGIN_ERROR.getCode(),ErrorCode.LOGIN_ERROR.getMessage(),null);
                return response;
            }
            String passWordMd5 = DigestUtils.md5DigestAsHex((passWord + Constant.SALT_STR).getBytes());
            if (!passWordMd5.equals(user.getPassWord())){
                response = new Response(ErrorCode.LOGIN_ERROR.getCode(),ErrorCode.LOGIN_ERROR.getMessage(),null);
                return response;
            }
            String token = generateUserToken(user.getPassWord());
            servletResponse.addHeader("token",token);
            redisTemplate.opsForValue().set(token,"",60 * 30 , TimeUnit.SECONDS);
            userDAO.updateLoginStatus(user.getUserId(),1);
        }catch (Exception e){
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,e.getMessage());
        }
        return response;
    }

    public Response logout(HttpServletRequest servletRequest){
        return new Response();
    }

    private String generateUserToken(String passWord){
        String str = passWord + Constant.SALT_STR + System.currentTimeMillis();
        String token  = DigestUtils.md5DigestAsHex(str.getBytes());
        return token;
    }

    private User convertUser(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUserName());
        String finalPassword = userDTO.getPassWord() + Constant.SALT_STR;
        user.setPassWord(DigestUtils.md5DigestAsHex(finalPassword.getBytes()));
        user.setTelPhone(userDTO.getTelPhone());
        user.setPicUrl(userDTO.getPicUrl());
        user.setStatus(1);
        user.setMail(userDTO.getMail());
        return user;
    }
}
