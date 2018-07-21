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
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/table/bootstrap-table.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/table/bootstrap-editable.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/extensions/tablefixed/bootstrap-table-fixed-columns.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/extensions/datetimepicker/bootstrap-datetimepicker.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/lib/jQuery/jquery.validate.min.css" rel="stylesheet" />


<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/jQuery/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/js/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/table/bootstrap-table.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/table/bootstrap-editable.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/extensions/tablefixed/bootstrap-table-fixed-columns.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/extensions/editable/bootstrap-table-editable.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/extensions/datetimepicker/bootstrap-datetimepicker.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/extensions/datetimepicker/bootstrap-datetimepicker.zh-CN.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/table/locale/bootstrap-table-zh-CN.js" charset="utf-8"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/jQuery/jquery.validate.min.js" charset="utf-8"></script> 


<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/ztree/css/metroStyle/metroStyle.css" />
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/ztree/jquery.ztree.all-3.5.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/utils/base64.js" charset="utf-8"></script>


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
<!--           <div id="logoDiv" class="logoDiv">
  
          </div> -->
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
          <div class="menu-item" href="#seven" data-toggle="tab">
               －数据库管理
          </div>
          <div class="menu-item" href="#eight" data-toggle="tab">
               －数据表创建
          </div>
          <div class="menu-title">权限授予管理</div>
          <div class="menu-item" href="#six" data-toggle="tab">
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
           		 <div class="panel-body" style="padding-bottom:0px;">
			        <div class="panel panel-default">
			            <div class="panel-heading">查询条件</div>
			            <div class="panel-body">
			                <form id="formSearch" class="form-horizontal">
			                    <div class="form-group" style="margin-top:15px">
			                        <label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
			                        <div class="col-sm-3">
			                            <input type="text" class="form-control" id="txt_search_departmentname">
			                        </div>
			                        <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
			                        <div class="col-sm-3">
			                            <input type="text" class="form-control" id="txt_search_statu">
			                        </div>
			                        <div class="col-sm-4" style="text-align:left;">
			                            <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
			                        </div>
			                    </div>
			                </form>
			            </div>
			        </div>       
					<div class="input-group date form_datetime col-sm-12" data-link-field="dt_set_order_time_input">
						<input class="form-control"  id="dt_set_order_time" type="text" value="2015-10-16">
						<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
						<input type="hidden" id="dt_set_order_time_input" value="2015-10-16" name="set_order_time"/>
					</div>
			
			        <div id="toolbar" class="btn-group">
			            <button id="btn_add" type="button" class="btn btn-default">
			                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			            </button>
 			            <button id="btn_edit" type="button" class="btn btn-default">
			                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			            </button>
			            <button id="btn_delete" type="button" class="btn btn-default">
			                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			            </button>
			        </div>
			        <table id="tb_departments"></table>
			    </div>
           </div>
           <div id="eight" class="tab-pane">
          	   <div id="selectBar" class="btn-group">
          	   	   <span style="margin-left: 18px;">选择库:</span>
          	       <select class="form-control" style="width: 180px;display: inline;">
	          	   		<option>1</option>
	          	   </select>
		       </div>
			   <table id="dbtableDefTb" 
			   		   data-toggle="table" 
			   		   data-toolbar="#selectBar"
			           data-search="true"
			           data-show-refresh="true"
			           data-show-toggle="true"
			           data-show-columns="true"
			           data-show-export="true"
			           data-pagination="true"
			           data-side-pagination="server"
			           data-page-size="10"
			           data-page-list="[10, 25, 50, 100, All]"
			           data-smart-display="false"
			           data-show-footer="false"
			           data-content-type="application/json"
			           data-query-params="dbTablesParams"
			           >
			        <thead>
				        <tr>
				        	<th data-field="" data-radio="true"></th>
				            <th data-field="xh">序号</th>
				            <th data-field="orderDB">所属库</th>
				            <th data-field="typeDB">库类型</th>
				            <th data-field="createTable">创建时间</th>
				            <th data-field="nameTable">表名</th>
				            <th data-field="commontTable">表描述</th>
				            <th data-field="countTable">表数据量</th>
				            <th data-field="chartTable">字符集</th>
				            <th data-field="enginDB">存储引擎</th>
				        </tr>
			        </thead>
			    </table>
			   	<table class="table table-bordered">
	                <tbody>
	                    <tr>
	                        <td colspan="2">
	                            <input value="" style="color: #337ab7;font-weight: bold;" readonly="readonly" class="form-control" id="sourceTableName" />
	                        </td>
	                        <td>
	                            <table>
	                                <tr>
	                                    <td>
	                                    	<span>表名:</span><input value="" placeholder="表名不能为空" style="width: 180px;display: inline;" class="form-control" id="destTableName"/>
	                                    </td>
	                                    <td>
	                                    	目标库选择：
	                                    	<select id ="destDB" name="destDB" style="width: 180px;display: inline;" class="form-control" title="请选择">
	                                    		<option value="我是波波2">我是波波2</option>	
	                                    	</select>
										</td>
	                                </tr>
	                            </table>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>
	                            <table class="table" id="table-methods-table-left">
	                                <thead>
	                                    <tr>
	                                        <th data-field="state" data-checkbox="true"></th>
	                                        <th data-field="xh">序号</th>
	                                        <th data-field="filed">字段名称</th>
	                                        <th data-field="datatype">字段类型</th>
	                                        <th data-field="isnull">是否为空</th>
	                                        <th data-field="defaultValue">默认值</th>
	                                        <th data-field="isIndex">是否主键、索引</th>
	                                        <th data-field="commont">描述 </th>
	                                    </tr>
	                                </thead>
	                            </table>
	                        </td>
	                        <td valign="middle">
	                           	<button class="btn btn-info btn-large btn-block" type="button" id="btn2Right" data-method="append">--></button> 
	                        </td>
	                        <td>
	                            <table data-detail-view="true" data-detail-formatter="detailFormatter" class="table" id="table-methods-table-right">
	                                <thead>
	                                    <tr>
	                                        <th data-field="filed" data-formatter="colformatter">字段名称</th>
	                                        <th data-field="datatype" data-formatter="colformatter">字段类型</th>
	                                        <th data-field="isnull" data-formatter="selectIsnullformatter">是否为空</th>
	                                        <th data-field="isIndex" data-formatter="selectformatter">是否主键、索引</th>
	                                        <th data-field="defaultValue" data-formatter="coldefaultformatter">默认值</th>
	                                        <th data-field="commont" data-formatter="colformatter">描述 </th>
	                                        <th data-formatter="deleteColTr">操作</th>
	                                    </tr>
	                                </thead>
	                            </table>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="3" align="right">
	                            <button onclick="submitNewTable()" class="btn btn-primary btn-large btn-block" type="button" id="btnOk" >确定</button>
	                        </td>
	                    </tr>
	                </tbody>
            	</table>
           </div>
	</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
	    <form id="myModalLabelFrom" action="${pageContext.request.contextPath}/permission/db" method="post">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="myModalLabel">新增</h4>
	            </div>
	            <div class="modal-body">
	                <div class="form-group">
	                    <label for="txt_departmentname">数据库名称</label>
	                    <input type="text" name="db_dbname" class="form-control" id="db_dbname" placeholder="例如:cvf数据库">
	                </div>
	                <div class="form-group">
	                    <label for="txt_parentdepartment">数据库类型</label>
	                    <input type="text" name="db_type" class="form-control" id="db_type" placeholder="例如:mysql">
	                </div>
	                <div class="form-group">
	                    <label for="txt_departmentlevel">IP</label>
	                    <input type="text" name="db_ip" class="form-control" id="db_ip" placeholder="例如:localhost">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">端口</label>
	                    <input type="text" name="db_port" class="form-control" id="db_port" placeholder="例如:3306">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">数据库链接</label>
	                    <input type="text" name="db_url" class="form-control" id="db_url" placeholder="例如:jdbc:mysql://localhost/datas?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">用户</label>
	                    <input type="text" name="db_username" class="form-control" id="db_username" placeholder="例如:root">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">数据库密码</label>
	                    <input type="text" name="db_password" class="form-control" id="db_password" placeholder="例如:199345">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">数据库驱动</label>
	                    <input type="text" name="db_driver" class="form-control" id="db_driver" placeholder="例如:com.mysql.jdbc.Driver">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">描述</label>
	                    <input type="text" name="db_commont" class="form-control" id="db_commont" placeholder="描述">
	                </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
	                <button type="submit" class="btn btn-primary" ><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
	            </div>
	        </div>
	    </form>
    </div>
