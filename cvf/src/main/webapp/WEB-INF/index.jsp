<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/resources/lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/reset.css" charset="utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/bootstrap/js/bootstrap.min.js"></script>
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
        color: #717592;
        min-width: 100%;
        min-height: 500px;
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
          <div class="menu-title">菜单管理一</div>
          <div class="menu-item" href="#one" data-toggle="tab">
               －用户管理
          </div>
          <div class="menu-item" href="#two" data-toggle="tab">
               －权限管理
          </div>
          <div class="menu-title">菜单管理二</div>
          <div class="menu-item" href="#three" data-toggle="tab">
               －用户管理
          </div>
          <div class="menu-item" href="#four" data-toggle="tab">
               －权限管理
          </div>
      </div>
      <!-- 右边内容 -->
      <div id="right" class="tab-content right">
           <div id="one" class="tab-pane active">
                <span style="margin-left:40px;text-shadow: 2px 0px 6px rgba(94, 35, 255, 0.91);">
                      内容一
               </span>
           </div>
           <div id="two" class="tab-pane">
                <span style="margin-left:40px;text-shadow: 2px 0px 6px rgba(94, 35, 255, 0.91);">
                      内容二
               </span>
           </div>
           <div id="three" class="tab-pane">
                <span style="margin-left:40px;text-shadow: 2px 0px 6px rgba(94, 35, 255, 0.91);">
                      内容三
               </span>
           </div>
           <div id="four" class="tab-pane">
                <iframe id="fourIfm" frameborder="no" border="0" style="width:100%;"
        				src="http://www.what21.com/" scrolling="no" onload="changeFrameHeight()">
  			</iframe>          
           </div>
      </div>
</div>
<%-- <form action="${pageContext.request.contextPath }/login.do" name="user" METHOD="POST">
账户:<input class='account'/>
密码:<input class='password'/>
<input type="submit" value="登录">
</form> --%>
<script type="text/javascript">
$(function(){
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
</body>
</html>