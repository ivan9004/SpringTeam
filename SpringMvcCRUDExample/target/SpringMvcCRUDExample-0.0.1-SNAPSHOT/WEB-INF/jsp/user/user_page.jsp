<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<spring:url value="/user/add" var="addURL"/>
<a href="${addURL }">Agregar</a>

	<h1>Estos son los usuarios</h1>

	<table width="100%" border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Email</th>
			<th>Pass</th>
			<th>Direccion</th>
			<th>Telefono</th>
			<th>edad</th>
			<th colspan="3">Accion</th>
		</tr>
		<c:forEach items="${listUser }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.nombre }</td>
				<td>${user.apellidos }</td>
				<td>${user.email }</td>
				<td>${user.pass }</td>
				<td>${user.direccion }</td>
				<td>${user.telefono }</td>
				<td>${user.edad }</td>
				<td>
					<spring:url value="/user/update/${user.id}" var="updateURL"/>
					<a href="${updateURL }">Actualizar</a>
				</td>
				<td>
					<spring:url value="/user/delete/${user.id}" var="deleteURL"/>
					<a href="${deleteURL }">Borrar</a>
				</td>
				<td>
					<spring:url value="/compra/add/${user.id}" var="compraURL"/>
					<a href="${compraURL }">Comprar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>