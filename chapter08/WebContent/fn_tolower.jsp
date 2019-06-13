<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	fn:toLowerCase 函数将字符串ITCAST转化为小写 <br />
	${fn:toLowerCase("ITCAST") } <br />
	
	fn:toUppderCase函数将字符串itcast转化为大写 <br />
	${fn:toUpperCase("itcast") } <br />
	
</body>	
</html>