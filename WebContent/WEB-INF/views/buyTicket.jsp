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
	<spring:message code="buy"/>
	<c:out value="${shoppingCart.id}"/>
	<br>
	<spring:message code="show.extra"/>
	<form:form modelAttribute="extra">
	<spring:message code="extra.bicycle"/>
	<form:checkbox path="bici" onclick="enableBike(this.id)" id="bike_check"/> <form:select path="nbici" items="${numberlist}" id="bike_number" disabled="true" />
	<br>
	<spring:message code="extra.pet"/>
	<form:checkbox path="mascota" onclick="enablePet(this.id)" id="pet_check"/><form:select path="nmascota" items="${numberlist}" id="pet_number" disabled="true"/>
	<br>
	<spring:message code="extra.surf"/>
	<form:checkbox path="surf" onclick="enableSurf(this.id)" id="surf_check"/><form:select path="nsurf" items="${numberlist}" id="surf_number" disabled="true"/>
	<br>
	<spring:message code="extra.sky"/>
	<form:checkbox path="sky" onclick="enableSky(this.id)" id="sky_check"/><form:select path="nsky" items="${numberlist}" id="sky_number" disabled="true"/>
	<br>
	<spring:message code="extra.insurance"/>
	<form:checkbox path="seguro" id="seguro_check"/>
	<br>
	<input type="submit" value="submit" />
	</form:form>
	
	<script>
		function enableBike(id) {
			if (document.getElementById(id).checked == true) {
				document.getElementById("bike_number").disabled = false;
			} else {
				document.getElementById("bike_number").disabled = true;
			}
		}
		function enablePet(id) {
			if (document.getElementById(id).checked == true) {
				document.getElementById("pet_number").disabled = false;
			} else {
				document.getElementById("pet_number").disabled = true;
			}
		}
		function enableSurf(id) {
			if (document.getElementById(id).checked == true) {
				document.getElementById("surf_number").disabled = false;
			} else {
				document.getElementById("surf_number").disabled = true;
			}
		}
		function enableSky(id) {
			if (document.getElementById(id).checked == true) {
				document.getElementById("sky_number").disabled = false;
			} else {
				document.getElementById("sky_number").disabled = true;
			}
		}
	</script>
</body>
</html>