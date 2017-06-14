package com.happygraduation.MVC.controller;


import com.happygraduation.MVC.service.Admainservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ${wanghongjie} on 2017/6/15.
 */
@WebServlet(name = "update",urlPatterns = "/updatestate")
public class UpdateServlet extends HttpServlet {
    Admainservice admainservice = new Admainservice();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Boolean tushust = null, qicaist = null, xuefeist = null;
        String Sno=null,tushustate=null,qicaistate=null,xuefeistate=null;
        if (httpSession.getAttribute("admin") == null) {
            resp.sendRedirect("error.jsp");
        }else{
            Sno = req.getParameter("Sno");
            tushustate = req.getParameter("tushustate");
            qicaistate = req.getParameter("qicaistate");
            xuefeistate = req.getParameter("xuefeistate");
        }
        if(tushustate=="1"){
            tushust = true;
        }
        if (qicaistate == "1") {
            qicaist = true;
        }
        if (xuefeistate == "1") {
            xuefeist = true;
        }


        if(admainservice.updatetushustate(Sno,tushust)||admainservice.updatetushustate(Sno, qicaist)||admainservice.updatetushustate(Sno, xuefeist)){
            resp.sendRedirect("success.jsp");

        }else
            resp.sendRedirect("error.jsp");

    }
}
