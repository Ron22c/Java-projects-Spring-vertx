<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>WELCOME</title>
</head>
<body>
<h2>WELCOME TO OUR PAGE</h2>
<form:form action="/register" modelAttribute="user">
    <p/>PHONE: <form:input path="phone" required="true"/>
    <p/>FIRSTNAME: <form:input path="firstName" required="true"/>
    <p/>LASTNAME: <form:input path="lastName" required="true"/>
    <p/>PASSWORD: <form:input path="password" required="true"/>
    <p/>GENDER: <form:radiobuttons path="gender" items="${gender}"/>
    <p/>LANGUAGES KNOWN: <form:checkboxes path="language" items="${language}"/>
    <p/>COUNTRY: <form:select path="country" items="${country}"/>
    <p/><input type="submit" value="SIGNUP">
</form:form>
</body>
</html>
