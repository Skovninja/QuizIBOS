<%@ page import="businesslogic.DirectFromIndexTest" %><%--
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
</head>
<body>

<h1>QuizTest</h1>
<a href="quizlogin.jsp">Login her!</a>

<br><% // Direct access to run a class from index
    DirectFromIndexTest outTest = new DirectFromIndexTest();
    //out.print(outTest.displayTestInfo);
    outTest.testRun();
%>
<%//the quick way %>
<%=outTest.displayTestInfo%>


</body>
</html>
