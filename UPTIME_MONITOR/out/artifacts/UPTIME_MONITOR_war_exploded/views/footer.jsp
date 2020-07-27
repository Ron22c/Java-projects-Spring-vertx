<%@ taglib prefix="co" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<br/>
<p>*******************************************</p>
<br/>

<co:set value="<%= new java.util.Date()%>" var="date"/>
<fmt:formatDate value="${date}" />
<fmt:formatDate value="${date}" type="time"/>
<h3>copyright by CRANAJIT & CO.</h3>
</body>
</html>
