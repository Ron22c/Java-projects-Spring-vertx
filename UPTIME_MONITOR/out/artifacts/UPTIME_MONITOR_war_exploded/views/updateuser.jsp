<%@ page import="com.cranajit.models.UserInfoModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cranajit.models.UserInfoModel" %>
<c:import url="header.jsp">
    <c:param name="title" value="UPDATE USER INFORMATION"/>
</c:import>

<%
    UserInfoModel model = (UserInfoModel) request.getAttribute("user");
%>

<h3>PLEASE PROVIDE THE BELOW MENTIONED DETAILS TO UPDATE YOUR PROFIE</h3>

<form action="<%=request.getContextPath()%>/members" method="post">
    FIRST NAME: <input type="text" name="first" value="<%=model.getFirstName()%>" required><br/>
    LAST NAME: <input type="text" name="last" value="<%=model.getLastName()%>" required><br/>
    PASSWORD: <input type="password" name="password" value="<%=model.getPassword()%>" required><br/>
    GENDER: <input type="radio" name="gender" value="male" checked="checked"> MALE
    <input type="radio" name="gender" value="female"> FEMALE
    <input type="radio" name="gender" value="other"> OTHER<br/>
    LANGUAGES KNOWN: <input type="checkbox" name="language" value="english" checked> ENGLISH
    <input type="checkbox" name="language" value="spanish"> SPANISH
    <input type="checkbox" name="language" value="bengali"> BENGALI<br/>
    COUNTRY: <select name="country">
    <option value="india">INDIA</option>
    <option value="usa">USA</option>
    <option value="spain">SPAIN</option>
    </select><br/>
    <input type="hidden" name="action" value="updateUserInfo"/>
    <input type="hidden" name="phone" value="<%=model.getPhone()%>">
    <input type="submit" value="UPDATE MY PROFILE"/>
</form>


<c:import url="footer.jsp"/>