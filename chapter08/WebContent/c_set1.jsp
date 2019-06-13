<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	session域中的userName属性,用属性values
	<c:set var="userName" value="itcast" scope="session" />
	<c:out value="${userName } "  />
	<br />
	Session域中的bookName属性, 用标签体设置
	<c:set var="bookName" scope="session">
		JavaWeb基础知识
	</c:set>
	<c:out value="${bookName }"  />
</body>
</html>