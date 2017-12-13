package serverpresentation;

import businesslogic.surveymodule.InterfaceQuestionType;
import businesslogic.surveymodule.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet", urlPatterns = "/quiz")
public class QuizServlet extends HttpServlet {

    Quiz quiz;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        quiz.nextPart();
        out.print(quiz.getHTML());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String quizID = request.getParameter("quizid");
        int quizIntID = Integer.parseInt(quizID);
        quiz = new Quiz(quizIntID);

        PrintWriter out = response.getWriter();
        out.print(quiz.getHTML());

        out.print(quizID);
    }
}
