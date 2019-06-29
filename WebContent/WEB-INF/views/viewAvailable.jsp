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
	<form:form modelAttribute="shoppingCart">
	<table>
		<tr>
			<td><b><spring:message code="show.estacionsalida"/></b></td>
			<td><b><spring:message code="show.estacionllegada"/></b></td>
			<td><b><spring:message code="show.fechasalida"/></b></td>
			<td><b><spring:message code="show.horasalida"/></b></td>
			<td><b><spring:message code="show.fechallegada"/></b></td>
			<td><b><spring:message code="show.horallegada"/></b></td>
			<td><b><spring:message code="show.elegir"/></b>
		</tr>
		<c:forEach items="${travels}" var="travel" varStatus="loop">
			<tr>
				<td><c:out value="${travel.departure}"></c:out></td>
				<td><c:out value="${travel.arrival}"></c:out></td>
				<td><c:out value="${travel.departureDate}"></c:out></td>
				<td><c:out value="${travel.departureHour}"></c:out></td>
				<td><c:out value="${travel.arrivalDate}"></c:out></td>
				<td><c:out value="${travel.arrivalHour}"></c:out></td>
				<td>
					<form:checkbox path="id" id="Check${loop.index}" onclick="selectOnlyThis(this.id)" value="${travel.id}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="submit" />
	</form:form>
		<a href="buyTicket"><spring:message code="select.buy"/></a><br/>
		<a href="printTicket"><spring:message code="select.print"/></a>
		
		<script>
		
		function selectOnlyThis(id) {
			for (var i = 0; i <= 1; i++) {
				document.getElementById("Check" + i).checked = false;
			}
			document.getElementById(id).checked = true;
		}
			
		</script>
</body>
</html>
