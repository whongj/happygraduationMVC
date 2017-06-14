package com.happygraduation.MVC.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Created by ${wanghongjie} on 2017/6/11.
 */
public class JDBCUtils {
        /**
         * 获取连接
         *
         */
        public static Connection getConnection()
        {
            String driverName = "com.mysql.jdbc.Driver";

            String url = "jdbc:mysql://localhost:3306/happygraduation?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            String user = "root" ;
            String password = "7070120";
            Connection con = null ;
            try {
                Class.forName(driverName);
                con = DriverManager.getConnection(url, user, password);
                System.out.println("success");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return con ;

        }

        /**
         * 关闭连接
         */
        public static void free(ResultSet rs, Statement sta , Connection con)
        {
            try {
                if(null != rs)
                {
                    rs.close();
                    rs = null ;
                }

                if(null != sta)
                {
                    sta.close();
                    sta = null ;
                }

                if(null != con)
                {
                    con.close();
                    con = null ;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
