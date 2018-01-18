<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/main.css" />
</head>
<body class="login">
<div class="login_m">
	<div class="login_logo"><canvas width="196px" height="49px" id="logo"></canvas></div>
	<div class="login_boder">
		<div class="login_padding">
			<h2>用户名:</h2>
			<label>
				<input type="text" id="username" class="txt_input txt_input2" value="">
			</label>
			<h2>密码:</h2>
			<label>
				<input type="password" name="textfield2" id="userpwd" class="txt_input" value="">
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
	</div>
</div>
<br />
<br />
<p align="center">作者:<a href="${CONTEXTPATH }/resource.jsp" target="_blank" title="程占波">程占波</a></p>
</body>
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
</html>