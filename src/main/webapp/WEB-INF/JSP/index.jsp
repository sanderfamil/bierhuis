<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>

<!doctype html>
<html>
<head>
<v:head title="Welkom"/>
</head>
<body>
<v:menu/>
<h1>Welkom in het huis van de Belgische bieren</h1>
<img src="<c:url value='/images/bierhuis.jpg'/>" alt="bierhuis"/><br>
We hebben momenteel <fmt:formatNumber value="${aantalBieren}"/> bieren.
</body>
</html>