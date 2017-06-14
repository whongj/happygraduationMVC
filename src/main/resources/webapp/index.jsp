<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/11
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>欢迎你，毕业生</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">毕业生离校管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form action="/login" class="navbar-form navbar-right" method="post">
                <div class="form-group">
                    <input type="text" placeholder="用户名" name="sno" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="密码" name="password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">登陆</button>
                <button type="submit" class="btn btn-warning" formaction="/adminlogin">管理员登陆</button>
                <button type="submit" class="btn btn" formaction="enroll.html">学生注册</button>


            </form>

        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>欢迎你，毕业生</h1>
        <p>中北大学（North University of China）位于山西太原，是山西省人民政府与中华人民共和国国家国防科技工业局共建的综合性教学研究型大学，是中西部高校基础能力建设工程入选高校、卓越工程师教育培养计划重点建设高校，属国家二级保密单位...</p>
        <p><a class="btn btn-primary btn-lg" href="functionlist.html" role="button">点这看功能 &raquo;</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>信息中心</h2>
            <p> 毕业生信息导入和分类管理、通知功能</p>
            <p><a class="btn btn-default" href="功能页面1" role="button">教师点这导入信息&raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>文件上传</h2>
            <P>毕业设计论文说明书、源码上传——学生专用</P>
            <p><a class="btn btn-default" href="upload.html" role="button">学生上传 &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>各类手续</h2>
            <P>学费、图书、器材借用等的审核和注销功能——学生打开只能看到自己的列表。教师打开可以通过学号查询，然后操作。</P>
            <p><a class="btn btn-default" href="功能页面3" role="button">修改信息和 &raquo;</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; A02第二小组 2017 </p>
    </footer>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>