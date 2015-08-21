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
    <table class="tg">
    <tr>
        <th width="100">Userid</th>
        <th width="100">Username</th>
        <th width="100">Name</th>
        <th width="100">Last name</th>
        <th width="100">Email</th>
        <th width="100">Password</th>
        <th width="100">Groupid</th>
    </tr>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.eMail}</td>
            <td>${user.passWord}</td>
            <td>${user.groupId}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>