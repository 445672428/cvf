<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>授权页面</title>
<script type="text/javascript">
	var CONTEXTPATH='${pageContext.request.contextPath}';
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/reset.css" charset="utf-8"> --%>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/jQuery/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/js/bootstrap-treeview.min.js"></script>

<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/ztree/css/metroStyle/metroStyle.css" />
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/ztree/jquery.ztree.all-3.5.min.js" charset="utf-8"></script>

<style>
	body{
	    margin:0; 
	    padding:0;
	    font-family: Lato,Helvetica,Arial,sans-serif;
        font-size: 14px;
        line-height: 1.72222;
        color: #34495e;
        background-color: #fff;
	}
	.wrap {
	        min-width: 100%;
	        position: absolute;
	        background: #eff3f6 bottom;
	        min-height: 100%;
	        overflow: hidden;
	    }
	.left{
	    margin-left:0px;
	        position: absolute;
	        box-sizing: border-box;
	        width: 200px;
	        height: 100%;
	        background: #4d5e70 bottom;
	    }
    .logoDiv{
        padding-top: 20px;
        padding-bottom: 20px;
        height: 70px;
        background-color: #354457;
        font-size: 17px;
        color: #fff;
        vertical-align: bottom;    
    }
    .logoTitle{
        margin-left:15px;
        line-height: 1.7;
    }
    .menu-title {
        margin-left:15px;
        color: #828e9a;
        padding-top: 10px;
        padding-bottom: 10px;
        font-size: 14px;
        font-weight: bold;
    }
    .menu-item {
        padding-left:15px;
        line-height: 40px;
        height: 40px;
        color: #aab1b7;
        cursor: pointer;
    }
    .menu-item-active {
        background-color: #3d4e60;
        border-right: 4px solid #647f9d;
        color: #fff;
    }
    .right{
        box-sizing: border-box;
        float: left;
        box-sizing: border-box;
        padding-left: 200px;
        overflow-y: overlay;
        overflow-x: hidden;
        clear: both;
        background-color: #F5F5F5;
        /* color: #F5F5F5; */
        min-width: 100%;
        min-height: 500px;
    }
    .center1{
    	margin: 0 auto;
	    width: 894px;
	    padding: 0 8px 50px 0;
	    border-left: 4px solid #eceff1;
	    border-right: 4px solid #eceff1;
	    background: #fff;
	    min-height: 450px;
	    _height: auto;
	    overflow: hidden;
	    position: relative;
	    display: block;
    }
    .inputfile {
        opacity: 0;
        position:absolute;clip:rect(0 0 0 0);
        z-index: -11111;  width: 0px;  height: 1px;
    }
    .management ul.ulp {
	    padding-top: 20px;
	}
	.management ul {
	    border: 2px solid #fff;
	}
	.management ul {
	    padding: 20px 0 0 0;
	}
	ul {
	    list-style: none;
	    padding: 0;
	    margin: 0;
	}
	.management li blockquote {
	    float: left;
	    width: 210px;
	    padding: 8px 3px 0 0;
	    font-size: 14px;
	    text-align: right;
	}
	.management li {
	    clear: both;
	    width: 693px;
	    padding: 0 0 17px 0;
	    display: block;
	    overflow: hidden;
	}
	.select_text, .select_text1 {
	    width: 275px;
	    height: 29px;
	    border: 1px solid #3197b5;
	    padding: 0 0 0 5px;
	    font-size: 14px;
	    color: #333;
	    background: #fff;
	}
	.input_text, .input_text1, .input_text2 {
	    width: 275px;
	    height: 29px;
	    line-height: 29px;
	    padding: 0 5px;
	    border: 1px solid #3197b5;
	    font-size: 14px;
	    color: #333;
	    background: #fff;
	}
	.management li .tips_info, .tips_info_orange, .tips_info_suc {
	    position: absolute;
	    margin: 6px 0 0 5px;
	    line-height: 19px;
	    _line-height: 20px;
	    padding-left: 20px;
	    background-position: 0 -72px;
	    color: #f9590d;
	}
	.eSize{
		width: 100%;
		min-height: 440px;
		height:100%;
		border: 1px solid #3197b5;
	}
	#six table th{
		text-align: center;
	}
	#six table td, .tree{
		width: 300px;
		height: 100%;
	}
	.tree{
		overflow-y:auto; 
	}
	.groupTree{
		display:none;
		width: 250px;
		height: 500px;
		overflow-y: overlay; 
		position: absolute;
		margin-left: 170px;
		margin-top: -31px;
	}
