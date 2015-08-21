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
		<c:if test="${!empty listGroups}">
    <table class="tg">
    <tr>
        <th width="100">Groupid</th>
        <th width="100">Name</th>
        <th width="100">Description</th>
        <th width="100">Accesslevel</th>
    </tr>
    <c:forEach items="${listGroups}" var="group">
        <tr>
            <td>${groups.groupId}</td>
            <td>${groups.name}</td>
            <td>${groups.description}</td>
            <td>${groups.accesslevel}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>
	</body>
</html>