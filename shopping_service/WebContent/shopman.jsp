<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售管理平台</title>
<link href="mycss/bootstrap.css" rel="stylesheet">
<link href="mycss/shopman.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$("#content").load("homeback.html");
	$("#home").click(function(){
		$("#content").load("homeback.html");
	});
	$("#queryorder").click(function(){
		$("#content").load("queryorders.html");
	})
	$("#addfactory").click(function(){
		$("#content").load("addfactory.html");
	})
		$("#editfactory").click(function(){
		$("#content").load("editfactory.html");
	})
		$("#selfactory").click(function(){
		$("#content").load("selectfactory.html");
	})
	$("#addproduct").click(function(){
		$("#content").load("addproduct.html");
	})
	$("#updateproduct").click(function(){
		$("#content").load("editproduct.html");
	})
	$("#addproimg").click(function(){
		$("#content").load("addproimg.html");
	})
	$("#delproimg").click(function(){
		$("#content").load("delproimg.html");
	})
})
</script>
<body>

<div class="header">
	<div class="header_left"> 
		<div class="logo"><img src="img/tree.png" /></div> 
    	<div class="title">农特产品销售管理平台</div>
    </div>
	<div class="header_right">    	   
       <div class="operate"> 欢迎您:<span id="empeename" style="color: Red; font-family: Tahoma"></span> <a>注销</a>  <a>修改密码</a> </div> 
	</div>  
    <div style="clear:both"></div>
</div>

<div id="navbar" class="nav-menu">
   <ul id="menus" class="">
   
     <li id="item1"><a href="#" id="home">首页</a></li>
     
     <li id="item2"><a href="#">数据管理</a>
        <ul > 订单管理
          <li><a href="#" id="queryorder">订单查询</a>
        </ul>
        <ul >销售品管理
          <li><a href="#" id="addproduct">添加销售品</a> </li>
          <li><a href="#" id="updateproduct">修改销售品</a> </li>
        </ul>
         <ul >销售品图片管理
          <li><a href="#" id="addproimg">添加图片</a> </li>
          <li><a href="#" id="delproimg">删除图片</a> </li>
        </ul>
        <ul >商家管理
        <li><a href="#" id="selfactory">查询商家</a> </li>
          <li><a href="#" id="addfactory">添加商家</a> </li>
          <li><a href="#" id="editfactory">修改商家</a> </li>
        </ul>
         <ul >用户资料管理
          <li><a href="#">修改用户资料</a> </li>
        </ul>
      </li>
      
      <li id="item3"><a href="#">日志查询</a></li>
   </ul>
  </div>
  
 <div id="content" class="mainshow"></div> 

</body>
</html>