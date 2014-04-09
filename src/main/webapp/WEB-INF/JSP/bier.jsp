<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>
<!doctype html>
<html>
<head>
<v:head title="${bier.naam}"></v:head>
</head>
<body>
<h1>${bier.naam}</h1>
<b>Alcohol</b><br>
${bier.alcohol} <c:out value="%"></c:out><br>
<b>Prijs</b><br>
<c:out value="€"></c:out> ${bier.prijs}<br>
<b>Soort</b><br>
${bier.soort.naam}<br>
<b>Brouwer</b><br>
${bier.brouwer.naam}<br>
<form method="post">
<label><b>Aantal</b><br>
<input type="hidden" name="bierNr" value="${bier.bierNr}">
<input name="aantal" type="number" value="${param.aantal}" autofocus> </label>
${fout}<br>
<input type="submit" value="Toevoegen"> 
</form>
</body>
</html>