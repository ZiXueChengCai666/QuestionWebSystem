<%--
  Created by IntelliJ IDEA.
  User: wufan
  Date: 2017-11-28
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>


<%

    session.invalidate();
    response.sendRedirect("/index.jsp");
%>
</body>
</html>
