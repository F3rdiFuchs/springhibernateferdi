<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>adduser</title>
	</head> 
	<body>
		<h1>Add user:</h1>
		<springForm:form method="POST" commandName="adduser">
			<table>
				<tr>
					<td>Username:</td>
				  	<td><input type="text" name="userName"/></td>
				  	<td><springForm:errors path="userName" /></td>
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
					  <td>Password:</td>
					  <td><input type="password" id="passWord" name="passWord" /></td>
					  <td></td>
				</tr>
				<tr>
					  <td>Userid</td>
					  <td>Will be set by the administrator later...</td>
					  <td></td>
				</tr>
				  	  <td><input type="submit" value="save" /></td>
				  	  <td></td>
				  	  <td></td>
				</tr>
			</table>
		</springForm:form>
		
		<br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>