</style>
</head>
<body>
<div class="wrap">
      <!-- 左边内容 -->
      <div id="left" class="left">
          <div id="logoDiv" class="logoDiv">
              <p id="logoTitle" class="logoTitle">
                  <img id="logo" alt="左右布局" src="http://tool.what21.com/page/image/menu/cf.png"
                          style="height: 28px; padding-right: 5px;vertical-align: middle;">
                  <span style="font-size:18px;">左右布局</span>
              </p>
          </div>
          <div class="menu-title">基础信息管理</div>
          <div class="menu-item" href="#one" data-toggle="tab">
               －组织信息录入
          </div>
          <div class="menu-item" href="#two" data-toggle="tab">
               －人员信息录入
          </div>
          <div class="menu-item" href="#three" data-toggle="tab">
               －资源类型录入
          </div>
          <div class="menu-item" href="#four" data-toggle="tab">
               －要素信息录入
          </div>
          <div class="menu-title">应用系统管理</div>
          <div class="menu-item" href="#five" data-toggle="tab">
               －系统资源管理
          </div>
          <div class="menu-title">权限授予管理</div>
          <div class="menu-item" href="#six" data-toggle="tab">
               －用户管理
          </div>
          <div class="menu-item" href="#seven" data-toggle="tab">
               －权限管理
          </div>
          <div class="menu-item" href="#eight" data-toggle="tab">
               －资源分配
          </div>
      </div>
      <!-- 右边内容 -->
      <div id="right" class="tab-content right">
           <div id="one" class="tab-pane active management">
           			<form id="groupform" action="${pageContext.request.contextPath }/permission/group" enctype="multipart/form-data" method="POST">
           				<ul class="ulp">
	           				<li>
								<blockquote><b>*</b> 名称：</blockquote>
								<input name="groupname" type="text" class="input_text" size="26" maxlength="100" onpaste="return false"/>
							</li>
							<li>
								<blockquote><b>*</b> 简介：</blockquote>
								<textarea  rows="3" style="width: 275px;" name="groupbrief" placeholder="请填写简介..."></textarea>
							</li>
							<li>
								<blockquote><b>*</b> 所属组织：</blockquote>
								<input id="parentgroupname" class="input_text" onclick="showGroupTree()" style="cursor: pointer;" type="text" placeholder="不填为独立组织..." autoComplete="off" readonly="readonly" />
		        				<input id="groupparentid" name="groupparentid" type="hidden" value="" />
		        				<div id="groupTree" class="groupTree"></div>
							</li>
							<li>
								<blockquote><b>*</b> 详情：</blockquote>
								<textarea rows="3" style="width: 275px;" name="groupdetails" placeholder="请填写具体详情..."></textarea>
							</li>
							<li>
								<blockquote><b>*</b> 组织图标：</blockquote>
	        					<input type="file" name="file" id="file" onchange="changepic(this)" class="inputfile" accept="image/png, image/jpeg, image/gif, image/jpg" /> 
								<label for="file" class='btn btn-success'>选择一个log图标</label>
								<img src="" id="show" style="width: 60px;">
							</li>
							<li>
								<div class="col-xs-6 text-right">
									<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-floppy-save"></span> 点击保存</button>
								</div>
							</li>
           				</ul>
        			</form>

					<div data-role="fieldcontain">
					    <div id="localImag">
					        <img id="preview" width="-1" height="-1" style="display: none" />
					    </div>
					</div>
					<button id="stop">guanbi</button>
					<button id="start" onclick="startMediaStream()">kaiqi</button>
        			<div class="booth" style="   width:400px;background:#ccc;border: 10px solid #ddd;margin: 0 auto;">
					    <video id="video" width="400" height="300"></video>
					    <button id='tack'> snap shot</button>
					    <canvas id='canvas' width='400' height='300'></canvas>
					    <img id='img' src=''>
				    </div>
           </div>
           <div id="two" class="tab-pane management">
           		<form id="stafffrom" action="${pageContext.request.contextPath }/permission/staff" method="POST">
					<ul class="ulp">
						<li>
							<blockquote><b>*</b> 真实姓名：</blockquote>
							<input type="text" name="txtName" id="txtName" class="input_text" size="26" maxlength="20" onpaste="return false">
							<span id="infoName" style="display:none" class="tips_info">您还没有输入真实姓名</span>
							<span id="infoNameText" style="display:none" class="tips_info">请输入中文或英文姓名</span>
						</li>
						<li>
							<blockquote>详细地址：</blockquote>
							<input type="text" name="txtAddress" id="txtAddress" size="26" maxlength="24" class="input_text" value="">
						</li>
						<li>
						    <blockquote>证件类型：</blockquote>
							<select id="card_type" name="card_type" class="select_text">
								<option value="1">身份证</option>
								<option value="2">护照</option>
							</select>
						</li>
						<li>
							<!-- <blockquote>您的证件号码：</blockquote> -->
							<blockquote><b>*</b> 证件号码：</blockquote>
							<input type="text" name="txtIDCard" id="txtIDCard" size="26" maxlength="18" class="input_text" value="" style="ime-mode:disabled;color:#999999" onpaste="return false">        
							<span id="infoNoCard" style="display:none" class="tips_info">您还没有输入证件号码</span>
							<span id="infoCard" style="display:none" class="tips_info">您输入的证件号码格式错误</span>
						</li>
						
						 <li>
							<blockquote><b></b> 手机号码：</blockquote>
							<input name="txtMob" id="txtMob" type="input_text" class="input_text" style="ime-mode:disabled;color:#333;" maxlength="11" >
							<span id="errMobile" class="tips_info" style="display:none">请正确填写手机号码</span>
						</li>
						
						<li>
							<blockquote><b></b> 邮箱账号：</blockquote>
							<input name="txtEmail" id="txtEmail" type="input_text" class="input_text" style="ime-mode:disabled;color:#333;" maxlength="11" >
							<span id="errMobile" class="tips_info" style="display:none">请正确填写邮箱账号</span>
						</li>
						
						<li>
							<div class="col-xs-6 text-right">
				              	<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-floppy-save"></span> 点击提交</button>
				            </div>
						</li>
					</ul>
				</form>
           </div>
           <div id="three" class="tab-pane management">
           		<form id="sourceform" action="${pageContext.request.contextPath }/permission/source" method="POST">
					<ul class="ulp">
						<li>
						    <blockquote>资源种类：</blockquote>
							<select id="card_type" name="card_type" class="select_text">
								<option value="1">自然资源</option>
								<option value="2">社会资源</option>
							</select>
						</li>
						<li>
							<blockquote>资源所属：</blockquote>
							<input type="text" name="sourceType" id="sourceType" size="26" maxlength="24" class="input_text" value="">
						</li>
						<li>
							<blockquote>资源名称：</blockquote>
							<input type="text" name="sourceName" id="sourceName" size="26" maxlength="24" class="input_text" value="">
						</li>
						<li>
							<div class="col-xs-6 text-right">
				              	<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-floppy-save"></span> 点击提交</button>
				            </div>
						</li>
					</ul>
				</form>
           </div>
           <div id="four" class="tab-pane management">
           		 <form id="elementform" action="${pageContext.request.contextPath }/permission/element" method="POST">
					<ul class="ulp">
						<li>
							<blockquote>要素名称：</blockquote>
							<input type="text" name="elementName" id="elementName" size="26" maxlength="24" class="input_text" value="">
						</li>
						<li>
						    <blockquote>要素所属：</blockquote>
							<select id="card_type" name="card_type" class="select_text">
								<option value="1">自然资源</option>
							</select>
						</li>
						<li>
							<div class="col-xs-6 text-right">
				              	<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-floppy-save"></span> 点击提交</button>
				            </div>
						</li>
					</ul>
				</form>
           </div>
           <div id="five" class="tab-pane">
           		<form  id="appform" action="${pageContext.request.contextPath }/permission/app" method="POST">
					<ul class="ulp">
						<li>
							<blockquote>应用名称：</blockquote>
							<input type="text" name="appName" id="appName" size="26" maxlength="24" class="input_text" value="">
						</li>
						<li>
							<blockquote>应用别名：</blockquote>
							<input type="text" name="appAliasName" id="appAliasName" size="26" maxlength="24" class="input_text" value="">
						</li>
						<li>
						    <blockquote>URL功能名称：</blockquote>
							<input type="text" name="urlFunctionName" id="urlFunctionName" size="26" maxlength="254" class="input_text" value="" placeholder="请填写对应应用的绝对URL" />
						</li>
						<li>
						    <blockquote>访问资源URL：</blockquote>
							<input type="text" name="urlName" id="urlName" size="26" maxlength="254" class="input_text" value="" placeholder="请填写对应应用的绝对URL" />
						</li>
					</ul>
				</form>
           </div>
           <div id="six" class="tab-pane">
           		<table class="eSize">
           			<thead>
           				<tr>
           					<th>组织</th><th>部门</th><th>角色</th><th>人员</th>
           				</tr>
           			</thead>
           			<tbody>
	           			<tr>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree1"></ul>  
				                </div>
	           				</td>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree2"></ul>  
				                </div>
	           				</td>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree3"></ul>  
				                </div>
	           				</td>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree4"></ul>  
				                </div>
	           				</td>
	           			</tr>
           			</tbody>
           		</table>
           		<table class="eSize">
           			<thead>
           				<tr><th>权限</th><th>菜单</th><th>页面元素</th><th>功能操作</th></tr>
           			</thead>
           			<tbody>
	           			<tr>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree5"></ul>  
				                </div>
	           				</td>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree6"></ul>  
				                </div>
	           				</td>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree7"></ul>  
				                </div>
	           				</td>
	           				<td>
	           					<div class="col-xs-2 tree">  
				                    <ul class="ztree" id="ztree8"></ul>  
				                </div>
	           				</td>
	           			</tr>
           			</tbody>
           		</table>
           </div>
           <div id="seven" class="tab-pane" style="background: #F5F5F5;background-color: #F5F5F5;">
           		<ul class="list-group list-unstyled list-inline">
           			<li class="list-group-item">组织</li>
				    <li class="list-group-item">部门</li>
				    <li class="list-group-item">角色</li>
				    <li class="list-group-item">人员</li>
				    <li class="list-group-item">菜单</li>
				    <li class="list-group-item">页面元素</li>
				    <li class="list-group-item">功能操作</li>
           		</ul>
           
				<div id="menuContent" class="menuContent" style="width:95%;border:1px solid rgb(170,170,170);z-index:10;">
				  <ul id="treeDemo" class="ztree" style="margin-top:0; width:100%; height:auto;"></ul>
				 </div>

           </div>
           <div id="eight" class="tab-pane">
            
            <div id="procitytree" style="height: 400px;overflow-y :scroll;"></div>
            </div>
           </div>
      
