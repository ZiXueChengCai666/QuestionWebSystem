<%@ page import="domain.User" %>
<%@ page import="service.QuestionService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.MyQuestion" %>
<%@ page import="service.Text_service" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2017-11-28
  Time: 10:17
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

    <link href="square/green.css" rel="stylesheet">
    <script src="js/icheck.js"></script>

    <link rel="stylesheet" href="css/buttons.css">





    <script>
        $(document).ready(function(){

            $('input').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
                increaseArea: '20%' // optional
            });
        });

    </script>

    <SCRIPT>
        function isHidden(oDiv){
            var vDiv = document.getElementById(oDiv);
            vDiv.style.display = (vDiv.style.display == 'none')?'block':'none';
        }
    </SCRIPT>


</head>
<body >


<%User user = (User) session.getAttribute("user");%>
<%if (user != null) {%>

<%
    QuestionService questionService = new QuestionService();
    ArrayList<Integer> arrayList = questionService.SearchMyQuestionList();
    MyQuestion myQuestion = null;
%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center"><br>
                欢迎 <%out.println(user.getUserNiCheng());%>进入答题系统<br>
            </h3>
            <form action="/showGrade.jsp" method="post">
                <% for (int i = 0; i < arrayList.size(); i++) {
                    myQuestion = questionService.SearchMyQuestion(arrayList.get(i));
                %>
                <table class="table">
                    <tbody>
                    <tr class="warning">
                        <td>
                            <DIV style="cursor:hand" onclick="isHidden(<%=myQuestion.getQuestion_id()%>)">
                                <%out.print(i + 1 + "、" + myQuestion.getQuestion_name()); %></DIV>
                            <DIV id="<%=myQuestion.getQuestion_id()%>">
                            <input type="radio" name=<%=myQuestion.getQuestion_id()%> value="A"><%
                            out.print("A、" + myQuestion.getAnswer_A());  %> <%for(int j=0;j<7;++j)%>&nbsp;

                            <input type="radio" name=<%=myQuestion.getQuestion_id()%>  value="B"><%
                            out.print("B、" + myQuestion.getAnswer_B()); %><%for(int j=0;j<7;++j)%>&nbsp;
                            <input type="radio" name=<%=myQuestion.getQuestion_id()%>  value="C"><%
                            out.print("C、" + myQuestion.getAnswer_C()); %><%for(int j=0;j<7;++j)%>&nbsp;
                            <input type="radio" name=<%=myQuestion.getQuestion_id()%>  value="D"><%
                            out.print("D、" + myQuestion.getAnswer_D()); %><%for(int j=0;j<7;++j)%>&nbsp;

                            </DIV>

                    </tr>
                    <%}%>

                    </tbody>
                </table>

                <div class="row clearfix">
                    <div class="col-md-4 column">
                    </div>
                    <div class="col-md-4 column">
                        <input type="submit" value="提交答案" class="btn btn-default btn-primary btn-block active"/>
                    </div>
                    <div class="col-md-4 column">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>






























<%}else{
    response.sendRedirect("/error.jsp");

}%>

</body>
</html>
