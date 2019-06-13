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
<style type='text/css'>
	table tr .user_id{ width:63px; text-align: center;}
	table tr .user_pwd{ width:118px; padding-left:17px;}
	table tr .user_name{ width:63px; padding-left:17px;}
	table tr .user_sex{ width:63px; padding-left:13px;}
	table tr .user_tele{ width:63px; padding-left:13px;}
	table tr .now_borrow_books{ width:80px; padding-left:13px;}
	table tr .last_borrow_books{ width:113px; padding-left:13px;}
	table tr .email{ width:160px; padding-left:13px;}
	table tr .addtime{ width:160px; padding-left:13px;}
	table tr .operate{ padding-left:13px;}
</style>
</head>

<body>
<div class="title"><h2>信息管理</h2></div>
<div class="table-operate ue-clear">
	
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="user_id">账户</th>
                <th class="user_pwd">密码</th>
				<th class="user_name">姓名</th>
                <th class="user_sex">性别</th>
				<th class="user_tele">电话</th>
                <th class="operate">修改</th>
                <th class="delete">删除</th>
            </tr>
        </thead>
        <tbody >
        	<c:forEach var="user" items="${requestScope.list }" >
	        	<tr style="height: 30px;">
	            	<th class="user_id"> ${user.user_id } </th>
	                <th class="user_pwd">${user.user_pwd} </th>
					<th class="user_name">${user.user_name} </th>
	                <th name="user_sex">${user.user_sex } </th>
					<th class="user_tele">${user.user_tele} </th>
					<th class="delete" > <a href="${pageContext.request.contextPath}/UserdeleteServlet?id=${user.user_id} " >删除</a> </th>		
	                <th class="operate"><a href="${pageContext.request.contextPath}/UsermodifyServlet?id=${user.user_id} ">修改</a> </th>
	            </tr>
	        </c:forEach>    
	        
        </tbody>
    </table>
</div>
<div class="pagination ue-clear">
	<div class="pagin-list">
		{$show}
	</div>
	<div class="pxofy">总共{$count}条记录</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/WdatePicker.js"></script>
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
