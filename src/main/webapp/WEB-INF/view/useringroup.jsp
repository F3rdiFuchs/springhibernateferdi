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
    <table class="tg">
    <tr>
        <th width="100">Userid</th>
        <th width="100">Username</th>
        <th width="100">Name</th>
        <th width="100">Last name</th>
        <th width="100">Email</th>
        <th width="100">Password</th>
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