<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 17/05/20
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET PROPERTY</title>
</head>
<body>
GETTING property....<br/>
<jsp:useBean id="user" class="com.cranajit.User" scope="session"/>
First Name: <jsp:getProperty name="user" property="firstName"/><br/>
Last Name: <jsp:getProperty name="user" property="lastName" /><br/>
Property Get completed
</body>
</html>
