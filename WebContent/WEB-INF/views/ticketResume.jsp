<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>TuBus</title>
</head>
<body>
	<h1 style="text-align: center;">TUBUS.COM</h1>
	<br>
	<p> <spring:message code="show.resume"/></p>
	<br>
	<spring:message code="user.nombre"/>: <c:out value="${user.nombre}"/>
	<br>
	<spring:message code="user.apellidos"/>: <c:out value="${user.apellidos}"/>
	<br>
	<spring:message code="user.ident"/>: <c:out value="${user.ident}"/>
	<br>
	<spring:message code="user.email"/>: <c:out value="${user.email}"/>
	<br>
	<spring:message code="show.numeroIda"/>: <c:out value="${shoppingCart.id}"/>
	<br>
	<spring:message code="show.numeroVuelta"/>: <c:out value="${shoppingCart.vueltaId}"/>
	<br>
	<spring:message code="show.code"/>: <c:out value="${shoppingCart.code}"/>
	<br>
	<button onclick="printCalendar()"><spring:message code="select.print"/></button>
	<br>
	<a href="sendResume"><spring:message code="select.sendresume"/></a>
	<br>
	<a href="scheduleTicket"><spring:message code="show.inicio"/></a>
	<script>
	
	function printCalendar() {
		window.print();
	}
		
	</script>
	</body>
</html>