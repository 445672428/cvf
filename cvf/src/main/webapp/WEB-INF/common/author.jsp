<% 
	out.print("程占波");
%>

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

<!-- 引入Jquery -->  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/easyui/jquery.min.js" charset="utf-8"></script>  
<script src="${CONTEXTPATH }/resources/lib/jquery-ui/jquery-ui.js" charset="utf-8"></script>
<link rel="stylesheet" href="${CONTEXTPATH }/resources/lib/jquery-ui/jquery-ui.css">
</head>
<body>
<div id="dragger" class="dragger" style="width: 100px;height: 100px;background-color: red;"></div>
</body>
<script type="text/javascript">
	$(function(){
		$(".dragger").draggable();
	})
</script>
</html>