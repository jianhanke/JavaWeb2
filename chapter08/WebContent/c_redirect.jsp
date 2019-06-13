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
	<c:url var="myURL" value="register.jsp">
		<c:param name="username" value="张三" />
		<c:param name="country" value="中国" />
	</c:url>
	<c:redirect url="${myURL }" />
</body>
</html>