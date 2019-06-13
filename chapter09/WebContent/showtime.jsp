<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.itcast.chapter09.classistag.User"
    %>
<%@ taglib prefix="itcast" uri="/simpleTag" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		User user=new User();
		user.setName("Conca");
		session.setAttribute("user",user);
	%>
	<itcast:showtime user="${sessionScope.user }" /> <br />
</body>
</html>