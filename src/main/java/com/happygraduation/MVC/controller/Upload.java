package com.happygraduation.MVC.controller;

import com.happygraduation.MVC.dao.ConcreteStudentConnDAO;
import com.happygraduation.MVC.dao.StudentConnDAO;
import com.happygraduation.MVC.pojo.Student;
import com.happygraduation.MVC.pojo.StudentConn;
import com.happygraduation.MVC.service.Admainservice;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanghongjie on 2017/6/15.
 */
@WebServlet(name = "upload",urlPatterns = "/upload")
public class Upload extends HttpServlet {
    private String uploadPath = "D:\\temp"; // 上传文件的目录
    private String tempPath = "d:\\temp\\buffer\\"; // 临时文件目录
    File tempPathFile;
    Admainservice admainservice = new Admainservice();
//    StudentConnDAO studentConnDAO = new ConcreteStudentConnDAO();

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            HttpSession httpSession = request.getSession();
            Student student = (Student) httpSession.getAttribute("student");
            if (student == null) {
                response.sendRedirect("/enroll.jsp");
            }
            StudentConn studentConn = new StudentConn();
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Set factory constraints
            factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
            factory.setRepository(tempPathFile);// 设置缓冲区目录

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
            Iterator<FileItem> i = items.iterator();
            int w =0;
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                String fileName = fi.getName();
                if (fileName != null) {
                    File fullFile = new File(fi.getName());
                    File savedFile = new File(uploadPath, fullFile.getName());
                    fi.write(savedFile);
                    if(w==0) {
                        studentConn.setLunwenFilePath(uploadPath + fullFile.getName());
                        w++;
                    }else
                        studentConn.setYuanmaFilePath(uploadPath+fullFile.getName());
                }
            }
            studentConn.setSno(student.getSno());
            studentConn.setQicaistate(false);
            studentConn.setTushustate(false);
            studentConn.setXuefeistate(false);
            if(admainservice.addAStudentConn(studentConn)){
                httpSession.setAttribute("StuConn", studentConn);

                response.sendRedirect("uploadsuccess.jsp");
            }else {
                response.sendRedirect("error.jsp");
            }
            System.out.print("upload succeed");
        } catch (Exception e) {
            // 可以跳转出错页面
            e.printStackTrace();
        }
    }

    public void init() throws ServletException {
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        File tempPathFile = new File(tempPath);
        if (!tempPathFile.exists()) {
            tempPathFile.mkdirs();
        }
    }

}
