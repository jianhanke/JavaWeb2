<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	request里的属性:<%=request.getAttribute("username") %>
	${requestScope.username }
	${param.num }
	${paramValues.nums[0] }
	<br>-------分界线-------<br>
	<% request.setAttribute("name","jianhanke"); %><br>
	EL获取name值: ${requestScope.name}<br>
	${name}
	
</body>
</html>