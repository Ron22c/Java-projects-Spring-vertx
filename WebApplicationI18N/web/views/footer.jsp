<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br/><p>***********************</p><br/>
<c:set var="date" value="<%=new java.util.Date()%>"/>
TIME: <fmt:formatDate type="time"  value="${date}"/>
DATE: <fmt:formatDate type="date"  value="${date}"/>
<p>copyright by cranajit</p>
</body>
</html>
