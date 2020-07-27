<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 07/06/20
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "com.cranajit.models.UserModel" %>
<%@ page import= "java.util.List" %>
<%@ page import="java.util.Arrays" %>

<html>
<head>
    <title>SECCESS</title>
</head>
<body>

<h1>REGISTRATION SECCESSFUL</h1>
<h3>USERS LIST:</h3>
<table border="2">
    <thead>
    <th>Phone</th>
    <th>FIRST NAME</th>
    <th>LAST NAME</th>
    <th>GENDER</th>
    <th>LANGUAGE KNOWN</th>
    <th>COUNTRY</th>
    </thead>
    <tbody>
        <%
            List<UserModel> users = (List<UserModel>)request.getAttribute("users");
            for(UserModel user: users) {
                out.println("<tr>");
                out.println("<td>"+user.getPhone()+"</td>");
                out.println("<td>"+user.getFirstName()+"</td>");
                out.println("<td>"+user.getLastName()+"</td>");
                out.println("<td>"+user.getGender()+"</td>");
                out.println("<td>"+Arrays.toString(user.getLanguage())+"</td>");
                out.println("<td>"+user.getCountry()+"</td>");
                out.println("</tr>");
            }
        %>
    </tbody>
</table>

</body>
</html>
