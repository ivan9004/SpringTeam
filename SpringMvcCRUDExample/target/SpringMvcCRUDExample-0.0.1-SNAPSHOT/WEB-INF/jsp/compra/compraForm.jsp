<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprar</title>
</head>
<body>
	<spring:url value="/compra/save" var="saveURL" />
	<form:form modelAttribute="formCompra" method="post"
		action="${saveURL }">
		<table>
			<tr>
				<td>Comprador</td>
				<form:hidden path="id"/>
				<td>${userMap }					
				</td>
			</tr>
			<tr>
				<td>Auto</td>
				<td><form:select path="idAuto" items="${autoMap }"/></td>
			</tr>
			<tr>
				<td>Pago inicial</td>
				<td><form:input path="paInicial" /></td>
			</tr>
			<tr>
				<td>Restante</td>
				<td><form:input path="rest" disabled="true"/></td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td><form:input path="fecha" /></td>
			</tr>
			<tr>
				<td>Aceptar</td>
				<td><button type="submit"></button>Guardar</td>
			</tr>
		</table>
	</form:form>
</body>
</html>