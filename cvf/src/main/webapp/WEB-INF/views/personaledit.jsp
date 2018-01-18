<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<!-- jquery -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js" charset="utf-8"></script>
<!-- bootstrap -->
<%-- <script type="text/javascript" src="${CONTEXTPATH }/resources/lib/bootstrap/js/bootstrap.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/bootstrap/css/bootstrap.css" /> --%>
<style type="text/css">
	body, h1, h2, h3, h4, h5, h6, hr, p, blockquote, dl, dt, dd, ul, ol, li, pre, form, fieldset, legend, button, input, textarea, th, td{
		margin: 0;
		padding: 0;
	}
	.my_head{
		position: relative;
		height: 40px;
		display: block;
		width: 100%;
		border-bottom: 1px solid #e0dede;
		box-shadow:0 -1px 0 #fefcfc inset, 0 0 4px rgba(0, 0, 0, .1);
	}
	.mod-banner {
	    float: right;
	    padding-top: 15px;
	    color: #999;
	    position: relative;
	    z-index: 1;
	}
	.mod-banner .user-name {
	    font-weight: bold;
	    text-decoration: none;
	}
	a:active, a:visited {
	    border: none;
	    outline: none;
	}
	.mod-banner a {
    	margin: 0 5px;
	}
	ul li, ol{
		list-style: none;
	}
	a {
	    text-decoration: none;
	    color: #2c76c0;
	    outline: none;
	    transition: color .2s;
	    -moz-transition: color .2s;
	    -o-transition: color .2s;
	    -webkit-transition: color .2s;
	}
	.setTop{
		font-size: 22px;
	    height: 46px;
	    line-height: 46px;
	    padding-left: 20px;
	    background: -webkit-linear-gradient(#fff,#f7f7f7);
	    font-family: "microsoft yahei","\5FAE\8F6F\96C5\9ED1",Tahoma,Arial,Helvetica,STHeiti;
	}
	.customTainer{
		width: 960px;
		border: solid 1px #ededed;
		margin-top: 21px;
		color: #666;
	}
	div.setting-content {
	    background: #f7f7f7;
	    min-height: 640px;
	    _height: 640px;
	}
	.clearfix {
	    zoom: 1;
	}
	.setting-menu {
	    float: left;
	    width: 199px;
	}
	.setting-menu .menu-title {
	    height: 39px;
	    line-height: 38px;
	    font-size: 14px;
	    border-top: solid 1px #e5e5e5;
	    border-bottom: solid 1px #e5e5e5;
	    border-right: 1px solid #e5e5e5;
	    position: relative;
	}
	.setting-menu .menu-list .menu-item.on {
	    background: #fff;
	    border-right: 1px solid #fff;
	}
	.setting-menu .menu-list .menu-item {
	    line-height: 34px;
	    height: 35px;
	    font-size: 12px;
	    width: 198px;
	    border-right: 1px solid #e5e5e5;
	}
	.setting-menu .active h3 {
	    border-left: 4px #2e82ff solid;
	}
	.menu-title h3 {
	    display: block;
	    padding-left: 45px;
	    font-weight: bold;
	    position: absolute;
	    left: 0;
	    top: -1px;
	    height: 41px;
	    width: 195px;
	}
	.container {
	  padding-right: 15px;
	  padding-left: 15px;
	  margin-right: auto;
	  margin-left: auto;
	}
	@media (min-width: 768px) {
	  .container {
	    width: 750px;
	  }
	}
	@media (min-width: 992px) {
	  .container {
	    width: 970px;
	  }
	}
	@media (min-width:1400px){
		.container{
			width: 1000px;
		}
	}
	.menu-list .menu-item a {
	    margin-left: 45px;
	    display: block;
	    padding-left: 11px;
	    background: none;
	    color: #666;
	}
	.setting-detail{
		margin-left:2px;
		float: left;
		width: 778px;
		border:solid 1px #e5e5e5;
		min-height: 640px;
		display: block;
		background: #ffffff;
	}
	table{
		border-collapse: collapse;
		border-spacing: 0;
		display: table;
	}
	.setting-detail tr{
		vertical-align: top;
		border-color:inherit;
	}
	.setting-detail td {
	    padding: 7px 0 8px;
	}
	.setting-detail button, input, select, textarea {
	    font-size: 100%;
	}
	select:not(:-internal-list-box) {
	    overflow: visible !important;
	}
	.mod-cus-sel {
		font-size: 12px;
	    border: 1px solid;
	    border-color: #d8d8d8 #e5e5e5 #e5e5e5 #d8d8d8;
	    box-shadow: 2px 3px 3px #f6f8f9 inset;
	    -moz-box-shadow: 2px 3px 3px #f6f8f9 inset;
	    -webkit-box-shadow: 2px 3px 3px #f6f8f9 inset;
	    height: 28px;
	    float: left;
	    cursor: pointer;
	    margin-right: 10px;
	    background: transparent url(resources/images/cussel_normal.png) no-repeat right center;
	}
	.cus-sel-opt-txt, .cus-sel-opt-panel {
	    padding: 0 25px 0 10px;
	    line-height: 28px;
	    min-width: 65px;
	    display: inline-block;
	    white-space: nowrap;
	}
	.cus-sel-opt-ctn {
	    display: none;
	    max-height: 300px;
	}
	.setting-submit-btn {
	    border: none;
	    border: 1px solid #5c8ebf;
	    border: 0 none\9;
	    -moz-border-radius: 2px;
	    -webkit-border-radius: 2px;
	    border-radius: 2px;
	    filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, startColorstr=#75abda, endColorstr=#6698c9);
	    background: -webkit-linear-gradient(#75abda,#6698c9);
	    background: -moz-linear-gradient(#75abda,#6698c9);
	    font-size: 14px;
	    width: 68px;
	    height: 34px;
	    line-height: 34px;
	    color: #fff;
	    text-align: center;
	    cursor: pointer;
	}
	.setting-submit-ml100 {
	    margin: 13px 0 0 100px;
	}
	.setting-profile-form th {
	    text-align: right;
	    font-weight: normal;
	    padding: 14px 10px 0 0;
	    width: 90px;
	}
	.setting-profile-form td {
	    padding: 7px 0 8px;
	}
</style>
</head>
<body>
<div class='my_head'>
	<div id="1000000" class="mod-banner" style="display: block;">
		<a href="https://www.baidu.com/p/setting/profile/basic#" id="pUserInfo" onclick="return false;" class="user-name">
			<span class="un" onmouseover='showTag();' onmouseout='hideTag();' >仙桃市丶波波</span>
			<span class="icon"></span>
		</a>| 
		<a href="http://msg.baidu.com/" target="_blank">私信</a>
		<a href="https://www.baidu.com/">首页</a>
	</div>
</div>
<div class="container customTainer">
	<div>
		<div class='setTop'>个人设置</div>
		<div class="setting-content clearfix"> 
			<div class="setting-menu"> 
				<div class="menu-title menu-profile-current active"> <h3>个人资料</h3></div> 
				<ul class="menu-list"> 
					<li class="menu-item basic-link on"><a href="https://www.baidu.com/p/setting/profile/basic">基本资料</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item details-link"><a href="https://www.baidu.com/p/setting/profile/details">详细资料</a> </li>
					<li class="menu-split">  </li>
					<li class="menu-item education-link"><a href="https://www.baidu.com/p/setting/profile/education">教育背景</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item career-link"><a href="https://www.baidu.com/p/setting/profile/career">工作信息</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item portrait-link"><a href="https://www.baidu.com/p/setting/profile/portrait">头像设置</a> </li>
				</ul> 
				<div class="menu-title menu-privacy" id="settingPrivacy"> <h3>隐私设置</h3> </div> 
				<ul class="menu-list"> 
					<li class="menu-item tieba-link" id="settingPrivacyTieba"><a href="https://www.baidu.com/p/setting/privacy/tieba">我在贴吧</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item zhidao-link" id="settingPrivacyZhidao"><a href="https://www.baidu.com/p/setting/privacy/zhidao">我在知道</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item wenku-link" id="settingPrivacyWenku"><a href="https://www.baidu.com/p/setting/privacy/wenku">我在文库</a>  </li>
					<li class="menu-split"> </li>
					<li class="menu-item baike-link" id="settingPrivacyBaike"><a href="https://www.baidu.com/p/setting/privacy/baike">我在百科</a> </li>
					<li class="menu-split"> </li>
				</ul> 
			</div>
			<div class="setting-detail" id="stthld">
				<form id="profile" class="setting-profile-form" method="POST" action="https://passport.baidu.com/v2/?ucenterset"> 
					<table> 
						<tbody> 
							<tr> 
								<th>体型:</th> 
								<td> <select id="passport_figure" name="passport_figure" style="display: none;">
								<option value="none">请选择</option>
								</select>   
									<div class="mod-cus-sel " id="cussel1000000">
									<div class="cus-sel-opt-panel">丰满</div>
									<ol class="cus-sel-opt-ctn">
									<li class="cus-sel-opt"><a class="cus-sel-opt-txt" data-value="0" href="#">未知</a></li>
									<li class="cus-sel-opt "><a class="cus-sel-opt-txt" data-value="1" href="#">苗条</a></li>
									<li class="cus-sel-opt  cus-sel-opt-selected"><a class="cus-sel-opt-txt" data-value="2" href="#">丰满</a></li>
									<li class="cus-sel-opt "><a class="cus-sel-opt-txt" data-value="3" href="#">中等身材</a></li>
									<li class="cus-sel-opt "><a class="cus-sel-opt-txt" data-value="4" href="#">高大</a></li>
									<li class="cus-sel-opt "><a class="cus-sel-opt-txt" data-value="5" href="#">小巧</a></li>
									<li class="cus-sel-opt "><a class="cus-sel-opt-txt" data-value="6" href="#">运动型</a></li>
									<li class="cus-sel-opt "><a class="cus-sel-opt-txt" data-value="7" href="#">健美</a></li>
									</ol>
									</div>
								</td>
							</tr>
						</tbody>
					</table> 
					<input type="submit" class="setting-submit-btn setting-submit-ml100" value="保存"> 
				</form>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	function showTag(){
		var element = event.target||event.srcElement;
		var _this = this;
		debugger
		/* 		<div id="pUserNamePopup" class="username-menu inactive">
		<a href="https://www.baidu.com/p/%E4%BB%99%E6%A1%83%E8%81%8C%E9%99%A2%E4%B8%B6%E5%86%AF%E8%99%B9" class="log-myhome bdown">我的主页</a> 
		<a href="https://www.baidu.com/p/setting/profile/basic" target="tiebaPrivacySetting" class="log-page-setting bdown" id="tieba_privacy_link">主页设置</a>  
		<a href="http://passport.baidu.com/center" class="pass-center bdown">帐号设置</a>  
		<a href="https://passport.baidu.com/?logout&amp;u=https%3a%2f%2fpassport.baidu.com&amp;tpl=pp" class="log-lgout">退出</a> 
		</div>  */
	}
	function hideTag(){
		var element = event.target||event.srcElement;
		debugger
	}
</script>
</html>