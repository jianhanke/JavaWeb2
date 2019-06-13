<%@ page language="java" contentType="text/html; 
charset=utf-8" pageEncoding="utf-8"
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  session.setAttribute("name", "ceshi");     %>
	
		session的值为:${sessionScope.name } <br />
		

	
</body>
</html>