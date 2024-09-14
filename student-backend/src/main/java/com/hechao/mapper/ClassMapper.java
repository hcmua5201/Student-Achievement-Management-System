package com.hechao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.hechao.entry.Class;
import java.util.List;

@Mapper
public interface ClassMapper {


//    查询所有班级信息
    @Select("SELECT * FROM class")
    List<Class> selectAll();
}
