<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 16/05/20
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home Page</title>
</head>
<body>
<h1>This is the home page</h1>
<a href="<%= request.getContextPath()%>/Router?page=login">Login</a><br/>
<a href="<%= request.getContextPath()%>/Router?page=signup">SignUp</a><br/>
<a href="<%= request.getContextPath()%>/Router?page=about">About</a><br/>
</body>
</html>
