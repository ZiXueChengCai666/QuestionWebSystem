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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeacherService teacherService = new TeacherService();

        if (null != request.getParameter("teacherName") && null != request.getParameter("teacherPassword")) {

            String name = request.getParameter("teacherName");
            String password = request.getParameter("teacherPassword");
            password = MD5Util.MD5(password);
            Teacher teacher = teacherService.loginTeacher(name, password);

            if (teacher != null) {
                HttpSession session = request.getSession();
                session.setAttribute("teacher",teacher);

                ServletContext thisContext = getServletConfig().getServletContext();
                RequestDispatcher myDispatcher;
                myDispatcher = thisContext.getRequestDispatcher("/aaa.jsp");
                myDispatcher.forward(request, response);//forward
            }else{
                response.sendRedirect("/login_teacher.jsp?errNo");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
