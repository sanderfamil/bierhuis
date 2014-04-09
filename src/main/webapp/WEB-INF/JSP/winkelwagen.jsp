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
<h1>Winkelwagen</h1>
<table>
<thead>
<tr>
<th>Bier</th>
<th>Prijs</th>
<th>Aantal</th>
<th>Te betalen</th>
</tr>
</thead>
<tbody>
<c:forEach items="${bestelbon.bestelbonLijnen}" var="bestelbonLijn">
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
<td>Totaal: <fmt:formatNumber value="${bestelbon.totaal}" minFractionDigits="2" maxFractionDigits="2"/></td>
</tr>
</tfoot>
</table>

<form method="post">
<label>
<b>Naam</b><br>
<input name="naam" autofocus><br>
</label>
<label>
<b>Straat</b><br>
<input name="straat"><br>
</label>
<label>
<b>Huisnummer</b><br>
<input name="huisNr"><br>
</label>
<label>
<b>Postcode</b><br>
<input name="postCode" type="number" min="1000" max="9999"><br>
</label>
<label>
<b>Gemeente</b><br>
<input name="gemeente"><br>
</label>
<input type="submit" value="Als bestelbon bevestigen">
</form>
</body>
</html>