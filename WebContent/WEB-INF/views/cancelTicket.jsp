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
	<form:form modelAttribute="ticket">
	<spring:message code="show.code"/>
	<form:input path="code" id="ticket_code" required="true"/>
	<br>
	<spring:message code="user.email"/>
	<form:input path="user" id="user_email" required="true"/>
	<input type="submit" value="submit" />
	</form:form>
</body>
</html>