package com.cgs.dao;

import com.cgs.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    String TABLE_NAME = " user_info ";

    String COLUMNS = " user_id, user_name, pass_word, tel_phone, pic_url, status, vip, mail ";

    @Insert("insert into " + TABLE_NAME + "(" + COLUMNS + ")"
            + " values (#{user.userId}, #{item.exchangeId}, #{item.name}, #{item.listingDate}, #{item.exchangeId}, #{item.name}, #{item.listingDate} )")
    public void insert(User user);

    @Update("")
    public void updateLoginStatus(Long userId,Integer status);

    @Select("")
    public User queryUserByPhone(String phone);

    @Select("")
    public User queryUserByMail(String mail);

    @Select("")
    public User queryUserByUserName(String userName);


}
