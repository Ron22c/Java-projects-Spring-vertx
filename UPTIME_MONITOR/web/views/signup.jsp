<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="REGISTRATION PAGE"/>
</c:import>
<h3>PLEASE PROVIDE THE BELOW MENTIONED DETAILS TO BECOME A MEMBER OF OUR UPTIME FAMILY</h3>

<form action="<%=request.getContextPath()%>/controller" method="post">
    FIRST NAME: <input type="text" name="first" required><br/>
    LAST NAME: <input type="text" name="last" required><br/>
    PHONE: <input type="text" name="phone" required><br/>
    PASSWORD: <input type="password" name="password" required><br/>
    GENDER: <input type="radio" name="gender" value="male" checked="checked"> MALE
    <input type="radio" name="gender" value="female"> FEMALE
    <input type="radio" name="gender" value="other"> OTHER<br/>
    LANGUAGES KNOWN: <input type="checkbox" name="language" value="english"> ENGLISH
    <input type="checkbox" name="language" value="spanish"> SPANISH
    <input type="checkbox" name="language" value="bengali"> BENGALI<br/>
    COUNTRY: <select name="country">
    <option value="india">INDIA</option>
    <option value="usa">USA</option>
    <option value="spain">SPAIN</option>
    </select><br/>
    <input type="hidden" name="action" value="signup"/>
    <input type="submit" name="REGISTER" value="REGISTER">
</form>

<c:import url="footer.jsp"/>