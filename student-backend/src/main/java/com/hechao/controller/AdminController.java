package com.hechao.controller;

import com.hechao.service.ClassService;
import com.hechao.service.UserService;
import com.hechao.vo.GetAllUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hechao.entry.Class;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ClassService classService;

    // 查询所有用户
    @GetMapping("/GetAllUserInfo")
    public Result list() {
        List<GetAllUserInfo> allUserInfo = userService.getAllUserInfo();
        System.out.println(allUserInfo);
        return new Result(200, "查询成功", allUserInfo);
    }

    //获取所有班级信息
    @GetMapping("/GetClassList")
    public Result getClassList() {
        List<Class> classList = classService.selectAll();
        System.out.println(classList);
        return new Result(200, "查询成功", classList);

    }


    //根据学号查询学生信息
    @GetMapping("/searchByNumber/{number}")
    public Result searchByNumber(@PathVariable("number") String number) {
        System.out.println("根据学号查询学生信息"+number);
        List<GetAllUserInfo> userInfo = userService.searchByNumber(number);
        System.out.println(userInfo);
        return new Result(200, "查询成功", userInfo);

    }


    //根据班级名称查询学生信息
    @GetMapping("/searchByClassName/{name}")
    public Result searchByClassId(@PathVariable("name") String  name) {
        System.out.println("根据班级名称查询学生信息"+name);
        List<GetAllUserInfo> userInfo = userService.searchByClassName(name);
        System.out.println(userInfo);
        return new Result(200, "查询成功", userInfo);

    }

}
