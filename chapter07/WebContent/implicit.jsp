<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	之前的:${pageContext } <br>
	<%session.setAttribute("pageContext","itcast"); %>
	输出表达式pageContext的值:${sessionScope.pageContext} <br>
	
	<% request.setAttribute("ceshi","info"); %>
	${ceshi } <br>
	
</body>
</html>