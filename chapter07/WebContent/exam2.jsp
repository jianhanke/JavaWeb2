<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="itcast" uri="http://www.itcast.cn" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
 	<br >
	text1 ${itcast:reverse(requestScope.text1) } <br />
	text2  ${itcast:reverse(requestScope.text2)} <br>
	
</body>
</html>