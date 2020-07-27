<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 15/05/20
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is JSP</title>
</head>
<body>
    <h1>
        <%!
            int i=34;
            int j=34;
            int k = i+j;
        %>
            <br/>
        <%
            int i=12;
            int j=23;
            out.print(i+j);
            out.print("<br/>");
            out.print(request.getParameter("first"));
            out.print("<br/>");
            out.print(request.getParameter("second"));
            out.print("<br/>");
        %>
            <br/>
        <%="hello: " + new java.util.Date()%>

        <h1>Here come the content from a file</h1>
        <h3>
            <%@ include file="file1.txt" %>
            <%--<jsp:forward page="file1.txt"/>--%>
            <%@ page import="java.util.Date" %>

            <jsp:include page="file1.txt"/>

            <%= new Date()%>
        </h3>


        <%
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//            response.sendRedirect("index.jsp");
        %>
        <%-- This is a comment --%>
    </h1>
</body>
</html>
