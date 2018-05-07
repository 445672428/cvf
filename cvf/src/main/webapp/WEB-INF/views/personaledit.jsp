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
<style type="text/css">
.mod-cus-input-242 {
    width: 242px;
}
.mod-cus-input {
    border: 1px solid;
    border-color: #d8d8d8 #e5e5e5 #e5e5e5 #d8d8d8;
    box-shadow: 2px 3px 3px #f6f8f9 inset;
    outline: none;
    padding: 0 8px;
    width: 212px;
    height: 26px;
    font-size: 12px;
    line-height: 26px\0;
    padding: 1px 8px;
}
.setting-profile-form .profile-gender {
    margin: 0 25px 0 3px;
    vertical-align: middle;
}
.setting-submit-ml100 {
    margin: 13px 0 0 100px;
}
.setting-detail .setting-profile-title {
    font-size: 20px;
    color: #999;
    line-height: 1;
    padding: 11px 0 11px 11px;
    border-bottom: solid 2px #f2f2f2;
}
.yahei {
    font-family: "microsoft yahei","\5FAE\8F6F\96C5\9ED1",Tahoma,Arial,Helvetica,STHeiti;
}
.delete{
    background: #f7f7f7;
}
.mod-userbar-select div {
    position: absolute;
    right: 0;
    top: 20px;
    border: 1px solid #9b9b9b;
    box-shadow: 1px 1px 2px #ccc;
    background: #fff;
    display: none;
    width: 65px;
}
.mod-userbar li {
    float: left;
    margin: 0 5px;
    color: #ccc;
    height: 24px;
}
.mod-banner a {
    color: #000;
}
</style>
</head>
<body>
<div class='my_head'>
	<div class="mod-banner" style="display: block;">
		<a id="pUserInfo" onclick="return false;" class="user-name">
			<span onmouseover='showTag();' onmouseout='hideTag();' >仙桃市丶波波</span>
		</a>
		
		<div id="userbar-panel-list" >
			<ul class="pass-userpanel clearfix">
				<li class="pass-list pass-list-1"><a target="_blank">首页</a></li>
				<li class="pass-list pass-list-1"><a target="_blank">帐号设置</a></li>
				<li class="pass-list pass-list-2"><a class="pass-item">退出</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="container customTainer">
	<div>
		<div class='setTop'>个人设置</div>
		<div class="setting-content clearfix"> 
			<div class="setting-menu"> 
				<div class="menu-title menu-privacy active"><h3>个人资料</h3></div> 
				<ul class="menu-list"> 
					<li class="menu-item basic-link on"><a>基本资料</a> </li>
					<li class="menu-split"> </li>
					<li class="menu-item details-link"><a>详细资料</a> </li>
					<li class="menu-split"></li>
					<li class="menu-item education-link"><a>教育背景</a> </li>
					<li class="menu-split"></li>
					<li class="menu-item career-link"><a>工作信息</a> </li>
					<li class="menu-split"></li>
					<li class="menu-item portrait-link"><a>头像设置</a> </li>
				</ul> 
				<div class="menu-title menu-privacy" id="settingPrivacy"><h3>隐私设置</h3></div> 
				<ul class="menu-list"> 
					<li class="menu-item tieba-link" id="settingPrivacyTieba"><a>我的收藏</a></li>
					<li class="menu-split"> </li>
					<li class="menu-item zhidao-link" id="settingPrivacyZhidao"><a>我的浏览</a></li>
					<li class="menu-split"> </li>
					<li class="menu-item wenku-link" id="settingPrivacyWenku"><a>我的文库</a></li>
					<li class="menu-split"> </li>
					<li class="menu-item baike-link" id="settingPrivacyBaike"><a>我的搜索</a></li>
					<li class="menu-split"> </li>
				</ul> 
			</div>
			<div class="setting-detail" id="stthld">
<%-- 				<div class="setting-profile-title yahei">基本资料</div>
				<form id="profile" class="setting-profile-form" method="POST" action="${CONTEXTPATH }/maker/name?name=basicInfo"> 
					<table> 
						<tbody> 
							<tr> 
								<th>姓名:</th> 
								<td> 
									<input type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
								</td>
							</tr>
							<tr> 
								<th>性别:</th> 
								<td> 
									<input name="passport_sex" id="passport-sex-1" type="radio" value="1" checked="">
									<label class="profile-gender" for="passport-sex-1">男</label>
									<input name="passport_sex" id="passport-sex-2" type="radio" value="2">
									<label for="passport-sex-2" class="profile-gender">女</label>
								</td>
							</tr>
							<tr> 
								<th>体型:</th> 
								<td> 
									<div id="cussel1000000" class="mod-cus-sel cus-sel-active"></div>
									<div id="cussel1000001" class="mod-cus-sel cus-sel-active"></div>
								</td>
							</tr>
							<tr> 
								<th>血型:</th> 
								<td> 
									<div id="cussel1000002" class="mod-cus-sel cus-sel-active"></div>
								</td>
							</tr>
							<tr> 
								<th>出身地:</th> 
								<td> 
									<div id="cussel1000003" class="mod-cus-sel cus-sel-active"></div>
									<div id="cussel1000004" class="mod-cus-sel cus-sel-active"></div>
								</td>
							</tr>
							<tr> 
								<th>居住地:</th> 
								<td> 
									<div id="cussel1000005" class="mod-cus-sel cus-sel-active"></div>
									<div id="cussel1000006" class="mod-cus-sel cus-sel-active"></div>
								</td>
							</tr>
						</tbody>
					</table> 
					<input type="submit" class="setting-submit-btn setting-submit-ml100" value="保存"> 
				</form> --%>
