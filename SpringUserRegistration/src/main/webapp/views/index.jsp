<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>USER REGISTRATION</title>
</head>
<body>
<h2>Hello World!</h2>
<form:form action="/user" modelAttribute="user" method="post">
    GENDER: <form:radiobuttons path="gender" items="${gender}"/>
    <input type="submit" value="SUBMIT">
</form:form>
</body>
</html>
