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
		<form method="POST">
		<div>
		  <label for="absender">Username:</label>
		  <input type="text" id="userName" name="userName" />
		</div>
		<div>
		  <label for="absender">Name:</label>
		  <input type="text" id="name" name="name" />
		</div>
		<div>
		  <label for="absender">Last name:</label>
		  <input type="text" id="lastName" name="lastName" />
		</div>
		<div>
		  <label for="absender">E-Mail::</label>
		  <input type="text" id="eMail" name="eMail" />
		</div>
		<div>
		<div>
		  <label for="absender">Passoword:</label>
		  <input type="password" id="passWord" name="passWord" />
		</div>
		<div>
		  <label for="absender">Userid</label>
		  <label for="absender">Will be set by the administrator later...</label>
		</div>
		  <input type="submit" value="save" />
		</div>
		</form><br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>