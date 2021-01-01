package com.cgs.service;

import com.cgs.dao.RoleDAO;
import com.cgs.po.UserPO;
import com.cgs.constant.Constant;
import com.cgs.dao.UserDAO;
import com.cgs.dto.UserDTO;
import com.cgs.utils.ResponseUtils;
import com.cgs.utils.UserIdGenerateUtils;
import constant.ErrorCode;
import constant.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private RedisTemplate redisTemplate;

    public Response register(UserDTO user, HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        Response response = new Response();
        try {
            UserPO phoneUser = userDAO.queryUserByPhone(user.getTelPhone());
            if (!ObjectUtils.isEmpty(phoneUser)){
                response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"用户电话已经注册");
                return response;
            }
            UserPO mailUser = userDAO.queryUserByMail(user.getMail());
            if (!ObjectUtils.isEmpty(phoneUser)){
                response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"用户邮箱已经注册");
                return response;
            }
            String token = generateUserToken(user.getPassWord());
            redisTemplate.opsForValue().set(token,"",60 * 30 , TimeUnit.SECONDS);
            servletResponse.addHeader("token",token);
            UserPO storeUser = new UserPO();
            userDAO.insert(storeUser);
        }catch (Exception e){
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,e.getMessage());
        }
        return response;
    }

    public Response login(String userName, String passWord, HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        Response response = new Response();
        try {
            UserPO user = userDAO.queryUserByUserName(userName);
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
            Cookie cookie = new Cookie("token",token);
            servletResponse.addCookie(cookie);
            redisTemplate.opsForValue().set(token,"",60 * 30 , TimeUnit.SECONDS);
            userDAO.updateLoginStatus(user.getUserId(),1);
        }catch (Exception e){
            response = ResponseUtils.buildResponseByCode(ErrorCode.EXCEPTION,e.getMessage());
        }
        return response;
    }

    public Response logout(HttpServletRequest servletRequest){
        Cookie[] cookies = servletRequest.getCookies();
        Response response = new Response();
        if (ObjectUtils.isEmpty(cookies)){
            response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"未登陆系统");
            return response;
        }
        String token = null;
        for (Cookie cookie : cookies){
            if ("token".equals(cookie.getName())){
                token = cookie.getValue();
            }
        }
        if (StringUtils.isEmpty(token)){
            response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"未登陆系统");
            return response;
        }
        redisTemplate.delete(token);
        response = ResponseUtils.buildResponseByCode(ErrorCode.OK,null);
        return response;
    }

    public Response auth(HttpServletRequest servletRequest){
        Response response = null;
        Cookie[] cookies = servletRequest.getCookies();
        if (ObjectUtils.isEmpty(cookies)){
            response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"未登陆系统");
            return response;
        }
        String token = null;
        for (Cookie cookie : cookies){
            if ("token".equals(cookie.getName())){
                token = cookie.getValue();
            }
        }
        if (StringUtils.isEmpty(token) || !redisTemplate.hasKey(token)){
            response = ResponseUtils.buildResponseByCode(ErrorCode.LOGIN_ERROR,"未登陆系统");
            return response;
        }
        return response;
    }

    private String generateUserToken(String passWord){
        String str = passWord + Constant.SALT_STR + System.currentTimeMillis();
        String token  = DigestUtils.md5DigestAsHex(str.getBytes());
        return token;
    }

    private UserPO convertUser(UserDTO userDTO){
        UserPO user = new UserPO();
        user.setUserId(UserIdGenerateUtils.getUserId());
        user.setUserName(userDTO.getUserName());
        String finalPassword = userDTO.getPassWord() + Constant.SALT_STR;
        user.setPassWord(DigestUtils.md5DigestAsHex(finalPassword.getBytes()));
        user.setTelPhone(userDTO.getTelPhone());
        user.setPicUrl(userDTO.getPicUrl());
        user.setMail(userDTO.getMail());
        return user;
    }
}
