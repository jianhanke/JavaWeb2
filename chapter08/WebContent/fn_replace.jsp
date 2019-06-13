<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	fn:replace("www.itcast.cn",".","-")的替代结果为:
	${fn:replace("www.itcast.cn",".","-") } <br>
	
	fn:replace("2018/11/28","/","-")的替代结果为:
	${fn:replace("2018/11/28","/","-") } <br>
	
</body>
</html>