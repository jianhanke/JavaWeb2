<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	fn:substring("welcome to itcast!",3,9)返回的结果为:
	${fn:substring("welcome to itcast!",3,9) } <br>
	
	fn:substringBefore("mydata.txt",".")返回的结果为:
	${fn:substringBefore("mydata.txt",".") } <br>
	
	fn:substringAfter("mydata.txt",".")返回的结果为:
	${fn:substringAfter("mydata.txt",".") } <br>
	
	<% 
		int i=1;
	%>
	<c:set value="<%=i %>" var="i" />
	<c:out value="${i }" />
	
	
</body>
</html>