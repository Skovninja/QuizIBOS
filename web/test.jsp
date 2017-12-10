<%@page import="businesslogic.testmodule.QuizTestClass" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 23-08-2017
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Test Page</h1>

<br><% // Direct access to run a function from index %>

<%//=QuizTestClass.testRun(2)%>
<%=QuizTestClass.testRun(3)%>

</body>
</html>
