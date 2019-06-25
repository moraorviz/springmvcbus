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
	<h2 style="text-align: center;">Welcome to the smallest bus ticket shop in
		the world!</h2>
	<br> Our Catalog:
	<br>
	<table>
		<tr>
			<td><b>City Id</b></td>
			<td><b>Name</b></td>
		</tr>
		<c:forEach items="${citieslist}" var="city">
			<tr>
				<td><c:out value="${city.id}"></c:out></td>
				<td><c:out value="${city.name}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
