<%--
  Created by IntelliJ IDEA.
  User: guest
  Date: 16.03.20
  Time: 14:50
  To change this template use File | Settings | File Templates.
  тут хтмл, но это работает
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My super project!</title>
</head>
<body>
<!-- header -->
<div>
    <h1>Super app!</h1>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <h3>Please, registration</h3>
<%--        <button onclick="location.href='/my_app_war/list'">List users</button>--%>
        <button onclick="location.href='/my_app_war/add'">Registration</button>
    </div>
    <h2>OR</h2>
    <div>
        <h3>Sign in!</h3>

        <form method="POST" accept-charset="UTF-8">
            <p><input type="text" name="name" placeholder="your name"/></p>
            <p><input type="password" name="password" placeholder="your password"/></p>
            <p> <input type="submit" value="login"/></p>
        </form>

    </div>
</div>
</body>
</html>
