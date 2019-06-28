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
	<h2 style="text-align: center;">
		<spring:message code="welcome" />
	</h2>
	<br>
	<spring:message code="select.type" />
	<input type="checkbox" id="Check1" value="oneway"
		onclick="selectOnlyThis(this.id)" />
	<spring:message code="select.oneway" />
	<input type="checkbox" id="Check2" value="round"
		onclick="selectOnlyThis(this.id)" />
	<spring:message code="select.round" />
	<br>
	
	<form:form modelAttribute="search" accept-charset="utf-8">
		<spring:message code="select.departure_city" />
		<form:select itemValue="id" itemLabel="name" path="departure" items="${citieslist}" />
		<br>
		<spring:message code="select.arrival_city" />
		<form:select itemValue="id" itemLabel="name" path="arrival" items="${citieslist}" />
		<br>
		<spring:message code="select.departure_date" />
		<form:select path="departureDate" items="${dateslist}" />
		<br>
		<spring:message code="select.return_date" />
		<form:select disabled="true" path="returnDate" items="${dateslist}" />
		<br>
		<spring:message code="select.number" />
		<form:select path="number" items="${numberlist}" />
		<input type="submit"/>
	</form:form>
	
	<script>

		document.getElementById("returnDate").disabled = true;
	
		function selectOnlyThis(id) {
			for (var i = 1; i <= 2; i++) {
				document.getElementById("Check" + i).checked = false;
			}
			document.getElementById(id).checked = true;
			roundtravel();
		}

		function roundtravel() {
			if (document.getElementById("Check1").checked) {
				document.getElementById("returnDate").disabled = true;
			} else {
				document.getElementById("returnDate").disabled = false;
			}
		}
		
	</script>
</body>
</html>
