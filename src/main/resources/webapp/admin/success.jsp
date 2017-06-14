<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <base href="<%=basePath%>">
    <base target="main" />
    <title>欢迎管理员使用后台管理系统</title>

    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>jslib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
    <link rel="stylesheet"
          href="<%=basePath%>jslib/font-awesome/css/font-awesome.css">
    <script src="<%=basePath%>jslib/jquery-1.7.2.min.js"
            type="text/javascript"></script>

    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

        .brand .first {
            color: #ccc;
            font-style: italic;
        }

        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
<!--<![endif]-->

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">
            <li id="fat-menu" class="dropdown"><a href="#" role="button"
                                                  class="dropdown-toggle" data-toggle="dropdown"> <i
                    class="icon-user"></i><%-- ${user.id}  --%>名称：${admin.name} <i
                    class="icon-caret-down"></i> </a>

                <ul class="dropdown-menu">
                    <li>
                        <%-- <a tabindex="-1" href="<%=basePath%>user/changepass.jsp?userid=${user.userid}&&username=${user.name}">修改密码</a>
                         --%></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" class="visible-phone" href="#">Settings</a>
                    </li>
                    <li class="divider visible-phone"></li>
                    <li><a  href="<%=basePath %>admin/logout"
                            target="_top">Logout</a>
                    </li>
                </ul></li>

        </ul>
        <a class="brand" href="#"><span class="first">欢迎使用</span> <span
                class="second">后台管理系统</span> </a>
    </div>
</div>

<div class="sidebar-nav">

    <%--
    <% System.out.println((Role)session.getAttribute("role")) ;%> --%>
    <%-- ${SessionScope.role.userctrl==1 } --%>
    <c:if test="${admin.name !=null }">
        登录成功
    </c:if>
    <%-- 	 <c:if test="${role.allctrl==1 }" var="theallctrl">
        <a href="#error-menuallctrl" class="nav-header collapsed"
            data-toggle="collapse"><i class="icon-briefcase"></i>系统管理<i
            class="icon-chevron-up"></i> </a>
            <ul id="error-menuallctrl" class="nav nav-list collapse">
            <li><a href="servlet/SysFunServlet?cmd=list">系统管理</a>
            </li>
        </ul>
        </c:if>
         --%>

    <%--<c:forEach items="${sysfunlist}" var="top">--%>
        <%--<c:if test="${top.pid==0}">--%>
            <%--<a href="#error-menu${top.id}" class="nav-header collapsed"--%>
               <%--data-toggle="collapse"><i class="icon-briefcase"></i>${top.name}<i--%>
                    <%--class="icon-chevron-up"></i> </a>--%>
            <%--<ul id="error-menu${top.id}" class="nav nav-list collapse">--%>

                <%--<c:forEach items="${sysfunlist}" var="child">--%>
                    <%--<c:if test="${child.pid==top.id}">--%>
                        <%--<li>--%>
                            <%--<a href="<%=basePath%>${child.url}">${child.name}</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>
                <%--</c:forEach>--%>

            <%--</ul>--%>
        <%--</c:if>--%>
    <%--</c:forEach>--%>

</div>

<div class="content">
    <iframe name="main" height="600px" width="100%" scrolling="auto"
            frameborder="0" src=""> </iframe>
</div>
<script src="<%=basePath%>jslib/bootstrap/js/bootstrap.js"></script>
</body></html>