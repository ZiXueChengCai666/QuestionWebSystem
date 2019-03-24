<%@ page import="domain.MyQuestion" %>
<%@ page import="service.QuestionService" %>
<%@ page import="domain.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2017-12-9
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

    <link href="css/dist/css/flat-ui.css" rel="stylesheet">
    <link href="css/docs/assets/css/demo.css" rel="stylesheet">
    <link href="css/buttons.css" rel="stylesheet">
<script>
    function validateIt(inputelement) {
        if (inputelement.validity.patternMismatch) {
            inputelement.setCustomValidity('请从[A、B、C、D]中选择');
        } else {
            inputelement.setCustomValidity(''); //输入内容符合验证条件
        }
    }
</script>


</head>
<body>
    <%Teacher teacher = (Teacher) session.getAttribute("teacher");%>
    <%if (teacher != null) {%>


    <%
    String idStr = request.getParameter("updateId");
    int id = Integer.valueOf(idStr);
    System.out.println("123456"+id);
    MyQuestion myQuestion = null;
    QuestionService questionService = new QuestionService();
    myQuestion = questionService.SearchMyQuestion(id);
    System.out.println(id);
%>
<div class="row clearfix">
    <div class="col-md-4 column">
    </div>
    <div class="col-md-4 column">
        <form action="/controller/UpdateQuestionServlet" method="post">
            <h3 class="demo-panel-title">修改试题</h3>
            <div class="form-group">
                <input type="text" name="update_id" value="<%=myQuestion.getQuestion_id()%>" placeholder="试题编号"
                       class="form-control" readonly="readonly"
                       required="required"/>
            </div>
            <div class="form-group has-success">
                <input type="text" name="update_name" value="<%=myQuestion.getQuestion_name()%>" placeholder="试题名字"
                       class="form-control "
                       required="required"/>
            </div>
            <div class="form-group">
                <input type="text" name="update_A" value="<%=myQuestion.getAnswer_A()%>" placeholder="A选项"
                       class="form-control" required="required"/>
            </div>
            <div class="form-group has-success">
                <input type="text" name="update_B" value="<%=myQuestion.getAnswer_B()%>" placeholder="B选项"
                       class="form-control" required="required"/>
            </div>
            <div class="form-group">
                <input type="text" name="update_C" value="<%=myQuestion.getAnswer_C()%>" placeholder="C选项"
                       class="form-control" required="required"/>
            </div>
            <div class="form-group has-success">
                <input type="text" name="update_D" value="<%=myQuestion.getAnswer_D()%>" placeholder="D选项"
                       class="form-control" required="required"/>
            </div>
            <div class="form-group">
                <input type="text" name="update_correct" value="<%=myQuestion.getAnswer_correct()%>" placeholder="正确答案"
                       class="form-control"  pattern="[A,B,C,D]" oninvalid="validateIt(this)" oninput="validateIt(this)"
                       required="required"/>
            </div>

            <h6>
                <button type="submit" class="button button-glow button-rounded button-raised button-primary">Submit
                </button>
                <button type="button" class="button button-glow button-rounded button-raised button-primary"
                        onclick="window.location='/oporateQuestion.jsp'">返回
                </button>

        </form>
    </div>
    <div class="col-md-4 column">
    </div>
</div>
<%}else{
        response.sendRedirect("/error.jsp");
}%>















