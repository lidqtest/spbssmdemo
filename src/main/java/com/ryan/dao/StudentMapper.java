package com.ryan.dao;

import com.ryan.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/3/29.
 */

@Mapper
@Component(value = "studentMapper")
public interface StudentMapper {


    Student selectByPrimaryKey(@Param("id") Integer id);


}
