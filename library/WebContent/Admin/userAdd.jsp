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
<form action="${pageContext.request.contextPath}/UseraddServlet " method="post">
<div class="main">
	<p class="short-input ue-clear">
    	<label>账户</label>
        <input name="user_id" type="text" placeholder="用户名" />
    </p>
	<p class="short-input ue-clear">
    	<label>密码：</label>
        <input name="user_pwd" type="text" placeholder="密码" />
    </p>
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input name="user_name" type="text" placeholder="姓名" />
    </p>
   
	<p class="short-input ue-clear">
    	<label>性别：</label>
    	<input name="user_sex" type="radio" value="男" checked='checked' />男
		<input name="user_sex" type="radio" value="女" />女
    </p>

	<p class="short-input ue-clear">
    	<label>电话：</label>
        <input type="text" name="user_tele" placeholder="联系电话" />
    </p>

</div>
 
<div class="btn ue-clear">
	<a href="javascript:;" class="confirm" id='btnSubmit'>确定</a>
    <a href="javascript:;" class="clear" id='btnReset'>清空内容</a>
</div>
 <h style="font-size: 100px;color:red; " >${requestScope.message } </h>

</form>
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
