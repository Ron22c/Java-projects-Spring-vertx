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
    <title>Home Members AREA</title>
</head>
<body>
<%
    String userId=null, sessionId=null;
    if(request.getSession().getAttribute("userId") == null) {
        response.sendRedirect("login.jsp");
    } else {
        userId=request.getSession().getAttribute("userId").toString();
        sessionId=request.getSession().getId();
    }
%>
<%--
Replacing cookie with session attribute
Cookie[] cookie = request.getCookies();
if(cookie != null) {
    for(Cookie c: cookie) {
        if(c.getName().equals("userId")) {
            userId = c.getValue();
        }
        if(c.getName().equals("JSESSIONID")) {
            sessionId = c.getValue();
        }
    }
}
--%>


<h1>Welcome to members area</h1><br/>
<h3>User Id: <%=userId%></h3><br/>
<h3>Session Id: <%=sessionId%></h3>

<form action="<%=request.getContextPath()%>/membersareacontroller" method="get">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="LOGOUT">
</form>

</body>
</html>
