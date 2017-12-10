package serverpresentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ulrik on 16-05-2017.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/logintest")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eName = request.getParameter("enteredusername");
        String ePassword = request.getParameter("enteredpassword");

        businesslogic.Login login = new businesslogic.Login();

        // gør at der kan skrives til WEB side
        PrintWriter out = response.getWriter();

        if (login.isValid(eName, ePassword)) {
            //out.print("<h1>hej "+eName+"</h1>");
            response.sendRedirect("/welcome.jsp");

        } else {
            out.print("LoginServlet forkert\n" + eName + " " + ePassword);

        }



        //forwards parameters, has error if URL is reentered
        request.setAttribute("username", eName);
        //request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // gør at der kan skrives til WEB side
        PrintWriter out = response.getWriter();
        out.print("LoginServlet servlet");

        String eName = request.getParameter("testname");
        System.out.println("URL get " + eName + " works!");
    }
}