</div>

<div class="modal fade" id="myEditModal" tabindex="-1" role="dialog" aria-labelledby="myEditModalLabel">
    <div class="modal-dialog" role="document">
    	<form id="myEditModalFrom" action="${pageContext.request.contextPath}/permission/db" method="post">
    		<input type="hidden" name="_method" value="put" />
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="myEditModalLabel">编辑</h4>
	            </div>
	            <div class="modal-body">
	                <div class="form-group">
	                    <label for="txt_departmentname">ID</label>
	                    <input type="text" name="db_ID" class="form-control" id="db_ID">
	                </div>
	                <div class="form-group">
	                    <label for="txt_departmentname">所属用户</label>
	                    <input type="text" name="db_user" class="form-control" id="db_user">
	                </div>
	                
	                <div class="form-group">
	                    <label for="txt_departmentname">数据库名称</label>
	                    <input type="text" name="db_dbname" class="form-control" id="db_dbname">
	                </div>
	                <div class="form-group">
	                    <label for="txt_parentdepartment">数据库类型</label>
	                    <input type="text" name="db_type" class="form-control" id="db_type">
	                </div>
	                <div class="form-group">
	                    <label for="txt_departmentlevel">IP</label>
	                    <input type="text" name="db_ip" class="form-control" id="db_ip">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">端口</label>
	                    <input type="text" name="db_port" class="form-control" id="db_port">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">数据库链接</label>
	                    <input type="text" name="db_url" class="form-control" id="db_url">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">用户</label>
	                    <input type="text" name="db_username" class="form-control" id="db_username">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">数据库密码</label>
	                    <input type="text" name="db_password" class="form-control" id="db_password">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">数据库驱动</label>
	                    <input type="text" name="db_driver" class="form-control" id="db_driver">
	                </div>
	                <div class="form-group">
	                    <label for="txt_statu">描述</label>
	                    <input type="text" name="db_commont" class="form-control" id="db_commont">
	                </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
	                <button type="submit" class="btn btn-primary" ><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
	            </div>
	        </div>
        </form>
    </div>
