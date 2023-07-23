<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Tarea</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>


	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Gestor Tareas</span>
			<span class="navbar-brand mb-0 h3">Usuario logeado: ${sessionScope.usuarioLogeado.nombre}</span>
			<span class="navbar-brand mb-0 h3"><a class="text-decoration-none text-white" href="../SalirController">Salir</a></span>
		</div>
	</nav>


	<div class="wrapper">
	<div><a href="../TareaController"> Ir a Menú Principal</a></div>
		

		<h1>Insertar Tarea</h1>
		<form method="POST" action="../CrearTareaController">
			<label for="txtCod">Código</label> <br>
			<input type="text" name="txtCod" id="txtCod" /> <br>
			
			<label for="txtNombre">Nombre</label> <br>
			<input type="text" name="txtNombre" id="txtNombre" /><br>			
			 
			<br><br> 
			<input type="submit" value="Insertar"> 
		</form>


	</div>
</body>
</html>