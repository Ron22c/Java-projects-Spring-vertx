<%@ taglib prefix="cs" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<cs:import url="header.jsp">
    <cs:param name="title" value="MEMBERS AREA"/>
</cs:import>

<h1>HEY BUDDY WELCOME TO THE FRIENDS AREA</h1>
<cs:import url="../xml/users.xml" var="userData"/>
<x:parse xml="${userData}" var="data"/>
<h3>YOUR FRIENDS ARE:</h3><br/>
<table border="2px">
<x:forEach select="$data/users/user">
    <tr>
    <td><x:out select="name"/></td>
    <td><x:out select="age"/></td>
    <td><x:out select="sex"/></td>
    </tr>
</x:forEach>
</table>

<cs:import url="footer.jsp"/>