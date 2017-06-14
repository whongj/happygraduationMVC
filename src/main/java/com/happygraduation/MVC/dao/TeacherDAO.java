package com.happygraduation.MVC.dao;

import com.happygraduation.MVC.pojo.Teacher;

import java.util.Set;

/**
 * Created by ${wanghongjie} on 2017/6/11.
 */
public interface TeacherDAO {
    public int addStudent(Teacher teacher);

    public int deleteStudent(String name);

    public int updateStudent(String Sno,String password);

    public Teacher findStudent(String name);

    public Set<Teacher> findAll();}
