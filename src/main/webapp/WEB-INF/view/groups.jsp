<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Groups</title>
	</head> 
	<body>
		<h1>Groups:</h1>
		<c:if test="${!empty listGroup}">
    <table class="tg">
    <tr>
        <th width="100">Groupid</th>
        <th width="100">Name</th>
        <th width="100">Description</th>
        <th width="100">Accesslevel</th>
    </tr>
    <c:forEach items="${listGroup}" var="user">
        <tr>
            <td>${group.groupId}</td>
            <td>${group.name}</td>
            <td>${group.description}</td>
            <td>${group.accesslevel}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>