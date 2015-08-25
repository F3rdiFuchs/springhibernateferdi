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
		<c:if test="${!empty listTasks}">
    <table border="1" class="tg">
    <tr>
        <td>Taskid</td>
        <td>Description</td>
        <td>Start</td>
        <td>End</td>
        <td>Status</td>
    </tr>
    <c:forEach items="${listTasks}" var="tasks">
        <tr>
            <td>${tasks.taskId}</td>
            <td>${tasks.description}</td>
            <td>${tasks.start}</td>
            <td>${tasks.end}</td>
            <td>${tasks.status}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>

	</body>
</html>