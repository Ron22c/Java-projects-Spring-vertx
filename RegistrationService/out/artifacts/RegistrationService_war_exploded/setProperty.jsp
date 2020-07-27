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
    <title>SET PROPERTY</title>
</head>
<body>
Setting property....<br/>
<jsp:useBean id="user" class="com.cranajit.User" scope="session"/>
<jsp:setProperty name="user" property="firstName" value="Ron"/>
<jsp:setProperty name="user" property="lastName" value="Chandra Chandra"/>
Property set complete<br/>
</html>