</div>
<!-- 个人信息采集 -->
<script type="text/javascript">
var mediaStreamTrack;
var video = document.getElementById('video'),
canvas = document.getElementById('canvas'),
snap = document.getElementById('tack'),
img = document.getElementById('img'),
vendorUrl = window.URL || window.webkitURL;
function startMediaStream(){
	//媒体对象
	navigator.getMedia = navigator.getUserMedia ||navagator.webkitGetUserMedia ||navigator.mozGetUserMedia ||navigator.msGetUserMedia;
	if (navigator.getUserMedia) { // 标准的API
		navigator.getMedia({
			video: true, //使用摄像头对象
			audio: false  //不适用音频
		}, function(stream){
			mediaStreamTrack = typeof stream.stop === 'function' ? stream : stream.getTracks()[0]; 
			video.src = vendorUrl.createObjectURL(stream);
			video.play();
		}, function(error) {
			console.log(error);
		});
	} else if (navigator.webkitGetUserMedia) { // WebKit 核心的API
		navigator.webkitGetUserMedia({ "video": true }, function (stream) {
			mediaStreamTrack = typeof stream.stop === 'function' ? stream : stream.getTracks()[0]; 
		    video.src = window.webkitURL.createObjectURL(stream);
		    video.play();
		}, function(error){
			console.log(error);
		});
	}
	
}

