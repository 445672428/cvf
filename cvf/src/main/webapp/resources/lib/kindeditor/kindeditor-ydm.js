var Ydm_KindEditor =function(){
}

Ydm_KindEditor.prototype = {
		options:{
			K:null,
			userid:0,
			folder:'temp',
			rootpath:'',
			serviceurl:'/upload_ydm/',
			imgurl:'imageUploadAction.do',
			elements:null,
			systemid:0,
			qcloudpic:false,
			picopt:"bbb",
			maxsize:'200MB',
			imgmaxsize:'2MB',
				des:'c186c95f8ad8dbc0e6b92e28c43dccd4', //上传参数
				videourl:'mediaUploadAction.do'
		},
		setOptions:function(options)
		{
			this.options=$.extend({},this.options,options);
		},
		ImageUpload:function(option)
		{
			if(option!=null)
			{
				var settings=$.extend({},this.options,option);
				var receiveEL=settings.elements;
				KindEditor.ready(function(K) {
					 K.DEBUG=true;
			            var editor = K.editor({
			                uploadJson :settings.serviceurl+  settings.imgurl+"?id="+settings.folder+"&qcloudpic="+settings.qcloudpic+"&picopt="+settings.picopt+"&systemid="+settings.systemid,
			                imageSizeLimit :settings.imgmaxsize,
			                allowFileManager : true,
			                afterBlur:function(){this.sync();},
			                formatUploadUrl:false
			            });
		              editor.loadPlugin('image', function() {
		                    editor.plugin.imageDialog({
		                        showRemote : false,
		                        clickFn : function(data) {    
			                        if(receiveEL!=null)
			                        {
				                         for(var i=0,k=receiveEL.length;i<k;i++)
				                         {
				                          	var img=$("#"+receiveEL[i]);
				                          	if(img){
					                          	if(img.is("img"))
					                          	{
					                          		$("#"+receiveEL[i]).attr("src",data.url);
					                          	}else if(img.is("input"))
					                          	{
					                          		img.val(data.url);
					                          	}
				                          	}
				                         }
			                        }
		                            editor.hideDialog();
		                        }
		                    });
		                });
		            });
				 
				
			}
		},
		VideoUpload:function (options)
		{
			var settings=$.extend({},this.options,options);
			var receiveEL=settings.elements;
			KindEditor.ready(function(K) {
				 K.DEBUG=true;
			var editor2 = K.editor({
					uploadJson :settings.serviceurl+ settings.videourl+"?p="+settings.des+"&id="+settings.id,
					imageSizeLimit : settings.maxsize,
					allowFileManager : true,
		         afterBlur:function(){this.sync();},
					formatUploadUrl:false
					
				});
			  //视频上传
					editor2.loadPlugin('image', function() {
						editor2.plugin.imageDialog({
							allowMediaUpload: true,
							showRemote : false,
							clickFn : function(data) {	
								//$("input[id='videourl']").val(data.url);	
								 if(receiveEL!=null)
			                        {
				                         for(var i=0,k=receiveEL.length;i<k;i++)
				                         {
				                          	var img=$("#"+receiveEL[i]);
				                          	if(img){
					                          	if(img.is("input"))
					                          	{
					                          		img.val(data.url);
					                          	}
				                          	}
				                         }
			                        }
								editor2.hideDialog();
							}
						});
					});
			});
		},
		editor:function(options)
		{
			 
			var settings=$.extend({},this.options,options);
			if(settings.id!=null)
				{
					var tools=[  'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template',  'paste',
						         'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
						         'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
						         'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
						         'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
						         'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|',  'multiimage',
						         'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
						         'anchor', 'link', 'unlink', '|', 'about'];
					var editoroptions={uploadJson :settings.serviceurl+ settings.imgurl+"?id="+settings.folder+"&qcloudpic="+settings.qcloudpic+"&picopt="+settings.picopt+"&systemid="+settings.systemid,//'../imageUploadAction.do?id=cwh',
				              imageSizeLimit : settings.imgmaxsize,
									allowFileManager : true,
									fileManagerJson : 'kindEditorManager.do',
									afterBlur:function(){this.sync();},
									items:tools,
				              formatUploadUrl:false
				              
						};
					if(settings.K!=null)
						{
							var K=settings.K;
						 	K.DEBUG=true;
							var tmp_editor= K.create('textarea[id="'+settings.id+'"]', editoroptions);
							return tmp_editor;
						}else{
							KindEditor.ready(function(K) {	
								 K.DEBUG=true;
								window.ydmeditor = K.create('textarea[id="'+settings.id+'"]',editoroptions);
							 });
						}
					
				}
			return window.ydmeditor;
		}
}

//var ydm_editor=null;
//KindEditor.ready(function(K) {	
//$(function(){
	var	ydm_editor = new Ydm_KindEditor();
//});
//});
