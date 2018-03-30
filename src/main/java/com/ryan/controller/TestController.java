package com.ryan.controller;

import com.ryan.pojo.Student;
import com.ryan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/29.
 */

@Controller
public class TestController {

    @Autowired
    private TestService testServiceImpl;

    @RequestMapping(value="test",method = RequestMethod.GET)
    public String testController(){
        Student stu = testServiceImpl.testService();
        System.out.println("学生id为：" + stu.getId());
        System.out.println("学生姓名为：" + stu.getName());
        System.out.println("学生年龄为：" + stu.getAge());
        return "/index";
    }

}
