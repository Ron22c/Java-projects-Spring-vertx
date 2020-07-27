<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp">
    <c:param name="title" value="LOGIN PAGE"/>
</c:import>
<h3>PLEASE ENTER THE CREDENTIALS TO LOGIN INTO THE SYSTEM</h3>
<form action="<%=request.getContextPath()%>/controller" method="post">
    PHONE: <input type="text" name="phone" required/><br/>
    PASSWORD: <input type="password" name="password" required><br/>
    <input type="hidden" name="action" value="login"/>
    <input type="submit" name="LOGIN" value="LOGIN">
</form>
<c:import url="footer.jsp"/>
