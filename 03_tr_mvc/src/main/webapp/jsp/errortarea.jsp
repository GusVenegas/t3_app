<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Tarea</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css" />
</head>
<body>

    <nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Gestor Tareas</span>
			
		</div>
	</nav>

<div class="text-center">
		<h1 class="fs-1 text-secondary">Algo fue mal!!</h1>
		<p class="fs-4 text-danger"> El código <c:out value="${codigoTarea}"/> está en uso intenta con otro código<p>
		
		<a href="CrearTareaController">Regresar</a>
	</div>
	
</body>
</html>