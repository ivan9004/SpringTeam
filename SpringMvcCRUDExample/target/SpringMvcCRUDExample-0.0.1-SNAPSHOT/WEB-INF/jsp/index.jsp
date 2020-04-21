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
	<h1>Pagina de inicio</h1>

	<spring:url value="/user/list" var="listURL" />
	<a href="${listURL }">Ir a usuarios</a>
	<div>
	
	<spring:url value="/report" var="reportLink" />

		<a href="${reportLink}">Ver compras en formato PDF</a> <br /> <a
			href="${reportLink}?format=xls">Ver compras en XLS</a><br /> <a
			href="${reportLink}?format=csv">Ver compras en CSV</a><br />

	</div>

</body>
</html>