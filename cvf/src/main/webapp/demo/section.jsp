<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- ztree样式 -->
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/ztree/css/zTreeStyle/zTreeStyle.css" />
<title>section使用</title>
<style type="text/css">
.headtitle{
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	width: 100%;
	height: 80px;
	background: #0382AD;
}
.footer{
	position: absolute;
	bottom: 0;
	right: 0;
	left: 0;
	background:#111111;
	height: 40px;
	width: 100%;
}
.bj{
    position: absolute;
    top: 90px;
    right: 0;
    bottom: 50px;
    left:0;
    margin: 0 10px;
    text-align: left;
    background: #0382AD;
}

.menu{
	position: absolute;
	width:270px;
	top: 0;
	left: 0;
	bottom: 0;
	float: left;
	border: 1px solid #ccc;
	background: #f9f9f9;
	box-shadow:0 0 5px rgba(0,0,0,.3);
	overflow: auto;
}
.main{
	position: absolute;
	left: 280px;
	top: 0;
	right: 0;
	bottom: 0;
	border: 1px solid #ccc;
	background: #f9f9f9;
	box-shadow:0 0 5px rgba(0,0,0,.3);
}
</style>
<script type="text/javascript">
var CONTEXTPATH = '${CONTEXTPATH}';
</script>
</head>
<body>
	<header class="headtitle"></header>
	<section class="bj">
 		<section class="main"></section>
		<aside class="menu">
			<ul id="tree" class="ztree" style="margin-top:0px;width:210px;height:100%;padding:0px;"></ul>
		</aside>
	</section>
	<footer class="footer"></footer>
</body>


<!-- 引入Jquery -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.min.js" charset="utf-8"></script>  

<!-- ztree 引入 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/ztree/jquery.ztree.all-3.5.min.js" charset="utf-8"></script>

<!-- 全国城市街道数据加载 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/tree.js" charset="utf-8"></script>

</html>