package com.happygraduation.MVC.dao;

import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.pojo.StudentConn;

import java.util.Set;

/**
 * Create table SudentConn
 *
 *  *
 * 创建学生联系表--
 * varchar sno
 * varchar 论文Filepath
 * varchar 源码filepath
 * boolean 学费state
 * boolean 图书state
 * boolean 器材借用state
 *
 */
/**
 * Created by ${wanghongjie} on 2017/6/11.
 */
public interface StudentConnDAO {
    public int addStudentConn(StudentConn studentConn);

    public int deleteStudentConnfromFilepath(String Sno);

    public int deleteStudentConnfromyuanmafilepath(String Sno);

    public int updateStudentxuefeistate(String Sno,boolean xuefeistate);


    public int updateStudenttushustate(String Sno,boolean tushustate);

    public StudentConn findStudent(String Sno);

    //查找所有学生的剩余
    public Set<StudentConn> findAll();


}
