<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 17/05/20
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/login" method="post">
    UserId: <input type="text" name="userid"><br/>
    Password: <input type="password" name="password"><br/>
    <input type="submit" name="submit">
</form>
</body>
</html>
