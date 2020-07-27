<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cranajit.models.UserInfoModel"  %>
<%@ page import="java.util.List"  %>
<c:import url="header.jsp">
    <c:param name="title" value="MEMBERS AREA"/>
</c:import>
<%
    String phone=null;
    String sessionId=null;
    String user=null;
    if(request.getSession().getAttribute("phone")!=null) {
        phone = request.getSession().getAttribute("phone").toString();
        sessionId = request.getSession().getId();
        Cookie[] cookies = request.getCookies();
        if(cookies!= null) {
            for(Cookie cookie:cookies) {
                if(cookie.getName().equals("user")) {
                    user = cookie.getValue();
                }
            }
        }
    } else {
        response.sendRedirect(request.getContextPath()+"/controller?page=login");
    }
%>
<h1>WELCOME TO THE MEMBERS AREA</h1><br/>
<h3>USER PHONE NUMBER: <%=phone%></h3><br/>
<h3>SESSION ID: <%=sessionId%></h3><br/>
<h3>USER ID: <%=user%></h3><br/>

<h2>ALL OF THE MEMBERS INFO</h2>
<table border="1" cellspacing="1">
    <thead>
    <th>Phone</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Gender</th>
    <th>Languages</th>
    <th>Country</th>
    </thead>
    <tbody>
    <%
        List<UserInfoModel> userData = (List) request.getAttribute("userData");
        for (UserInfoModel userDataModel : userData) {
            out.print("<tr>");
            out.print("<td>" + userDataModel.getPhone() + "</td>");
            out.print("<td>" + userDataModel.getFirstName() + "</td>");
            out.print("<td>" + userDataModel.getLastName() + "</td>");
            out.print("<td>" + userDataModel.getGender() + "</td>");
            out.print("<td>" + userDataModel.getLanguage() + "</td>");
            out.print("<td>" + userDataModel.getCountry() + "</td>");
            out.print("</tr>");
        }
    %>
    </tbody>
</table>
<br/>

<h3>ADD IMAGES</h3>
<form action="<%=request.getContextPath()%>/members?action=imageupload&phone=<%=phone%>" method="post" enctype="multipart/form-data">
    SELECT IMAGES : <input type="file" name="files" multiple/>
    <input type="submit" value="UPLOAD IMAGES"/>
</form>

<h3>UPDATE MY INFO</h3>
<form action="<%=request.getContextPath()%>/members" method="get">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="phone" value="<%=phone%>"/>
    <input type="submit" value="UPDATE ACCOUNT"/>
</form>

<h3>DELETE MY ACCOUNT</h3>
<form action="<%=request.getContextPath()%>/members" method="get">
    <input type="hidden" name="action" value="delete"/>
    <input type="hidden" name="phone" value="<%=phone%>"/>
    <input type="submit" value="DELETE ACCOUNT"/>
</form>

<form action="<%=request.getContextPath()%>/members" method="get">
    <input type="hidden" name="action" value="logout"/>
    <input type="submit" name="LOGOUT" value="LOGOUT"/>
</form>
<c:import url="footer.jsp"/>