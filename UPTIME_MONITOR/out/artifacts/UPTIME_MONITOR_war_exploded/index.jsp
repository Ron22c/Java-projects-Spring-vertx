<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="views/header.jsp">
  <c:param name="title" value="WELCOME TO UPTIME"/>
</c:import>
<h3>PLEASE LOGIN OR REGISTER YOURSELF TO EXPLORE</h3><br/>
<a href="<%=request.getContextPath()%>/controller?page=login">LOGIN INTO THE CONSOLE AND EXPLORE</a><br/><br/>
<a href="<%=request.getContextPath()%>/controller?page=signup">REGISTER AND BE A PART OF THE COOL FAMILY</a><br/>
<c:import url="views/footer.jsp"/>
