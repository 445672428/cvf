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
var fileNames = $("#username");
var fileInfo = {};
$(function(){
	//$("div[data-options='west']").css("overflow","hidden");
	loadFile();
	createFile();
	initFile('bobo',0,'bobo');
	//$(".fileDiv,.ui-widget-content").on('onmousedown',rightClick);
	//$(".ui-widget-content img").draggable({'revert': true, 'helper': "clone",'start':dragStart,'drag':drag,'stop':dragStop});
})

function initFile(userid,level,parentid){
	$.ajax({type: "POST",url: CONTEXTPATH+"/queryfiles.do",data: {'parentid':parentid,'userid':userid,'level':level},cache: false,async : false,dataType: "json",
        success: function (data ,textStatus, jqXHR)
        {	
        	$(".portlet-body").html("");	
        	var fileDiv = "";
			$(data['list']).each(function(index,e){
				fileDiv += "<div class='filecontainer'>"+
					"<div class='fileDiv ui-widget-content' file='' fileid='' ondblclick=initFile('"+e['userid']+"','"+e['level']+"','"+e['id']+"')><img src='resources/images/file.gif'  alt='' /></div>"+
					"<input title='"+e['filename']+"' type='text' value='"+e['filename']+"' name='"+e['filename']+"' class='fileinput'/>"+
					"</div>";
			});
			$(".portlet-body").append(fileDiv);
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {      
        }
     });
}

fileNames.on("focus",function(e){
	inputValue = $(this).val();
})
fileNames.on("blur",function(e){
	if(inputValue!==$(this).val()){
		//编辑文件名保存		
		editFileName();
	}
})
//ondblclick 添加双击事件
fileNames.on("mousedown",function(e){
	var uuid = $(this).attr('uuid');
	var userid = $(this).attr('userid');
	var parentid = $(this).attr('parentid');
	var level = $(this).attr('level');
		$.ajax({type: "POST",url: CONTEXTPATH+"/queryfiles.do",data: {'userid':userid,'parentid':uuid,'level':level},cache: false,async : false,dataType: "json",
        success: function (data ,textStatus, jqXHR)
        {	
        	var fileDiv = "";
			$(data['list']).each(function(index,e){
				fileDiv += "<div class='filecontainer'>"+
					"<div class='fileDiv ui-widget-content' file='' fileid='' ondblclick=initFile('"+e['userid']+"','"+e['level']+"','"+e['id']+"')><img src='resources/images/file.gif'  alt='' /></div>"+
					"<input title='"+e['filename']+"' type='text' value='"+e['filename']+"' name='"+e['filename']+"' class='fileinput'/>"+
					"</div>";
			});
			$(".portlet-body").append(fileDiv);
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {      
        }
     });
	
})

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
//创建文件夹
function editHandle(){
	var uuid = getUuid();
	uuid = uuid.replace(/-/g,"");
	var userid = 'bobo';
	var parentid = userid;
	var level = 0;
	
	var fileIndex = 1;
	var files = $(".filecontainer");
	var fileDiv = "<div index='"+fileIndex+"' class='filecontainer'>"+
	"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')><img src='resources/images/file.gif'  alt='' /></div>"+
	"<input type='text' title='新建文件夹' value='新建文件夹' name='新建文件夹' class='fileinput'/>"+
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
						"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')><img src='resources/images/file.gif'  alt='' /></div>"+
						"<input title='"+name+"' type='text' value='"+name+"' name='"+name+"' class='fileinput'/>"+
						"</div>";
				}else{
					var pre = same[temp];
					var lst = same[temp+1];
					if(typeof(lst)=='undefined'){
						 var name = '新建文件夹'+(len);
						 fileDiv = "<div class='filecontainer'>"+
							"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')><img src='resources/images/file.gif'  alt='' /></div>"+
							"<input title='"+name+"' type='text' value='"+name+"' name='"+name+"' class='fileinput'/>"+
							"</div>";
							break;
					}else{
						var n1 = pre.val().substring(pre.val().indexOf('新建文件夹')+5, pre.val().length)==''?0:pre.val().substring(pre.val().indexOf('新建文件夹')+5, pre.val().length);
						var n2 = lst.val().substring(lst.val().indexOf('新建文件夹')+5, lst.val().length);
						if((parseInt(n2)-parseInt(n1))!=1){
							 var name = '新建文件夹'+(parseInt(n1)+1);
							 fileDiv = "<div class='filecontainer'>"+
								"<div class='fileDiv ui-widget-content' ondblclick=initFile('"+userid+"','"+level+"','"+uuid+"')><img src='resources/images/file.gif'  alt='' /></div>"+
								"<input title='"+name+"' type='text' value='"+name+"' name='"+name+"' class='fileinput'/>"+
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
	fileInfo.uuid = uuid;fileInfo.filename = filename;fileInfo.userid = userid;fileInfo.parentid = parentid;fileInfo.level = level;
	$.ajax({type: "POST",url: CONTEXTPATH+"/filecreate.do",data: {'uuid':uuid,'userid':userid,'filename':filename,'parentid':userid,'level':level},cache: false,async : false,dataType: "json",
        success: function (data ,textStatus, jqXHR)
        {	
			
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {      
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

