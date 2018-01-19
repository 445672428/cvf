//  假定页面存在如下元素
//  <input type="text" id="username">
//  注册input事件
/*
 * 保存input 新旧值
 * */
var userid = 'bobo';
var inputValue = "";
var username = document.getElementById("username");
var result = [];
var fileInfo = {};
var _UUID = 'bobo';
var _LEVEL = 0;
$(function(){
	//$("div[data-options='west']").css("overflow","hidden");
	loadFile();
	createFile();
	initFile(userid,_LEVEL,_UUID);
	//$(".fileDiv,.ui-widget-content").on('onmousedown',rightClick);
	$(".fileDiv,.ui-widget-content").on('mouseover',showDel);
	$(".fileDiv,.ui-widget-content").on('mouseout',hideDel);
	$("span.gzv8Pv").on('click',delThisFile);
	//$(".ui-widget-content img").draggable({'revert': true, 'helper': "clone",'start':dragStart,'drag':drag,'stop':dragStop});
})

function initFile(userid,level,parentid){
	var element = event.target||event.srcElement;
	if(element.localName=='span'&&element.className=='gzv8Pv'){
		return;
	}
	_UUID = parentid;
	_LEVEL = level;
	$.ajax({type: "POST",url: CONTEXTPATH+"/queryfiles.do",data: {'parentid':parentid,'userid':userid,'level':level},cache: false,async : false,dataType: "json",
        success: function (data ,textStatus, jqXHR)
        {	
        	if(data||data.length>0){
        		$(".portlet-body").html("");	
	        	var fileDiv = "";
				$(data['list']).each(function(index,e){
					fileDiv += "<div class='filecontainer'>"+
						"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+e['userid']+"','"+(e['level']+1)+"','"+e['id']+"')>" +
						"<span class='gzv8Pv'></span><img src='resources/images/file.gif'/></div>"+
						"<input uuid='"+e['id']+"' title='"+e['filename']+"' type='text' value='"+e['filename']+"' name='"+e['filename']+"' class='fileinput'/>"+
						"</div>";
				});
				$(".portlet-body").append(fileDiv);
				bindEvent();
        	}
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {      
        }
     });
}

/**
 * 绑定事件
 */
function bindEvent(){
	$(".fileDiv,.ui-widget-content").on('mouseover',showDel);
	$(".fileDiv,.ui-widget-content").on('mouseout',hideDel);
	$('.fileinput').on("focus",function(e){
		//debugger
		inputValue = $(this).val();
	});
	$('.fileinput').on("blur",function(e){
		if(inputValue!==$(this).val()){
			//编辑文件名保存
			editFileName();
			editSave($(this).attr('uuid'),$(this).val());
		}
	});
}

function showDel(){
	$(this).find("span.gzv8Pv").css("visibility","visible");
}
function hideDel(){
	$(this).find("span.gzv8Pv").css("visibility","hidden");
}
/*
 * 删除文件
 */
function delThisFile(){
	var parent = $(this).parent();
	var _func = parent.attr('ondblclick');
	//进行正则参数匹配
	//var reg = new RegExp('/\(([^)]*)\)/','g');
	//    /\((.+)\)/g
	//var params = reg.test(_func);
	var param = _func.match(/\(([^)]*)\)/);
	if(param){
		$(this).parent().parent().remove();
		var relDo = _func.replace('initFile','delFile');
		eval(relDo);
	}
}
/*
 * 后台删除文件
 */
