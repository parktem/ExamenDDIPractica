<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo alumno</title>
</head>
<body>


	<form:form action="addPet" method="post" modelAttribute="pet">
		<span></span><form:input type="hidden" name="codOwner" path="codOwner"/>
		<span>Nombre:</span><form:input type="text" name="name" path="name"/>
		<input type="submit">
	</form:form>
</body>
</html>