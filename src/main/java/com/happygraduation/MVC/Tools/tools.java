package com.happygraduation.MVC.Tools;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ${wanghongjie} on 2017/6/12.
 */

public class tools {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String PrintException(String functionname, String classname) {
        String str = "Exception in Class:" + classname + " function:"
                + functionname;
        System.out.println(str);
        return str;
    }

    public static String changeAStringToUtf8(String s) {
        String str = null;
        try {
            str = new String(s.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(s + "字符集转换失败");
            return s;
        }
        return str;
    }

    public static String MD5_32(String e) {
        byte[] back = e.getBytes();
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(e.getBytes());
            back = md.digest();
            int i;

            for (int offset = 0; offset < back.length; offset++) {
                i = back[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // System.out.println("32位: " + buf.toString());// 32位的加密
            // System.out.println("16位: " + buf.toString().substring(8, 24));//
            // 16位的加密，其实就是32位加密后的截取

        } catch (Exception e1) {
            back = e.getBytes();
            System.out.println("在MD5加密过程中出现了异常，加密失败");
        }
        return buf.toString();
    }

    public static String MD5_16(String e) {
        return MD5_32(e).substring(8, 24);
    }

    public static String nowtimestring() {
        Date date = new Date();
        String nowtime = sdf.format(date);
        return nowtime;
    }

    public static long nowtimelong() {
        return Long.parseLong(nowtimestring());
    }

    /**
     * 没有处理过的UUID
     *
     * @return
     */
    public static String getbeforeUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * 返回没有_的UUID
     *
     * @return
     */
    public static String getUUID() {
        String s = getbeforeUUID();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
                + s.substring(19, 23) + s.substring(24);
    }

    /**
     * @author jzs
     * @param upload
     *            上传文件的实体
     * @param uploadFileName
     *            上传文件名称
     * @param reralpath
     *            真实路径一般用 ServletActionContext.getServletContext().getRealPath(
     *            this.getSavePath())
     * */
    public static String upfile(File upload, String uploadFileName,
                                String reralpath) {

        String newname = "";
        try {
            String oldname = uploadFileName;
            newname = "source_" + nowtimelong()
                    + oldname.substring(oldname.lastIndexOf("."));
            String path = reralpath + "\\" + newname;

            File filesave = new File(path);
            System.out.println("path:" + path);

            FileOutputStream fos = new FileOutputStream(filesave);
            FileInputStream fis = new FileInputStream(upload);
            byte b[] = new byte[1024000];
            int len = 0;
            while ((len = fis.read(b)) > 0) {
                fos.write(b, 0, len);
            }
            fos.close();
            fis.close();

			/*
			 * 这里还有一部分是修改回去savepath的
			 */

        } catch (Exception e) {
            PrintException("upfile", "Tool");
            newname = "";
        }
        return newname;
    }

    /**
     * 分页
     *
     * @param pagenum
     *            当前页数
     * @param pagesize
     *            页面大小
     * @param alllist
     *            所有页面
     * @return
     */
    public synchronized static List<? extends Object> getCurrentPage(
            int pagenum, int pagesize, List<?> alllist) {
        int size = alllist.size();
        if (pagenum < 0) {
            pagenum = 0;
        }
        if (pagenum > (size / pagesize)) {
            pagenum = size / pagesize;
        }
        int start = pagenum * pagesize;
        int end = (pagenum + 1) * pagesize;
        if (end > size) {
            end = size;
        }

        return alllist.subList(start, end);
    }

    /**
     * 获取基地址
     *
     * @param request
     * @param response
     * @return
     */
    public static String Basepath(HttpServletRequest request,
                                  HttpServletResponse response) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + path + "/";
        return basePath;
    }

    public static String getNowTime_Format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        return sdf.format(new Date());
    }

    public static String getNowTimeRFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 根据文件流来上传文件
     *
     * @param fis
     *            上传文件的流
     * @param uploadfilename
     *            上传文件的名称
     * @param basepath
     *            web的路径
     * @param savepath
     *            保存路径
     * @param wantnewname
     *            想要获得的名称
     * @return 新的文件相对路径
     */
    public static String upfile(FileInputStream fis, String uploadfilename,
                                String basepath, String savepath, String wantnewname) {
        String oldname = uploadfilename;
        String newname = getNowTime_Format()+"_"+oldname.substring(oldname.lastIndexOf("."));
        try {
            File outfile = null;
            if (wantnewname == null || wantnewname.equals("")) {
                outfile = new File(basepath + "/" + savepath + "/" + "test"
                        + newname);
            } else {
                newname = wantnewname + newname;
                outfile = new File(basepath + "/" + savepath + "/" + newname);
            }

            if (!outfile.exists()) {
                outfile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(outfile);

            byte b[] = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) > 0) {
                fos.write(b, 0, len);
            }
            fos.close();
            fis.close();
            return savepath + "/" + newname;
        } catch (Exception ex) {
            PrintException("upfile", "Tools");
        }

        return null;
    }

    /**
     * 根据文件流来上传文件
     *
     * @param fis
     *            上传文件的流
     * @param uploadfilename
     *            上传文件的名称
     * @param basepath
     *            web的路径
     * @param savepath
     *            保存路径
     * @return 新的文件相对路径
     */
    public static String upfile(FileInputStream fis, String uploadfilename,
                                String basepath, String savepath) {
        return upfile(fis, uploadfilename, basepath, savepath, null);
    }

    /**
     * 需要依赖于 commons-fileupload .jar和commons-io .jar。 将mulpart/formdata
     * 转换为常见的parameter
     *
     * @param request
     * @return
     */
    public Map MulpartToGeneral(HttpServletRequest request) {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List items = upload.parseRequest(request);
            Map param = new HashMap();
            for (Object object : items) {
                FileItem fileItem = (FileItem) object;
                if (fileItem.isFormField()) {
                    param.put(fileItem.getFieldName(),
                            fileItem.getString("utf-8"));// 如果你页面编码是utf-8的
                }
            }
            return param;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}