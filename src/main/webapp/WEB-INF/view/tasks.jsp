<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Tasks</title>
	</head> 
	<body>
		<h1>Tasklist:</h1>
		<c:if test="${!empty listTask}">
    <table class="tg">
    <tr>
        <th width="100">Taskid</th>
        <th width="100">Description</th>
        <th width="100">Start</th>
        <th width="100">End</th>
        <th width="100">Status</th>
    </tr>
    <c:forEach items="${listTask}" var="tasks">
        <tr>
            <td>${tasks.taskid}</td>
            <td>${tasks.description}</td>
            <td>${tasks.start}</td>
            <td>${tasks.end}</td>
            <td>${tasks.status}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>
<br><a href="http://localhost:8080/springhibernateferdi/new">new user</a>

	</body>
</html>