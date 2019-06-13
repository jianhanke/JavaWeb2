<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="itcast" uri="http://www.itcast.cn" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="choose_when_otherwise.jsp">
		<input type="radio" name="hobby" value="badminton" />羽毛球
		<input type="radio" name="hobby" value="score" />足球
		<input type="radio" name="hobby" value="basketball" />篮球
		<input type="radio" name="hobby" value="others" />替他<br  />
		<input type="submit" value="提交">
	</form>
</body>
</html>