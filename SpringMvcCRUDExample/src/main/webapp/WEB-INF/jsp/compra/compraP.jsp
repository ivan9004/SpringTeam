<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Compras</h1>

	<table width="100%" border="1">
		<tr>
			<th>ID</th>
			<th>ID Auto</th>
			<th>Pago inicial</th>
			<th>Retante</th>
			<th>Fecha</th>
		</tr>
		<c:forEach items="${listCompra }" var="compra">
			<tr>
				<td>${compra.id }</td>
				<td>${compra.idAuto }</td>
				<td>${compra.paInicial }</td>
				<td>${compra.rest }</td>
				<td>${compra.fecha }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>