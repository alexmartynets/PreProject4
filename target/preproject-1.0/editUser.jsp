<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 13.02.2020
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/edit"  method="post">
    <input type = "hidden" name = "id" value = ${param.id}>
    <tr>
        <th>Login</th> <td><input type = "text" name = "login" value = ${param.login}></td>
    </tr>
    <tr>
        <th>Password</th> <td><input type = "text" name = "password" value = ${param.password}></td>
    </tr>
    <tr>
        <th>Name</th> <td><input type = "text" name = "name" value = ${param.name}></td>
    </tr>

    <tr>
    <p><select name="role" required>
        <option></option>
        <option>admin</option>
        <option>user</option>
    </select></p>
    </tr>

    <input type = "submit" value = "Save">
</form>
</body>
</html>