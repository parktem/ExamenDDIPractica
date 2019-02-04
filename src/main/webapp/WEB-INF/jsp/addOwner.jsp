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
	<form:form action="addOwner" method="post" modelAttribute="owner">
		<span>Nombre:</span><form:input type="text" name="name" path="name"/>
		<span>Apellidos:</span><form:input type="text" name="surname" path="surname"/>
		<input type="submit">
	</form:form>
	<table>
	<tbody>
		<c:forEach var="owner1" items="${selectAllOwners}" >
			<tr>
				<td><c:out value="${owner1.codOwner}"/> </td>
				<td><c:out value="${owner1.name}"/> </td>
				<td><c:out value="${owner1.surname}"/> </td>
				<td><a href="/editOwner?codOwner=${owner1.codOwner}">EDIT</a> </td>
				<td><a href="/deleteOwner?codOwner=${owner1.codOwner}">DELETE</a> </td>
				<td><a href="/addPet?codOwner=${owner1.codOwner}">ADD PET</a> </td>
				<td>
	    			<c:forEach var="pet" items="${owner1.pets}">
	    				<c:out value="${pet.name} "/>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>