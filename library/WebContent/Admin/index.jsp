<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/base.css" />
<link rel="stylesheet" type="/book/Admin/static/css" href="${pageContext.request.contextPath}/Admin/static/css/jquery.dialog.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/static/css/index.css" />
<title>图书后台管理系统</title>
</head>
	
<body>
<div id="container">
  <div id="hd">
    <div class="hd-wrap ue-clear">
      <div class="top-light"></div>
      <h1 class="logo"></h1>
      <div class="login-info ue-clear">
        <div class="welcome ue-clear"><span>管理员:</span><a  class="user-name">${sessionScope.admin.admin_name}</a></div>
        <!-- <div class="login-msg ue-clear"> <a href="javascript:;" class="msg-txt">消息</a> <a href="javascript:;" class="msg-num">10</a> </div> -->
      </div>
      <div class="toolbar ue-clear">
       <a href="javascript:;" class="home-btn">首页</a>
       <a href="__CONTROLLER__/logout" class="quit-btn exit"></a> </div>
    </div>
  </div>
  <div id="bd">
    <div class="wrap ue-clear">
      <div class="sidebar">
        <h2 class="sidebar-header">
          <p>功能导航</p>
        </h2>
        <ul class="nav">
         <!--  <li class="office current">
            <div class="nav-header"><a href="javascript:;" date-src="home.html" class="ue-clear"><span>日常办公</span><i class="icon"></i></a></div>
          </li>
          <li class="gongwen">
            <div class="nav-header"><a href="javascript:;" class="ue-clear"><span>公文起草</span><i class="icon"></i></a></div>
          </li> -->
          <li class="nav-info">
            <div class="nav-header"><a href="javascript:;" class="ue-clear"><span>图书管理</span><i class="icon"></i></a></div>
            <ul class="subnav">
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/BookshowServlet">查看书籍</a></li>
              <li><a href="" date-src="${pageContext.request.contextPath}/BookAddServlet">添加图书</a></li>
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/BookBorrowedServlet">借阅查询</a></li>
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/BookExistServlet">现有书籍</a></li>

            </ul>
          </li>


          <li class="konwledge">
            <div class="nav-header"><a href="javascript:;" class="ue-clear"><span>用户管理</span><i class="icon"></i></a></div>
          <ul class="subnav">
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/UsershowServlet ">用户列表</a></li>
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/Admin/userAdd.jsp">添加用户 </a></li>
            
          </ul>
              
          </li>
          <li class="agency">
            <div class="nav-header"><a href="javascript:;" class="ue-clear"><span>图书记录</span><i class="icon"></i></a></div>
            <ul class="subnav">
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/CirculateServlet">流通记录</a></li>
              
            
          </ul>


  	
              <li class="gongwen">
            <div class="nav-header"><a href="javascript:;" class="ue-clear"><span>数据统计</span><i class="icon"></i></a></div>
            <ul class="subnav">
              <li><a href="javascript:;" date-src="${pageContext.request.contextPath}/SexServlet ">用户统计</a></li>
              
            
          </ul>

          </li> 
      

          <li class="system">
            <div class="nav-header"><a href="javascript:;" class="ue-clear"><span>留言管理</span><i class="icon"></i></a></div>
              <ul class="subnav">
              <li><a href="javascript:;" date-src=" ${pageContext.request.contextPath}/MessageServlet">留言处理</a></li>
              
            
          </ul>

          </li>
        </ul>

      </div>
      <div class="content">
        <iframe src="${pageContext.request.contextPath}/Admin/home.jsp" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
      </div>
    </div>
  </div>
  <div id="ft" class="ue-clear">
    <div class="ft-left"> <span>中国移动</span> <em>Office&nbsp;System</em> </div>
    <div class="ft-right"> <span>Automation</span> <em>V2.0&nbsp;2014</em> </div>
  </div>
</div>
<div class="exitDialog">
  <div class="dialog-content">
    <div class="ui-dialog-icon"></div>
   	
  </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/jquery.dialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Admin/static/js/index.js"></script>
</html>
