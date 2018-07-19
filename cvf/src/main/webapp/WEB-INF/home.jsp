<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="" name="description" />
<meta content="" name="author" />
<title></title>
<!-- 引入easyUi默认的CSS格式--蓝色 -->  
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/easyui/themes/default/easyui.css" />  
<!-- 引入easyUi小图标 -->  
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/easyui/themes/icon.css" /> 
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/layer/theme/default/layer.css" /> 
<script type="text/javascript">
var CONTEXTPATH = '${CONTEXTPATH}';
</script>
<style type="text/css">
ul{
	list-style: none;
}
.westBar li span{
	font-size: 20px;
	height:20px;
	width:20px;
	display:inline-block;
}

.westBar li,a{
	text-decoration : none;
	cursor: pointer;
}
.westBar li:active{
	background-color:#CAC6C6;
}
.pass-userpanel li:hover{color:blue;}
.pass-userpanel li{
	margin-top: 8px;
}
.westBar li:hover{color:red;}
.westBar li:link{color:blue;}
.westBar li:visited{
    text-decoration: none;
    color: #900b09;
    background: transparent;
    border-bottom: 1px solid #CAC6C6;
}
.active{
	background-color:#CAC6C6;
}
#username{cursor: pointer;}
#username :hover{color:blue;}
.weather{
	float:left;
	width: 540px;
	height: 40px;
}
.w10_l,.w11_l,.w12_l,.w13_l,.w14_l,.w16_l,.w19_l,.w20_l,.w26_l,.w28_l,.w32_l,.w37_l,.w39_l,.w40_l,.w41_l,.w42_l,.w60_l,.w61_l,.w62_l,.w63_l,.w64_l,.w65_l {
    background-position: -200px -50px;
    display: block;
	width: 40px;
    height: 40px;
    background: url(./resources/images/w_day40.png) no-repeat;
}
.w10_l{background-position:0px 0px;}
.w11_l{background-position:-50px 0px;}
.w12_l{background-position:-100px 0px;}
.w13_l{background-position:-150px 0px;}
.w14_l{background-position:-200px 0px;}
.w16_l{background-position:0 -50px;}
.w19_l{background-position:-50px -50px;}
.w20_l{background-position:-100px -50px;}
.w26_l{background-position:-150px -50px;}
.w28_l{background-position:-200px -50px;}
.w32_l{background-position:0px -100px;}
.w37_l{background-position:-50px -100px;}
.w39_l{background-position:-100px -100px;}
.w40_l{background-position:-150px -100px;}
.w41_l{background-position:-200px -100px;}
.w42_l{background-position:0px -150px;}
.w60_l{background-position:-50px -150px;}
.w61_l{background-position:-100px -150px;}
.w62_l{background-position:-150px -150px;}
.w63_l{background-position:-200px -150px;}
.w64_l{background-position:0px -200px;}
.w65_l{background-position:-50px -200px;}
.line1{
	padding-left: 60px;
	margin-top: -25px;
}
.region{
	cursor: pointer;
}
.region:hover {
	color:red;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
		<div class="weather">
			<span class="w28_l"></span>
			<div class="line1">
				<em class="piece region">武汉&nbsp;&nbsp;</em>
				<em class="piece">今天&nbsp;&nbsp;</em>
				<em class="piece status">${type}&nbsp;&nbsp;</em>
				<em class="piece" id="J_todayTemp">${weather}</em>
			</div>
		</div>
		<div style="float: right;margin-right: 40px;">
			<ul class="dropdown-menu">
		        <li id="username" class="dropdown-header header-nav-current-user">
		          		用户： <strong class="css-truncate-target">程占波</strong>
		        </li>
      		</ul>
    		<div class="mod-banner" id="setting" style="display: none;position: fixed;right:34px;top:35px;">
				<div id="userbar-panel-list" >
					<ul class="pass-userpanel clearfix">
						<li class="pass-list pass-list-1"><a target="_blank">首页</a></li>
						<li class="pass-list pass-list-1"><a target="_blank">帐号设置</a></li>
						<li class="pass-list pass-list-2"><a class="pass-item">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单'" style="width:15%;padding:10px;overflow-x:hidden; ">
		<div title="搜索菜单" data-options="iconCls:'icon-search',collapsed:false,collapsible:false" style="width:100%;padding: 10px;height: 3%;">  
        	<input id="layout_west_sc" class="easyui-searchbox" data-options="prompt:'请输入你需要的菜单'" style="width:80%;">  
    	</div>
		<!-- according -->
		<div class="easyui-accordion" style="width:100%;height: 94%;"  >
			<div title="用户信息管理" data-options="iconCls:'icon-edit'" style="padding:10px;">
				<div data-options="fit:true,collapsible:false" style="padding:10px;">
					<ul class="westBar" id="admin">
						 <li data-link='${CONTEXTPATH }/rest?page=log/applog'><span class="icon-search"></span>程序日志</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=demo/templet'><span class="icon-search"></span>用户管理</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=index'><span class="icon-search"></span>角色管理</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=fileshow'><span class="icon-search"></span>文件查看</li>
	                     <li data-link='${CONTEXTPATH }/personal'><span class="icon-search"></span>个人信息</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=chart/map'><span class="icon-search"></span>天气详情</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=system/syslist'><span class="icon-search"></span>vue</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=system/adduser'><span class="icon-search"></span>bootrap</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=views/memory'><span class="icon-search"></span>时光轴</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=show/uimage'><span class="icon-search"></span>图片墙</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=show/listimages'><span class="icon-search"></span>搜索</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=chart/jsplumb'><span class="icon-search"></span>jsplumb</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=chat/chathome'><span class="icon-search"></span>聊天室</li>
 	                     <li data-link='${CONTEXTPATH }/rest?page=file/bigfile'><span class="icon-search"></span>大文件上传</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=file/imageUpload'><span class="icon-search"></span>图片上传</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=file/multiPicker'><span class="icon-search"></span>多文件上传</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=file/mutlfile'><span class="icon-search"></span>多文件</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=file/upload'><span class="icon-search"></span>上传</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=ace/index'><span class="icon-search"></span>ace/index</li>
	                     <li data-link='${CONTEXTPATH }/rest?page=auth'><span class="icon-search"></span>auth</li>
	                     <li data-link='${CONTEXTPATH }/mysql/host'><span class="icon-search"></span>tree</li>
	                 </ul>
                 </div>
			</div>
			<div title="成长日志" data-options="iconCls:'icon-man'" style="padding:10px;">
			</div>
			<div title="文件管理" data-options="iconCls:'icon-save'" style="padding:10px;">
			</div>
			<div title="帮助" data-options="iconCls:'icon-help'" style="padding:10px;"></div>
			<div title="模板" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
				<div style="width: 100%;height: 100px;overflow-y:auto;background: #aaa;">
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="admin_tabs" class="easyui-tabs" data-options="fit:true">
		</div>
	</div>
</body>
<!-- 引入Jquery -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.min.js" charset="utf-8"></script>  
<!-- 引入Jquery_easyui -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<!-- 引入easyUi国际化--中文 -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- 三级省市联动 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/city.js" charset="utf-8"></script>
<!-- layer弹框 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/layer/layer.js" charset="utf-8"></script>
<script type="text/javascript">
var isClick = true;
$(function(){
	$("#setting,#username").bind('mouseover',function(){
		$("#setting").show();
	});
	$("#setting,#username").bind('mouseout',function(){
		$("#setting").hide();
	});
	
	$(".region").bind('click',function(){
		if(isClick){
			var showHtml = '<div style="margin-top:28px;"><select name="s_province" id="s_province" style="width: 100px;height:28px;margin-left:18px;"></select>'+
			'<select name="s_city" id="s_city" style="width: 100px;height:28px;margin-left:8px;"></select>'+
			'<select name="s_county" id="s_county" style="width: 100px;height:28px;margin-left:8px;"></select></div>';
			layer.open({
				type: 1,
				area: ['400px','88px'],
				shade: false,
				title: false,
				content: showHtml,
				success: function(layero, index){
					isClick = false;
					_init_area();

				},
				cancel:function(index){
					isClick = true;
					var s_province = $("#s_province option:selected").text();
					var s_city = $("#s_city option:selected").text();
					var s_county = $("#s_county option:selected").text();
					if(s_province!='省份'){
						$(".piece.region").html(s_province+"&nbsp;&nbsp;");
					}
					if(s_city!='地级市'){
						$(".piece.region").html(s_city+"&nbsp;&nbsp;");
					}
					if(s_county!='市、县级市'){
						$(".piece.region").html(s_county+"&nbsp;&nbsp;");
					}
					//进行天气查询
					
					//页面设置websocket 每一个小时进行刷新一次当前天气情况
				},yes:function(index){
					
				}
			});
		}
	})
})
function showSetting(){
	$("#setting").show();
}
function hideSetting(){
	$("#setting").hide();
}
	var menus = ['权限表','角色权限表','角色','组权限表','组角色表','用户权限表','组','用户组表','用户角色表','用户表','组织表','操作日志表'];
	var sources = ['查看用户','增加用户','修改用户','删除用户','权限设置','角色分配管理','组分配管理'];
	var files = ['创建文件','删除文件','编辑文件','文件夹搜索','文件搜索','文件权限分配'];
	$(function(){
	    $("ul.westBar li").on("click", treeClick)
	});
	function treeClick(){
        // 添加选中样式
        $("ul.westBar li").removeClass('active');
        $(this).addClass('active');
        var title = $(this).text();
		var url = $(this).attr('data-link');
		var name = $(this).attr("name");
		var iconCls = $(this).attr('data-icon');
		addTabs(title,url,iconCls,name);
	}
	function addTabs(title,url,iconCls,name){
	    if($('#admin_tabs').tabs('exists',title)){ // 处理已打开过的tab
	        $('#admin_tabs').tabs('select',title);
	        return;
	    }
	    var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		$('#admin_tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
</script>
</html>