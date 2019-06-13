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
	fn:startsWith("www.itcast.cn","www")返回值为:
	${fn:startsWith("www.itcast.cn","www") }<br>
	
	fn:startsWith("welcome","www")返回值为:
	${fn:startsWith("welcome","www") }<br>

	fn:endsWith("www.itcast.cn","cn")返回值为:
	${fn:endsWith("www.itcast.cn","cn") }<br>
	
	fn:endsWith("welcome","cn")返回值为:
	${fn:endsWith("welcome","cn") }<br>
		
	
	
</body>
</html>