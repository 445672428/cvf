<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="" name="description" />
<meta content="" name="author" />
<title>文件目录</title>
<!-- 引入easyUi默认的CSS格式--蓝色 -->  
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/easyui/themes/default/easyui.css" />  
<!-- 引入easyUi小图标 -->  
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/easyui/themes/icon.css" /> 
<!-- ztree样式 -->
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/ztree/css/zTreeStyle/zTreeStyle.css" />
<!-- jquery-ui样式 -->
<link rel="stylesheet" href="${CONTEXTPATH }/resources/lib/jquery-ui/jquery-ui.css">

<style type="text/css">
.filecontainer{
	width: 80px;
	height: 100px;
	float: left;
	margin: 10px 0px 0px 10px;
}
.filecontainer input{
	cursor: hand;
}
.fileDiv{
	width: 80px;
	height: 80px;
	background-size:100% 100%;
	cursor: pointer;
}
.fileinput{
	height:20px;
	width: 100%;
	text-align: center;
	margin-top	: -8px;
	border: 0px;
}
div.fileDiv img{
	width: 100%;
	height: 100%;
	max-height: 80px;
	max-width: 80px;
	background: clear;
}
#hand{
	float:right;
	height: 100%;
	list-style-type: none;
	margin: 0px;
}
#hand li{
	margin: 7px;
	padding: 5px;
	float: left;
	width: 60px;
	height: 70%;
}
.gzv8Pv{
	width: 16px;
	height: 16px;
	margin: 0px;
	padding: 0px;
	display: compact;
	position:absolute;
	visibility:hidden;
	cursor:pointer;
	background: url("${CONTEXTPATH }/resources/lib/easyui/themes/icons/delete3.png") no-repeat;
}

.search{
	background: url("${CONTEXTPATH }/resources/images/search.gif") no-repeat;
	background-size:100% 100%;
}
.filedel{
	background: url("${CONTEXTPATH }/resources/images/workdel.gif") no-repeat;
	background-size:100% 100%;
}
.del{
	background: url("${CONTEXTPATH }/resources/images/filedel.gif") no-repeat;
	background-size:100% 100%;
}
.printfile{
	background: url("${CONTEXTPATH }/resources/images/print.gif") no-repeat;
	background-size:100% 100%;
}
</style>
<script type="text/javascript">
var CONTEXTPATH = '${CONTEXTPATH}';
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center'">
		<div class="easyui-panel" style="height:10%;width: 100%;overflow-y:hidden;">
			<ul id="hand">
				<li onclick="showSearchWindow();" class="search"></li>
				<li onclick="deletePageALLFile();" class="del"></li>
				<li onclick="exportAll();" class="printfile"></li>
			</ul>
		</div>
		<div id="hotleinfo" class="easyui-panel" style="height:90%;padding:10px;width: 100%;">
			<div class="portlet-body">
 			</div>
		</div>
	</div>
	
	<div id="createPanle" class="easyui-menu" style="width:120px;">
		<div onclick="javascript:editHandle()">创建文件夹</div>
		<div onclick="javascript:editHandle()">创建文本文件</div>
		<div data-options="iconCls:'icon-print'">打印</div>
		<div>取消</div>
	</div>
<!-- <div id="searchWindow" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save'" style="width:70%;height:80%;padding:10px;"></div>
 -->
</body>
<!-- 引入Jquery -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.min.js" charset="utf-8"></script>  
<!-- jquery-ui -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jquery-ui/jquery-ui.js" charset="utf-8"></script>
<!-- 引入Jquery_easyui -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<!-- 引入easyUi国际化--中文 -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- ztree 引入 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/ztree/jquery.ztree.all-3.5.min.js" charset="utf-8"></script>
<!-- 公共js 引入 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/common.js" charset="utf-8"></script>
<!-- 全国城市街道数据加载 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/tree.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/inputEvent.js?ver=<%=new Date().getTime() %>" charset="utf-8"></script>
</html>