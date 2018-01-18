<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/login.css" />
</head>
<body class="login">
<div id="switcher">
	<div class="center">
		<ul>
			<li class="top2">
				<a href="#">手机二维码预览</a>
				<div class="vm">
					<div id="output"></div>
					<p style="color:#808080;margin:10px 0 0 0;">扫一扫，直接在手机上打开</p>
				</div>
			</li>
			<li class="logoTop"><a href="${CONTEXTPATH }/templet.jsp"></a></li>
			<%-- <li class="remove_frame"><a href="${CONTEXTPATH }/loginmain.jsp" title="移除框架"></a></li> --%>
		</ul>
	</div>
</div>
<div class="login_m">
	<div class="login_logo"><canvas width="196px" height="49px" id="logo"></canvas></div>
	<div class="login_boder">
		<form id="userform" action="${CONTEXTPATH }/login.do" method="POST">
			<div class="login_padding">
				<h2>用户名:</h2>
				<label>
					<input type="text" name="username" id="username" class="txt_input txt_input2" value="">
				</label>
				<h2>密码:</h2>
				<label>
					<input type="password" name="password" id="userpwd" class="txt_input" value="">
				</label>
				<p class="forgot"><a href="${CONTEXTPATH }/register.jsp">注册账号&nbsp;&nbsp;</a><a href="javascript:void(0);">忘记密码?</a></p>
				<div class="rem_sub">
					<div class="rem_sub_l">
						<input type="checkbox" name="checkbox" id="save_me">
						<label for="checkbox">记住</label>
					</div>
					<label>
						<input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;">
					</label>
				</div>
			</div>
		</form>
	</div>
</div>
<br />
<br />
<p align="center">作者:<a href="${CONTEXTPATH }/resource.jsp" target="_blank" title="程占波">波波</a></p>
</body>
<!-- 引入Jquery -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery-1.7.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jquery.qrcode.min.js" charset="utf-8"></script>
<script>
    var canvas=document.getElementById("logo");
    var ctx=canvas.getContext("2d");
    var gradient=ctx.createLinearGradient(0,0,canvas.width,0);
    gradient.addColorStop("0","magenta");
    gradient.addColorStop("0.5","blue");
    gradient.addColorStop("1.0","red");
    ctx.fillStyle=gradient;
    ctx.font="30px Verdana";
    ctx.fillText("波波欢迎你!",30,30);
</script>
<script type="text/javascript">
$(document).ready(function () {
	function fixHeight() {
		var headerHeight = $("#switcher").height();
		$("#iframe").attr("height", $(window).height()-54+ "px");
	}
	$(window).resize(function () {
		fixHeight();
	}).resize();
});
jQuery('#output').qrcode({width:150,height: 150,text: window.location.href});
</script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?382f81c966395258f239157654081890";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</html>