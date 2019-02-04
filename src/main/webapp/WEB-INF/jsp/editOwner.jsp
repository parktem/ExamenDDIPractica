<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietario editado</title>
</head>
<body>

<form:form action="/saveEditOwner" method="post" modelAttribute="owner">
		<span>ID:</span><form:input type="hidden" name="codOwner" path="codOwner"/>
		<span>Nombre:</span><form:input type="text" name="name" path="name"/>
		<span>Apellidos:</span><form:input type="text" name="surname" path="surname"/>
		<input type="submit">
	</form:form>
	
</body>
</html>