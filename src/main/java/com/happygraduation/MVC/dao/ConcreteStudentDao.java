package com.happygraduation.MVC.dao;

import com.happygraduation.MVC.Exception.DAOException;
import com.happygraduation.MVC.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ${wanghongjie} on 2017/6/11.
 */
public class ConcreteStudentDao implements StudentDAO{

    //增加一个学生
    public int addStudent(Student student)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "insert into student(Sno,Sname,password) values(?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, student.getSno());
            ps.setString(2, student.getSname());
            ps.setString(3, student.getPassword());

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }
        return i;
    }

    //根据学号删除一个学生
    public int deleteStudent(String Sno)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "delete from student where Sno =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Sno);

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }

    //修改一个学生密码
    public int updateStudent(String Sno,String password)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "update student set password=?  where Sno =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, Sno);
            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }
    //查询一行 通过Sno
    public Student findStudent(String Sno)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select Sname  from student where Sno =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Sno);

            rs = ps.executeQuery() ;
            stu = new Student();
            while(rs.next())
            {
                stu.setSname(rs.getString(1));

            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return stu;
    }

    //查询所有
    public Set<Student> findAll()
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        Set<Student> set = null ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select Sname,Sno,password from student";
            ps = con.prepareStatement(sql);

            set = new HashSet<Student>() ;
            rs = ps.executeQuery() ;

            while(rs.next())
            {
                stu = new Student();
                stu.setSname(rs.getString(1));
                stu.setSno(rs.getString(2));
                stu.setPassword(rs.getString(3));
                set.add(stu);
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return set;
    }

    public Student findStudentbypassword(String Sno, String password) {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        Set<Student> set = null ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select Sname from student WHERE  Sno=? AND Password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,Sno);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next())
            {
                stu = new Student();
                stu.setSname(rs.getString(1));
                stu.setSno(Sno);
                stu.setPassword(password);
                System.out.println(stu);
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return stu;
    }

}