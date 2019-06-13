<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
		<form action="${pageContext.request.contextPath}/param.jsp">
			num1:<input type="text" name="num1"><br>
			num2:<input type="text" name="num"><br>
			num3:<input type="text" name="num"><br>
			<input type="submit" value="提交">
			<input type="reset" value="重置"><br >
			num1:${param.num1} ${paramValues.num1[0] } <br>
			num2:${paramValues.num[0]} ${param.num} <br>
			num3:${paramValues.num[1]} ${param.num} <br>
			
		
		</form>
</body>
</html>