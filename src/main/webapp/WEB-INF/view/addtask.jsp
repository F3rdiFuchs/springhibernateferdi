<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>addtask</title>
	</head> 
	<body>
		<h1>Add new task::</h1>
		<form method="POST">
			<table border ="1">
				<tr>
					<td>Description</td>
				  	<td><textarea type="text" rows ="5" name="description"></textarea></td>
				  	<td></td>
				</tr>
				
				<tr>
					  <td>Start:</td>
					  <td><input type="text" name="start" /></td>
					  <td></td>
				</tr>
				
				<tr>
					  <td>End</td>
					  <td><input type="text" name="end" /></td>
					  <td></td>
				</tr>
				<tr>
					  <td>User:</td>
					  <td>
						  <form:select multiple="true" path="user" required="false" name="user">
						  	<form:options items="${user.userName} }" itemsValue=""> </form:options>
						  </form:select>  	
					  </td>
					  <td></td>
				</tr>
				
				<tr>
				  	  <td><input type="submit" value="save task" /></td>
				  	  <td></td>
				  	  <td></td>
				</tr>
				
			</table>
		</form>
		
		<br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>