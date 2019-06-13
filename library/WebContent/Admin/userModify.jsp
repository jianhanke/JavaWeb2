<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/info-reg.css" />
<title>移动办公自动化系统</title>
<style type='text/css'>
	select {
		background: rgba(0, 0, 0, 0) url("${pageContext.request.contextPath}/Admin/static/images/inputbg.png") repeat-x scroll 0 0;
	    border: 1px solid #c5d6e0;
	    height: 28px;
	    outline: medium none;
	    padding: 0 8px;
	    width: 240px;
	}
	.main p input {
		float:none;
	}
</style>
</head>

<body>
<div class="title"><h2>信息登记</h2></div>
<form action="${pageContext.request.contextPath}/UsermodifyServlet" method="post">
<div class="main">
	<p class="short-input ue-clear">
    	<label>账户:</label>
        <input name="user_id" type="text" value="${requestScope.user.user_id } " />
    </p>
	<p class="short-input ue-clear">
    	<label>密码：</label>
        <input name="user_pwd" type="text" value="${requestScope.user.user_pwd } " />
    </p>
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input name="user_name" type="text" value="${requestScope.user.user_name } " />
    </p>
	             
	<p class="short-input ue-clear">
    	<label>性别：</label>          
    	<input name="user_sex" type="radio" value="男" ${requestScope.user.user_sex=="男" ? "checked": "否" }  />男

		<input name="user_sex" type="radio" value="女" ${requestScope.user.user_sex=="女" ? "checked": "否" }         />女
    </p>
	<p class="short-input ue-clear">
    	<label>电话：</label>
        <input type="text" name="user_tele" value="${requestScope.user.user_tele}" />
    </p>
    <p>
        <label >   </label>
    </p>
    
</div>
<div class="btn ue-clear">
	<a class="confirm" id='btnSubmit'>确定</a>
    
</div>
</form>
<h style="font-size: 100px;color:red; " >${requestScope.message } </h>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$('#btnSubmit').on('click',function(){
		$('form').submit();
	});
	
	$('#btnReset').on('click',function(){
		$('form')[0].reset();
	});
});	

$(".select-title").on("click",function(){
	$(".select-list").toggle();
	return false;
});
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find("span").text(txt);
});

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
