<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>User in Group</title>
	</head> 
	<body>
		<h1>Userlist:</h1>
		<c:if test="${!empty listUserById}">
    <table border = "1" class="tg">
    <tr>
        <td>Userid</td>
        <td>Username</td>
        <td>Name</td>
        <td>Last name</td>
        <td>Email</td>
        <td>Password</td>
    </tr>
    <c:forEach items="${listUserById}" var="userByG">
        <tr>
            <td>${userByG.userId}</td>
            <td>${userByG.userName}</td>
            <td>${userByG.name}</td>
            <td>${userByG.lastName}</td>
            <td>${userByG.eMail}</td>
            <td>${userByG.passWord}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<br><a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>