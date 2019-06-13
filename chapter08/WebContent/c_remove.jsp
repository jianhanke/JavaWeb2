<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
f
	<c:set scope="request" var="company" value="传播智课" />
	<c:set scope="request" var="url" value="www.itcast.cn" />
	Company:<c:out  value="${requestScope.company}" /> <br />
	Url:<c:out  value="${url}" />        <br />
	使用移出标签后 :<br />
	<c:remove scope="request" var="company" />
	<c:remove scope="request" var="url" />
	Company:<c:out  value="${company}" /> <br />
	Url:<c:out  value="${requestScope.url}" />        <br />
	 
</body>
</html>