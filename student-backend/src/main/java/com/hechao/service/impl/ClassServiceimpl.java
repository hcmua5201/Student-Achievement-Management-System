package com.hechao.service.impl;

import com.hechao.mapper.ClassMapper;
import com.hechao.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hechao.entry.Class;
import java.util.List;


@Service
public class ClassServiceimpl implements ClassService {


    @Autowired
    ClassMapper classMapper;
    @Override
    public List<Class> selectAll() {
        return classMapper.selectAll();
    }
}
