package serverpresentation;

import businesslogic.surveymodule.InterfaceQuestionType;
import businesslogic.surveymodule.Question;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder sbTest = new StringBuilder("<h1>Quiz - TEST </h1>");
        Quiz qz = new Quiz(1);

        InterfaceQuestionType qs = qz.getQuestions().get(1);

        sbTest.append(qs.getHTML());


        PrintWriter out = response.getWriter();
        out.print(sbTest);

    }
}
