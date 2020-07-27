<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>USER REGISTRATION</title>
</head>
<body>
<h2>WELCOME TO THE APPLICATION</h2>
<form:form action="/showuserdata" modelAttribute="user">
    <p/>NAME: <form:input path="name" required="true"/>
    <p/>EMAIL: <form:input path="email" required="true"/>
    <p/>GENDER: <form:radiobuttons path="gender" items="${gender}" required="true"/>
    <p/>COUNTRY: <form:select path="country" items="${country}" required="true"/>
    <p/>INTRODUCTION: <form:textarea path="introduction" required="true"/>
    <p/>LANGUAGES:
        <form:checkbox path="languages" value="BENGALI"/>BENGALI
        <form:checkbox path="languages" value="SPANISH"/>SPANISH
        <form:checkbox path="languages" value="PORTUGEESE"/>PORTUGEESE
    <p/><input type="submit" value="SUBMIT">
</form:form>
</body>
</html>
