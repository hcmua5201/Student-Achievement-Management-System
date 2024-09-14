package com.hechao.controller;

import com.hechao.entry.User;
import com.hechao.service.UserService;
import com.hechao.vo.GetAllUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    //    登录，根据用户名和密码验证用户是否存在
    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role) {

        System.out.println("username:" + username + " password:" + password + " role:" + role);

        //        检查是否为空
        if (username == null || password == null) {
            return new Result( 400, "用户名或密码不能为空", null);
        }
        // 调用service层方法验证用户是否存在
        User login = userService.login(username, password);
        if (login == null) {
            return new Result(400, "用户名或密码错误", null);
        }
        // 验证角色是否正确,如果角色不正确，则返回401
        if (!login.getRole().equals(role)) {
            return new Result(400, "权限不足", null);
        }
        // 登录成功，返回token
        return new Result(200, "登录成功", login);

    }







}
