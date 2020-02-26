<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 21.02.2020
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth page</title>
</head>
<body>
<h2>For auth please enter you login and password</h2>
<form action="/auth" method="post">
    <input required type="text" name="login" placeholder="Login">
    <input required type="text" name="password" placeholder="Password">
    <input type="submit" value="Auth">
</form>
</body>
</html>