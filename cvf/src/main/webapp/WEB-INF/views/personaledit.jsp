<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<!-- jquery -->
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/mylib/select.css" />
<link rel="stylesheet" type="text/css" href="${CONTEXTPATH }/resources/css/personaledit.css" />
</head>
<body>
<div class='my_head'>
	<div id="1000000" class="mod-banner" style="display: block;">
		<a id="pUserInfo" onclick="return false;" class="user-name">
			<span onmouseover='showTag();' onmouseout='hideTag();' >仙桃市丶波波</span>
		</a>| 
		<a href="https://www.baidu.com/">首页</a>
	</div>
</div>
<div class="container customTainer">
	<div>
		<div class='setTop'>个人设置</div>
		<div class="setting-content clearfix"> 
			<div class="setting-menu"> 
				<div class="menu-title menu-privacy active"> <h3>个人资料</h3></div> 
				<ul class="menu-list"> 
					<li class="menu-item basic-link on"><a>基本资料</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item details-link"><a href="https://www.baidu.com/p/setting/profile/basic" target="tiebaPrivacySetting">详细资料</a> </li>
					<li class="menu-split">  </li>
					<li class="menu-item education-link"><a>教育背景</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item career-link"><a>工作信息</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item portrait-link"><a>头像设置</a> </li>
				</ul> 
				<div class="menu-title menu-privacy" id="settingPrivacy"> <h3>隐私设置</h3> </div> 
				<ul class="menu-list"> 
					<li class="menu-item tieba-link" id="settingPrivacyTieba"><a>我在贴吧</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item zhidao-link" id="settingPrivacyZhidao"><a>我在知道</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item wenku-link" id="settingPrivacyWenku"><a>我在文库</a>  </li>
					<li class="menu-split"> </li>
					<li class="menu-item baike-link" id="settingPrivacyBaike"><a>我在百科</a> </li>
					<li class="menu-split"> </li>
				</ul> 
			</div>
			<div class="setting-detail" id="stthld">
				<form id="profile" class="setting-profile-form" method="POST" action="https://passport.baidu.com/v2/?ucenterset"> 
					<table> 
						<tbody> 
							<tr> 
								<th>体型:</th> 
								<td> 
									<div id="cussel1000000" class="mod-cus-sel cus-sel-active">
									</div>
									<div id="cussel1000001" class="mod-cus-sel cus-sel-active">
									</div>
								</td>
							</tr>
						</tbody>
					</table> 
					<input type="submit" class="setting-submit-btn" value="保存"> 
				</form>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	var datas = [];
	for(var index = 0;index <100;index++){
		var data = {"name":"波波"+index,"value":"波波"+index};
		datas.push(data);
	}
	var datas2 = [];
	for(var index = 0;index <100;index++){
		var data = {"name":"健美"+index,"value":"健美"+index};
		datas2.push(data);
	}
	cvfSelect({'id':'cussel1000000','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000001','datas':datas2});
	menuSelect();
	//bodyAddClick();
});
function menuSelect(){
	$(".setting-menu a").on('click',function(){
		var This = $(this);
		var parent = This.parent();
		if(!parent.hasClass("on")){
			var ulsElement = parent.siblings(".on");
			if(ulsElement.length>0){
				parent.siblings(".on").removeClass('on');
				parent.addClass("on");
			}else{
				$(".setting-menu ul.menu-list li.on").removeClass('on');
				parent.addClass("on");
				$(".menu-title.menu-privacy").removeClass("active");
				parent.parent().prev(".menu-title.menu-privacy").addClass("active");
			}
		}
	});
}

var _targetID;
function cvfSelect(params){
	var fristDefault = params['default']||"请选择";
	var id = params['id'];
	var datas = params['datas']||[];
	var lo = "<div tmpId='"+id+"' class='cus-sel-opt-panel'>"+fristDefault+"</div>";
	lo += "<ol class='cus-sel-opt-ctn isShow'>";
	for(var index = 0; index < datas.length;index++){
		var data = datas[index];
		lo += "<li class='cus-sel-opt '><a class='cus-sel-opt-txt' data-value='"+data['value']+"' href='#'>"+data['name']+"</a></li>";
	}
	lo += "</ol>";
	$("#"+id).html(lo);
	
	$("#"+id+" ol li a.cus-sel-opt-txt").on('click',function(){
		var cxt = $(this).html();
		$("div[tmpId="+id+"]").html(cxt);
		$("#"+id+" .cus-sel-opt-ctn").hide();
	});
	var isFirst = true;
	$("#"+id).on('click',function(){
    	if(isFirst){
    		isFirst = false;
    		customerShow(id);
    	}else{
        	if($("#"+id+" .cus-sel-opt-ctn").hasClass("isShow")){
        		customeHide(id);
        	}else{
        		customerShow(id);
        	}
    	}
    	if(_targetID&&_targetID!=id){
    		customeHide(_targetID);
    	}
    	_targetID = id;
	});
	var customerShow = function(id){
		$("#"+id+" .cus-sel-opt-ctn").addClass("isShow");
		$("#"+id+" .cus-sel-opt-ctn").show();
	};
	var customeHide = function(id){
		$("#"+id+" .cus-sel-opt-ctn").removeClass("isShow");
		$("#"+id+" .cus-sel-opt-ctn").hide();
	}

}

var bodyAddClick = function(){
	$("body").bind('click',function(e){
		if (!$(e.target).closest(".cus-sel-opt-ctn").length) {
	        var element = $(e.target);
	        if(element.hasClass("cus-sel-opt-panel")){       
				if(_targetID){
					customeHide(_targetID);
				}        
	        }
	    }
	});	
}


</script>
<script type="text/javascript">
	function showTag(){
		var element = event.target||event.srcElement;
		var _this = this;
	}
	function hideTag(){
		var element = event.target||event.srcElement;
	}
</script>
</html>