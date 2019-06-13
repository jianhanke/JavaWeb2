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
	使用"|",和","作为分隔符
	<c:forTokens var="token" items="String,Summer,autumn|winter" delims="|,">
		${token}
	</c:forTokens>
	<br>
	使用"--"作为分隔符
	<c:forTokens var="token" items="Day--week--Month--Year" delims="--">
		${token }
	</c:forTokens>
</body>
</html>