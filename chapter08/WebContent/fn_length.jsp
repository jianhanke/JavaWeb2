<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int[] array={1,2,3,4};
		List list=new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
	%>
<c:set value="<%=array %>" var="array" /> <br>
<c:set value="<%=list %>" var="list" /> <br>
fn:length函数获取数组,集合中元素的个数以及字符串长度
数组元素的个数: ${fn:length(array) } <br>
集合中元素的个数: ${fn:length(list) } <br>
字符串长度: ${fn:length("Tomcat") } <br>

</body>
</html>