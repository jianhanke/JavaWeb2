<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="ResultServlet" method="post">
		用户名:<input type="text" name="username"><br>
		留言: <textarea rows="6" cols="50" name="message"></textarea> <br>
		<input type="submit" value="提交">
		 
	</form>
</body>
</html>