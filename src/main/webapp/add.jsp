<%--
  Created by IntelliJ IDEA.
  User: guest
  Date: 16.03.20
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add your user</title>
</head>
<body>
<h1>Register your user!</h1>
<form method="POST" accept-charset="UTF-8">
    <p><input type="text" name="name" placeholder="name" /> </p>
    <p> <input type="text" name="lang" placeholder="Programming Language"/> </p>
    <p><input type="checkbox" name="is_admin" value="true" >сделать админом?</p>
    <p> <input type="submit" value="registration"> </p>
</form>

</body>
</html>
