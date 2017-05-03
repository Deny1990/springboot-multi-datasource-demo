package com.yuan.boot.mapper;

import com.yuan.boot.model.Student;

import java.util.List;

/**
 * Created by yuanxin on 17/5/2.
 */
public interface StudentMapper
{
    List<Student> likeName(String name);

    Student getById(int id);

    String getNameById(int id);

}
