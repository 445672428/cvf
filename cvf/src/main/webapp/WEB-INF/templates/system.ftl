<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>系统中心</title>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/lib/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container" style="background: #eee;">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container ">
		        <div class="navbar-header">
		          	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		          </button>
		          <a class="navbar-brand" href="#">系统配置</a>
		        </div>
		        <div id="navbar" class="navbar-collapse collapse">
		        	<ul class="nav nav-tabs navbar-nav" role="tablist">  
					  <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">用户信息</a></li>  
					  <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">基础信息修改</a></li>  
					  <li role="presentation"><a href="#messages" role="tab" data-toggle="tab">操作设置</a></li>  
					  <li role="presentation"><a href="#settings" role="tab" data-toggle="tab">设置</a></li>  
					</ul>
		        </div>
	        </div>
	    </nav>
		<!-- 面板区 -->  
		<div class="tab-content">
			<#include "from1.ftl"/>
			<#include "from2.ftl"/>
			<#include "from3.ftl"/>
			<#include "from4.ftl"/>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
    $.fn.serializeObject = function() {  
        var o = {};  
        var a = this.serializeArray();  
        $.each(a, function() {  
            if (o[this.name]) {  
                if (!o[this.name].push) {  
                    o[this.name] = [ o[this.name] ];  
                }  
                o[this.name].push(this.value || '');  
            } else {  
                o[this.name] = this.value || '';  
            }  
        });  
        return o;  
    }
</script>