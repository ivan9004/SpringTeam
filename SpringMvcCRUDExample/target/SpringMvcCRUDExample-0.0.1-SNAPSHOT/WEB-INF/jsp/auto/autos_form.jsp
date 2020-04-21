<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url value="/auto/save" var="saveURL" />
	<form:form modelAttribute="autosForm" method="post" action="${saveURL }">
		<form:hidden path="idAuto" />
		<table>
			<tr>
				<td>Precio</td>
				<td><form:input path="precio" /></td>
			</tr>
			<tr>
				<td>Nombre del auto</td>
				<td><form:input path="nombreAuto" /></td>
			</tr>
			<tr>
				<td>Modelo</td>
				<td><form:input path="modelo" /></td>
			</tr>
			<tr>
				<td>Puertas</td>
				<td><form:input path="puertas" /></td>
			</tr>
			<tr>
				<td>Aceptar</td>
				<td><button type="submit"></button>Guardar</td>
			</tr>
		</table>
	</form:form>
</body>
</html>