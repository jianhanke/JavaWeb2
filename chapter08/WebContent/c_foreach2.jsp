<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		Map userMap=new HashMap();
		userMap.put("Tom","123");
		userMap.put("Meke","123");
		userMap.put("Lina","123");
	%>
	HashMap集合中的元素:<br>
	<c:forEach var="entry" items="<%=userMap %>">
		${entry.key }:${entry.value} <br />
	</c:forEach>
	
</body>
</html>