document.getElementById("stop").addEventListener("click", function () {  
    mediaStreamTrack && mediaStreamTrack.stop();  
});  
/* document.getElementById("picture").addEventListener("click", function () {  
    var context = document.getElementById("canvas").getContext("2d");  
    context.drawImage(video, 0, 0, 320, 320);  
}); */




snap.addEventListener('click', function(){
	//绘制canvas图形
	canvas.getContext('2d').drawImage(video, 0, 0, 400, 300);
	//把canvas图像转为img图片
	img.src = canvas.toDataURL("image/png");
});


 

</script>


<script type="text/javascript">
var zNodes = [
     		 { id: 1, pId: 0, name: "父节点1", open: true },
     		 { id: 11, pId: 1, name: "父节点11" },
     		 { id: 111, pId: 11, name: "叶子节点111" },
     		 { id: 112, pId: 11, name: "叶子节点112" },
     		 { id: 113, pId: 11, name: "叶子节点113" },
     		 { id: 114, pId: 11, name: "叶子节点114" },
     		 { id: 12, pId: 1, name: "父节点12" },
     		 { id: 121, pId: 12, name: "叶子节点121" },
     		 { id: 122, pId: 12, name: "叶子节点122" },
     		 { id: 123, pId: 12, name: "叶子节点123" },
     		 { id: 124, pId: 12, name: "叶子节点124" },
     		 { id: 13, pId: 1, name: "父节点13", isParent: true },
     		 { id: 2, pId: 0, name: "父节点2" },
     		 { id: 21, pId: 2, name: "父节点21", open: true },
     		 { id: 211, pId: 21, name: "叶子节点211" },
     		 { id: 212, pId: 21, name: "叶子节点212" },
     		 { id: 213, pId: 21, name: "叶子节点213" },
     		 { id: 214, pId: 21, name: "叶子节点214" },
     		 { id: 22, pId: 2, name: "父节点22" },
     		 { id: 221, pId: 22, name: "叶子节点221" },
     		 { id: 222, pId: 22, name: "叶子节点222" },
     		 { id: 223, pId: 22, name: "叶子节点223" },
     		 { id: 224, pId: 22, name: "叶子节点224" },
     		 { id: 23, pId: 2, name: "父节点23" },
     		 { id: 231, pId: 23, name: "叶子节点231" },
     		 { id: 232, pId: 23, name: "叶子节点232" },
     		 { id: 233, pId: 23, name: "叶子节点233" },
     		 { id: 234, pId: 23, name: "叶子节点234" },
     		 { id: 3, pId: 0, name: "父节点3", isParent: true }
     	];
     	
