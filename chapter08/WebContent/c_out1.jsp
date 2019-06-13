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
	第一个out标签，不带标签体   
	<c:out value="${param.username }" default="unknown" /><br />
	第二个out标签,标签体
	<c:out value="${param.username }" >
	unkonw
	</c:out>
</body>
</html>