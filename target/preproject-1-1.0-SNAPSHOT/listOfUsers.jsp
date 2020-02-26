<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 13.02.2020
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<h2>List of users</h2>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Имя</td>
    </tr>
    <c:forEach items="${users}" var = "user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getLogin()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getName()}</td>
            <td>
                <a href="${pageContext.request.contextPath}/edit?id=${user.getId()}" methods="get">
                    <input type="submit" name="update" value="Edit" style="float:left">
                </a>
                <a href="${pageContext.request.contextPath}/delete?id=${user.getId()}" methods="get">
                    <input type="submit" name="id" value="Delete" style="float:left">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/add">
    <input type="submit" value="Add new user">
</a>
</body>
</html>