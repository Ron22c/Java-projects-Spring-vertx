<%@page import="com.cranajit.models.UserModel" %>
<html>
<head>
    <title>USER INFORMATION</title>
</head>
<body>
<% UserModel model = (UserModel)request.getAttribute("model");%>
<h3>NAME: <%=model.getName()%></h3>
<h3>EMAIL: <%=model.getEmail()%></h3>
<h3>GENDER: <%=model.getGender()%></h3>
<h3>COUNTRY: <%=model.getCountry()%></h3>
<h3>INTRODUCTION: <%=model.getIntroduction()%></h3>
<h3>LANGUAGES KNOWN:</h3>
<ul>
    <%
        for(String language: model.getLanguages()){
            out.println("<li>"+language+"</li>");
        }
    %>
</ul>
</body>
</html>