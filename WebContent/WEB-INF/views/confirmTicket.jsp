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
	<p> <spring:message code="confirm"/> <c:out value="${shoppingCart.id}"/> </p>
	<br>
	<form:form modelAttribute="user">
	<spring:message code="user.nombre"/>
	<form:input path="nombre" id="user_name"/>
	<br>
	<spring:message code="user.apellidos"/>
	<form:input path="apellidos" id="user_apellidos"/>
	<br>
	<form:select path="tipoIdent" items="${metodosident}" id="tipo_ident"/>
	<form:input path="ident" id="user_ident" />
	<br>
	<spring:message code="user.email"/>
	<form:input path="email" id="user_email"/>
	<br>
	<input type="submit" value="submit" />
	</form:form>
	
	<script>
	
	</script>
</body>
</html>