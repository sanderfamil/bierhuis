<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>
<!doctype html>
<html>
<head>
<v:head title='${empty bier ? "Bier niet gevonden" : bier.naam}'/>
</head>
<body>
<v:menu/>
<c:if test="${not empty bier}">
<h1>${bier.naam}</h1>
<b>Alcohol</b><br>
${bier.alcohol} <c:out value="%"></c:out><br>
<b>Prijs</b><br>
<c:out value="€"></c:out> ${bier.prijs}<br>
<b>Soort</b><br>
${bier.soort.naam}<br>
<b>Brouwer</b><br>
${bier.brouwer.naam}<br>
<form method="post" id="toevoegform">
<label><b>Aantal</b><span class="fout"> ${fout}</span><br>
<input type="hidden" name="bierNr" value="${bier.bierNr}">
<input name="aantal" type="number"  value="${oudAantal}" autofocus required min="1"> </label>
<input type="submit" value="Toevoegen" id="toevoegknop"> 
</form>
${bierAlInMandje}
	<script>
		document.getElementById("toevoegform").onsubmit = function() {
			document.getElementById("toevoegknop").disabled = true;

		};
	</script>
</c:if>
<c:if test="${empty bier}">
<h1>Bier niet gevonden</h1>
${fout}
</c:if>
</body>
</html>