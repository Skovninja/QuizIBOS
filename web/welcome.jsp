<%--
  Created by IntelliJ IDEA.
  User: Ulrik
  Date: 17-05-2017
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hej ${username}</h1>
<h2>Her kan du vælge en quiz eller se alle brugere</h2>

<a href="/showallusers.jsp">vis Alle Brugerene</a><br><br>

<a href="/quiz?quizid=0">Gå til Quiz 0</a><br>
<a href="/quiz?quizid=1">Gå til Quiz 1</a><br>
<a href="/quiz?quizid=2">Gå til Quiz 2</a><br>
<a href="/quiz?quizid=3">Gå til Quiz 3</a><br>
<a href="/quiz?quizid=3">Gå til Quiz 4</a><br>

</body>
</html>
