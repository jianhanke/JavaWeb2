<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="cn.itcast.chapter08.entity.User" />
	<c:set value="jianhanke"  target="${user}" property="username" /> <br />
	User对象的username的属性值为:<c:out value="${user.username }" /> <br />
	
	<c:set value="123456" property="password" target="${user}" /> <br />
	User对象的password的属性值为:<c:out value="${user.password }" /> <hr />
	request中的Map中设置值<br/>
<%
	HashMap map=new HashMap();
	request.setAttribute("preferences",map);
	
	HashMap map2=new HashMap();
	map2.put("name","hanke");  //EL对象不能获取此值
%>	
<c:set   target="${preferences }" value="green" property="color" />
Map中color的值:<c:out value="${preferences.color}" /> 
<hr />




</body>
</html>