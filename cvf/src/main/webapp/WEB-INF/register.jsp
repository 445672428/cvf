<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="shortcut icon" href="${CONTEXTPATH }/resources/images/favicon.ico" type="image/x-icon" />
<script type="text/javascript">
var CONTEXTPATH = '${pageContext.request.contextPath}';
</script>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/register.css" />
<script data-main="resources/js/register" type="text/javascript" src="${CONTEXTPATH }/resources/lib/require.js" charset="utf-8"></script>
</head>
<body>
    <!--头部-->
    <div class="header">
        <canvas width="196px" height="100%" id="logo"></canvas>
        <div class="desc">欢迎注册</div>
    </div>
    <!--版心-->
    <div class="container">
	    <form action="${CONTEXTPATH}/register" method="POST">
	    	<!--注册模块-->
	    	<div class="register">
	    		<!--用户名-->
	    		<div class="register-box">
	    			<!--表单项-->
	    			<div class="box default">
	    				<label for="userName">用&nbsp;户&nbsp;名</label>
	    				<input type="text" name="userName" id="userName" placeholder="您的账户名和登录名" />
	    				<i></i>
	    			</div>
	    			<!--提示信息-->
	    			<div class="tip">
	    				<i></i>
	    				<span></span>
	    			</div>
	    		</div>
	    		<!--设置密码-->
	    		<div class="register-box">
	    			<!--表单项-->
	    			<div class="box default">
	    				<label for="pwd">设 置 密 码</label>
	    				<input type="password" name="password" id="pwd" placeholder="建议至少两种字符组合" />
	    				<i></i>
	    			</div>
	    			<!--提示信息-->
	    			<div class="tip">
	    				<i></i>
	    				<span></span>
	    			</div>
	    		</div>
	    		<!--确认密码-->
	    		<div class="register-box">
	    			<!--表单项-->
	    			<div class="box default">
	    				<label for="pwd2">确 认 密 码</label>
	    				<input type="password" id="pwd2" name="password" placeholder="请再次输入密码" />
	    				<i></i>
	    			</div>
	    			<!--提示信息-->
	    			<div class="tip">
	    				<i></i>
	    				<span></span>
	    			</div>
	    		</div>
				<!--设置密码-->
	    		<div class="register-box">
	    			<!--表单项-->
	    			<div class="box default">
	    				<label for="email">邮 箱 验 证</label>
	    				<input type="text" id="email" name="email" placeholder="请输入邮箱" />
	    				<i></i>
	    			</div>
	    			<!--提示信息-->
	    			<div class="tip">
	    				<i></i>
	    				<span></span>
	    			</div>
	    		</div>
	    		<!--手机验证-->
	    		<div id="checkedDiv" class="register-box">
	    			<!--表单项-->
	    			<div class="box default">
	    				<label for="mobile">手 机 验 证</label>
	    				<input type="text" id="mobile" name="mobile" placeholder="请输入手机号" />
	    				<i></i>
	    			</div>
	    			<!--提示信息-->
	    			<div class="tip">
	    				<i></i>
	    				<span></span>
	    			</div>
	    		</div>
	    		 <!--注册协议-->
	    		<div class="register-box xieyi">
	    			<!--表单项-->
	    			<div class="box default">
	    				<input type="checkbox" id="ck" />
	    				<span>我已阅读并同意<a href="##">《用户注册协议》</a></span>
	    			</div>
	    			<!--提示信息-->
	    			<div class="tip">
	    				<i></i>
	    				<span></span>
	    			</div>
	    		</div>
	    		<!--注册-->
	    		<button id="btn">注册</button>
	    	</div>
    	</form>
    </div>
</body>
</html>