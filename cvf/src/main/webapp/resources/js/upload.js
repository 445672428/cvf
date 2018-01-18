//(function(root,jquery,win,factory){
//	var local = factory();
//	root['upload'] = local;
//}(this,$,window,function(){
//	var CHUNCKSIZE = 1 * 1024 * 1024;
//	var formData = new FormData();
//	var fileMap = new Map();
//	
//	var _id = 'multipleInput';
//	$("#fileUpload").bind('click',push);
//	$(_id).bind('change',fileUpload);
//	var fileUpload = function(){
//	}
//	var push = function(){
//	}
//	var factory = {};
//	return factory;
//}))
$(function(){
	initFileInfo({'loadId':'multipleInput','startUp':'startUp','stopUp':'stopUp','delUp':'delUp'});
});
//添加文件

function fileEntity(){ return{'start':false,'pause':false,'del':false}; }
var fileMap = new Map();
function initFileInfo(){
	var params = arguments.length;
	var loadId = arguments[params-1]['loadId'];
	var startUp = arguments[params-1]['startUp'];
	var stopUp = arguments[params-1]['stopUp'];
	var delUp = arguments[params-1]['delUp'];
	$("#"+loadId).change(function(event){
		var element = event.target||event.srcElement;
		var fiels = element.files;
		var content = "";
		var fileInfo = fileEntity();
		$(fiels).each(function(index,e){
			var _id = getUuid();
			fileInfo.uuid = _id;
			fileInfo.status = false;
			fileInfo.file = e;
			fileMap.set(_id,fileInfo);
			
			var canvas = document.createElement('canvas');
			canvas.style.width = '100px;';
			canvas.style.height = '100px;'
			canvas.style.bor3der   = "1px solid";
			var cxt = canvas.getContext('2d');
			var reader = new FileReader();
			reader.readAsDataURL(fiels[0]);
			reader.onload= function(e){
				var res = reader.result;
				var img = new Image();
				img.src=res;
				img.onload = function(){
					cxt.drawImage(img,0,0);
				};
			};
			var _size = toDecimal2(e['size']/1024);
			var tr = "<tr class='template-upload fade in'>"+
			"<td class='preview'><span class='fade in'><canvas style='width:80px;height:80px;'></canvas></span></td>"+
			"<td>"+e['name']+"</td>"+
			"<td>"+_size+"/kb</td>"+
			"<td><div class='progress'><div class='progressbar'></div></div></td>"+
			"<td id='progressId'>100%</td>"+
			"<td id='createTime'>20180113</td>"+
			"<td>"+e['type']+"</td>"+
			"<td><button cls='start' uuid='"+_id+"' class='btn blue start'>开始上传</button></td>"+
			"<td><button cls='pause' uuid='"+_id+"' class='btn blue pause'>暂停上传</button></td>" +
			"<td><button cls='delete' uuid='"+_id+"' class='btn blue delete'>删除</button></td></tr>";
			content += tr;
		});
		$("table[role='presentation'] tbody").append(content);
	});
	$("button[cls].btn").bind('click',slice_fileUpload);
}
//通过规则 uuid 对应一个文件信息

//定义一个操作 枚举
var handlerEnum = {'DEL': 1,'PAUSE': 2,'UP': 3,'ALL': 4};
var handlerType = {'allstart':'allstart','allcan':'allcan','alldel':'alldel','start':'start','pause':'pause','delete':'delete'};

function slice_AllfileUpload(){
	
}
function slice_AllCanclefileUpload(){
	
}
function slice_AllPausefileUpload(){
	
}
function slice_SingleStartfileUpload(){
	
}
function slice_SinglePausefileUpload(){
	
}
function slice_SingleCanceltfileUpload(){
	
}


