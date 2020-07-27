<%@ taglib prefix="cs" uri="http://java.sun.com/jsp/jstl/core" %>
<cs:import url="header.jsp">
    <cs:param name="title" value="REGISTER YOURSELF"/>
</cs:import>
<h3>PLEASE FILL THE BELOW MENTIONED DETAILS TO REGISTER YOURSELF</h3><br/>
<form action="<%=request.getContextPath()%>/controller" method="post">
    FIRST NAME: <input type="text" name="first" required/><br/>
    LAST NAME: <input type="text" name="last" required/><br/>
    PASSWORD: <input type="password" name="password" required/><br/>
    GENDER: <input type="radio" name="gender" value="male"> MALE
    <input type="radio" name="gender" value="female"> FEMALE<br/>
    LANGUAGES KNOWN: <input type="checkbox" name="language" value="english"> ENGLISH
    <input type="checkbox" name="language" value="bengali"> BENGALI
    <input type="checkbox" name="language" value="hindi"> HINDI
    <input type="checkbox" name="language" value="spanish"> SPANISH<br/>
    COUNTRY: <select name="country">
    <option value="india">INDIA</option>
    <option value="us">US</option>
    <option value="uk">UK</option>
    <option value="spain">SPAIN</option>
    <option value="canada">CANADA</option>
    </select>
    <br/>
    <input type="hidden" name="action" value="signup"/>
    <input type="submit" name="REGISTER"/>
</select>

</form>

<cs:import url="footer.jsp"/>