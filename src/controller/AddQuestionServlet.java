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

@WebServlet(name = "AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (teacher != null) {
            QuestionService questionService = new QuestionService();
            MyQuestion myQuestion = new MyQuestion();
            if (null != request.getParameter("addName") && null != request.getParameter("addA")
                    && null != request.getParameter("addB") && null != request.getParameter("addC")
                    && null != request.getParameter("addD") && null != request.getParameter("addCorrect")) {

                String name = request.getParameter("addName");
                String A = request.getParameter("addA");
                String B = request.getParameter("addB");
                String C = request.getParameter("addC");
                String D = request.getParameter("addD");
                String correct = request.getParameter("addCorrect");

                myQuestion.setQuestion_name(name);
                myQuestion.setAnswer_A(A);
                myQuestion.setAnswer_B(B);
                myQuestion.setAnswer_C(C);
                myQuestion.setAnswer_D(D);
                myQuestion.setAnswer_correct(correct);

                questionService.addMyQuestion(myQuestion);

                ServletContext thisContext = getServletConfig().getServletContext();
                RequestDispatcher myDispatcher;
                myDispatcher = thisContext.getRequestDispatcher("/aaa.jsp");
                myDispatcher.forward(request, response);//forward

            }
        }else{
            response.sendRedirect("/error.jsp");
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
