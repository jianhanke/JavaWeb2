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
<div class="title"><h2>留言板</h2></div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
                <th class="num">是否匿名</th>
            	<th class="num" >  留言人</th>
                <th class="name">留言内容</th>
                <th class="process">留言日期</th>
                <th class="num"  >点击删除</th>
                <th class="name">点击置顶</th>
            </tr>
        </thead>
           
        <tr> 
            <td style="color:blue"> <p style="float:right">【置顶】</p>${one.user_status=='11' ? '实名' : '匿名'} </td>
            <td style="color:blue">${one.user_name}   </td>
            <td style="color:blue"> ${one.user_message} </td>
            <td style="color:blue">${one.add_date } </td>  
        </tr>   
       
        <tbody>
              
    	        
		<c:forEach var="info" items="${requestScope.list}">
    
        	<tr>
        		
            	<td class="user_name" style="color: red;float: center">${info.user_status=='1' ? '实名' : '匿名'} </td>
                <td> ${info.user_name} </td>
                <td style="height: 50px;"> ${info.user_message }   </td>
                <td class="date" >${info.add_date } </td>
                <td>   <a href="${pageContext.request.contextPath}/MessageServlet?delete_id=${info.message_id}" style="color:red">删除</a> </td>
                <td>      <a href="${pageContext.request.contextPath}/MessageServlet?top_id=${info.message_id}" style="color:blue">置顶</a> </td>
            </tr>
            
           </c:forEach>

        </tbody>

    </table>
</div>
<div class="pagination ue-clear"></div>
<h style="font-size: 100px;color:red; " >${requestScope.message } </h>
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