function slice_fileUpload(){
	if(fileMap.size<0){
		return;
	}
	var element = event.target||event.srcElement;
	if(element.localName=='span'){
		element = $(element).parent();
	}
	var loadId = $(element).attr('uuid');
	var _cls = $(element).attr('cls');
	var keys = [];
	fileMap.forEach(function(val,key,map){
		keys.push(key);
	});
	for(var ind = 0; ind < keys.length;ind ++){
		var val = fileMap.get(keys[ind]);
		var CHUNCKSIZE = 1 * 1024 * 1024;
		//status用来标识上传文件是否有运行 
		if(_cls==='allstart'){
			fileMap.forEach(function(val,key,map){
				val['start'] = true;
				val['status'] = true;
			});
		}else if(_cls==='allcan'){
			fileMap.forEach(function(val,key,map){
				val['start'] = false;
				val['status'] = false;
			});
		}else if(_cls==='alldel'){
			fileMap.forEach(function(val,key,map){
				val['start'] = false;
				val['status'] = false;
			});
		}else if(_cls==='start'){
			if(loadId&&loadId==val['uuid']){
				val['start'] = true;
				status = true;
			}
		}else if(_cls==='pause'){
			if(loadId&&loadId==val['uuid']){
				status = false;
			}
		}else if(_cls==='delete'){
			if(loadId&&loadId==val['uuid']){
				status = false;
			}
		}
		var uuid = val['uuid'];
		var file = val['file'];
		var name = file['name'];
		var size = file['size'];
		var type = file['type'];
		var chunkCount = Math.ceil(size/CHUNCKSIZE);
		if(val['start']){
			if(val['pause']||val['del']){
				break;
			}			
		}
		for(var index = 0; index < chunkCount; index++){
			var start = index * CHUNCKSIZE;
			var end = Math.min(size, start + CHUNCKSIZE);
			var formData = new FormData();
			var precent = toDecimal2(end/size) * 100;
			//多文件 并行上传 规则 当前文件分块总数量  索引数  上传者的IP 一个文件生成的唯一uuid    
			formData.append(chunkCount+"——"+(index+1)+"——"+REALIP+"_"+val['uuid'], file.slice(start, end),name);
			if(val['del']||val['pause']){
				continue;
			}
			if(val['del']&&uuid==loadId){
				continue;
			}
			if(val['pause']&&uuid==loadId){
				continue;
			}
			$.ajax({
		        url: CONTEXTPATH+"/file/load",
		        type: "POST",
		        data: formData,
		        async:false,
		        processData: false,
		        contentType: false,
		        success: function (responseText) {
		            $(".progressbar").css({'width':precent+"%"});
					$("#progressId").html(precent);
		        }
		    });
		}
	}
}

function reloadUp(){
	
}

/*
 * 文件分段上传jquery插件
 */
(function (jQuery) {
	jQuery.fn.fcupInitialize = function () {

		return this.each(function () {

			var button = jQuery(this),
			fcup = 0;
			if (!jQuery.uploading) {
				jQuery.uploading = '上传中...';
			}
			if (!jQuery.upfinished) {
				jQuery.upfinished = '上传完成';
			}
			var options = jQuery.extend({
					loading: jQuery.uploading,
					finished: jQuery.upfinished
				}, button.data());

			button.attr({
				'data-loading': options.loading,
				'data-finished': options.finished
			});
			var bar = jQuery('<span class="tz-bar background-horizontal">').appendTo(button);
			button.on('fcup', function (e, val, absolute, finish) {

				if (!button.hasClass('in-fcup')) {
					bar.show();
					fcup = 0;
					button.removeClass('finished').addClass('in-fcup')
				}
				if (absolute) {
					fcup = val;
				} else {
					fcup += val;
				}

				if (fcup >= 100) {
					fcup = 100;
					jQuery.upstr = options.finished;
					jQuery.fcup_add();
				}

				if (finish) {

					button.removeClass('in-fcup').addClass('finished');

					bar.delay(500).fadeOut(function () {
						button.trigger('fcup-finish');
						setProgress(0);
					});

				}

				setProgress(fcup);
			});

			function setProgress(percentage) {
				bar.filter('.background-horizontal,.background-bar').width(percentage + '%');
				bar.filter('.background-vertical').height(percentage + '%');
			}

		});

	};

	jQuery.fn.fcupStart = function () {

		var button = this.first(),
		last_fcup = new Date().getTime();

		if (button.hasClass('in-fcup')) {
			return this;
		}

		button.on('fcup', function () {
			last_fcup = new Date().getTime();
		});

		var interval = window.setInterval(function () {

				if (new Date().getTime() > 2000 + last_fcup) {

					button.fcupIncrement(5);
				}

			}, 500);

		button.on('fcup-finish', function () {
			window.clearInterval(interval);
		});

		return button.fcupIncrement(10);
	};

	jQuery.fn.fcupFinish = function () {
		return this.first().fcupSet(100);
	};

	jQuery.fn.fcupIncrement = function (val) {

		val = val || 10;

		var button = this.first();

		button.trigger('fcup', [val])

		return this;
	};

	jQuery.fn.fcupSet = function (val) {
		val = val || 10;

		var finish = false;
		if (val >= 100) {
			finish = true;
		}

		return this.first().trigger('fcup', [val, true, finish]);
	};

})(jQuery);

