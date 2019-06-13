<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set value="1" var="visitCount1" property="visitCount1" />
	
	${pageScope.visitCount1 }

	
	<c:if test="${visitCount1==1 }"  var="visitCount2" >
		This is you first visit.
	</c:if>
	
	${pageScope.visitCount1 } ${pageScope.visitCount2
	
	 }
	
	
	
</body>
</html>