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
		List colorList=new ArrayList();
	colorList.add("red");
	colorList.add("yellow");
	colorList.add("blue");
	colorList.add("green");
	colorList.add("black");		
	%>
	
	<c:forEach var="color" items="<%=colorList %>" begin="1" end="3" step="2" >
		${color } <br />
	</c:forEach>
</body>
</html>