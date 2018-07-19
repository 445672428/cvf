<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多文件上传模板</title>
<!-- jquery -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js" charset="utf-8"></script>
<!-- bootstrap -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/bootstrap/js/bootstrap.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/ystep.css" />
<!-- 公共js 引入 -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/common.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/plugin/sockjs.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/utils/jszip.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/plugin/setStep.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/js/upload.js" charset="utf-8"></script>
<style type="text/css">
input[type='file']{
	height: 30px;
	line-height: 30px;
}
.fileinput-button input{
	top: 0px;
	right: 0px;
	margin: 0xp;
	opacity:0;
	transform:translate(-300px, 0) scale(4);
	font-size: 23px;
	direction: ltr;
	cursor: pointer;
}

.btn.green{
	background-color: #35aa47;
	color: white;
	text-shadow: none;
	text-align: center;
}
.btn.blue{
	background-color: #4d90fe;
	color: white;
	text-shadow: none;
	text-align: center;
}
.btn.yellow{
	background-color: #ffb848;
	color: white;
	text-shadow: none;
	text-align: center;
}
.btn.red{
	background-color: #d84a38;
	color: white;
	text-shadow: none;
	text-align: center;
}
span {
	border-radius:10 !important;
}
.fileinput-button{
	position: relative;
	overflow: hidden;
	float: left;
	margin-right: 1em;
}
[class^="icon-"], [class*=" icon-"], [class^="icon-"]:hover, [class*=" icon-"]:hover{
	background: none !important;
}
[class^="icon-"],[class*="icon-"]{
	display: inline;
	width: auto;
	height: auto;
	line-height: normal;
	vertical-align: baseline;
}
/* .icon-white{
	background-image: url(resources/lib/bootstrap/images/glyphicons-halflings-white.png);
} */
div.checker input {
	opacity:0;
	border: none;
	background: none;
	display:inline-block;
	zoom:1;
}
input[type="reset"],input[type="checkbox"],input[type="radio"],input[type="submit"],input[type="button"] {
	line-height: normal;
	cursor: pointer;
}
.tdcenter{
	text-align:center; /*设置水平居中*/
	vertical-align:middle;/*设置垂直居中*/
}
.fileList{
	padding: 0;
}
ul{
	display: block;
	list-style-type: disc;
    -webkit-margin-before: 1em;
    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    -webkit-padding-start: 40px;
}
.fileList li{
	list-style-type: none;
	margin-top: 10px;
}
li{
	display: list-item;
	text-align: -webkit-match-parent;
}
.progress{
	display: inline-block;
	width: 400px;
	height: 10px;
	background: white;
	border-radius:20px;
	border:2px groove #666;
	vertical-align: middle;
	padding: 0 2px;
}
.progressbar{
	width: 0%;
	height: 9px;
	border-radius:20px;
	background: url("resources/images/jdt.png") repeat-x center;
}
table[role='presentation']>thead{
	text-align: center;
}
</style>
<script type="text/javascript">
var CONTEXTPATH = '${CONTEXTPATH}';
var REALIP = '${REALIP}';
</script>
</head>
<body>
<div class="container">
	<form style="margin: auto;margin-top: 20%;" id="fileupload" method="POST" enctype="multipart/form-data">
		<div class="span7">
			<div >
				<!-- style="margin: 0 auto;border: 1px solid #000000;text-align: center;" -->
				<span style="height: 34px;width: 100px;" class="btn green fileinput-button">
					<i class="icon-plus icon-white" ></i>
					<span>添加文件...</span>
					<input id='multipleInput' type="file" name='files[]' multiple="multiple" />
				</span>
				<button cls='allstart' type="button" id="fileUpload" class="btn blue start">
					<i class="icon-upload icon-white"></i>
					<span id="startUp">开始上传</span>
				</button>
				<button cls='allcan' type="reset" class="btn yellow cancel">
					<i class="icon-ban-circle icon-white"></i>
					<span id="stopUp">取消上传</span>
				</button>
				<button cls='alldel' type="button" class="btn red delete">
					<i class="icon-trash icon-white"></i>
					<span id="delUp">删除</span>
				</button>
				<div class="checker">
					<span>
						<input type="checkbox" class="toggle fileupload-toggle-checkbox"/>
					</span>
				</div>
			</div>
		</div>
		<!-- 上传文件列表 -->
		<table role='presentation' class="table table-striped">
			<thead><tr><td>预览</td><td>名称</td><td>大小</td><td>进度</td><td>当前进度</td><td>上传时间</td><td>文件类型</td><td>开始上传</td><td>暂停上传</td><td>删除</td></tr></thead>
			<tbody class="files" data-toggle='modal-gallery' data-target='#modal-gallery'></tbody>
		</table>
	</form>
	<div id='saaa' style="height: 100px;width: 100px;"><canvas style="height: 100px;width: 100px;" id='canvas'></canvas></div>
