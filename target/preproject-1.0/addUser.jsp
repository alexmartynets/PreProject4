<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 13.02.2020
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>For registration please enter desire login, password and your real name</h2>
<form action="${pageContext.request.contextPath}/add" method="post">
    <input required type="text" name="login" placeholder="Choose your login">
    <input required type="text" name="password" placeholder="Choose your password">
    <input required type="text" name="name" placeholder="Enter your name">
    <input type="submit" value="Register">
</form>
</body>
</html>