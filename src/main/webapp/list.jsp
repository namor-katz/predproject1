<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: guest
  Date: 16.03.20
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Users</title>
</head>
<body>
<h1>This list all users</h1>
<ul>
    <%
        List<String> names = (List<String>) request.getAttribute("userNames");

        if (names != null && !names.isEmpty()) {
            for (String s : names) {
                out.println("<li>" + s + "</li>");
                out.println("<button background=\"navi\">delete</button>");
                out.println("<hr>");
            }
        }
    %>
</ul>

</body>
</html>
