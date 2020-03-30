<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page import="java.util.*" %>
<%@ page import="com.mycompany.app.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User detail info</h1>
<div>
    <p>I have id = <c:out value="${user.id}" /></p>
    <p>My name is <c:out value="${user.name}" />   </p>
    <p> I write in language <c:out value="${user.basic_language}"/> </p>
<%--    <p> And I register <c:out value="${user.time_created}" /> </p>--%>

</div>
</body>
</html>
