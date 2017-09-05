package com.happygraduation.MVC.controller;

import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.service.studnetservice;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ${zhanghong} on 2017/6/15.
 */
@WebServlet(name = "register",urlPatterns = "/register")
public class enroll extends HttpServlet {

    studnetservice studnetser = new studnetservice();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Sno
        String Sno;
        String password;
        Sno = req.getParameter("username");
        password = req.getParameter("password");
        Student student = new Student();
        student.setPassword(password);
        student.setSno(Sno);

        if (0 < studnetser.add(student)) {
            resp.sendRedirect("/user/success.jsp");
        }else
            resp.sendRedirect("error.jsp");


    }
}
