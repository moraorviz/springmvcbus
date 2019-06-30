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
	<spring:message code="cancel"/>
	<br>
	<form:form modelAttribute="ticket" id="delete_form" onsubmit="return validate();" accept-charset="utf-8">
	<spring:message code="show.code"/>
	<form:input path="code" id="ticket_code" required="true"/>
	<br>
	<spring:message code="user.email"/>
	<form:input path="user" id="user_email" required="true"/>
	<input type="submit" value="submit" />
	</form:form>
	<br>
	<a href="scheduleTicket"><spring:message code="show.inicio"/></a>
	
	<c:out value="${text.text}"/>
	
	<script>
	function validate() {
		var code = document.forms["delete_form"]["ticket_code"].value;
		var email = document.forms["delete_form"]["user_email"].value;
		var emailRegexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		var codeRegexp = /^[a-z0-9]+$/i
		if (!emailRegexp.test(email)) {
			alert("Wrong email format");
			return false;
		} else if (!codeRegexp.test(code)) {
			alert("Wrong code format");
			return false
		}
		alert("Datos correctos.");
	}
	</script>
</body>
</html>