package com.happygraduation.MVC.dao;

import com.happygraduation.MVC.Exception.DAOException;
import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.pojo.StudentConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Create table SudentConn
 *
 *  *
 * 创建学生联系表--
 * varchar sno
 * varchar sname
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
public class ConcreteStudentConnDAO implements StudentConnDAO {

    public int deleteStudentConn(String sno){
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "delete from studentConn where Sno =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, sno);

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


    public int addStudentConn(StudentConn studentConn) {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "insert into StudentConn(Sno,sname,lunwenfilepath,yuanmafilepath,xuefeistate,tushustate,qicaistate)" +
                    " values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, studentConn.getSno());
            ps.setString(2, studentConn.getSname());
            ps.setString(3, studentConn.getLunwenFilePath());
            ps.setString(4, studentConn.getYuanmaFilePath());
            ps.setBoolean(5, studentConn.isXuefeistate());
            ps.setBoolean(6, studentConn.isTushustate());
            ps.setBoolean(7, studentConn.isQicaistate());

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

//待定
    public int deleteStudentConnfromFilepath(String Sno) {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "update studentconn set filepath  where Sno =?";
            ps = con.prepareStatement(sql);
//            ps.setString(1, password);
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
//待定
    public int deleteStudentConnfromyuanmafilepath(String Sno) {
        return 0;
    }

    public int updateStudentxuefeistate(String Sno, boolean xuefeistate) {
        return 0;
    }

    public int updateStudenttushustate(String Sno, boolean tushustate) {
        return 0;
    }

    public int updateStudentqicaistate(String Sno, boolean qicaistate) {
        return 0;
    }

    public int updateStudentConnyuanmaFilepath(String Sno, String path) {
        return 0;
    }

    public int updateStudentConnshuomingshuFilepath(String Sno, String shuomingshuFilepath) {
        return 0;
    }

    public int updateStudentConnshuomingshuFilepath() {
        return 0;
    }

    //查询一行 通过Sno
    public StudentConn findStudent(String Sno)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        StudentConn studentConn = null ;
        ResultSet rs = null;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select Sname ,lunwenfilepath,yuanmafilepath,xuefeistate,tushustate,qicaistate from studentconn where Sno =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Sno);
            rs = ps.executeQuery() ;
            studentConn = new StudentConn();
            while(rs.next())
            {
                studentConn.setSname(rs.getString(1));
                studentConn.setLunwenFilePath(rs.getString(2));
                studentConn.setYuanmaFilePath(rs.getString(3));
                studentConn.setXuefeistate(rs.getBoolean(4));
                studentConn.setTushustate(rs.getBoolean(5));
                studentConn.setQicaistate(rs.getBoolean(6));
                studentConn.setSno(Sno);
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

        return studentConn;
    }

    //查询所有
    public Set<StudentConn> findAll()
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        StudentConn stu = null ;
        ResultSet rs = null;
        Set<StudentConn> set = null ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select Sname ,lunwenfilepath,yuanmafilepath,xuefeistate,tushustate,qicaistate from studentconn";
            ps = con.prepareStatement(sql);
            set = new HashSet<StudentConn>() ;
            rs = ps.executeQuery() ;

            while(rs.next())
            {
                stu = new StudentConn();
                stu.setSname(rs.getString(1));
                stu.setLunwenFilePath(rs.getString(2));
                stu.setYuanmaFilePath(rs.getString(3));
                stu.setXuefeistate(rs.getBoolean(4));
                stu.setTushustate(rs.getBoolean(5));
                stu.setQicaistate(rs.getBoolean(6));
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
}
