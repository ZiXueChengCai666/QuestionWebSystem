package controller;

import domain.Teacher;
import domain.User;
import service.TeacherService;
import service.UserService;
import util.MD5Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherRegistServlet")
public class TeacherRegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         TeacherService teacherService = new TeacherService();
        PrintWriter out = response.getWriter();


        if (null != request.getParameter("registTeacherName") && null != request.getParameter("registTeacherPassword")) {
            Teacher teacher = new Teacher();

            String name = request.getParameter("registTeacherName");
            String password = request.getParameter("registTeacherPassword");
            password = MD5Util.MD5(password);
            teacher.setTeacherName(name);
            teacher.setTeacherPassword(password);
            teacherService.registerTeacher(teacher);

            out.println("<script language='javaScript'> alert('注册成功');</script>");

            ServletContext thisContext = getServletConfig().getServletContext();
            RequestDispatcher myDispatcher;
            myDispatcher = thisContext.getRequestDispatcher("/login_teacher.jsp?isLogin");
            myDispatcher.forward(request, response);//forward
        } else {
            response.sendRedirect("/regist_teacher.jsp?errNo");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
