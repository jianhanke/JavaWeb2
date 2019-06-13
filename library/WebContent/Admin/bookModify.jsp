<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="el" uri="http://www.EL.cn" %>     
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/info-reg.css" />
<title>移动办公自动化系统</title>
</head>

<body>
<div class="title"><h2>信息登记</h2></div> 
<form action="${pageContext.request.contextPath}/BookModifyServlet" method="post" enctype="multipart/form-data">
	<div class="main">
	    <p class="short-input ue-clear">
	    	<label>书名</label>
	        <input type="text" name="book_name" value="${book.book_name}" />
	    </p>

	    <p class="short-input  ue-clear">

		<label> 图片</label>
		<input type="file" name="picture">

		</p>

	    <p class="short-input ue-clear">
	    	<label>作者</label>
	        <input type="text" name="author" value="${book.author}" >  

	    </p>

	    <p class="short-input ue-clear">
	    	<label>出版社</label>
	    	<input type="text" name="press" value="${book.press}">
	        
	    </p>

		<p class="short-input ue-clear">
	    	<label>备注</label>
	    	<input type="text" name="remark" value="${book.remark}">
	    </p>
	<input type="hidden"  name="id" value="${book.id}"/>

	</div>
	<div class="btn ue-clear">
		<a href="javascript:;" id="btnsubmit" class="confirm">确定</a>
	    <a href="javascript:;" id="btncancel" class="clear">清空内容</a>
		<a href="__CONTROLLER__/delete/id/{$data.id}" id="delete" class="confirm">删除</a>
	   </div>
</form>
</body>
 <h style="font-size: 100px;color:red; " >${requestScope.message } </h>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/WdatePicker.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").toggle();
	return false;
});
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find("span").text(txt);
});

$(function(){
	//给确定按钮绑定点击事件
	$('.confirm').on('click',function(){
		$('form').submit();
	});

	//给清空按钮绑定点击事件
	$('.clear').on('click',function(){
		$('form')[0].reset();
	});
});



showRemind('input[type=text], textarea','placeholder');
</script>
</html>
