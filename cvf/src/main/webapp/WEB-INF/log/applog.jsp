<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>程序操作日志监控</title>
<script src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js"></script>
<style>
	html,body
	{
		height:100%;
		width:100%;
	}
</style>
</head>
<body>
    <div id="log-container" style="height: 100%; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
        <div>
        </div>
    </div>
</body>
<script type="text/javascript">
var PATH = '${CONTEXTPATH }';
var websocket = null;
var ip = window.location.host;
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://"+ip+PATH+"/tomcat/websocket/log");
}
else {
	alert("当前浏览器不提供websocket");
}
        
websocket.onmessage = function(event) {
    $("#log-container div").append(event.data + "<p> </p>");
    $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
};

websocket.onerror = function () {
	alert("连接失败");
};
        
 window.onbeforeunload = function(event) { 
 	websocket.close();
 }
 
 window.onunload = function() {
 	websocket.close();
 }
</script>
</html>
