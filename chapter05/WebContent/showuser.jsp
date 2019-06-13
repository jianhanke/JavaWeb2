<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.user==null }" >
			<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
		</c:when>
		<c:otherwise>
			欢迎你, ${sessionScope.user.username }!
			<a href="${pageContext.request.contextPath}/LogoutServlet">退出</a>
		</c:otherwise>
	</c:choose>
	<hr/>
	在线用户列表
	<c:forEach var="user" items="${requestScope.users }" >
		${user.value.username } 
	</c:forEach>
</body>
</html>