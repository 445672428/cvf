<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>聊天主页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/kindeditor/lang/zh_CN.js"></script>

</head>
<body>
    <div class="container-fluid">
      <div class="row">
      	<div class="col-sm-1 col-md-1 col-lg-1 sidebar">
      	  <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
      	</div>
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a >1</a></li>
            <li><a >2</a></li>
            <li><a >3</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a >4</a></li>
            <li><a >5</a></li>
            <li><a >6</a></li>
            <li><a >7</a></li>
            <li><a >8</a></li>
          </ul>
        </div>
        
        <div id="contentFrame" class="col-sm-8 col-md-9 main">
          <h1 id="personTitle" class="page-header">Dashboard</h1>
          <div class="row placeholders">
	          <h2 class="sub-header">Section title</h2>
	          <div class="table-responsive" style="width: 800px;height: 600px;">
	          	<div style="width: 100%;height: 430px;overflow-y:auto;">
		            <table id="chatRds" class="table table-striped">
		                <tr>
		                  <td>1001</td>
		                </tr>
		            </table>
	            </div>
	            <div style="width: 100%;height: 170px;overflow-y:auto;">
	            	<textarea id="content_1" name="content" style="width:800px;height:150px;"></textarea>
	            </div>
	          </div>
	          <button onclick="sendMsg()">发送</button>
          </div>
      	</div>
   	 </div>
    </div>
</body>
<script type="text/javascript">
var editor; 
var websocket = null;
//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8082/cvf/websocket/bobo");
}
else {
    alert('当前浏览器 Not support websocket')
}

//连接发生错误的回调方法
websocket.onerror = function () {
	console.log("WebSocket连接发生错误");
};

//连接成功建立的回调方法
websocket.onopen = function () {
	console.log("WebSocket连接成功");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
}
websocket.onmessage = function (event) {
	console.log(event.data);
	var record = "<tr><td>"+event.data+"</td></tr>";
	$("#chatRds").append(record);
}
//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
/* function send(message,callback) {
    websocket.send(message);
   	//接收到消息的回调方法
   	websocket.onmessage = function (event) {
  	  if(typeof callback === "function"){
  	   	if(event.data==message){
  	   	   callback(message);
  	   	}
	  }
   	}
} 
	send(content,function(msg){
		var record = "<tr><td>"+msg+"</td></tr>";
		$("#chatRds").append(record);
	});
*/

function frameMakerChat(data){
	var title = data['title'];
	var records = data['chatRd'];
	/* for(var i = 0; i < records.length; i++){
		
	} */
}

function sendMsg(){
	var content = editor.html();
	websocket.send(content);
}

KindEditor.ready(function(K) { 
    editor = K.create('textarea[name="content"]', {  
        newlineTag : "br",   
        resizeType : 2,  
        allowPreviewEmoticons : true,  
        allowImageUpload : true,  
        minHeight:"100px",  
        autoHeightMode : false,  
        afterCreate : function() {  
            this.loadPlugin('autoheight');  
        },  
        items : [  
            //'fullscreen', 
            //'source' , 
            //'table',  
            //'insertfile', 
            //'link' , 
            'image' , 
            'emoticons' , '|' , 
            'forecolor' 
            //,'hilitecolor', 
            //'bold' ,
            //'underline', 
            //'removeformat', '|'   
            //,'justifyleft', 
            //'justifycenter', 
            //'justifyright'
            //,'preview'
            ],
            afterBlur:function(){this.sync();}
    });
});  
</script>
</html>