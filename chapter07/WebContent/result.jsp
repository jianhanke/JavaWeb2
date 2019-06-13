<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="itcast" uri="http://www.itcast.cn" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	用户名${name }
	留言内容${itcast:filter2(message) }
	
</body>
</html>