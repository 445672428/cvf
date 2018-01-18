<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="" name="description" />
<meta content="" name="author" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/login.css" />
<!--[if IE]>
<style type="text/css">
	li.remove_frame a {
		padding-top: 5px;
		background-position: 0px -3px;
	}
</style>
<![endif]-->
<script type="text/javascript">
var CONTEXTPATH = '${CONTEXTPATH}';
</script>
</head>
<body id="by">

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
			<li class="remove_frame"><a href="${CONTEXTPATH }/loginmain.jsp" title="移除框架"></a></li>
		</ul>
	</div>
</div>
<div id="iframe-wrap">
	<iframe id="iframe" src="${CONTEXTPATH}/loginmain.jsp" frameborder="0"  width="100%"></iframe>
</div>
</body>
<!-- 引入Jquery -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery-1.7.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jquery.qrcode.min.js" charset="utf-8"></script>
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