<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 16-05-2017
  Time: 02:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz - Login</title>
</head>
<body>

<h1>Login</h1>

<form action="/login" method="post">
    <input type="text" name="enteredusername"><br>
    <input type="password" name="enteredpassword"><br>

    <% //min checkLoginInDB
        String test = "<input type=\"radio\">";
        out.print(test);
    %>
    <input type="submit" value="Log på">

</form>

</body>
</html>
