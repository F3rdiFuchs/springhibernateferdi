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
		<form modelAttribute="employee" method="POST">
		<div>
		  <label for="absender">Username:</label>
		  <input type="text" id="username" name="username" />
		</div>
		<div>
		  <label for="absender">Name:</label>
		  <input type="text" id="name" name="name" />
		</div>
		<div>
		  <label for="absender">Last name:</label>
		  <input type="text" id="lastname" name="lastname" />
		</div>
		<div>
		  <label for="absender">Name:</label>
		  <input type="text" id="name" name="name" />
		</div>
		<div>
		  <label for="absender">E-Mail::</label>
		  <input type="text" id="email" name="email" />
		</div>
		<div>
		<div>
		  <label for="absender">Passoword:</label>
		  <input type="password" id="password" name="password" />
		</div>
		<div>
		  <label for="absender">Retype passoword:</label>
		  <input type="password" id="password" name="password" />
		</div>
		  <input type="submit" value="save" />
		</div>
		</form>
	</body>
</html>