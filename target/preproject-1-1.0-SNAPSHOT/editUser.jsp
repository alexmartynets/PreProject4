<%--
  Created by IntelliJ IDEA.
  User: Love
  Date: 13.02.2020
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<%--<form action="${pageContext.request.contextPath}/edit"  method="post">--%>
<%--    <input type = "hidden" name = "id" value = ${param.id}>--%>
<%--    <tr>--%>
<%--        <th>Login</th> <td><input type = "text" name = "login" value = ${param.login}></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <th>Password</th> <td><input type = "text" name = "password" value = ${param.password}></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <th>Name</th> <td><input type = "text" name = "name" value = ${param.name}></td>--%>
<%--    </tr>--%>
<%--    <input type = "submit" value = "Edit">--%>

    <div align="center">
        <h2>Edit User</h2>
        <form:form action="${pageContext.request.contextPath}/edit"  method="post">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${param.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>
                <tr>
                    <td>Login: </td>
                    <td><form:input path="login" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>

</form>
</body>
</html>