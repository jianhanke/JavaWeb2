<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.itcast.chapter05.listener.MyBean2"
    %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>从Session域中读取数据</h1>
		姓名:${sessionScope.myBean2.name }
		年龄:${sessionScope.myBean2.age }
</body>
</html>