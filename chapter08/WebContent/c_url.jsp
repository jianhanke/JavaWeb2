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
使用绝对路径构造   
	<c:url var="myURL" value="http://localhost:8080/chapter8080/chapter08/register.jsp" >
		<c:param name="username" value="张三" />
		<c:param name="country" value="中国" />
	</c:url>
	<a href="${myURL }">register.jsp</a> <br />
使用相对路径
	<c:url var="myURL" value="register.jsp?username=Tom&country=France" />
	<a href="${myURL }">register.jsp</a> <br />
	<a href="${myURL }">测试</a> <br />
	<a href="${myURL }">测试22</a> <br />
	<a href="${myURL }">register.jsp</a> <br />
</body>
</html>