</div>

<script type="text/javascript">

//动态绑定change事件
$(document).on("change","select.isnull-select,select.eq-select",selectChangeVal);
$(document).on("change","input[name='commont'],input[name='filed'],input[name='datatype'],input[name='defaultValue']",function() {
	var This = $(this);
	updateChange(This);
});

$("#dbtableDefTb").bootstrapTable({
	url:"${pageContext.request.contextPath}/jsplumb/dbtables",
	method: 'get', 
	striped: true,
	clickToSelect: true,
    onLoadSuccess:function(data){
    	$("#dbtableDefTb").bootstrapTable('check',0);
    },
    onCheck:selectTableOneRow
});


function dbTablesParams(param){
	$.extend(param,{dbname:'dbname'});
	return param;
}
/**
 * 选中第一行 进行表结构查询
 */
function selectTableOneRow(row, $element){
	var tableName = row.nameTable;
	var schema = row.orderDB;
	$("#sourceTableName").val(tableName);
	$('#table-methods-table-left').bootstrapTable('destroy');//直接销毁 其实可以进行刷新
	$('#table-methods-table-right').bootstrapTable('destroy');
	$tableLeft = $('#table-methods-table-left').bootstrapTable({
	    url: '${pageContext.request.contextPath}/jsplumb/tableinfo?dbname=dbname&tableName='+tableName+'&schema='+schema,
	    method: 'get'
	});
	$tableRight = $('#table-methods-table-right').bootstrapTable();
}


$('#btn2Right').click(function () {
   var selectContent = $tableLeft.bootstrapTable('getSelections');
   $tableRight.bootstrapTable("append", selectContent);
   var selects = $tableLeft.bootstrapTable('getSelections');
   filed = $.map(selects, function (row) {
       return row.filed;
   });
});
function detailFormatter(index, row, element){
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    })
    return html.join('');
}
function colformatter(value,row,index){
	var field = getField(value,row);
	var input = "<input name='"+field+"' style='width:180px;' class='form-control input_text' value='"+value+"'/>"
	return input;
}

