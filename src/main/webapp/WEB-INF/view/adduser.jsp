<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>adduser</title>
	</head> 
	<body>
		<h1>Add user:</h1>
		<form method="POST">
			<table border = "1">
				<tr>
					<td>Username:</td>
				  	<td><input type="text" name="userName"/></td>
				  	<td><form:errors path="userName" /></td>
				</tr>
				<tr>
					  <td>Name:</td>
					  <td><input type="text" name="name" /></td>
					  <td><form:errors path="name" /></td>
				</tr>
				<tr>
					  <td>Last name:</td>
					  <td><input type="text" name="lastName" /></td>
					  <td><form:errors path="lastName" /></td>
				</tr>
				<tr>
					  <td>E-Mail:</td>
					  <td><input type="text" name="eMail" /></td>
					  <td><form:errors path="eMail"/></td>
				</tr>
				<tr>
				<tr>
					  <td>Password:</td>
					  <td><input type="password" name="passWord" /></td>
					  <td><form:errors path="passWord"/></td>
				</tr>
				<tr>
					  <td>Userid</td>
					  <td>Will be set by the administrator later...</td>
					  <td></td>
				</tr>
				
				<tr>
				  	  <td><input type="submit" value="save" /></td>
				  	  <td></td>
				  	  <td></td>
				</tr>
			</table>
		</form>
		
		<br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>