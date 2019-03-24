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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();

        if (null != request.getParameter("Name") && null != request.getParameter("Password")) {

            String name = request.getParameter("Name");
            String password = request.getParameter("Password");
            password = MD5Util.MD5(password);
            User user = userService.loginUser(name, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);

                ServletContext thisContext = getServletConfig().getServletContext();
                RequestDispatcher myDispatcher;
                myDispatcher = thisContext.getRequestDispatcher("/temp.jsp");
                myDispatcher.forward(request, response);//forward
            }else{
                response.sendRedirect("/login.jsp?errNo");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
