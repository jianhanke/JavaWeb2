<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.itcast.chapter05.listener.MyBean"
    %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%  session.setAttribute("myBean",new MyBean()); %>
	
</body>
</html>