package com.yuan.boot.service;

import com.yuan.boot.dataconfig.TargetDataSource;
import com.yuan.boot.mapper.StudentMapper;
import com.yuan.boot.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuanxin on 17/5/2.
 */
@Service
public class StudentService
{
    @Resource
    StudentMapper studentMapper;

    public List<Student> getStudents(String name){
        List<Student> list = studentMapper.likeName(name);
        return list;
    }

    @TargetDataSource(name="ds2")
    public List<Student> getStudentsByDs2(String name){
        List<Student> list =  studentMapper.likeName(name);
        return list;
    }
}
