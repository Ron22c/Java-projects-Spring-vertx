<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 07/06/20
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN HERE</title>
</head>
    <body>
        <form:form action="/login" modelAttribute="user" method="get">
            PHONE: <form:input path="phone" required="true"/>
            PASSWORD: <form:input path="password" required="true"/>
            <input type="submit" value="SUBMIT">
        </form:form>
    </body>
</html>
