<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="itcast" uri="http://www.itcast.cn" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<itcast:choose>
		<itcast:when test="${param.hoby=='badminton' }">
				你的爱好是羽毛球
		</itcast:when>
		<itcast:when test="${param.hobby=='football' }">
			你的爱好是足球
		</itcast:when>
		<itcast:when test="${param.hobby=='baskedball' }">
			你的爱好是篮球
		</itcast:when>
		<itcast:otherwise>
			要加强体育锻炼
		</itcast:otherwise>
		
	</itcast:choose>
</body>
</html>