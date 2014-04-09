<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>
<!doctype html>
<html>
<head>
<v:head title='${empty brouwer ? "Brouwer niet gevonden" : brouwer.naam}'/>
</head>
<body>
<v:menu/>
<c:if test="${not empty brouwer}">
<h1>${brouwer.naam}</h1>
<ul>
<c:forEach items="${brouwer.bieren}" var="bier">
<li>
<c:url value="/bier.htm" var="BierURL">
<c:param name="bierId" value="${bier.bierNr}"/></c:url>
<a href="${BierURL}">${bier.naam}</a>
</li>
</c:forEach>
</ul>
</c:if>
<c:if test="${empty brouwer}">	
<h1>Brouwer niet gevonden</h1>
${fout}
</c:if>
</body>
</html>