<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	fn:contains("www.itcast.cn","it")返回值:
	${fn:contains("www.itcast.cn","it") } <br>
	
	fn:contains("www.itcast.cn","IT")返回值
	${fn:contains("www.itcast.cn","IT") } <br>
	
	fn:contains("www.itcast.cn","")返回值
	${fn:contains("www.itcast.cn","") } <br>
</body>
</html>