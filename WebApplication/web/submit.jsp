<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 16/05/20
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit</title>
</head>
<body>
<h3> Name: <%=request.getParameter("first") +" "+ request.getParameter("last")%></h3>
<h3> gender: <%=request.getParameter("gender")%></h3>
<h3> language:
    <%
        String[] languages = request.getParameterValues("language");
        if(languages != null) {
            for(int i=0; i<languages.length;i++) {
                out.print("<br/>"+languages[i]);
            }
        } else {
            out.print("Not Provided");
        }
    %>
</h3>
<h3> country: <%=request.getParameter("country")%></h3>
<a href="<%=request.getContextPath()%>/Router?page=login">Login to the application</a>

</body>
</html>
