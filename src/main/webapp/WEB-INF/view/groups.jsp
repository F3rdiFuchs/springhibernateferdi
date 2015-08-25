<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Groups</title>
	</head> 
	<body>
		<c:if test="${!empty listGroups}">
	    <table border="1"class="tg">
	    <tr>
	        <td>Groupid</t>
	        <td>Name</td>
	        <td>Description</td>
	        <td>Accesslevel</td>
	    </tr>
	    <c:forEach items="${listGroups}" var="groups">
	        <tr>
	            <td><a href="http://localhost:8080/springhibernateferdi/groups/${groups.groupId}">${groups.groupId}</a></td>
	            <td>${groups.name}</td>
	            <td>${groups.description}</td>
	            <td>${groups.accessLevel}</td>
	        </tr>
	    </c:forEach>
    </table>
</c:if>
<br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
</body>
</html>