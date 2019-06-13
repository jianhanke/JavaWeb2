<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.username=='itcast' }" >
			unKonw user
		</c:when>
		<c:when test="${param.username=='itcast'}"  >
			${param.username} is Manager
		</c:when>
		<c:otherwise>
			${param.username } is employee
		</c:otherwise>
		
	</c:choose>
</body>
</html>