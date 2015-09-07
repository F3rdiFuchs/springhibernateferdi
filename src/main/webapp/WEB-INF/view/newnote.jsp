<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Upload</title>
	</head> 
	<body>
		<h1>Upload:</h1>
		<form:form method="POST" enctype="multipart/form-data" action="newnote">
			<table border ="1">
				
				<tr>
					  <td>User:</td>
					  <td><select name="user" id="user">
							   	<c:forEach items="${listUser}" var="user">
							   		<option value = "${user.userId}">${user.userName}</option>
							   	</c:forEach>
						   </select>
					</td>
					<td></td>
				</tr>
				
				<tr>
					  <td>Category:</td>
					  <td><select name="category" id="category">
							   	<c:forEach items="${listCategory}" var="category">
							   		<option value = "${category.categoryId}">${category.categoryId}</option>
							   	</c:forEach>
						   </select>
					</td>
					<td></td>
				</tr>
				
				<tr>
					<td>Note:</td>
				  	<td><textarea rows ="4" name="note"></textarea></td>
				  	<td></td>
				</tr>
				
				<tr>
					<td>Documents:</td>
				  	<td><input type="file" id="fileUpload" name="fileUpload" multiple></td>
				  	<td></td>
				</tr>
				
				<tr>
				  	  <td><input type="submit" value="save note" /></td>
				  	  <td></td>
				  	  <td></td>
				</tr>
				
			</table>
		</form:form>
		
		<br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>