<%@ page import="businesslogic.testmodule.QuizTestClass" %><%--
  Created by IntelliJ IDEA.
  User: Ulrik
  Date: 16-05-2017
  Time: 01:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz - IBOS</title>
    <script>
        //Using setTimeout to execute a function after 5 seconds.
        setTimeout(function () {
            //Redirect with JavaScript
            window.location.href= '/test';
        }, 2000);
    </script>
</head>
<body>

<h1>QuizTest</h1>
<a href="quizlogin.jsp">Login her!</a>

<%
    /*the quick way using "="
    The string called this way is a static one
    this is to avoid the construction og a new object
     */
%>
<%=QuizTestClass.testStringStatic%>




</body>
</html>
