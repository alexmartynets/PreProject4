<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 26.02.2020
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User's home page</title>
</head>
<body>
<p>Welcome ${sessionScope.get("user").getName()}!</p>
<p><a href="/logout">Logout</a></p>
</body>
</html>
