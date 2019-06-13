<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="cn.itcast.chapter05.listener.MyBean2"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>向Session域中写入入数据</h1>
	<%
		MyBean2 myBean2=new MyBean2();
			myBean2.setName("Tom");
			myBean2.setAge(20);
			session.setAttribute("myBean2",myBean2);
	%>

</body>
</html>