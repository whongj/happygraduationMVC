package com.happygraduation.MVC.controller;


import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.service.studnetservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ${wanghongjie} on 2017/6/12.
 */
@WebServlet(name = "loginservlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    studnetservice service = new studnetservice();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String Sno = req.getParameter("sno");
                String password = req.getParameter("password");
                HttpSession httpSession = req.getSession();
                Student student = null;
                if(service.login(Sno,password)){
                    student = service.getStudentBysno(Sno,password);
                    httpSession.setAttribute("student", student);
                    resp.sendRedirect("/success.jsp");
        }else
            resp.sendRedirect("/error.jsp");
    }
}