<%-- 				<div class="setting-profile-title yahei">教育背景</div>
<form id="profile" class="setting-profile-form" method="POST" action="${CONTEXTPATH }/maker/name?name=basicInfo"> 
	<table style="margin-left: 50px;"> 
		<thead>
			<tr>
				<th style="text-align: center;width: 80px;">阶段</th>
				<th style="text-align: center;width: 180px;">名称</th>
				<th style="text-align: center;width: 80px;">地区</th>
				<th style="text-align: center;width: 80px;">年份</th>
			</tr>
		</thead>
		<tbody> 
			<tr> 
				<td style="text-align: center;">小学:</td>
				<td >
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div id="cussel1000000" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000001" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			
			<tr> 
				<td style="text-align: center;">初中:</td>
				<td >
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div id="cussel1000002" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000003" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			
			
			<tr> 
				<td style="text-align: center;">高中:</td>
				<td >
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div id="cussel1000004" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000005" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			
			
			<tr> 
				<td style="text-align: center;">大学:</td>
				<td >
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div id="cussel1000006" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000007" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			
			<tr> 
				<td style="text-align: center;">考研:</td>
				<td >
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div id="cussel1000008" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000009" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			<tr> 
				<td style="text-align: center;">博士:</td>
				<td >
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div id="cussel1000010" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000011" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
		</tbody>
	</table> 
	<input type="submit" class="setting-submit-btn setting-submit-ml100" value="保存"> 
</form> --%>
<%-- <div class="setting-profile-title yahei">详细资料</div>
<form id="profile" class="setting-profile-form" method="POST" action="${CONTEXTPATH }/maker/name?name=basicInfo"> 
	<table> 
		<tbody> 
			<tr> 
				<th>姓名:</th> 
				<td> 
					<input type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
			</tr>
			<tr> 
				<th>个人习惯:</th> 
				<td> 
					<div id="cussel1000000" class="mod-cus-sel cus-sel-active"></div>
					<div id="cussel1000001" class="mod-cus-sel cus-sel-active"></div>
					<div id="cussel1000002" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			<tr> 
				<th>个人爱好:</th> 
				<td> 
					<input type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
			</tr>
			<tr> 
				<th>个人性格:</th> 
				<td> 
					<div id="cussel1000003" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			<tr> 
				<th>教育程度:</th> 
				<td> 
					<div id="cussel1000004" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			<tr> 
				<th>职业:</th> 
				<td> 
					<div id="cussel1000005" class="mod-cus-sel cus-sel-active"></div>
				</td>
			</tr>
			<tr> 
				<th>联系方式:</th> 
				<td> 
					<input type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
			</tr>
		</tbody>
	</table> 
	<input type="submit" class="setting-submit-btn setting-submit-ml100" value="保存"> 
</form> --%>
<div class="setting-profile-title yahei">工作信息</div>
<form id="profile" class="setting-profile-form" method="POST" action="${CONTEXTPATH }/maker/name?name=basicInfo"> 
	<table style="margin-left: 50px;"> 
		<thead>
			<tr>
				<th style="text-align: center;width: 170px;">工作单位</th>
				<th style="text-align: center;width: 150px;">地区</th>
				<th style="text-align: left;width: 80px;" colspan="3">工作时间</th>
			</tr>
		</thead>
		<tbody> 
			<tr class="delete">
				<td>国务院</td>
				<td>北京</td>
				<td>20181212</td>
				<td>20581212</td>
				<td>
					<a class="career-delete-btn" href="#">删除</a>
				</td>
			</tr>
			<tr> 
				<td>
					<input style="width: 150px;" type="text" name="passport_userschool" id="passport_userschool" class="mod-cus-input-242 mod-cus-input" value="" style="color: rgb(204, 204, 204);">
				</td>
				<td>
					<div style="width: 150px;" id="cussel1000000" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000001" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<div id="cussel1000002" class="mod-cus-sel cus-sel-active"></div>
				</td>
				<td>
					<input type="submit" class="setting-submit-btn" value="保存"> 
				</td>
			</tr>
		</tbody>
	</table> 
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
	cvfSelect({'id':'cussel1000002','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000003','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000004','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000005','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000006','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000007','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000008','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000009','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000010','datas':datas,'default':'选择波波'});
	cvfSelect({'id':'cussel1000011','datas':datas,'default':'选择波波'});
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