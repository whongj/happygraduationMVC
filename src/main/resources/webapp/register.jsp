<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/12
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>毕业生离校管理系统</title>
    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!--jquery.validate-->
    <script type="text/javascript" src="js/jquery.validate.min.js" ></script>
    <script type="text/javascript" src="js/message.js" ></script>
    <style type="text/css">
        body{background: url(img/4.jpg) no-repeat;background-size: cover;font-size: 16px;}
        .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
        #login_form{display: block;}
        #register_form{display: none;}
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}
        .checkbox{padding-left:21px;}
    </style>
</head>
<body>
<!--
    基础知识：
    网格系统:通过行和列布局
    行必须放在container内
    手机用col-xs-*
    平板用col-sm-*
    笔记本或普通台式电脑用col-md-*
    大型设备台式电脑用col-lg-*
    为了兼容多个设备，可以用多个col-*-*来控制；
-->
<!--
    从案例学知识，来做一个登录，注册页面
    用到font-awesome 4.3.0；bootstrap 3.3.0；jQuery Validate
-->
<div class="container">
    <div class="form row">
        <form action="/login" class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form" method="post">
            <h3 class="form-title">Login to your account</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Password" name="password" maxlength="8"/>
                </div>
                <div class="form-group">
                    <label class="checkbox">
                        <input type="checkbox" name="remember" value="1"/> Remember me
                    </label>
                    <hr />
                    <a href="javascript:;" id="register_btn" class="">Create an account</a>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success pull-right" value="登陆 "/>
                </div>
            </div>
        </form>
    </div>

    <div class="form row">
        <form action="/register" class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" method="post">
            <h3 class="form-title">Login to your account</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Password" id="register_password" name="password"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-check fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>
                </div>
                <!--<div class="form-group">-->
                <!--<i class="fa fa-envelope fa-lg"></i>-->
                <!--<input class="form-control eamil" type="text" placeholder="Email" name="email"/>-->
                <!--</div>-->
                <div class="form-group">
                    <input type="submit" class="btn btn-success pull-right" value="注册"/>
                    <input type="submit" class="btn btn-info pull-left" id="back_btn" value="back " formaction="enroll.html"/>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="js/main.js" ></script>
</body>
</html>
