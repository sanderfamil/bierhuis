<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>

<!doctype html>
<html>
<head>
<v:head title="Brouwers"/>
</head>
<body>
<v:menu/>
<h1>Brouwers</h1>
<c:if test="${not empty brouwers}">
<ul>
<c:forEach items="${brouwers}" var="brouwer">
<c:url value="/brouwerdetail.htm" var="brouwerdetailURL">
<c:param name="brouwerId" value="${brouwer.brouwerNr}"/>
</c:url>
<li><a href="${brouwerdetailURL}">${brouwer.naam} (${brouwer.adres.gemeente})</a></li>
</c:forEach>
</ul>
</c:if>
</body>
</html>