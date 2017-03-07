<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="../css/recording.css" rel="stylesheet" type="text/css" /><!--框架元素基本样式-->
<link href="../css/bootstrap.css" rel="stylesheet"><!--三级菜单样式-->
<link href="../css/mega-menu.css" rel="stylesheet"><!-- Mega Menu Style，三级菜单样式 -->
</head>
<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script><!--日历脚本-->
<script src="http://code.jquery.com/jquery-latest.js"></script><!--消费分类三级菜单脚本-->
<script src="../js/bootstrap.min.js"></script><!--消费分类三级菜单脚本-->
<script language="javascript" type="text/javascript">
     
	 function selected(x){//点击标签的js脚本
	  
		var labelvaule=document.getElementById("labelvalue");
		var labellist=document.getElementsByTagName("li");
		labelvalue.value=labellist[x].innerHTML;
		 var form_1 = document.getElementById("category");
		 form_1.value=x;
	}
	function check()
	{
		var bill=document.getElementsByTagName("input");
		var billDate=bill[2];
		var billlabel=bill[3];
		var billMoney=bill[4];
		var showStr="";
		if(billDate.value==""){
			showStr+="“日期” ";
		}
		if("点击添加标签"==billlabel.value){
			showStr+="“标签”";
		}
		var reg=/^\d{1,}\.*\d{1,}$/;
		if(billMoney.value=="" || !billMoney.value.match(reg))
		{
			showStr+="”金额“";
		}
		if(showStr!="")
		{
			alert("请输入有效的"+showStr);
			return false;
		}
		else
			return true;
			
	}
	function payselected()
	{
		var labeladd=document.getElementById("labelvalue");
		labeladd.removeAttribute("disabled");
	}
	function incomeselected()
	{
		var labeladd=document.getElementById("labelvalue");
		labeladd.disabled="disabled";
	}
</script>
<body>
<div id="content">
	<form id="bill" action="<%= path%>/servlet/BillServlet"  method="post" onsubmit="return check()">
		<h3 align="center">添加账目</h3>
		<div>
			<input onclick="payselected()" type="radio" checked="checked" name="consume" value="consume" class="consume"/>支出
			<input onclick="incomeselected()" type="radio" name="consume" value="income" class="consume"/>收入
		</div>
			<div>
				<label>日期：</label>
				<input class="Wdate" type="text" name="date" onClick="WdatePicker()">
			</div><!--将日期记录加特效-->
			<div>
				<label>标签：</label>
				<span class="dropdown" id="labelinput">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<input type="button" id="labelvalue"  value="点击添加标签" dis> </input>
				</a>
				<section class="dropdown-menu mega-menu-2 transition">
					<ul class="add-bottom-space">
						<li class="nav-title">餐饮</li>
						<a href="#"><li onclick="selected(1)">早晚午餐</li></a>
						<a href="#"><li onclick="selected(2)">休闲聚餐</li></a>
						<a href="#"><li onclick="selected(3)">水果零食</li></a>
						<a href="#"><li onclick="selected(4)">其他餐饮</li></a>
					</ul>
					<ul class="add-bottom-space">
						<li class="nav-title">运动交通</li>
						<a href="#"><li onclick="selected(6)">公共交通</li></a>
						<a href="#"><li onclick="selected(7)">打车租车</li></a>
						<a href="#"><li onclick="selected(8)">运动健身</li></a>
						<a href="#"><li onclick="selected(9)">旅行度假</li></a>
					</ul>
					<ul class="add-bottom-space">
						<li class="nav-title">生活服务</li>
						<a href="#"><li onclick="selected(11)">水电煤气</li></a>
						<a href="#"><li onclick="selected(12)">学习培训</li></a>
						<a href="#"><li onclick="selected(13)">通信上网</li></a>
						<a href="#"><li onclick="selected(14)">邮寄快递</li></a>
						<a href="#"><li onclick="selected(15)">宠物宝贝</li></a>
					</ul>
					<ul class="add-bottom-space">
					    <li class="nav-title">购物消费</li>
						<a href="#"><li onclick="selected(17)">数码设备</li></a>
						<a href="#"><li onclick="selected(18)">化妆饰品</li></a>
						<a href="#"><li onclick="selected(19)">衣服鞋帽</li></a>
						<a href="#"><li onclick="selected(20)">日常用品</li></a>
					</ul>
					<ul class="add-bottom-space">
						<li class="nav-title"></li>
						<a href="#"><li onclick="selected(22)">其他</li></a>
					</ul>
				</section>
			</span><!-- Regular Menu Ends -->
		</div>
		<div>
			<label>金额：</label>
			<input type="text" id="money" name="money" class="money"> </input>
			<span>元</span>
		</div>
		<div>
			<label>备注：</label>
			<textarea class="textfield" id="comment" name="comment" cols="35" rows="5"> </textarea>
		</div>
		<input type="submit" value="保存" class="button"> </input>
		<input onclick="location.reload()" type="button" value="重写" class="button"> </input><!--重新加载-->
		<span >
			<input name="category" id="category" style="display: none">
		</span>
	</form>
</div>
</body>

</html>
