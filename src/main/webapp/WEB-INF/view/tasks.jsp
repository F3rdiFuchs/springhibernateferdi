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
		<c:if test="${!empty tasksList}">
		    <table border="1" class="tg">
		    <tr>
		        <td>Taskid</td>
		        <td>Description</td>
		        <td>Start</td>
		        <td>End</td>
		        <td>Employee</td>
		        <td>Status</td>
		        <td></td>
		    </tr>
    <c:forEach items="${tasksList}" var="tasks">
        <tr>
            <td>${tasks.taskId}</td>
            <td>${tasks.description}</td>
            <td>${tasks.start}</td>
            <td>${tasks.end}</td>
            <td>${tasks.user}</td>
            <td>${tasks.status}</td>
            <td><c:if test="${tasks.status ==false}"><input type="submit" value="completed" /></c:if></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a><br><a href="http://localhost:8080/springhibernateferdi/tasks/add">add new task</a>

	</body>
</html>