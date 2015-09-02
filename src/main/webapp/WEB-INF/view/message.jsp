<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Messages</title>
	</head> 
	<body>
		<h1>Messages:</h1>
			<c:if test="${!empty listMessage}">
    			<table border ="1" class="tg">
    				<tr>
        				<td></td>
    				</tr>
    			<c:forEach items="${listMessage}" var="message">
			        <tr>
			            <td></td>
			        </tr>
    			</c:forEach>
    		</table>
		</c:if>
<a href="http://localhost:8080/springhibernateferdi">back</a>
<br>

	</body>
</html>