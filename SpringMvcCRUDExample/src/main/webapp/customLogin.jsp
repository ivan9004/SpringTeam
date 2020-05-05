<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<link href="<c:url value="/resources/CSS/estilos.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/JS/jquery-3.5.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/main.js"/>"></script>
</head>
<body>
	<header>
		<a href="">Viajes</a> <a href="">Transporte</a> <a href="">Sistems</a>
	</header>
	<div id="datos">
		<div id="imagenL">
			<img class="imagenLogo" alt="Huejutla"
				src="<c:url value="/resources/img/autobus_coronavirus.jpg"/>">
		</div>
		<div id="empresa">Grupo Huejutla Tlaxcala</div>
	</div>

	<div id="id01" class="modal">
		<font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>

		<form class="modal-content animate"
			action="<%=request.getContextPath()%>/appLogin" method="POST">

			<div class="imgcontainer">
				<img src="<c:url value="/resources/img/feliz.jpg"/>"
					alt="Grupo Huejutla" class="avatar">
			</div>
			<div class="container">
				<label for="app_username"><b>Usuario</b></label> <input type="text"
					name="app_username" placeholder="Colocar un usuario"
					required="required" /><br /> <br /> <label for="app_password"><b>Contraseña</b></label>
				<input type="password" name="app_password"
					placeholder="Colocar un passwrd" required="required" /> <br /> <br />
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<input type="submit" value="Iniciar" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancelar</button>
			</div>
		</form>
	</div>

	<button onclick="document.getElementById('id01').style.display='block'"
		style="width: auto;">Entrar</button>

	<footer> Empresas de transport Grupo huejutla todos los
		derechos recerbados </footer>
<body>
</html>
