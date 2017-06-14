package com.happygraduation.MVC.controller;

/**
 * Created by ${wanghongjie} on 2017/6/12.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

//
//@WebServlet(name="UploadServlet",urlPatterns="/upload")
//public class UploadServlet extends HttpServlet {
//
//    /**
//     * Constructor of the object.
//     */
//    public UploadServlet() {
//        super();
//    }
//
//    /**
//     * Destruction of the servlet. <br>
//     */
//    public void destroy() {
//        super.destroy(); // Just puts "destroy" string in log
//        // Put your code here
//    }
//
//    /**
//     * The doGet method of the servlet. <br>
//     *
//     * This method is called when a form has its tag value method equals to get.
//     *
//     * @param request the request send by the client to the server
//     * @param response the response send by the server to the client
//     * @throws ServletException if an error occurred
//     * @throws IOException if an error occurred
//     */
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().println("请以POST方式上传文件");
//    }
//
//    /**
//     * The doPost method of the servlet. <br>
//     *
//     * This method is called when a form has its tag value method equals to post.
//     *
//     * @param request the request send by the client to the server
//     * @param response the response send by the server to the client
//     * @throws ServletException if an error occurred
//     * @throws IOException if an error occurred
//     */
//    @SuppressWarnings({ "unchecked", "deprecation" })
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        File file1 = null,file2=null;
//        String description1 = null,description2 = null;
//        response.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        DiskFileUpload diskFileUpload = new DiskFileUpload();
//        try{
//            List<FileItem> list = diskFileUpload.parseRequest(request);
//
//            out.println("遍历所有的FileItem...<br/>");
//            for(FileItem fileItem : list){
//                if(fileItem.isFormField()){
//                    if("description1".equals(fileItem.getFieldName())){
//                        out.println("遍历到description1 ... <br/>");
//                        description1 = new String(fileItem.getString().getBytes(),"UTF-8");
//                    }
//                    if("description2".equals(fileItem.getFieldName())){
//                        out.println("遍历到description2 ... <br/>");
//                        description2 = new String(fileItem.getString().getBytes(),"UTF-8");
//                    }
//                }else{
//                    if("file1".equals(fileItem.getFieldName())){
//                        File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
//                        out.println("遍历到file1...<br/>");
//                        out.println("客户端文件位置："+remoteFile.getAbsolutePath()+"<br/>");
//
//                        file1 = new File(this.getServletContext().getRealPath("attachment"),remoteFile.getName());
//                        file1.getParentFile().mkdirs();
//                        file1.createNewFile();
//
//                        InputStream ins = fileItem.getInputStream();
//                        OutputStream ous = new FileOutputStream(file1);
//
//                        try{
//                            byte[] buffer = new byte[1024];
//                            int len = 0;
//                            while((len = ins.read(buffer)) > -1)
//                                ous.write(buffer,0,len);
//                            out.println("以保存文件"+file1.getAbsolutePath()+"<br/>");
//                        }finally{
//                            ous.close();
//                            ins.close();
//                        }
//                    }
//                    if("file2".equals(fileItem.getFieldName())){
//                        File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
//                        out.println("遍历到file2...<br/>");
//                        out.println("客户端文件位置："+remoteFile.getAbsolutePath()+"<br/>");
//
//                        file2 = new File(this.getServletContext().getRealPath("attachment"),remoteFile.getName());
//                        file2.getParentFile().mkdirs();
//                        file2.createNewFile();
//
//                        InputStream ins = fileItem.getInputStream();
//                        OutputStream ous = new FileOutputStream(file2);
//
//                        try{
//                            byte[] buffer = new byte[1024];
//                            int len = 0;
//                            while((len = ins.read(buffer)) > -1)
//                                ous.write(buffer,0,len);
//                            out.println("以保存文件"+file2.getAbsolutePath()+"<br/>");
//                        }finally{
//                            ous.close();
//                            ins.close();
//                        }
//                    }
//                }
//                out.println("Request 解析完毕<br/><br/>");
//            }
//        }catch(FileUploadException e){}
//
//        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//        out.println("<HTML>");
//        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//        out.println("  <BODY>");
//
//        if(file1 != null){
//            out.println("<div>");
//            out.println(" <div align='left'>file1;</div>");
//            out.println(" <div align='left'><a href='"+request.getContextPath()+"/attachment/"+
//                    file1.getName()+"'target=_blank>"+file1.getName()+"</a>");
//            out.println("</div>");
//            out.println("</div>");
//        }
//        if(file2 != null){
//            out.println("<div>");
//            out.println(" <div align='left'>file2;</div>");
//            out.println(" <div align='left'><a href='"+request.getContextPath()+"/attachment/"+
//                    file2.getName()+"'target=_blank>"+file2.getName()+"</a>");
//            out.println("</div>");
//            out.println("</div>");
//        }
//        out.println("<div>");
//        out.println(" <div align='left'>description1:</div>");
//        out.println(" <div align='left'>");
//        out.println(description1);
//        out.println("</div>");
//        out.println("</div>");
//
//        out.println("<div>");
//        out.println(" <div align='left'>description2:</div>");
//        out.println(" <div align='left'>");
//        out.println(description2);
//        out.println("</div>");
//        out.println("</div>");
//
//        out.println("  </BODY>");
//        out.println("</HTML>");
//        out.flush();
//        out.close();
//    }
//
//    /**
//     * Initialization of the servlet. <br>
//     *
//     * @throws ServletException if an error occurs
//     */
//    public void init() throws ServletException {
//        // Put your code here
//    }
//
//}