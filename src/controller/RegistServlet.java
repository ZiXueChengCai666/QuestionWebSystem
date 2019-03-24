package controller;

import domain.User;
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
import java.io.PrintWriter;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        PrintWriter out = response.getWriter();


        if (null != request.getParameter("regist_Name") && null != request.getParameter("regist_Password")
                && null != request.getParameter("regist_NiCheng")) {
            User user = new User();

            String name = request.getParameter("regist_Name");
            String password = request.getParameter("regist_Password");
            password = MD5Util.MD5(password);
            String nicheng = request.getParameter("regist_NiCheng");
            user.setUserName(name);
            user.setUserPassword(password);
            user.setUserNiCheng(nicheng);
            userService.registerUser(user);


            ServletContext thisContext = getServletConfig().getServletContext();
            RequestDispatcher myDispatcher;
            myDispatcher = thisContext.getRequestDispatcher("/login.jsp?islogin");
            myDispatcher.forward(request, response);//forward
        } else {
            response.sendRedirect("/regist.jsp?errNo");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
