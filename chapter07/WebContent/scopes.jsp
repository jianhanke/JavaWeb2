<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%pageContext.setAttribute("userName","itcast"); %>
	
	<%session.setAttribute("userName","itheima"); %>
	<%application.setAttribute("bookName","Java基础"); %>
	
	表达式\${pageScope.userName}的值为:${pageScope.userName }  <Br>
	表达式\${requestScope.bookName}的值为:${requestScope.bookName }   <br>
	表达式\${sessionScope.userName }的值为:${pageScope.userName } ${userName }<br>
	表达式\${applicationScope.bookName }的值为:${applicationScope.bookName} <br>
	<hr />
	
	${pageContext.request } <br />
	${requestScope } <br /> 
	<%=request %> <br />
	
	<%=pageContext.getRequest().getAttribute("bookName") %>

</body>
</html>