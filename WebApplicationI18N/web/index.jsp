<%@ taglib prefix = "cs" uri = "http://java.sun.com/jsp/jstl/core" %>
<cs:import url="views/header.jsp">
  <cs:param name="title" value="WELCOME"/>
</cs:import>

  <a href="<%=request.getContextPath()%>/controller?page=signup">REGISTER YOURSELF</a><br/>
  <a href="<%=request.getContextPath()%>/controller?page=login">LOGIN TO THE ACCOUNT</a><br/>

<cs:import url="views/footer.jsp"/>