function coldefaultformatter(value,row,index){
	var field = getField(value,row);
	return "<input name='"+field+"' style='width:80px;' class='form-control input_text' value='"+value+"'/>";
}
function deleteColTr(value,row,index){
	//return '<li onclick='delSelectRow('"+row.filed+"')' class="glyphicon glyphicon-remove"></li>';
	return "<button type='button' onclick=delSelectRow('"+row.filed+"')  class='btn btn-xs btn-link' >删除</button>";
}
function delSelectRow(filed){
	var fileds = [filed];
	fileds.push();
    $tableRight.bootstrapTable('remove', {
        field: 'filed',
        values: fileds
    });
}
function selectformatter(value,row,index){
	var field = getField(value,row); 
	return "<select name='"+field+"' style='width:68px;' class='form-control eq-select'><option value=''>无</option><option value='PRI'>主键</option><option value='UNI'>唯一</option><option value='MUL'>复合</option></select>";
}
//更新数据
function selectChangeVal(){
	var This = $(this);
	updateChange(This);
}
function updateChange(This){
	var val = This.val();
	var field = This.attr('name');
	var index = This.parent().parent().attr('data-index');
	$tableRight.bootstrapTable('updateCell', {
	    index: index,
	    field: field,
	    value: val
	 });
}

function selectIsnullformatter(value,row,index){
	var field = getField(value,row); 
	return "<select name='"+field+"' style='width:68px;' class='form-control isnull-select'><option value='1'>是</option><option value='0'>否</option></select>";
}
$("#table-methods-table-right thead tr th.detail").html("<div class='th-inner'><a class='detail-icon' onclick='insertRow()'><i class='glyphicon glyphicon-plus icon-plus'></i></a></div><div class='fht-cell'></div>");
function insertRow(){
    var row = {filed:'',datatype:'',isnull:'',defaultValue:'',isIndex:'',commont:''};
	$tableRight.bootstrapTable('insertRow', {index: 0, row: row});
}
function getField(value,row){
	var field;
	for(var key in row){
		if(value == row[key]){
			field = key;
			break;
		}
	}
	return field;
}
function submitNewTable(){
	var datas = $tableRight.bootstrapTable('getData');
	var tableName = $("#destTableName").val();
	var dbName = $("#destDB option:selected").val();
	if(''===$.trim(dbName)){
		alert("填写要创建的表名！");
		return ;
	}
	if(datas.length==0){
		alert("至少需要有一个字段！");
		return;
	}else{
		var flag = false;
		for(var i = 0; i < datas.length; i++){
			var count = 0;
			if(count>=2){
				flag = true;
				break;
			}
			var filed = datas[i]['filed'];
			for(var j = 0; j < datas.length; j++){
				var f = datas[j]['filed'];
				if(f==filed){
					count++;
				}
				if(count>=2){
					break;
				}
			}
		}
		if(flag){
			alert("字段名不能重复！");
			return;
		}
	}
	
	//进行表校验
    var isIn = false;
	$.ajax({type: "POST",async:false,url: '${CONTEXTPATH }/jsplumb/tableindb',data:{tableName:tableName,dbName:dbName},dataType:'json',
        success: function(data){
        	if(data.meta.success){
        		isIn = true;
        	}else{
        		alert(data.meta.message);
        	}
       },
       error : function(data){
    	   alert("数据查询失败！");
       }
   });
	if(!isIn){
		return;
	}
	//进行表创建 和数据流程 数据保存
	var uptable = {tableName:tableName,dbName:dbName,datas:datas};
	$.ajax({type: "POST",async:false,url: '${CONTEXTPATH }/jsplumb/createtable',data:JSON.stringify(uptable),dataType:'json',
		contentType:'application/json;charset=utf-8',success: function(data){
        	if(data.meta.success){
        		alert(data.meta.message);
        		flag = true;
        	}
       },
       error : function(data){
       }
   });
	
}
</script>