function delFile(userid,level,parentid){
	$.ajax({type: "POST",url: CONTEXTPATH+"/delfiles.do",data: {'parentid':parentid,'userid':userid,'level':level},cache: false,async : false,dataType: "json",
		 success: function (data ,textStatus, jqXHR)
		 {   
		 	
		 },
	    error:function (XMLHttpRequest, textStatus, errorThrown) {      
	    }
 	});
}
//创建文件夹
function createFile(){
	$("#hotleinfo").bind('contextmenu',function(e){
		e.preventDefault();
		$('#createPanle').menu('show', {
			left: e.pageX,
			top: e.pageY
		});
	});
}
/**
	文件夹 表结构设置 
	id 文件id  
	userid  文件对应用户 id
	filename 文件名称
	level  文件夹等级
	ishidden  是否隐藏
	parentid  父文件的id
	description 文件描述
	subName 拼接上层文件夹名称
*/
function editHandle(){
	var uuid = getUuid();
	uuid = uuid.replace(/-/g,"");
	var parentid = _UUID;
	var level = _LEVEL;
	var fileIndex = 1;
	var files = $(".filecontainer");
	var fileDiv = "<div index='"+fileIndex+"' class='filecontainer'>"+
	"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')>" +
	"<span class='gzv8Pv'></span><img src='resources/images/file.gif'/></div>"+
	"<input uuid='"+uuid+"' type='text' title='新建文件夹' value='新建文件夹' name='新建文件夹' class='fileinput'/>"+
	"</div>";
	if(typeof(files)=='undefined'&&files.length==0){
		//直接进行保存
	}else{
		var same = [];
		for(var i = 0; i < files.length; i++){
			var $_f = $(files[i]);
			 var input = $_f.find("input").eq(0);
			 var name = input.val();
			 if(name.indexOf('新建文件夹')>-1){
				 same.push(input);
			 }
		}
		if(same.length>0){
			var temp = 0;
			var len = same.length;
			do{
				if(len-1==0){
					 var name = '新建文件夹1';
					 fileDiv = "<div class='filecontainer'>"+
						"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')>" +
						"<span class='gzv8Pv'></span><img src='resources/images/file.gif' /></div>"+
						"<input uuid='"+uuid+"' title='"+name+"' type='text' value='"+name+"' name='"+name+"' class='fileinput'/>"+
						"</div>";
				}else{
					var pre = same[temp];
					var lst = same[temp+1];
					if(typeof(lst)=='undefined'){
						 var name = '新建文件夹'+(len);
						 fileDiv = "<div class='filecontainer'>"+
							"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')>" +
							"<span class='gzv8Pv'></span><img src='resources/images/file.gif'/></div>"+
							"<input uuid='"+uuid+"' title='"+name+"' type='text' value='"+name+"' name='"+name+"' class='fileinput'/>"+
							"</div>";
							break;
					}else{
						var n1 = pre.val().substring(pre.val().indexOf('新建文件夹')+5, pre.val().length)==''?0:pre.val().substring(pre.val().indexOf('新建文件夹')+5, pre.val().length);
						var n2 = lst.val().substring(lst.val().indexOf('新建文件夹')+5, lst.val().length);
						if((parseInt(n2)-parseInt(n1))!=1){
							 var name = '新建文件夹'+(parseInt(n1)+1);
							 fileDiv = "<div class='filecontainer'>"+
								"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')>" +
								"<span class='gzv8Pv'></span><img src='resources/images/file.gif' /></div>"+
								"<input uuid='"+uuid+"' title='"+name+"' type='text' value='"+name+"' name='"+name+"' class='fileinput'/>"+
								"</div>";
						}
					}
				}
				temp++;
			}while(temp<len);
		}
	}
	
	$(".portlet-body").append(fileDiv);
	var $currentFile = $(fileDiv);
	var filename = $currentFile.find(".fileinput").val();
	$currentFile.attr('uuid',uuid);
	$currentFile.attr('userid',userid);
	$currentFile.attr('parentid',parentid);
	$currentFile.attr('level',level);
	fileInfo.uuid = uuid;
	fileInfo.filename = filename;
	fileInfo.userid = userid;
	fileInfo.parentid = parentid;
	fileInfo.level = level;
	$.ajax({type: "POST",url: CONTEXTPATH+"/filecreate.do",data: {'uuid':uuid,'userid':userid,'filename':filename,'parentid':parentid,'level':level},cache: false,async : false,dataType: "json",
        success: function (data ,textStatus, jqXHR)
        {	
			bindEvent();
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {      
        }
     });
}
//文件名修改 保存
function editSave(id,name){
	if($('.fileinput').length>0){
		for(var ind = 0; ind < $('.fileinput').length;ind ++){
			if($($('.fileinput')[ind]).val() == name){
				$($('.fileinput')[ind]).val(inputValue);
				return;
			}
		}
	}
	$.ajax({type: "POST",url: CONTEXTPATH+"/savename.do",data: {'id':id,'name':name},cache:false,async:false,dataType:"json",
		 success: function (data,textStatus,jqXHR)
		 {   
		 	
		 },
	    error:function (XMLHttpRequest,textStatus,errorThrown) {      
	    }
 	});
}
/*
 * 拖拽事件监控
 * */
function dragStart(){
	var element = event.target||event.srcElement;
	var left = element.offsetLeft;
	var height = element.offsetHeight;
	var top = element.offsetTop;
	var width = element.offsetWidth;
	
	console.log("dragStart==="+left+"=="+height+"=="+top+"=="+width);
}
var topMent;
function drag(){
	var element = event.target||event.srcElement;
	var left = element.offsetLeft;
	var height = element.offsetHeight;
	var top = element.offsetTop;
	var width = element.offsetWidth;
	console.log("drag==="+left+"=="+height+"=="+top+"=="+width);
}
function dragStop(){
	var element = event.target||event.srcElement;
	topMent = element;
//	var left = element.offsetLeft;
//	var height = element.offsetHeight;
//	var top = element.offsetTop;
//	var width = element.offsetWidth;
//	console.log("dragStop==="+left+"=="+height+"=="+top+"=="+width);
}
function rightClick(){
	var element = event.target||event.srcElement;
}

var sNodes = [];
function editFileName(){
	
	for(var i = 1; i < 100; i++){
		var f = file();
		f['key'] = i;
		f['arr'] = [];
		sNodes.push(f);
	}
}
function file(){
	return {'key':'','arr':[],'level':0,'name':''};
}
/**
 * 永远会有返回值
 */
function nodeRecursion(sNodes){
	for(var i = 0; i < sNodes.length; i++){
		if(sNodes[i]['arr'].length>=index){
			if(i==index){
				if(sNodes[index]['level']==level){
					return sNodes[i]['arr'];
				}
			}
		}else{
			res(sNodes[i]['arr']);
		}
	}
}

function loadFile(array,index){
	if(array&&Array.isArray(array)&&array.length>0){
		if(sNodes&&sNodes.length>0){
			var level = sNodes[index]['level'];
			var currentNode = nodeRecursion(sNodes);
			if(currentNode[index]['key']==array[0]['id']){
				for(var index = 0; index < array.length; index++){
					var f = file();
					f['key'] = array[index]['id'];
					f['arr'] = [];
					f['level'] = array[index]['level'];
					f['name'] = array[index]['name'];
					var arr = currentNode['arr'];
					arr.push(f);
				}
			}
		}else{
			if(array&&array.length>0){
				for(var index = 0; index < array.length; index ++){
					var ele = array[index];
					var f = file();
					f['key'] = ele['id'];
					f['arr'] = [];
					f['level'] = 0;
					f['name'] = ele['name'];
					sNodes.push(f);
				}
			}
		}
	}
}

function deleteFile(){
	
}

//
//username.addEventListener("focus", function(event) {
//	inputval = this.value;
//    result.push({
//        event  : 'input',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//});
//
//username.addEventListener("input", function(event) {
//    result.push({
//        event  : 'input',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//});
//
//username.addEventListener("onblur", function(event) {
//    result.push({
//        event  : 'input',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//});
////  注册keydown事件
//username.addEventListener("keydown", function(event) {
//    result.push({
//        event  : 'keydown',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//});
////  注册keyup事件
//username.addEventListener("keyup", function(event) {
//    result.push({
//        event  : 'keyup',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//});
////  注册change事件
//username.addEventListener("change", function(event) {
//    result.push({
//        event  : 'change',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//    //  输出结果
//});
////  注册blur事件
//username.addEventListener("blur", function(event) {
//    result.push({
//        event  : 'blur',
//        value  : this.value,
//        keyCode : event.keyCode
//    });
//    //  输出结果
//    if(this.value!==inputValue){
//    	console.log("前后数据不一样 触发保存");
//    }
//    
//});
//

