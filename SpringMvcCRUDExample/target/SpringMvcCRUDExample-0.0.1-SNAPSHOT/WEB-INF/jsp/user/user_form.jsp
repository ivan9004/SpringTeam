<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario</title>
</head>
<body>

	<spring:url value="/user/save" var="saveURL" />
	<form:form modelAttribute="userForm" method="post" action="${saveURL }">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td>Apellidos</td>
				<td><form:input path="apellidos" /></td>
			</tr>
			<tr>
				<td>Nombre de usuario</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td><form:input path="direccion" /></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><form:input path="telefono" /></td>
			</tr>
			<tr>
				<td>Edad</td>
				<td><form:input path="edad" /></td>
			</tr>
			<tr>
				<td>Aceptar</td>
				<td><button type="submit"></button>Guardar</td>
			</tr>
		</table>
	</form:form>

</body>
</html>