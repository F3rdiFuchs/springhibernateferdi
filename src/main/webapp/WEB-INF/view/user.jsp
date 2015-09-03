<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h1>Userlist:</h1>
		<c:if test="${!empty listUser}">
    <table border ="1" class="tg">
    <tr>
        <td>Userid</td>
        <td>Username</td>
        <td>Name</td>
        <td>Last name</td>
        <td>Email</td>
        <td>Password</td>
        <td></td>
    </tr>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.eMail}</td>
            <td>${user.passWord}</td>
            <td><a href="http://localhost:8080/springhibernateferdi/delete/${user.userId}">delete*</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>
<br><a href="http://localhost:8080/springhibernateferdi/new">new user</a><br>* user and his messages 

	</body>
</html>