<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	1:${fn:escapeXml("<b>表示粗字体 </b>") } <br>
	2:<c:out value="<b>表示粗字体</b>" escapeXml="true" /> <br>
	3:${"<b>表示粗字体</b>"}
	
</body>
</html>