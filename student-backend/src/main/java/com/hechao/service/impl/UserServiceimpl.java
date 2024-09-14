package com.hechao.service.impl;

import com.hechao.entry.User;
import com.hechao.mapper.UserMapper;
import com.hechao.service.UserService;
import com.hechao.vo.GetAllUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceimpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public List<GetAllUserInfo> getAllUserInfo() {
        return userMapper.getAllUserInfo();
    }

    @Override
    public List<GetAllUserInfo> searchByNumber(String number) {
        return userMapper.searchByNumber(number);
    }

    @Override
    public List<GetAllUserInfo> searchByClassName(String name) {
        return userMapper.searchByClassName(name);
    }


}