<!-- 数据库管理页面start -->
<script type="text/javascript">
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
     $("#myEditModalFrom,#myModalLabelFrom").ajaxForm(function(data){ 
    	$('#myModal').modal('hide');
    	$("#myEditModal").modal('hide');
        $('#tb_departments').bootstrapTable('refresh');
    });
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    $('.form_datetime').datetimepicker({
		weekStart: 1,
		todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
		language:'zh-CN',
		format: 'yyyy-mm-dd hh:ii:ss',
		pickerPosition: 'bottom-left',
		showMeridian: 1
	 });

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '${pageContext.request.contextPath}/permission/db',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            dataType:'json',
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            sortable: false,                    //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
           // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showExport: true,
            onDblClickRow:function (row, $element) {//双击弹出编辑界面的层
            	
            },
            onClickRow:function (row, $element) {
            	
            },
            exportDataType: 'all',
            exportTypes:[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],  //导出文件类型
            fixedColumns: true,
            fixedNumber: 3,
            height:500,
            exportTypes:['excel'],  //导出文件类型
            Icons:'glyphicon-export',
            exportOptions:{
                ignoreColumn: [0,1],  //忽略某一列的索引
                fileName: '总台帐报表',  //文件名称设置
                worksheetName: 'sheet1',  //表格工作区名称
                tableName: '总台帐报表',
                excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
                onMsoNumberFormat: DoOnMsoNumberFormat
            },
            exportDataType:'all',
            onLoadSuccess:function(data){   //表格数据加载成功事件
                rowCount = data.length-1;
                $("#datatable").bootstrapTable('hideRow', {index:rowCount});
                $("#datatable td").attr("data-tableexport-msonumberformat","\@");
                $("#datatable tr").attr("data-tableexport-display","always");
            },
            onLoadError: function () {
            	
            },
            onPageChange:function(number,size){  //表格翻页事件
                $("#datatable").bootstrapTable('hideRow', {index:rowCount});
                $("#datatable td").attr("data-tableexport-msonumberformat","\@");
                $("#datatable tr").attr("data-tableexport-display","always");
     
            },
           // editable:true,//开启编辑模式
            onEditableSave: function (field, row, oldValue, $el) {
            	var result = Base.encode(row[field]);
                $.ajax({type: "post",url: '${CONTEXTPATH }/permission/dbcol',
                	data:{"_method":"put",col:field,value:result,id:row['id']},
                	dataType:'json',
                	async:false,
                    success: function(data){
                    	if(data.meta.success){
                    		alert("修改成功");
                    	}else{
                    		alert("修改失败");
                    	}
                   },
                   error : function(data){
                   
                   }
               });
            },
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: 'ID'
            }, {
                field: 'user',
                title: '所属用户'
            }, {
                field: 'dbname',
                title: '数据库名称',
                editable: true,
               	formatter: formatter
            }, {
                field: 'type',
                title: '数据库类型',
               	editable: true,
               	formatter: formatter
            }, {
                field: 'ip',
                title: 'IP',
               	editable: true,
               	formatter: formatter
            }, {
                field: 'port',
                title: '端口',
               	editable: true,
               	formatter: formatter
            }, {
                field: 'url',
                title: '数据库链接',
               	editable: true,
               	formatter: formatter
            }, {
                field: 'username',
                title: '用户',
               	editable: true,
               	formatter: formatter
            }, {
                field: 'password',
                title: '数据库密码',
               	editable:{
               		emptytext: "",
               		type: 'text'
               	},
               	formatter: formatter
            }, {
                field: 'driver',
                title: '数据库驱动',
               	editable: true,
               	formatter: formatter
            },{
                field: 'commont',
                title: '描述',
               	editable: true,
               	formatter: formatter
            },{
                field: 'save',
                title: '保存',
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
    	var temp = {};
        temp = $.extend(true,temp,params);
        return temp;
    };
    return oTableInit;
};
//操作栏的格式化
function actionFormatter(value, row, index) {
    var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"showViewById('" + index + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"saveViewById('" + index + "', view='save')\" title='保存'><span class='glyphicon glyphicon-ok'></span></a>";
    //result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    //result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
	
    return result;
}
function DoOnMsoNumberFormat(cell, row, col) {
    var result = "";
    if (row > 0 && col == 0)
        result = "\\@";
    return result;
}
//查看当前数据库具体信息
function showViewById(index,view){
	
}
//保存当前行数据
function saveViewById(index,view){
	
}
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };
    return oInit;
};

function formatter(value, row, index){
	return  value ;
}


//(2)关键字检索
$("#btn_query").click(function () {
    //点击查询是 使用刷新 处理刷新参数
    var opt = {
        url: "${pageContext.request.contextPath}/permission/db",
        silent: true,
        query: {
            text1: $("#txt_search_departmentname").val(), //条件1
            text2: $("#txt_search_statu").val()           //条件2 ....
        }
    };
    $('#tb_departments').bootstrapTable('refresh', opt);

});
//新增
$("#btn_add").click(function() {
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
	/*     var params = {index:0, row:{'id':'','user':'','dbname':'','type':'','ip':'','port':'',
    	'url':'','username':'','password':'','driver':'','driver':'','commont':''}}; 
    $('#tb_departments').bootstrapTable('insertRow', params); */
});
//编辑
$("#btn_edit").click(function () {
    var arrselections = $("#tb_departments").bootstrapTable('getSelections');
    if (arrselections.length > 1) {
    	alert("每次只能编辑一条！");
        return;
    }
    if (arrselections.length <= 0) {
    	alert("请选择一条进行编辑！");
        return;
    }

    $("#db_ID").val((arrselections[0]['id']));
    $("#db_user").val((arrselections[0]['user']));
    $("#myEditModal input[name='db_dbname']").val((arrselections[0]['dbname']));
    $("#myEditModal input[name='db_type']").val((arrselections[0]['type']));
    $("#myEditModal input[name='db_ip']").val((arrselections[0]['ip']));
    $("#myEditModal input[name='db_port']").val((arrselections[0]['port']));
    $("#myEditModal input[name='db_url']").val((arrselections[0]['url']));
    $("#myEditModal input[name='db_username']").val((arrselections[0]['username']));
    $("#myEditModal input[name='db_password']").val((arrselections[0]['password']));
    $("#myEditModal input[name='db_driver']").val((arrselections[0]['driver']));
    $("#myEditModal input[name='db_commont']").val((arrselections[0]['commont']));
        
    $("#myEditModalLabel").text("编辑");
    $('#myEditModal').modal();

});
//(4)删除及批量删除

