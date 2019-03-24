<%@ page import="domain.Teacher" %>
<%@ page import="service.QuestionService" %>
<%@ page import="domain.MyQuestion" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2017-11-30
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

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
    QuestionService questionService = new QuestionService();
    MyQuestion myQuestion = null;
    String str = "";
    ArrayList<MyQuestion> arrayList;


%>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br>
            <h2 class="text-center text-success">
                欢迎登录教师管理系统
            </h2>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-8 column">

            <form class="form-horizontal" role="form" action="/oporateQuestion.jsp">

                <div class="form-group">

                    <div class="col-sm-10">
                        <p>关键字查找:<br>
                            <input type="text" name="selectQuestion" placeholder="直接提交显示全部试题" class="form-control"
                                   id="inputEmail3"/>
                            <span class="input-icon fui-check-inverted"></span>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="button button-action button-pill">submit</button>
                    </div>
                </div>
            </form>
            <%
                if (request.getParameter("selectQuestion") != null) {
                    str = new String(request.getParameter("selectQuestion").getBytes("iso-8859-1"), "utf-8");
                }
                arrayList = questionService.selectQuestion(str);%>

            <% for (int i = 0; i < arrayList.size(); i++) {
                myQuestion = arrayList.get(i);
            %>
            <table class="table">
                <tbody>
                <tr class="success">
                    <td>
                        <%
                            out.print(myQuestion.getQuestion_id() + "、" + myQuestion.getQuestion_name() + "(" + myQuestion.getAnswer_correct() + ")");%>
                        <br>

                        <%out.print("A、" + myQuestion.getAnswer_A());%><%for (int j = 0; j < 7; ++j)%>&nbsp;

                        <%out.print("B、" + myQuestion.getAnswer_B());%><br>

                        <%out.print("C、" + myQuestion.getAnswer_C());%><%for (int j = 0; j < 7; ++j)%>&nbsp;

                        <%out.print("D、" + myQuestion.getAnswer_D());%>

                    </td>
                </tr>

                </tbody>
            </table>
            <%
                }
                str = "";
            %>

        </div>
        <div class="col-md-4 column">
            <form action="/controller/AddQuestionServlet" method="post">
                <br><br>
                <p>添加试题:<br>

                    <input type="text" name="addName" value="" placeholder="试题名字" class="form-control "
                           required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addA" value="" placeholder="A选项" class="form-control" required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addB" value="" placeholder="B选项" class="form-control" required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addC" value="" placeholder="C选项" class="form-control" required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addD" value="" placeholder="D选项" class="form-control" required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                    <input type="text" name="addCorrect" value="" placeholder="正确答案" class="form-control"
                           required="required" pattern="[A,B,C,D]" oninvalid="validateIt(this)"
                           oninput="validateIt(this)"/>
                    <span class="input-icon fui-check-inverted"></span>
                <h6>
                    <button type="submit" class="button button-glow button-rounded button-raised button-primary">
                        Submit
                    </button>

                    <%--<button type="submit">Submit</button>--%>
            </form>

            <form action="/controller/DeleteQuestionServlet" method="post">
                <br>
                <p>删除试题<br>

                    <input type="text" name="deleteId" placeholder="试题题号" class="form-control" required="required"
                           onKeyUp="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')"/>
                <h6>
                    <button type="submit" class="button button-glow button-rounded button-highlight">Submit</button>
            </form>

            <form action="/updateQuestion.jsp" method="post">
                <br>
                <p>修改试题<br>
                    <input type="text" name="updateId" value="" placeholder="输入题号" class="form-control "
                           onKeyUp="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')"
                           required="required"/>
                    <span class="input-icon fui-check-inverted"></span>
                <h6>
                    <button type="submit" class="button button-glow button-rounded button-royal">Submit</button>
            </form>
        </div>
    </div>
    <br><br>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <button type="button" class="btn btn-default btn-info btn-block btn-danger"
                    onclick="window.location='/exit.jsp?is_exit=1'">注销登录
            </button>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>


<%
    } else {
        response.sendRedirect("/error.jsp");

    }
%>
</body>
</html>
