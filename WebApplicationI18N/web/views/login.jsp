<%@ taglib prefix="cs" uri="http://java.sun.com/jsp/jstl/core"%>
<cs:import url="header.jsp">
    <cs:param name="title" value="LOGIN"/>
</cs:import>

<h3>PLEASE PROVIDE YOUR USERNAME AND PASSWORD FOR LOGIN</h3>
<form action="<%=request.getContextPath()%>/controller" method="post">
    USERNAME: <input type="text" name="username"/> <br/>
    PASSWORD: <input type="password" name="password"/> <br/>
    <input name="action" type="hidden" value="login">
    <input type="submit" value="LOGIN">
</form>
<cs:import url="footer.jsp"/>