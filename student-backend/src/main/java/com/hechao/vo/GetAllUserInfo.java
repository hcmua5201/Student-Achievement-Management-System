package com.hechao.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserInfo {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String phone;
    private String gender;
    private String number;
    private String classId;
//    班级名称
    private String name;
}
