<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
${sessionScope.get("student")}
<p> 恭喜您登陆成功 </p>
<% request%>
</body>
</html>
