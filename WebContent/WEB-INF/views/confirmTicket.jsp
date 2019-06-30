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
	<spring:message code="confirm"/>
	<br>
	 <spring:message code="show.numeroIda"/>
	 <c:out value="${shoppingCart.id}"/>
	 <br>
	 <spring:message code="show.numeroVuelta"/>
	 <c:out value="${shoppingCart.vueltaId}"/>
	<br>
	<form:form name="confirm_form" modelAttribute="user" onsubmit="return validate();" accept-charset="utf-8">
	<spring:message code="user.nombre"/>
	<form:input name="user_name" path="nombre" id="user_name" required="true"/>
	<br>
	<spring:message code="user.apellidos"/>
	<form:input name="user_surname" path="apellidos" id="user_apellidos" required="true"/>
	<br>
	<form:select name="tipo_ident" path="tipoIdent" items="${metodosident}" id="tipo_ident"/>
	<form:input name="user_ident" path="ident" id="user_ident" required="true" />
	<br>
	<spring:message code="user.email"/>
	<form:input name="user_email" path="email" id="user_email" required="true"/>
	<br>
	<input type="submit" value="submit" />
	</form:form>
	<script>
	
	function validate() {
		var tipoIdent = document.forms["confirm_form"]["tipo_ident"].value;
		var ident = document.forms["confirm_form"]["user_ident"].value;
		var email = document.forms["confirm_form"]["user_email"].value;
		var nifRegexp = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/i;
		var passportRegexp = /^[a-z]{3}[0-9]{6}[a-z]?$/i;
		var nieRegexp = /^[XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]$/i;
		var emailRegexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		var nameRegexp = null;
		var surnameRegexp = null;
		if (tipoIdent == "NIF" && !nifRegexp.test(ident)) {
			alert("Wrong NIF format");
			return false;
		} else if (tipoIdent == "NIE" && !nieRegexp.test(ident)) {
			alert("Wrong NIE format");
			return false;
		} else if (tipoIdent == "pasaporte" && !passportRegexp.test(itend)) {
			alert("Wrong passport format");
			return false;
		}
		if (!emailRegexp.test(email)) {
			alert("Wrong email format");
			return false;
		}
		alert("Datos correctos");
	}
	
	</script>
</body>
</html>
