<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}css/styles.css" />
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Gestor Tareas</span>
			<span class="navbar-brand mb-0 h3">Usuario logeado: ${sessionScope.usuarioLogeado.nombre}</span>
			<span class="navbar-brand mb-0 h3"><a class="text-decoration-none text-white" href="SalirController">Salir</a></span>
		</div>
	</nav>
	
	<h1>Listado de Tareas</h1>

	
	
	
    
	<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Código</th>
			<th scope="col">Nombre</th>
			<th scope="col">Responsable</th>
			<th scope="col">Estado</th>
			<th scope="col">Acción</th>
		</tr>
	</thead>
	
			
	
			<c:forEach items="${tareas}" var="tarea">
			<tr>
				<td scope="row">${tarea.codigo}</td>
				<td>${tarea.nombre}</td>
				<td>${tarea.responsable.nombre}</td>
				<td>${tarea.estadoTarea.texto}</td>
				<td><a href="CambiarEstadoController?idtarea=${tarea.codigo}">Cambiar Estado</a>
			</tr>
			</c:forEach>
            

	</table>
</body>
</html>