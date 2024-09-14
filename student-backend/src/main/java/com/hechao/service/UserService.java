package com.hechao.service;

import com.hechao.entry.User;
import com.hechao.vo.GetAllUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User login(String username, String password);
    List<GetAllUserInfo> getAllUserInfo();

    List<GetAllUserInfo> searchByNumber(@Param("number") String number);

    List<GetAllUserInfo> searchByClassName(@Param("name") String name);
}
