<%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2017-12-5
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h2 class="text-center text-error">
                抱歉，您还没有登录。。。
            </h2><br>
            <h3 class="text-center text-error">
                2秒后进入登录界面
            </h3>
        </div>
    </div>
</div>
<%
    response.setHeader("Refresh", "2;URL=index.jsp");

%>
</body>
</html>
