package com.happygraduation.MVC.controller;

import com.happygraduation.MVC.service.Admainservice;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wanghongjie on 2017/6/15.
 */
@WebServlet(name = "admainlogin",urlPatterns = "/adminlogin")
public class admainlogin extends HttpServlet{

    Admainservice admainservice = new Admainservice();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out= resp.getWriter();

        if (username == "15140A02" && password == "123") {
            out.print("管理员登录成功" + username);

            resp.sendRedirect("/admin/success.jsp");
        }else
            resp.sendRedirect("error.jsp");

    }
}
