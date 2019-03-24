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

import static java.lang.System.out;

@WebServlet(name = "UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        PrintWriter out = response.getWriter();

        if (teacher != null) {
            QuestionService questionService = new QuestionService();
            MyQuestion myQuestion = new MyQuestion();
            System.out.print(request.getParameter("update_id"));
            System.out.print(request.getParameter("update_A"));
            System.out.print(request.getParameter("update_B"));
            System.out.print(request.getParameter("update_correct"));

            if (null != request.getParameter("update_id") && null != request.getParameter("update_name") && null != request.getParameter("update_A")
                    && null != request.getParameter("update_B") && null != request.getParameter("update_C")
                    && null != request.getParameter("update_D") && null != request.getParameter("update_correct")) {

                int id = Integer.valueOf(request.getParameter("update_id"));
                String name = request.getParameter("update_name");
                String A = request.getParameter("update_A");
                String B = request.getParameter("update_B");
                String C = request.getParameter("update_C");
                String D = request.getParameter("update_D");
                String correct = request.getParameter("update_correct");

                questionService.updateQuestion(1, id, name);
                questionService.updateQuestion(2, id, A);
                questionService.updateQuestion(3, id, B);
                questionService.updateQuestion(4, id, C);
                questionService.updateQuestion(5, id, D);
                questionService.updateQuestion(6, id, correct);


                questionService.addMyQuestion(myQuestion);

                ServletContext thisContext = getServletConfig().getServletContext();
                RequestDispatcher myDispatcher;
                myDispatcher = thisContext.getRequestDispatcher("/aaa.jsp");
                myDispatcher.forward(request, response);//forward

            }
        }else {
            response.sendRedirect("/error.jsp");

        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