function initZtree(id,zNodes){
	var setting = {
			 view: {
				 enable : true,  
				 showLine : true,  
				 showIcon : showIconForTreeRight,  
				 addHoverDom: addHoverDom,
				 removeHoverDom: removeHoverDom
			 },
			 check: {
			 	enable: true
			 },
			 data: {
				 simpleData: {
				  	enable: true
				 }
			 },
			 callback : {  
			        onClick : zTreeOnClickRight,  
			        beforeRemove: beforeRemove,  
			        onRename: zTreeOnRename,  
			        onRemove: zTreeOnRemove,  
			 },  
			 edit: {
				enable: true,  
		        showRemoveBtn :true,  
		        showRenameBtn :true,  
		        removeTitle :"删除",  
		        renameTitle :"修改"  
			 }
	};

	function showIconForTreeRight(treeId, treeNode) {  
	    return !treeNode.isParent;  
	}
	function zTreeOnClickRight(event, treeId, treeNode) {  
	    var treeid = zTreeObj.getSelectedNodes()[0].id;  
	    var treepid = zTreeObj.getSelectedNodes()[0].pId;  
	    var treename = zTreeObj.getSelectedNodes()[0].name;  
	}
	  //修改
	function zTreeOnRename(event, treeId, treeNode, isCancel) {  
	    $.post('updateNode.action', {  
	        'classification.id': $.trim(treeNode.id),  
	        'classification.perId': $.trim(treeNode.pId),  
	        'classification.classification': treeNode.name  
	    }, function(data, textStatus, xhr) {  
	        if (textStatus == "success") {  
	        	alert("修改成功");  
	        } else {  
	        	alert("修改失败");  
	        }  
	    });  
	}  
	  //删除
	function zTreeOnRemove(event, treeId, treeNode) {  
		  
	}
	

	this.newCount = 1;
	//添加
	function addHoverDom(treeId, treeNode) {  
	    var sObj = $("#" + treeNode.tId + "_span");  
	    
	    var addBtn = $("#addBtn_" + treeNode.tId);
	    if (treeNode.editNameFlag || addBtn.length > 0) return;  
	    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='新增' onfocus='this.blur();'></span>";  
	  
	    sObj.after(addStr);  
	    var btn = $("#addBtn_" + treeNode.tId);  
	  
	    if (btn) btn.bind("click", function() {  
	        var name = "新增节点" + (newCount++); 
            if ("success" == "success") {  
                var newID = '1000';  
                zTreeObj.addNodes(treeNode, {  
                    id: newID,  
                    pId: treeNode.id,  
                    name: name  
                });  
                var node = zTreeObj.getNodeByParam("id", newID, null); //根据新的id找到新添加的节点  
                zTreeObj.selectNode(node); //让新添加的节点处于选中状态+  
            } else {  
            	alert("加载错误");  
            }  
	  
	        return false;  
	    });  
	}  
	function removeHoverDom(treeId, treeNode) {  
	    $("#addBtn_"+treeNode.tId).unbind().remove();  
	} 
	function beforeRemove(treeId, treeNode) {  
	    if(treeNode.isParent){  
	    	alert("请先删除子节点");  
	        return false;  
	    }         
	    return alert("确认删除 节点 -- " + treeNode.name + " 吗？");  
	}  
 
	/** 
	 * 显示ztree 
	 */  
	$("#addcla").click(function(){  
	    var name = "新增根节点" + (newCount++);  
        var newID = data;  
        zTreeObj.addNodes(null, {  
            id: newID,  
            name: name  
        });  
        var node = zTreeObj.getNodeByParam("id", newID, null); //根据新的id找到新添加的节点  
        zTreeObj.selectNode(node); //让新添加的节点处于选中状态+ 
	})
	
    var zTreeObj = $.fn.zTree.init($("#"+id), setting, zNodes);  
    zTreeObj.expandAll(true);  
    return zTreeObj;
}
//$.fn.zTree.init($("#treeDemo"), setting, zNodes); 
		

