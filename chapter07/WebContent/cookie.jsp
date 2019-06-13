<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<% response.addCookie(new Cookie("userName","itcast")); %>
	Cookie对象的信息: ${cookie.userName} <br>
	Cookie对象的名称和值: ${cookie.userName.name }=${cookie.userName.value}
	
</body>
</html>