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
	使用fn:split函数将"welcome to china" 字符串进行分割:<br>
	<c:set value='${fn:split("welcome to china"," ")}' var="strs" />
	
	<c:forEach var="token" items="${strs}">
		${token } <br>
	</c:forEach>
	
</body>
</html>