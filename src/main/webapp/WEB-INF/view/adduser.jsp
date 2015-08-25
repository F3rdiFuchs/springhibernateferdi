<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>adduser</title>
	</head> 
	<body>
		<h1>Add user:</h1>
		<form:form method="POST">
		<table>
		<tr>
			<td>Username:</td>
		  	<td><input type="text" id="userName" name="userName"></td>
		  	<td><form:errors path="userName"/></td>
		</tr>
		<tr>
		  <td>Name:</td>
		  <td><input type="text" id="name" name="name" /></td>
		  <td></td>
		</tr>
		<tr>
		  <td>Last name:</td>
		  <td><input type="text" id="lastName" name="lastName" /></td>
		  <td></td>
		</rt>
		<tr>
		  <td>E-Mail:</td>
		  <td><input type="text" id="eMail" name="eMail" /></td>
		  <td></td>
		</tr>
		<tr>
		<tr>
		  <td>Passoword:</td>
		  <td><input type="password" id="passWord" name="passWord" /></td>
		  <td></td>
		</tr>
		<tr>
		  <td>Userid</td>
		  <td>Will be set by the administrator later...</td>
		  <td></td>
		</tr>
		  <td><input type="submit" value="save" /></td>
		</tr>
		</table>
		</form><br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>