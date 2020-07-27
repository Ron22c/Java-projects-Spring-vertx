<%--
  Created by IntelliJ IDEA.
  User: cranajit
  Date: 17/05/20
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/controller" method="post">
        First Name: <input type="text" name="first" required/><br/>
        Last Name: <input type="text" name="last" required/><br/>
        Gender: <input type="radio" name="gender" value="male" checked="checked"> Male
                <input type="radio" name="gender" value="female"> Female<br/>
        Language Known: <input type="checkbox" name="language" value="english"> English
                        <input type="checkbox" name="language" value="bengali"> Bengali
                        <input type="checkbox" name="language" value="hindi"> Hindi<br/>
        Country: <select name="country"><br/>
                    <option name="india" value="india">India</option>
                    <option name="US" value="US">USA</option>
                    <option name="UK" value="UK">UK</option>
                    <option name="spain" value="spain">Spain</option>
                </select>
        <input name="submit" type="submit">
    </form>
</body>
</html>
