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
	<%
		String username=request.getParameter("username");

		String country=request.getParameter("country");
	
	%>
	UserName=<%=username %> <br />
	country=<%=country %> <br />
	
	Param_Username=${Param.username } <br>
	Param_Country=${Param.country } <br>
	
	
</body>
</html>