var big_upload = {

	fcup: function (config) {
		jQuery.extend(config);
		if (!jQuery.upstr) {
			jQuery.upstr = '上传文件';
		}
		if(!jQuery.upid){
			jQuery.upid = 'ad47494fc02c388e';
		}
		if (jQuery.updom && jQuery.upurl) {
			jQuery.fcup_add();
		}
	},

	fcup_add: function () {
		var html = '<div class="fcup-button">';
		html += jQuery.upstr;
		html += '<input type="file" id="'+ jQuery.upid +'" onchange="jQuery.big_upload()" style="position:absolute;font-size:100px;right:0;top:0;opacity:0;">';
		html += '</div>';
		jQuery(jQuery.updom).html(html);
	},
	fc_GetPercent: function (num, total) {
		num = parseFloat(num);
		total = parseFloat(total);
		if (isNaN(num) || isNaN(total)) {
			return "-";
		}
		return total <= 0 ? 0 : (Math.round(num / total * 10000) / 100.00);
	},

	big_upload: function () {
		jQuery('.fcup-button').fcupInitialize();
		var controlButton = jQuery('.fcup-button');
		var width = controlButton.outerWidth(true);
		var result = '';
		var file = jQuery('#'+jQuery.upid)[0].files[0],

		name = file.name,

		size = file.size,

		index1 = name.lastIndexOf(".");

		index2 = name.length,

		suffix = name.substring(index1 + 1, index2);
		if (!jQuery.shardsize) {
			jQuery.shardsize = 2;
		}
		var shardSize = jQuery.shardsize * 1024 * 1024,

		succeed = 0;

		shardCount = Math.ceil(size / shardSize);

		if (jQuery.uptype) {
			if (!jQuery.errtype) {
				jQuery.errtype = '文件类型不对';
			}
			uptype = jQuery.uptype.split(",");
			if (jQuery.inArray(suffix, uptype) == -1) {
				jQuery.upstr = jQuery.errtype;
				jQuery.fcup_add();
				return false;
			}
		}

		for (var i = 0; i < shardCount; ++i) {

			var start = i * shardSize,

			end = Math.min(size, start + shardSize);

			var form = new FormData();

			form.append("file_data", file.slice(start, end));

			form.append("file_name", name);

			form.append("file_total", shardCount);

			form.append("file_index", i + 1);
			
			jQuery.ajax({
				url: jQuery.upurl,
				type: "POST",
				data: form,
				async: true,
				processData: false,
				contentType: false,
				success: function (result) {
					if(typeof jQuery.upcallback == 'function'){
					    jQuery.upcallback(result);
					}else{
						console.log(result);
					}
					++succeed;
					var cent = jQuery.fc_GetPercent(succeed, shardCount);
					console.log(cent + '%');
					controlButton.fcupSet(cent);
				}
			});

		}

	}

};
(function (jQuery) {
	jQuery.extend(big_upload);
})(jQuery);

//(function (window, $, undefined) {
//    play=function(){
//        $("#demo").val("This is a demo.");
//    }
//    window.wbLogin = play;
//})(window, jQuery);


