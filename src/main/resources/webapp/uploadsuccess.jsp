<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/15
  Time: 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传成功</title>
</head>
<body>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<table class="table">
    <caption>上传代码成功</caption>
    <thead>
        <tr>上传结果</tr>
    </thead>
    <tbody>
    <tr>
        <td>Sno</td>
        <td>${sessionScope["StuConn"].sno } </td>
    </tr>
    <tr>
        <td>论文</td>
        <td>${sessionScope["StuConn"].lunwenFilePath}</td>
    </tr>
    <tr>
        <td>论文代码</td>
        <td>${sessionScope["StuConn"].yuanmaFilePath}</td>
    </tr>
    <tr>
        <td>图书借阅信息</td>
        <td>${sessionScope["StuConn"].tushustate}</td>
    </tr>
    <tr>
        <td>学费信息</td>
        <td>${sessionScope["StuConn"].xuefeistate}</td>
    </tr>
    <tr>
        <td>器材信息</td>
        <td>${sessionScope["StuConn"].qicaistate}</td>
    </tr>
    </tbody>
</table>

</body>
</html>
