<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+
":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <body>
	<a href="<%=request.getContextPath()%>/BookServlet2">全部图书</a><br/>
	<a href="<%=request.getContextPath()%>/BookServlet2?category=1">
         JavaSE分类</a><br/>
	<a href="<%=request.getContextPath()%>/BookServlet2?category=2">
         JavaEE分类</a><br/>
     <a href="<%=request.getContextPath()%>/BookServlet2?category=3">
         Java框架分类</a><br/>
  </body>
</html>
