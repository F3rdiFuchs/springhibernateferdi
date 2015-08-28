<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>addtask</title>
	</head> 
	<body>
		<h1>Add new task::</h1>
		<form method="POST">
			<table>
				<tr>
					<td>Description</td>
				  	<td><input type="text" name="description"/></td>
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
					  <td><select name="user" ><option>F3rdiFuchs</option></select></td>
					  <td><input type="submit" value="add user" /></td>
				</tr>
				<tr>
					  <td>User in list</td>
					  <td></td>
					  <td></td>
				</tr>
	
				<tr>
					  <td></td>
					  <td></td>
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