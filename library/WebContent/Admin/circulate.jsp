<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/info-mgt.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/WdatePicker.css" />
<title>移动办公自动化系统</title>
</head>

<body>
<div class="title"><h2>信息管理</h2></div>
<div class="table-operate ue-clear">
	
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="num">图书ID</th>
                <th class="name">书名</th>
                <th style=" "> 流转人数......</th>
            </tr>
        </thead>
        <tbody>
       	
            <c:forEach var="item" items="${requestScope.list}" >
            <tr>
            		<c:forEach var="oness" items="${item}">
            			<c:forEach var="ones" items="${oness}">
            				<td>${ones} </td>
            			</c:forEach>	
            		</c:forEach>
            </tr>		 
            </c:forEach>
            
            
    </volist>
           
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.pagination.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})


$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