$(function(){
	var ids = ['ztree1','ztree2','ztree3','ztree4','ztree5','ztree6','ztree7','ztree8'];
	var zTreeObj1 = initZtree('ztree1',zNodes);
	var zTreeObj2 = initZtree('ztree2',zNodes);
	var zTreeObj3 = initZtree('ztree3',zNodes);
	var zTreeObj4 = initZtree('ztree4',zNodes);
	var zTreeObj5 = initZtree('ztree5',zNodes);
	var zTreeObj6 = initZtree('ztree6',zNodes);
	var zTreeObj7 = initZtree('ztree7',zNodes);
	var zTreeObj8 = initZtree('ztree8',zNodes);
	
	
});


</script>

<script type="text/javascript">
function changepic() {
    var reads= new FileReader();
    f=document.getElementById('file').files[0];
    reads.readAsDataURL(f);
    reads.onload=function (e) {
        document.getElementById('show').src=this.result;
    };
}
$(function () {
	  var data = 
	  [
	    {
	      text: "系统设置",
	      href: "#node-1",
	      selectable: true,
	      id: '00',
	      selectable: false,
	      tags: ['available'],
	      nodes: 
	      [
	        { 
	          text: "目录设置",
	          id: '01',
	          nodeId: '01',
	          lazyLoad:true,//本节点为懒加载节点
	        }, 
	        { 
	          text: "爬虫设置",
	          id: '02',
	          lazyLoad:true,
	        }, 
	        { 
	          text: "项目权限",
	          id: '03'
	        }, 
	        { 
	          text: "账号管理",
	          id: '04',
	          selectable: false,
	        }
	      ]
	    }
	  ]

	$('#procitytree').treeview({
	    data: data,         // data is not optional
	    levels: 2,
	    showTags:true,
	    loadingIcon:"fa fa-hourglass",//懒加载过程中显示的沙漏字符图标
	    lazyLoad:loaddata//loaddata为点击懒加载节点目录时，运行的函数名称，把后端的数据添加到这个节点下面
	  }); 
	})

	function loaddata(node,func){//这个技巧真高，即能得到节点数据，又能把节点下级的数据通过函数发回去
	  // alert(node.id);
	  // alert(func);
	  var singleNode = {
	    text: "projcatename2",
	    id:"08",
	  };
	  func(singleNode);//把新的下级节点数据发回到后端，这样明显优雅很多
	  // $("#tree").treeview("addNode", [singleNode,node]);这一句和上面一句等同
	}

