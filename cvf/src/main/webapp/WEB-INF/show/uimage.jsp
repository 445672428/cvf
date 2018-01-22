<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>海量图片</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jQuery/jquery2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" />
<style type="text/css">
	#avfilter{
		display: block;
		padding: 15px 10px 0 200px;
	}
	div{
		vertical-align: baseline;
	}
	.avfilter_container{
		margin: 0;
		height: 39px;
		border: 1px solid #e6e6e6;
		padding: 0 0 0 10;
		background: #f8f8f8;
	}
	#imgid{
		padding: 0 5px 5px 200px;
		min-height: 400px;
		width: 1600px;
	}
	.imglist{
		position: relative;
	    vertical-align: baseline;
	    margin: 0px;
	    padding: 0px;
	    border-width: 0px;
	    border-style: initial;
	    border-color: initial;
	    border-image: initial;
	    font: inherit inherit inherit inherit inherit inherit inherit inherit;
	    display: block;
	    list-style-type: disc;
	}
	li{
		vertical-align: baseline;
	    margin: 0px;
	    padding: 0px;
	}
	.clearfix{
		zoom: 1;
	} 
	.pageNum0{}
	.imglist .imgitem {
	    float: left;
	}
	.imgitem{
		position: relative;
	    z-index: 1;
	    float: left;
	    overflow: hidden;
	}
	li {
	    list-style-type: none;
	}
</style>
</head>
<body>
	<div class="container" style="margin-top: 50px">
		<div id="avfilter">
			<div class="avfilter_container"></div>
		</div>
		<div id="imgid">
			<div class="imgpage">
				<ul class="imglist clearfix pageNum0">

				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		load();
	});
	function load(){
		$.ajax({type: "GET",url: "${pageContext.request.contextPath}/images.do",data:{'index':0,'size':100},dataType:"json",
			 success: function (data ,textStatus, jqXHR)
			 {  
				var html = "";
				$(data['list']).each(function(index,element){
					var col = "<li class='imgitem'>"+
						"<div class='imgbox'>"+
						"<a href='' target='_blank' style='display: block; width: 263px; height: 164px; margin-top: 0.427184px;' >"+
						"<img class='main_img img-hover' data-imgurl='' src='"+element['url']+"' style='background-color: rgb(175, 154, 178); width: 263px; height: 164px;'>"+
						"</a>"+
						"</div>"+
						"</li>";
					html += col;
				});
				$(".imgpage ul").append(html);
			 },
		    error:function (XMLHttpRequest, textStatus, errorThrown) {
		    }
	 	});
	}
</script>
</html>