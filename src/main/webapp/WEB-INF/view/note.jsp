<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>All notes:</title>
	</head> 
	<body>
		<h1>All notes:</h1>
		<c:if test="${!empty listNote}">
	    <table border="1"class="tg">
	    <tr>
	        <td>User:</td>
	        <td>Category:</td>
	        <td>Note:</td>
	        <td>Date:</td>
	        <td>File:</td>
	    </tr>
	    <c:forEach items="${listNote}" var="note">
	        <tr>
	            <td>${note.user}</td>
	            <td>${note.category}</td>
	            <td>${note.note}</td>
	            <td>${note.date}</td>
	            <td>${note.files}</td>
	        </tr>
	    </c:forEach>
    </table>
</c:if>
<br><br><a href="http://localhost:8080/springhibernateferdi">back</a>
	<br><a href="http://localhost:8080/springhibernateferdi/newnote">new note</a>
</body>
</html>