<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 16/05/20
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<h1>SIGN UP PAGE</h1>

<form action="submit.jsp" method="post">
    First Name: <input type="text" name="first" required/><br/>
    Last Name: <input type="text" name="last" required/><br/>
    Gender: <input type="radio" name="gender" value="male" checked="checked"> Male
            <input type="radio" name="gender" value="female"> Female<br/>
    Languages Known:    <input type="checkbox" name="language" value="english"> English
                        <input type="checkbox" name="language" value="bengali"> Bengali
                        <input type="checkbox" name="language" value="hindi"> Hindi<br/>
    Country: <select name="country">
    <option value="india">India</option>
    <option value="USA">USA</option>
    <option value="UK">UK</option>
    <option value="nepal">Nepal</option>
    </select><br/>
    <input type="submit" name="submit"/>
</form>
</body>
</html>
