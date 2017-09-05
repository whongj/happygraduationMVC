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
 * Created by ${macong} on 2017/6/15.
 */
@WebServlet(name = "update",urlPatterns = "/updatestate")
public class UpdateServlet extends HttpServlet {
    Admainservice admainservice = new Admainservice();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Boolean tushust = null, qicaist = null, xuefeist = null;
        String Sno=null,tushustate=null,qicaistate=null,xuefeistate=null;
        tushustate = req.getParameter("TUSHU");
        qicaistate = req.getParameter("QICAI");
        xuefeistate = req.getParameter("XUEFEI");
        Sno = req.getParameter("Sno");
        System.out.println(Sno+tushustate+qicaistate+xuefeistate);

        if (httpSession.getAttribute("admain") == null) {
            resp.sendRedirect("error.jsp");
        }
        if(tushustate.equals("1")){
            tushust = true;
        }
        if (qicaistate.equals("1")) {
            qicaist = true;
        }
        if (xuefeistate.equals("1")) {
            xuefeist = true;
        }
        System.out.println(xuefeist);
        System.out.println(qicaist);
        System.out.println(tushust);

        if(admainservice.updatetushustate(Sno,tushust)&&admainservice.updatexueqicai(Sno, qicaist)&&admainservice.updatexuefeistate(Sno, xuefeist)){
            resp.sendRedirect("/user/success.jsp");

        }else
        resp.sendRedirect("error.jsp");

    }
}
