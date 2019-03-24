<%@ page import="domain.User" %>
<%@ page import="service.QuestionService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.MyQuestion" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2017-11-28
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body>

<%User user = (User) session.getAttribute("user");%>
<%if (user != null) {%>
    <%
        QuestionService questionService = new QuestionService();
        ArrayList<Integer> arrayList = questionService.SearchMyQuestionList();
        MyQuestion myQuestion = null;
        int grade = 0;
        for(int i=0;i<arrayList.size();++i){
            myQuestion = questionService.SearchMyQuestion(arrayList.get(i));

            if(request.getParameter(myQuestion.getQuestion_id()+"") != null){
                String userAnswer = request.getParameter(myQuestion.getQuestion_id()+"");
                if(questionService.CheckQuestion(arrayList.get(i),userAnswer)){
                    grade++;
                }
            }
        }
    %>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center"><br>
                您的得分:
                <%
                    out.print(grade + "<br>");
                %>

            </h1>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center"><br><br>
                您的选项：
                <%
                    for(int i=0;i<arrayList.size();++i) {
                        myQuestion = questionService.SearchMyQuestion(arrayList.get(i));
                        out.print(request.getParameter(myQuestion.getQuestion_id()+"") + " ");
                    }
                %>
            </h3>
            <h3 class="text-center">
                正确答案：
                <%
                    for(int i=0;i<arrayList.size();++i) {
                        myQuestion = questionService.SearchMyQuestion(arrayList.get(i));
                        out.print(myQuestion.getAnswer_correct()+" ");
                    }
                %>
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-3 column">
        </div>
        <div class="col-md-6 column"><br><br>
            <button type="button" class="btn btn-block btn-lg btn-danger" onclick="window.location='exit.jsp?is_exit=1'">注销登录</button>
        </div>
        <div class="col-md-3 column">
        </div>
    </div>
</div>

<%}else{
    response.sendRedirect("/error.jsp");

}%>

</body>
</html>
