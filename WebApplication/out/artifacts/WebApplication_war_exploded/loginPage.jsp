<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 16/05/20
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>LOGIN PAGE</h1>

<form action="<%=request.getContextPath()%>/controller" method="post">
    First Name: <input type="text" name="first" required/><br/>
    Last Name: <input type="text" name="last"/><br/>
    Gender: <input type="radio" name="gender" value="male" checked="checked"> Male
            <input type="radio" name="gender" value="female"> Female<br/>
    <input type="submit" name="submit">
</form>
</body>
</html>
