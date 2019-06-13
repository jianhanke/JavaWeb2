<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	用户名:<%=request.getAttribute("username") %>  <br />
	密码:<%=request.getAttribute("password") %> <br />
	测试空域对象:<%=request.getAttribute("ceshi") %>
	<br />
	EL表达式 <br />
	用户名:${username } <br />
	密码:${password}  <br />
	测试空域对象${ceshi } <br />
	${10+2 }
	${10-2 }
	${10*2 }
	${10/2 }
	<br />
	${10==2 }  ${10 eq 2 } <br >
	<!--  	${10!=2 }  ${10 ne 2} <br >    有错误,但可以显示 -->
	${10<2 }  ${10lt 2 } <br >
	${10>2 }  ${10gt 2 } <br >
	${10<=2 } ${10le 2 } <br >
	${10>=2 } ${10ge 2} <br >
	${true&&false}   ${true and false } <br >
	${true||false } ${true or rfalse }  <br >
	${!true }       ${not true }   <br >
	<% int var=10;  %>
	${var }
	${empty var}<br >
	${	1==2? 3:4 } <br >
	${1*5+3 } ${1+5*3} <br > 
	
</body>
</html>