<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	10以内的奇数
	<c:forEach var="i"  begin="1" end="10" step="2">
		${i } <br>
	</c:forEach>
</body>
</html>