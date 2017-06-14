package com.happygraduation.MVC.pojo;

/**
 * Created by wanghongjie on 2017/5/29.
 */

import java.io.Serializable;

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
public class StudentConn implements Serializable {

    private  String sno;
        private String lunwenFilePath;
    private String yuanmaFilePath;
    private String sname;



    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

            private boolean xuefeistate;
    private boolean tushustate;
    private boolean qicaistate;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getLunwenFilePath() {
        return lunwenFilePath;
    }

    public void setLunwenFilePath(String lunwenFilePath) {
        this.lunwenFilePath = lunwenFilePath;
    }

    public String getYuanmaFilePath() {
        return yuanmaFilePath;
    }

    public void setYuanmaFilePath(String yuanmaFilePath) {
        this.yuanmaFilePath = yuanmaFilePath;
    }

    public boolean isXuefeistate() {
        return xuefeistate;
    }

    public void setXuefeistate(boolean xuefeistate) {
        this.xuefeistate = xuefeistate;
    }

    public boolean isTushustate() {
        return tushustate;
    }

    public void setTushustate(boolean tushustate) {
        this.tushustate = tushustate;
    }

    public boolean isQicaistate() {
        return qicaistate;
    }

    public void setQicaistate(boolean qicaistate) {
        this.qicaistate = qicaistate;
    }
}

