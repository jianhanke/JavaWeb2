<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		String [] fruits={"apple","orang","grape","banana"};
	%>
String 数组的元素:
<c:forEach var="name" items="<%=fruits%>" >
	${pageScope.name }
</c:forEach>
</body>
</html>