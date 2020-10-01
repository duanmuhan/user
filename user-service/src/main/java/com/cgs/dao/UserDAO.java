package com.cgs.dao;

import com.cgs.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    String TABLE_NAME = " user_info ";

    public void insert(User user);

    public void updateLoginStatus(Long userId,Integer status);

    public User queryUserByPhone(String phone);

    public User queryUserByMail(String mail);

    public User queryUserByUserName(String userName);


}
