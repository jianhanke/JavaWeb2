<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
    import="java.util.*"
    %>
<%@ taglib prefix="itcast" uri="/simpleTag" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<%
	int[] arr={0,1,2,3,4,5,6};
 	Map map=new HashMap();
	 	map.put("apple","apple2");
	 	map.put("banana","banana2");
	 	map.put("Lint","lint2");
	List list=new ArrayList();
		list.add("Tom");
		list.add("Silly");
		list.add("Jerry");
		list.add("Linda");
		list.add("Bob");
%>
	
<body>
	names index first last  <br />
	<itcast:examforeach var="name" object="<%=list %>"  varStatus="status" >
			
				${name }
				${status.count }
				 ${status.index }
				 ${status.first }
				 ${status.last } 
			 <br />
	</itcast:examforeach>
	
</body>
</html>