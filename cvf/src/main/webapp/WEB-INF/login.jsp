<%@page import="com.utils.HttpUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath }/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/login.css" />
<script data-main="resources/js/login" type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/plugin/require.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
	var PATH = '${pageContext.request.contextPath}';
	if(window != top){
		top.location.href = location.href;	
	}
</script>
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
			<li class="logoTop"><a href="${pageContext.request.contextPath }/templet.jsp"></a></li>
		</ul>
	</div>
</div>
<div class="login_m">
	<div class="login_logo"><canvas width="196px" height="49px" id="logo"></canvas></div>
	<div class="login_boder">
		<form id="userform" action="${pageContext.request.contextPath }/dologin" method="POST">
			<div class="login_padding">
				<h2>用户名:</h2>
				<label>
					<input type="text" name="username" id="username" class="txt_input txt_input2" value="">
				</label>
				<h2>密码:</h2>
				<label>
					<input type="password" name="password" id="userpwd" class="txt_input" value="">
				</label>
				<label>
					验证码:<input style="width: 100px;"  type="text" name="checkcode" id="checkcode" class="txt_input" value=""><img alt="" id="imgCode" src="${CONTEXTPATH }/servlet/validateCodeServlet">
				</label>
				<p class="forgot"><a href="${CONTEXTPATH }/register" target="_blank">注册账号&nbsp;&nbsp;</a><a href="javascript:void(0);">忘记密码?</a></p>
				<div class="rem_sub">
					<div class="rem_sub_l">
						<input type="checkbox" name="checkbox" id="save_me">
						<label for="checkbox">记住</label>
					</div>
					<label>
						<input type="button" class="sub_button" name="button" id="onlogin" value="登录" style="opacity: 0.7;">
					</label>
				</div>
			</div>
		</form>
	</div>
</div>
<br />
<br />
<p align="center">作者:<a href="${CONTEXTPATH }/author" target="_blank" title="程占波">波波</a></p>
</body>
</html>