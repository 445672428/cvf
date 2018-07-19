<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>bTabs使用实例</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" />
		
	<script src="${pageContext.request.contextPath}/resources/lib/jQuery/jquery2.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/tabs.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/menu.js" ></script>
		
	<style type="text/css">
		div.menuSideBar { }
		div.menuSideBar li.nav-header { font-size: 14px; padding: 3px 15px; }
		div.menuSideBar .nav-list > li > a, div.menuSideBar .dropdown-menu li a { -webkit-border-radius: 0px; -moz-border-radius: 0px; -ms-border-radius: 0px; border-radius: 0px; }
		.tab-pane{
			height: 100%;
		}
	</style>
</head>

<body>
	<div class="container-fluid">
		<div class="">
			<div id="content" class="row-fluid" style="min-height: 800px">
				<div class="col-md-2" style="padding-left: 0px;">
					<div class="well menuSideBar" style="padding: 8px 0px;">
						<ul class="nav nav-list" id="menuSideBar">
							<li class="nav-header">导航菜单</li>
							<li class="nav-divider"></li>
							<li mid="tab1" funurl="../index.jsp"><a tabindex="-1" href="javascript:void(0);">页面1</a></li>
							<li mid="tab2" funurl="../login.jsp"><a tabindex="-1" href="javascript:void(0);">页面2</a></li>
							<li mid="tab3" funurl="../register.jsp"><a tabindex="-1" href="javascript:void(0);">页面3</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-10" id="mainFrameTabs" style="padding : 0px;">

					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active noclose"><a href="#bTabs_navTabsMainPage" data-toggle="tab">首页</a></li>
					</ul>

					<!-- Tab panes -->
					<div class="tab-content">
						<div class="tab-pane active" id="bTabs_navTabsMainPage">
							<div class="page-header">
								<h2 style="font-size: 31.5px;text-align: center;font-weight: normal;">欢迎使用</h2>
							</div>
							<div style="text-align: center;font-size: 20px;line-height: 20px;"> Welcome to use bTabs plugin! </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
