package controller;

import domain.MyQuestion;
import domain.Teacher;
import service.QuestionService;

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

@WebServlet(name = "DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (teacher != null) {
            QuestionService questionService = new QuestionService();

            int num = Integer.valueOf(request.getParameter("deleteId"));
            questionService.deleteQuestion(num);

            ServletContext thisContext = getServletConfig().getServletContext();
            RequestDispatcher myDispatcher;
            myDispatcher = thisContext.getRequestDispatcher("/aaa.jsp");
            myDispatcher.forward(request, response);//forward
        }else{
            response.sendRedirect("/error.jsp");

        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
