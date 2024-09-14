package com.hechao.mapper;


import com.hechao.entry.User;
import com.hechao.vo.GetAllUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    // 用户登录
    // 根据用户名和密码查询用户
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password} ")
    User login(@Param("username") String username,@Param("password") String password);


    //连表查询user表和class表，获取所有用户的个人信息和班级信息，返回List<User>，user表的字段class_id对应class表的id字段
    @Select("SELECT u.*,c.name  FROM user u LEFT JOIN class c ON u.class_id = c.id")
    List<GetAllUserInfo> getAllUserInfo();

    ////根据学号number模糊查询学生信息，返回List user表的字段class_id对应class表的id字段
    @Select("SELECT u.*,c.name  FROM user u LEFT JOIN class c ON u.class_id = c.id WHERE u.number LIKE CONCAT('%',#{number},'%')")
    List<GetAllUserInfo> searchByNumber(@Param("number") String number);

    ////根据班级名称查询学生信息，返回List user表的字段class_id对应class表的id字段
    @Select("SELECT u.*,c.name  FROM user u LEFT JOIN class c ON u.class_id = c.id WHERE c.name = #{name}")
    List<GetAllUserInfo> searchByClassName(@Param("name") String name);




}
