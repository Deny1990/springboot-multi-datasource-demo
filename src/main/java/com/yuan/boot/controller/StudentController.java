package com.yuan.boot.controller;

import com.yuan.boot.model.Student;
import com.yuan.boot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuanxin on 17/5/2.
 */
@Controller
public class StudentController
{
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Resource
    StudentService studentService;

    @RequestMapping("/getByName")
    @ResponseBody
    public List<Student> getStudentByName(){
       List<Student> list =  studentService.getStudents("YUANXIN");
        return list;
    }

    @RequestMapping("/getByDS2")
    @ResponseBody
    public List<Student> getStudentByDs2(){
        List<Student> list =  studentService.getStudentsByDs2("YUANXIN");
        return list;
    }
}
