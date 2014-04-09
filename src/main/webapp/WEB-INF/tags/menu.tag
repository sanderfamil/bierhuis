<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="menu">
<a href="<c:url value='/index.htm'/>">Welkom</a>
<a href="<c:url value='/brouwers.htm'/>">Bieren van een brouwer</a>
<c:if test="${not empty mandje}">
<a href="<c:url value='/winkelwagen.htm'/>">Winkelwagen</a>
</c:if>
</div>
