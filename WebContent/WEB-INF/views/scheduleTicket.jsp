<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import = "java.io.*,java.util.*" %>

<html>
<head>
<title>TuBus</title>
</head>
<body>
     <%
         Integer hitsCount = (Integer)application.getAttribute("hitCounter");
         if( hitsCount ==null || hitsCount == 0 ) {
            /* First visit */
            out.println("Welcome to my website!");
            hitsCount = 1;
         } else {
            /* return visit */
            out.println("Welcome back to my website!");
            hitsCount += 1;
         }
         application.setAttribute("hitCounter", hitsCount);
      %>


	<h1 style="text-align: center;">TUBUS.COM</h1>
	<br>
	<h2 style="text-align: center;">
		<spring:message code="welcome" />
	</h2>
	
	
	<form:form modelAttribute="search" accept-charset="utf-8">
	
	<br>
	<spring:message code="select.type" />
	<form:checkbox id="Check1" onclick="selectOnlyThis(this.id)" path="onlyGo"/>
	<spring:message code="select.oneway" />
	<form:checkbox id="Check2" value="roundtrip" path="roundTrip"
		onclick="selectOnlyThis(this.id)"/>
	<spring:message code="select.round" />
	<br>
	
		<spring:message code="select.departure_city" />
		<form:select itemValue="id" itemLabel="name" path="departure" items="${citieslist}" />
		<br>
		<spring:message code="select.arrival_city" />
		<form:select itemValue="id" itemLabel="name" path="arrival" items="${citieslist}" />
		<br>
		<spring:message code="select.departure_date" />
		<form:select path="departureDate" type="Date" items="${dateslist}" />
		<br>
		<spring:message code="select.return_date" />
		<form:select disabled="true" path="returnDate" type="Date" items="${dateslist}" />
		<br>
		<spring:message code="select.number" />
		<form:select path="number" items="${numberlist}" />
		<br>
		<input type="submit"/>
	</form:form>
	<a href="cancelTicket"><spring:message code="select.cancel"/></a>
	<br>
	    
         <spring:message code="visitors"/>: <%= hitsCount%>

	
	
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
