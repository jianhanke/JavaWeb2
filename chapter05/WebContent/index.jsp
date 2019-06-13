<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3>
		当前在线人数为:
			<%=application.getAttribute("count") %>
	</h3>
	<a href="<%=response.encodeUrl("logout.jsp")%> ">退出登录</a>
	测试session的值 ${sessionScope.name }
</body>
</html>