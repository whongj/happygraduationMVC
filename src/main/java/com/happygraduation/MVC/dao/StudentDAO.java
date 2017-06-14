package com.happygraduation.MVC.dao;

import com.happygraduation.MVC.pojo.Student;

import java.util.Set;

/**
 * Created by ${wanghongjie} on 2017/6/11.
 */
public interface StudentDAO {
    public int addStudent(Student student);

    public int deleteStudent(String name);

    public int updateStudent(String Sno,String password);

    public Student findStudent(String name);

    public Set<Student> findAll();

    public Student findStudentbypassword(String Sno, String password);

}
