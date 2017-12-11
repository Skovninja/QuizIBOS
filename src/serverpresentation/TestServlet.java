package serverpresentation;
import businesslogic.testmodule.QuizTestClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sbTest = new StringBuilder("<h1>TEST - page overview</h1>");

        //sbTest.append("<h2>Hey</h2>");


        sbTest.append("<h2>Tests omhandlende Quiz modulet</h2>");
        //creating object to test
        QuizTestClass qTC = new QuizTestClass();


        //region -- Test of Survey Module --

        //Test of the creation of an ArrayList of Answers
        //qTC.testDBOption();
        //sbTest.append(
        //        "<h3> Option ArrayList from DB - TEST<br>" +
        //        qTC.testDBOption()
        //        + "</h3>"
        //);


        //Test of the creation of a Quiz object
        sbTest.append("<h3>Quiz object TEST</h3>");
        sbTest.append(qTC.quizTest());

        //Test of the creation of a Question object
        //sbTest.append("<h3>Question object TEST</h3>");
        //sbTest.append(qTC.questionTest());

        //endregion


        //this part sends the StringBuilder to the HTML page
        PrintWriter out = response.getWriter();
        out.print(sbTest);


    }//End of  doGet
}
