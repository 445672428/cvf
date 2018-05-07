<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>基础信息录入</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" />
</head>
<body role="document">
    <div class="container" style="background: #eee;">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container ">
		        <div class="navbar-header">
		          	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		          </button>
		          <a class="navbar-brand" href="#">操作中心</a>
		        </div>
		        <div id="navbar" class="navbar-collapse collapse">
		        	<ul class="nav nav-tabs navbar-nav" role="tablist">  
					  <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">用户添加</a></li>  
					  <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">权限栏信息</a></li>  
					  <li role="presentation"><a href="#messages" role="tab" data-toggle="tab">推送信息</a></li>  
					  <li role="presentation"><a href="#settings" role="tab" data-toggle="tab">设置中心</a></li>  
					</ul>
		        </div>
	        </div>
	    </nav>
		<!-- 面板区 -->  
		<div class="tab-content">  
		  <div role="tabpanel" class="tab-pane active" id="home">
				<form>
			      <div class="jumbotron">
			      	 <h2>用户信息</h2>
			      	 <div class="row">
			      	 	<div class="col-sm-2 pull-right">
			      	 		<button class="btn btn-primary glyphicon glyphicon-floppy-disk" type="submit">保存</button>
			      	 		<button class="btn btn-small glyphicon glyphicon-plus btn-success">添加</button>
			      	 	</div>
			      	 </div>
					<div class="form-group col-sm-6">
					    <label for="InputUserName4">姓名：</label>
					    <input type="text" class="form-control" id="InputUserName4" placeholder="填写真实姓名">
					</div>
			        <div class="form-group col-sm-6">
					    <label for="InputUserCode4">用户名242342：</label>
					    <input type="text" class="form-control" id="InputUserCode4" placeholder="用户名">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputPassword4">密码23423：</label>
					    <input type="password" class="form-control" id="InputPassword4" placeholder="Password">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputUserSex4">性别4234：</label>
					    <input type="text" class="form-control" id="InputUserSex4" placeholder="男/女">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputUserNative4">出生地：</label>
					    <input type="text" class="form-control" id="InputUserNative4" placeholder="出生地">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputUserBrith4">出生年月：</label>
					    <input type="text" class="form-control" id="InputUserBrith4" placeholder="出生年月">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputEmail4">邮箱：</label>
					    <input type="email" class="form-control" id="InputEmail4" placeholder="邮箱">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputPhone4">电话：</label>
					    <input type="text" class="form-control" id="InputPhone4" placeholder="电话">
					</div>
			      </div>
			  </form>
		  </div>  
		  <div role="tabpanel" class="tab-pane" id="profile">
		  	<form>
			      <div class="jumbotron">
			      	 <h2>用户信息</h2>
			      	 <div class="row">
			      	 	<div class="col-sm-2 pull-right">
			      	 		<button class="btn btn-primary glyphicon glyphicon-floppy-disk" type="submit">保存</button>
			      	 		<button class="btn btn-small glyphicon glyphicon-plus btn-success">添加</button>
			      	 	</div>
			      	 </div>
					<div class="form-group col-sm-6">
					    <label for="InputUserName">姓名：</label>
					    <input type="text" class="form-control" id="InputUserName" placeholder="填写真实姓名">
					</div>
			        <div class="form-group col-sm-6">
					    <label for="InputUserCode">用户名：</label>
					    <input type="text" class="form-control" id="InputUserCode" placeholder="用户名">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputPassword">密码：</label>
					    <input type="password" class="form-control" id="InputPassword" placeholder="密码">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputUserSex">性别：</label>
					    <input type="text" class="form-control" id="InputUserSex" placeholder="男/女">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputUserNative">出生地：</label>
					    <input type="text" class="form-control" id="InputUserNative" placeholder="出生地">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputUserBrith">出生年月：</label>
					    <input type="text" class="form-control" id="InputUserBrith" placeholder="出生年月">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputEmail">邮箱：</label>
					    <input type="email" class="form-control" id="InputEmail" placeholder="邮箱">
					</div>
					<div class="form-group col-sm-6">
					    <label for="InputPhone">电话：</label>
					    <input type="text" class="form-control" id="InputPhone" placeholder="电话">
					</div>
					<div class="form-group col-sm-5">
					    <label for="InputPhone1">电话：</label>
					    <div style="display: flex;">
					    	<input type="text" class=" form-control" id="InputPhone1" placeholder="电话">
							<button style="margin-left: 15px;" class="btn btn-small pull-right glyphicon glyphicon glyphicon-trash btn-danger">删除</button>
					    </div>
					</div>
			      </div>
			  </form>
		  </div>  
		  <div role="tabpanel" class="tab-pane" id="messages">...3</div>  
		  <div role="tabpanel" class="tab-pane" id="settings">...4</div>  
		</div>
	</div>
</body>
</html>