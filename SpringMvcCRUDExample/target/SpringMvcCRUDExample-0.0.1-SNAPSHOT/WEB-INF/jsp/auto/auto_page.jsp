<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autos</title>
</head>
<body>
	<spring:url value="/auto/add" var="addURL" />
	<a href="${addURL }">Agregar</a>

	<h1>Pagina para los autos</h1>

	<table width="100%" border="1">
		<tr>
			<th>Precio</th>
			<th>Nombre Auto</th>
			<th>Modelo</th>
			<th>Puertas</th>
			<th colspan="2">Accion</th>
		</tr>
		<c:forEach items="${listAutos }" var="autos">
			<tr>
				<td>${autos.precio }</td>
				<td>${autos.nombreAuto }</td>
				<td>${autos.modelo }</td>
				<td>${autos.puertas}</td>
				<td><spring:url value="/auto/update/${autos.idAuto}" var="updateURL" />
					<a href="${updateURL }">Actualizar</a></td>
				<td><spring:url value="/auto/delete/${autos.idAuto}" var="deleteURL" />
					<a href="${deleteURL }">Borrar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>