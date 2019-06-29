<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>TuBus</title>
</head>
<body>
	<h1 style="text-align: center;">TUBUS.COM</h1>
	<spring:message code="show.idas"/>
	<br>
	<table>
		<tr>
			<td><b><spring:message code="show.estacionsalida"/></b></td>
			<td><b><spring:message code="show.estacionllegada"/></b></td>
			<td><b><spring:message code="show.fechasalida"/></b></td>
			<td><b><spring:message code="show.horasalida"/></b></td>
			<td><b><spring:message code="show.fechallegada"/></b></td>
			<td><b><spring:message code="show.horallegada"/></b></td>
		</tr>
		<c:forEach items="${travels}" var="travel">
			<tr>
				<td><c:out value="${travel.departure}"></c:out></td>
				<td><c:out value="${travel.arrival}"></c:out></td>
				<td><c:out value="${travel.departureDate}"></c:out></td>
				<td><c:out value="${travel.departureHour}"></c:out></td>
				<td><c:out value="${travel.arrivalDate}"></c:out></td>
				<td><c:out value="${travel.arrivalHour}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
