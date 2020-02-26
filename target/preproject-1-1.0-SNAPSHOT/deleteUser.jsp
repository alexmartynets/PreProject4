<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 13.02.2020
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user?</title>
</head>
<body>
<h2 align="center">Are you sure to delete user ${name}?</h2>

<form action= "/delete" method = "post">
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="Delete">
</form>
</body>
</html>