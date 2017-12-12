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

    int qTestNumber = 0;
    Quiz quiz = new Quiz(1);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //StringBuilder sbTest = new StringBuilder("<h1>Quiz - TEST (post method)</h1>");
        //qTestNumber++;
        //sbTest.append(qTestNumber);
        //InterfaceQuestionType qs = quiz.getQuizParts().get(qTestNumber);
        //sbTest.append(qs.getHTML());

        //sbTest.append(quiz.getHTML());

        //System.out.println(quiz.getHTML());


        PrintWriter out = response.getWriter();
        quiz.nextPart();
        out.print(quiz.getHTML());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        out.print(quiz.getHTML());

    }
}
