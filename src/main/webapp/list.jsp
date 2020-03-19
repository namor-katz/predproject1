<%@ page import="java.util.*" %>
<%@ page import="com.mycompany.app.model.User" %><%--
  Created by IntelliJ IDEA.
  User: guest
  Date: 16.03.20
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Users</title>
</head>
<body>
<center>
    <h1>This list all users</h1>
    <h2>
        <a href="/my_app_war/add">Add User</a>

    </h2>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption>List Users</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Time_Created</th>
            <th>Base Language</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userNames}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.time_created}" /></td>
                <td><c:out value="${user.basic_language}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>

            </tr>

        </c:forEach>
    </table>
</div>

</body>
</html>
