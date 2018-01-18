<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表格</title>
<style type="text/css">
.table-wrap {
    width: 100%;
    outline: none;
    position: relative;
    font-size: 14px;
    color: #444;
    margin-top: 20px;
}
.table-head {
	width: calc( 100% - 1.2em );
    background-color: #FAFAFA;
}
.table-head-wrap {
    width: calc( 100% - 1.2em );
    position: relative;
    overflow: hidden;
}
.grid {
    margin: 0px;
    table-layout: fixed;
    width: 100%;
    outline: 0px none;
    border-collapse: collapse;
    empty-cells: show;
    border:1px solid #d1d1d1;
    border-bottom: none;
	border-right: none;
}
.table-content .grid{
    border-top:none ;
}
.table-content {
    box-sizing: border-box;
    white-space: normal;
    position: relative;
    width: 100%;
    overflow-x: hidden;
    overflow-y: scroll ;
    min-height: 0;
	height: 100%;
}

</style>
</head>
<body>
	<div class="table-wrap">
		<div class="table-head table-head-wrap">
			<table class="grid" cellpadding="0" cellspacing="0" border="1px">
				<tr>
					 <td>姓名</td><td>用途大神客家话</td><td>用途爱的撒旦</td><td>用途傻傻的</td><td>用定时达途</td><td>用哇途</td>
				</tr>
			</table>
		</div>
		<div class="table-content">
			<table class="grid" cellpadding="0" cellspacing="0" border="1px">
				<% for(int index = 1; index <= 100; index++){ %>
				<tr>
					<td>姓名<%=index %></td><td>用途大神客家话<%=index %></td><td>用途爱的撒旦<%=index %></td><td>用途傻傻的<%=index %></td><td>用定时达途<%=index %></td><td>用哇途<%=index %></td>
				</tr>
				<%} %>
			</table>
		</div>
	</div>
</body>
</html>