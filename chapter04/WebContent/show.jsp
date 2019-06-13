<%@page import="ceshi.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr>
			<th>图书名称</th>
			<th>图书单价</th>
			<th>图书分类</th>
		</tr>
		<%
			List<Book> list = (List) request.getAttribute("bookList");
			for (Book b : list) {
		%>
		<tr>
			<td><%=b.getBname()%></td>
			<td><%=b.getPrice()%></td>
			<td>
				<%	if (b.getCategory() == 1) {%>
					<p style="color: red;">JavaSE分类</p> 
				<%} else if (b.getCategory() == 2) {%>
					<p style="color: blue;">JavaEE分类</p> 
                   <%} else {%>
					<p style="color: green;">Java框架分类</p> 
                   <%}%>
			</td>
		</tr>
		<%}%>
	</table>
</body>
</html>
