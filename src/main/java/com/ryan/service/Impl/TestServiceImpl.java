package com.ryan.service.Impl;

import com.ryan.dao.StudentMapper;
import com.ryan.pojo.Student;
import com.ryan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/29.
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student testService() {
        Student stu = studentMapper.selectByPrimaryKey(1);
        return stu;
    }
}
