<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
.westBar li:hover   {color:red;}
.westBar li:link    {color:blue;}
.westBar li:visited{
    text-decoration: none;
    color: #900b09;
    background: transparent;
    border-bottom: 1px solid #CAC6C6;
}
.active{
	background-color:#CAC6C6;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
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
	                     <li data-link='${CONTEXTPATH }/templet.jsp'><span class="icon-search"></span>用户管理</li>
	                     <li data-link='${CONTEXTPATH }/page.do?page=index'><span class="icon-search"></span>角色管理</li>
	                     <li data-link='${CONTEXTPATH }/page.do?page=views/personaledit'><span class="icon-search"></span>权限管理</li>
	                     <li data-link='${CONTEXTPATH }/page.do?page=views/personaledit'><span class="icon-search"></span>个人信息查看</li>
	                     <li data-link='${CONTEXTPATH }/page.do?page=fileupload'><span class="icon-search"></span>文件查看</li>
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
<!-- 	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div> -->
<!--  	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;"></div>  -->
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
<script type="text/javascript">
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
/* 	    $('#admin_tabs').tabs('add',{
	        title: title,
	        href:url,
	        //content:<iframescrolling="yes" frameborder="0" src=""style="width:100%;height:100%;"></iframe>',
	        iconCls: iconCls,
	        closable: true,
	        fit:true
			//cls:'pd3',
			//closable:true,
	    }); */
	}
</script>
</html>