<%@ taglib prefix="cs" uri="http://java.sun.com/jsp/jstl/core"%>
<cs:import url="header.jsp">
    <cs:param name="title" value="MEMBERS AREA"/>
</cs:import>
<%
    String username=null, sessionId=null;
    if(request.getSession().getAttribute("username")!=null) {
        username = request.getSession().getAttribute("username").toString();
        sessionId = request.getSession().getId();
    } else {
        response.sendRedirect(request.getContextPath()+"/controller?page=login");
    }
%>

<h1>**WELCOME TO THE MEMBERS AREA OF OUR APPLICATION**</h1></br>
<h3>HELLO <%=username%></h3></br>
<p>YOUR SESSION ID IS <%=sessionId%></p></br>

<form action="<%=request.getContextPath()%>/membercontroller" method="get">
    <input type="hidden" name="action" value="memberlogout">
    <input type="submit" name="LOGOUT" value="LOGOUT"></br>
</form>

<cs:import url="footer.jsp"/>