$(function(){
	
    $("#stafffrom,#groupform,#sourceform,#elementform,#appform").ajaxForm(function(data){    
    	
     });
	
	var parms = {
	        host : '1',db:'1',user:'1'
	    };
    $.ajax({type: "POST",url: '${CONTEXTPATH }/auth/add2.do',data:JSON.stringify(parms),dataType:'json',
        contentType:'application/json',success: function(data){

       },
       error : function(data){
       
       }
   });
})

</script>
<!-- -----------页面树------------ -->
<script type="text/javascript">

function showGroupTree(){
	$("#groupTree").show();
}
var data = 
	  [
	    {
	      text: "组织列表",
	      selectable: true,
	      icon:"glyphicon glyphicon-stop",
	      selectedIcon:"glyphicon glyphicon-stop",
	      id: '01',
	      nodes: 
	      [
	        { 
	          text: "目录设置",
	          id: '01'
	        }, 
	        { 
	          text: "爬虫设置",
	          id: '02'
	        }, 
	        { 
	          text: "项目权限",
	          id: '03'
	        }, 
	        { 
	          text: "账号管理",
	          id: '04'
	        }
	      ]
	    }
	  ];

	$('#groupTree').treeview({
	    data: data,         
	    levels: 2,
	    showTags:true,
	    onNodeSelected:function(e,args){
	    	$("#groupname").val(args.text);
	    	$("#groupid").val(args.id);
	    }
	  }); 
</script>
</body>
</html>