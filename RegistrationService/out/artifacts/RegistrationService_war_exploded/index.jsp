<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 17/05/20
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home Page</title>
  </head>
  <body>
    <a href="<%=request.getContextPath()%>/controller?page=signup">SIGN UP</a><br/>
    <a href="<%=request.getContextPath()%>/controller?page=login">LOGIN</a>
  </body>
</html>
