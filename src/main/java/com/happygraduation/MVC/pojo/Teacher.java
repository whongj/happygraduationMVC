package com.happygraduation.MVC.pojo;


import java.io.Serializable;

/**
 *admain不可以注册，但是可以对学生信息等进行管理
 * Created by wanghongjie on 2017/5/28.
 */
public class Teacher implements Serializable {
    String Tno;
    String password;

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
