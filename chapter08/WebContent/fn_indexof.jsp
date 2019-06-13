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
	fn:indexOf("www.itcastit.cn","it")返回值为:
	${fn:indexOf("www.itcastit.cn","it")} <br>
	
	fn:indexOf("www.itcastit.cn","aaa")返回值为:
	${fn:indexOf("www.itcastit.cn","aaa")}<br>
	
	fn:indexOf("www.itcastit.cn","")返回值为:
	${fn:indexOf("www.itcastit.cn","")}<br>
</body>
</html>