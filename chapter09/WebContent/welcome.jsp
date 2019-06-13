<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="itcast" uri="/simpleTag" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		String username=request.getParameter("username");
		if(username!=null){
			session.setAttribute("user",username);
		}
	%>
	
	欢迎光临本站
	<itcast:welcome>
		亲,您的昵称为:${sessionScope.user}
	</itcast:welcome>
	
</body>
</html>