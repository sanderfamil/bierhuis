<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>
<!doctype html>
<html>
<head>
<v:head title="Winkelwagen"></v:head>
</head>
<body>
<v:menu/>
<c:if test="${not empty mandje}">
<h1>Winkelwagen</h1>
<table id="mandjetabel">
<thead>
<tr>
<th>Bier</th>
<th>Prijs</th>
<th>Aantal</th>
<th>Te betalen</th>
</tr>
</thead>
<tbody>
<c:forEach items="${mandje.bestelbonLijnen}" var="bestelbonLijn">
<tr>
<td>${bestelbonLijn.bier.naam}</td>
<td> <fmt:formatNumber value="${bestelbonLijn.bier.prijs}" minFractionDigits="2" maxFractionDigits="2"/> </td>
<td>${bestelbonLijn.aantal}</td>
<td><fmt:formatNumber value="${bestelbonLijn.totaal}" minFractionDigits="2" maxFractionDigits="2"/></td>
</tr>
</c:forEach>
</tbody>
<tfoot>
<tr>
<td colspan="3"/>
<td>Totaal: <fmt:formatNumber value="${mandje.totaal}" minFractionDigits="2" maxFractionDigits="2"/></td>
</tr>
</tfoot>
</table>

<form method="post" id="toevoegform">
<label>
<b>Naam</b><span class="fout">${fouten.naam}</span><br>
<input name="naam" autofocus required><br>
</label>
<label>
<b>Straat</b><span class="fout">${fouten.straat}</span><br>
<input name="straat" required><br>
</label>
<label>
<b>Huisnummer</b><span class="fout">${fouten.huisNr}</span><br>
<input name="huisNr" required><br>
</label>
<label>
<b>Postcode</b><span class="fout">${fouten.postCode}</span><br>
<input name="postCode" type="number" min="1000" max="9999" required>
<br>
</label>
<label>
<b>Gemeente</b><span class="fout">${fouten.gemeente}</span><br>
<input name="gemeente" required><br>
</label>
<input type="submit" value="Als bestelbon bevestigen" id="toevoegknop">
</form>
</c:if>
	<script>
		document.getElementById("toevoegform").onsubmit = function() {
			document.getElementById("toevoegknop").disabled = true;

		};
	</script>
<c:if test="${empty mandje}">
<h1>Mandje niet gevonden.</h1>
</c:if>
</body>
</html>