</div>
<!-- <div style="width: 100%;height: 400px;overflow-y:auto;">
	<ul class="fileList">
		<li id="1file">
			<div class="progress">
				<div class="progressbar"></div>
			</div>
			<span class="filename"></span>
			<span class="progressnum"></span>
			<a class="uploadbtn"></a>
			<a class="stopbtn"></a>
			<a class="delfilebtn"></a>
		</li>
	</ul>
</div> -->
<h1>显示点击按钮 也可点击进度条节点</h1>
 <!-- 菜单及分页容器-->
<div class="stepCont stepCont3">
   <!-- 菜单导航显示-->
   <div class='ystep-container ystep-lg ystep-blue'></div>
   <!-- 分页容器-->
   <div class="pageCont">
       <div id="page1" class="stepPage"><h1>page1</h1></div>
       <div id="page2" class="stepPage"><h1>page2</h1></div>
       <div id="page3" class="stepPage"><h1>page3</h1></div>
       <div id="page4" class="stepPage"><h1>page4</h1></div>
       <div id="page5" class="stepPage"><h1>page5</h1></div>
   </div>
</div>
</body>
<script type="text/javascript">
/*  var sock=null;
 if (window['WebSocket']) {
     sock= new WebSocket('ws://' + window.location.host+'/cvf/webbobo');
 }else{
	 sock= new SockJS('/cvf/js/webbobo');//兼容低版本浏览器
 }
 sock.onopen = function() {
     console.log('Opening');
     sayHello();
 };
 sock.onmessage = function(e) {
     alert('Received message: '+ e.data);
 };
 sock.onclose = function() {
     console.log('Closing');
 };
 function sayHello() {
     console.log('Sending Hello!');
     sock.send("Hello!");
 } */
</script>
<script type="text/javascript">
        var oBody=document.getElementsByTagName("body")[0];
        var canvas = document.createElement("canvas");
        canvas.id='five';
        canvas.width=50;
        canvas.height=50;
         
        oBody.appendChild(canvas);
        var five = document.getElementById("five");
        var cfive = five.getContext('2d');
        cfive.arc(25,25,23,0,2*Math.PI);
        cfive.fillStyle="#e2e2e2";
        cfive.fill();
        var grd=cfive.createRadialGradient(18,18,2,18,18,12);
        grd.addColorStop(0,"#fff");
        grd.addColorStop(1,"#e2e2e2");
         
        cfive.shadowBlur=2;
        cfive.shadowColor="#666";
        cfive.shadowOffsetX=2;
        cfive.shadowOffsetY=2;
        cfive.fillStyle=grd;
        cfive.fill();
</script>
<script>
    var step1=new SetStep({
        content:'.stepCont1',
        showBtn:false,
    })
    var step2=new SetStep({
        content:'.stepCont2',
        clickAble:false
    })
    var step3=new SetStep({
        content:'.stepCont3'
    })
  </script>

</html>