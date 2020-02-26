<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 10.02.2020
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h2 align="center">Welcome to Index page</h2>
<h2 align="center">From this page you can <a href="${pageContext.request.contextPath}/auth">Login</a> to your account.</h2>
<h2 align="center">If you want you can create new account please press <a href="${pageContext.request.contextPath}/add">Register</a></h2>
<h2 align="center">Thank you!</h2>
</body>
</html>