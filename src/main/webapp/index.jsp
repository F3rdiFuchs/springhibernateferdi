<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Userlist</title>
		<style>
		#login-box {
			width: 300px;
			padding: 20px;
			margin: 100px auto;
			background: #fff;
			-webkit-border-radius: 2px;
			-moz-border-radius: 2px;
			border: 1px solid #000;
		}
	</style>
	</head> 
	<body>
		<div id="login-box">
			<h3>Login with Username and Password</h3>

		<form name="loginForm" method="POST">

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='userName'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='passWord' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>
		
		 <a href="http://localhost:8080/springhibernateferdi/users">Userlist</a>
		 <a href="http://localhost:8080/springhibernateferdi/groups">Groups</a>
		 <a href="http://localhost:8080/springhibernateferdi/tasks">Tasks</a>
		 <a href="http://localhost:8080/springhibernateferdi/cars">Cars</a>
		 <a href="http://localhost:8080/springhibernateferdi/message">Messages</a>
		 <a href="http://localhost:8080/springhibernateferdi/note">Notes</a>
	</body>
</html>
