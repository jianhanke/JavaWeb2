<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	fn:containsIgnoreCase("www.itcast.cn","it")返回值为:
	${fn:containsIgnoreCase("www.itcast.cn","it")} <br>
	
	fn:containsIgnoreCase("www.itcast.cn","IT")返回值为:
	${fn:containsIgnoreCase("www.itcast.cn","IT")} <br>
	
</body>
</html>