$("#btn_delete").click(function () {
    if (confirm("确认要删除吗？")) {
        var idlist = "";
        $("input[name='btSelectItem']:checked").each(function () {
            idlist += $(this).parents("tr").attr("data-uniqueid") + ",";
        })
        alert("删除的列表为" + idlist);

    }
});
</script>
<!-- 数据库管理页面end -->

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
</script>


<script type="text/javascript">
$(function(){
    $("#stafffrom,#groupform,#sourceform,#elementform,#appform").ajaxForm(function(data){    
    	
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

<script type="text/javascript">
(function ($) {

    window.Ewin = function () {
        var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
                              '<div class="modal-dialog modal-sm">' +
                                  '<div class="modal-content">' +
                                      '<div class="modal-header">' +
                                          '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
                                          '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
                                      '</div>' +
                                      '<div class="modal-body">' +
                                      '<p>[Message]</p>' +
                                      '</div>' +
                                       '<div class="modal-footer">' +
        '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>' +
        '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>' +
    '</div>' +
                                  '</div>' +
                              '</div>' +
                          '</div>';


        var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
                              '<div class="modal-dialog">' +
                                  '<div class="modal-content">' +
                                      '<div class="modal-header">' +
                                          '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
                                          '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
                                      '</div>' +
                                      '<div class="modal-body">' +
                                      '</div>' +
                                  '</div>' +
                              '</div>' +
                          '</div>';
        var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
        var generateId = function () {
            var date = new Date();
            return 'mdl' + date.valueOf();
        }
        var init = function (options) {
            options = $.extend({}, {
                title: "操作提示",
                message: "提示内容",
                btnok: "确定",
                btncl: "取消",
                width: 200,
                auto: false
            }, options || {});
            var modalId = generateId();
            var content = html.replace(reg, function (node, key) {
                return {
                    Id: modalId,
                    Title: options.title,
                    Message: options.message,
                    BtnOk: options.btnok,
                    BtnCancel: options.btncl
                }[key];
            });
            $('body').append(content);
            $('#' + modalId).modal({
                width: options.width,
                backdrop: 'static'
            });
            $('#' + modalId).on('hide.bs.modal', function (e) {
                $('body').find('#' + modalId).remove();
            });
            return modalId;
        }

        return {
            alert: function (options) {
                if (typeof options == 'string') {
                    options = {
                        message: options
                    };
                }
                var id = init(options);
                var modal = $('#' + id);
                modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
                modal.find('.cancel').hide();

                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            confirm: function (options) {
                var id = init(options);
                var modal = $('#' + id);
                modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
                modal.find('.cancel').show();
                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                            modal.find('.cancel').click(function () { callback(false); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            dialog: function (options) {
                options = $.extend({}, {
                    title: 'title',
                    url: '',
                    width: 800,
                    height: 550,
                    onReady: function () { },
                    onShown: function (e) { }
                }, options || {});
                var modalId = generateId();

                var content = dialogdHtml.replace(reg, function (node, key) {
                    return {
                        Id: modalId,
                        Title: options.title
                    }[key];
                });
                $('body').append(content);
                var target = $('#' + modalId);
                target.find('.modal-body').load(options.url);
                if (options.onReady())
                    options.onReady.call(target);
                target.modal();
                target.on('shown.bs.modal', function (e) {
                    if (options.onReady(e))
                        options.onReady.call(target, e);
                });
                target.on('hide.bs.modal', function (e) {
                    $('body').find(target).remove();
                });
            }
        }
    }();
})(jQuery);

</script>
</body>
</html>