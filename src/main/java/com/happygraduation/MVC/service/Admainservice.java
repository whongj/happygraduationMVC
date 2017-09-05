package com.happygraduation.MVC.service;

import com.happygraduation.MVC.dao.ConcreteStudentConnDAO;
import com.happygraduation.MVC.dao.ConcreteStudentDao;
import com.happygraduation.MVC.dao.StudentConnDAO;
import com.happygraduation.MVC.dao.StudentDAO;
import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.pojo.StudentConn;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by wanghongjie on 2017/6/15.
 */
public class Admainservice {
    StudentDAO studentDAO = new ConcreteStudentDao();
    StudentConnDAO studentConnDAO = new ConcreteStudentConnDAO();



//还得看一下数据分页
    public HashSet<StudentConn> findallStudentConn(){
        return (HashSet<StudentConn>) studentConnDAO.findAll();
    }


    public boolean updatetushustate(String Sno, boolean tushustate){
        if(0<studentConnDAO.updateStudenttushustate(Sno, tushustate)){
            return true;
        }else
            return false;
    }

    public boolean updatexuefeistate(String Sno,boolean xuefeistate){
        if (0 < studentConnDAO.updateStudentxuefeistate(Sno, xuefeistate)) {
            return true;
        }else
            return false;

    }

    public boolean updatexueqicai(String Sno,boolean qicaistate){
        if (0 < studentConnDAO.updateStudentqicaistate(Sno, qicaistate)) {
            return true;
        }else
            return false;

    }


    public boolean deletestudent(String Sno) {
        if (0 < studentDAO.deleteStudent(Sno) && 0 < studentConnDAO.deleteStudentConn(Sno)) {
            return true;
        }else
            return false;
    }

    public boolean addAStudentConn(StudentConn studentConn) {
        if (0 < studentConnDAO.addStudentConn(studentConn)) {
            return true;
        }else
            return false;
    }

//
//    public boolean addyuanmaFilepath(String yuanmafilepath,String sno){
//        if (0<studentConnDAO)
//    }
//


}
