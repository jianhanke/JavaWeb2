<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="el" uri="http://www.EL.cn" %> 

<!doctype html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/info-mgt.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/WdatePicker.css" />

<title>移动办公自动化系统</title>
</head>
<style type='text/css'>
    .picture{
        width=300px;height=300px;
    }

</style>
<body>
<div class="title"><h2>书籍管理</h2></div>
  <div class="search-wrap">
            <div class="search-content">
                <form action="" method="post" >
                    <table class="search-tab">
                        <tr>
                        <th style="width:350px;height:50px;font-size:15px;color:#00FF00; "></th>
                        <th style="width:80px;height:50px;font-size:15px;color:#00FF00; ">搜索范围:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="book_name">书名</option>
                                    <option value="author">作者</option>
                                    <option value="press">出版社</option>
                                </select>
                            </td>
                        <th style="width:80px;height:50px;font-size:15px;color:#00FF00;">搜索关键字:</th>

                            <td style="width:80px;height:50px;font-size:15px;color:#00FF00; "><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <th ><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></th>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
<div class="table-box">
    <table>
        <thead>
            <tr>
                <th class="num">ID</th>
                <th class="name">书名</th>
                <th class="process">图片</th>
                <th class="node">作者</th>
                <th class="time">出版社</th>
                <th class="operate">借书人</th>
               	

            </tr>
        </thead>

        <tbody>
	  <c:forEach var="book" items="${requestScope.list}" >
            <tr>
                <td class="book_id">${book.id}</td>
                <td class="book_name">${book.book_name}  </td>
                <td  class="file"><img src="/${el:doPath(book.thumb_picture)}"   /></td>
                <td class="author">${book.author} </td>
                <td class="press">${book.press} </td>
                <td class="username" style="color:red;"  >${book.user_name}  </td>
                
            </tr>
        </c:forEach> 
       	

        </tbody>
    </table>
</div>
<div class="pagination ue-clear">
    <div class="pagin-list">
        ${count} 
    </div>
    <div class="pxofy">共 {$count} 条记录</div>
</div>

</div>
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
$(function(){
    //给确定按钮绑定点击事件
    $('.btn').on('click',function(){
        $('form').submit();
    });


});


// $('.pagination').pagination(100,{
//     callback: function(page){
//         alert(page);    
//     },
//     display_msg: true,
//     setPageNo: true
// });
$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");
showRemind('input[type=text], textarea','placeholder');
</script>


</html>
