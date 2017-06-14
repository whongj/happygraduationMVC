package com.happygraduation.MVC.service;

import com.happygraduation.MVC.dao.ConcreteStudentConnDAO;
import com.happygraduation.MVC.dao.ConcreteStudentDao;
import com.happygraduation.MVC.dao.StudentConnDAO;
import com.happygraduation.MVC.dao.StudentDAO;
import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.pojo.StudentConn;

import java.util.SimpleTimeZone;

/**
 * Created by ${wanghongjie} on 2017/6/12.
 */
public class studnetservice {
    StudentConnDAO studentConnDAO = new ConcreteStudentConnDAO();
    StudentDAO studentDAO = new ConcreteStudentDao();
    public boolean login(String Sno, String password) {
        Student student = (Student)studentDAO.findStudentbypassword(Sno, password);
        if (student == null) {
            return false;
        }else
            return true;
    }

    public Student getStudentBysno(String Sno,String password) {
        return studentDAO.findStudentbypassword(Sno,password);


    }

    public int add(Student student) {
        return studentDAO.addStudent(student);
    }

    public int addConn(StudentConn studentConn) {
        return studentConnDAO.addStudentConn(studentConn);
    }

}
