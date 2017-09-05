package com.happygraduation.MVC.controller;

import com.happygraduation.MVC.pojo.Teacher;
import com.happygraduation.MVC.service.Admainservice;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.TableHeaderUI;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhonghong on 2017/6/15.
 */
@WebServlet(name = "admainlogin",urlPatterns = "/adminlogin")
public class admainlogin extends HttpServlet{

    Admainservice admainservice = new Admainservice();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("sno");
        String password = req.getParameter("password");
        PrintWriter out= resp.getWriter();
        HttpSession httpSession = req.getSession();
        Teacher teacher = new Teacher();
        if (username.equals("15140A02")&&password.equals("123456")) {
            teacher.setPassword("123456");
            teacher.setTno("15140A02");
            httpSession.setAttribute("admain", teacher);
            resp.sendRedirect("/admin/success.jsp");
        }else{
            resp.sendRedirect("error.jsp");

        }

    }
}
