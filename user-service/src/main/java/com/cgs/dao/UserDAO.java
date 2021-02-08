package com.cgs.dao;

import com.cgs.po.UserPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    String TABLE_NAME = " user_info ";

    String COLUMNS = " user_id, user_name, pass_word, tel_phone, pic_url, status, vip, mail , valid ";

    @Insert("insert into " + TABLE_NAME + "(" + COLUMNS + ")"
            + " values (#{user.userId}, #{user.userName}, #{user.passWord}, #{user.telPhone}, #{user.picUrl}, #{user.status}, #{user.vip}, #{user.mail} )")
    public void insert(@Param("user") UserPO user);

    @Update(" update " + TABLE_NAME + " set status = status where user_id=#{userId} ")
    public void updateLoginStatus(@Param("userId") Long userId, @Param("status") Integer status);

    @Results( id = "resultMap",value = {
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "passWord",column = "pass_word"),
            @Result(property = "telPhone",column = "tel_phone"),
            @Result(property = "picUrl",column = "pic_url"),
            @Result(property = "status",column = "status"),
            @Result(property = "vip",column = "vip"),
            @Result(property = "mail",column = "mail"),
    })
    @Select(" select * from " + TABLE_NAME + " where tel_phone=#{phone} ")
    public UserPO queryUserByPhone(@Param("phone") String phone);

    @ResultMap(value="resultMap")
    @Select(" select * from " + TABLE_NAME + " where mail=#{mail} and valid=1 ")
    public UserPO queryUserByMail(@Param("mail") String mail);

    @ResultMap(value="resultMap")
    @Select(" select * from " + TABLE_NAME + " where user_name=#{userName} and valid=1 ")
    public UserPO queryUserByUserName(@Param("userName") String userName);

    @Select(" select * from " + TABLE_NAME + " where user_id=#{userId}")
    @ResultMap(value = "resultMap")
    public UserPO queryUserByUserId(@Param("userId") Long userId);

}
