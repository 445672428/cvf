
require.config({
    paths:{
	        'jquery': CONTEXTPATH+'/resources/lib/jQuery/jquery-1.7.1.min',
	        'additional': CONTEXTPATH+'/resources/lib/jquery-validation/1.11.1/additional-methods.min',
	        'validate': CONTEXTPATH+'/resources/lib/jquery-validation/1.11.1/jquery.validate.min',
	        'security': CONTEXTPATH+'/resources/lib/security',
	        'sockjs': CONTEXTPATH+'/resources/lib/sockjs',
	        'common': CONTEXTPATH+'/resources/js/common'
    	},
        shim:{
            "jquery": { exports: "jquery" },  
            'validate':{
                deps:['jquery']
            },
            'qrcode':{
                deps:['jquery']
            },
            'sockjs':{
            	deps:['jquery']
            },
            'additional':{
            	deps:['jquery','validate']
            }
    	}
});
require(['jquery','additional','validate','security','sockjs','common'], function(jquery) {
	
	(function() {
		initLog();
		windowOnload();
	})();
	function initLog(){
	    var canvas=document.getElementById("logo");
	    var ctx=canvas.getContext("2d");
	    var gradient=ctx.createLinearGradient(0,0,canvas.width,0);
	    gradient.addColorStop("0","magenta");
	    gradient.addColorStop("0.5","blue");
	    gradient.addColorStop("1.0","red");
	    ctx.fillStyle=gradient;
	    ctx.font="30px Verdana";
	    ctx.fillText("波波欢迎你!",30,60);
	}
	var sendHtml = "<div id='checkCode' class='register-box'><div class='box default'><label>验证码</label><input type='text' name='mobileCode' maxlength='6' autocomplete='off' id='phoneCode' class='field phonecode' placeholder='输入验证码'>"+
                    "<i class='i-status'></i><i class='i-cancel'></i><button id='sendCode' class='sendCode' type='button'>发送</button></div>	<div class='tip'><i></i><span></span></div></div>"
	
	var countdown=90; 
	function sendemail(){
	    var obj = $("#sendCode");
	    settime(obj);
	 }
	function settime(obj) { //发送验证码倒计时
	    if (countdown == 0) { 
	        obj.attr('disabled',false); 
	        obj.val("免费获取验证码");
	        countdown = 60; 
	        return;
	    } else { 
	        obj.attr('disabled',true);
	        obj.val("重新发送(" + countdown + ")");
	        countdown--; 
	    } 
	setTimeout(function() {
	    settime(obj) }
	    ,1000) 
	}
	
	var websocket,empoent,module;
	var ip = window.location.host;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://"+ip+CONTEXTPATH+"/websocket/bobo");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://"+ip+CONTEXTPATH+"/websocket/bobo");
    }
    else {
        websocket = new SockJS("ws://"+ip+CONTEXTPATH+"/websocket/bobo");
    }
    websocket.onmessage = function (m) {
    	try{
	    	var obj = JSON.parse(m.data);
	    	empoent = obj.e;
	    	module = obj.m;
    	}catch(e){}
    }
    window.onbeforeunload = function () {
    	websocket.close();
    }
    window.onunload = function() {
    	websocket.close();
    }
	function $(id) {
		return document.getElementById(id);
	}
	// 中文、字母、数字、_ - 4-20

	var regs = {
		userNameReg: /^(([\u4e00-\u9fa5])|[a-zA-Z0-9-_]){4,20}$/,
		pwdReg: /^.{6,20}$/,
		numReg: /\d/,
		strReg: /[a-zA-Z]/,
		tsReg: /[^\u4e00-\u9fa5a-zA-Z0-9]/
	}
	
	
	function windowOnload() {
		// 用户名字母、数字、_、-、中文  \u4e00-\u9fa5  4-20
		// box   常规 box  出错的时候  box error  正确的时候  box right
		// tip   常规 tip hide  出错的时候  tip error  默认的时候  tip default
		var userName = $("userName");
		var pwd = $("pwd");
		var pwd2 = $("pwd2");
		var email = $("email");
		var mobile = $("mobile");
		var ck = $("ck");
		var btn = $("btn");
		
		mobile.oninput = function(evt) {
			var value = mobile.value;
			if(value.length == 11){
				var flag = isMobile(value);
				if(flag){
					//弹出发送验证码
					jquery("#checkedDiv").after(sendHtml);
					var mobileCode = $("phoneCode");
					mobileCode.oninput = function(evt) {
						var e = evt || window.event;
						checkMobileCode(e);
					}
					jquery("#sendCode").on('click',function(){
						debugger;
					})
				}
			}
		}
		function checkMobileCode(_e){
			var value = mobileCode.value;
			var tip = box.nextElementSibling;
			var span = tip.lastElementChild;
			if(value.length == 4){
				tip.className = "tip";
				span.innerHTML = "";
				return 
			}
			tip.className = "tip default";
			span.innerHTML = "请输入正确的验证码";
			return false;
		}

		userName.onkeyup=userName.onfocus=userName.onblur=function(evt) {
			var e = evt || window.event;
			checkUserName(e);
		}
		function checkUserName(_e) {
			var type;
			if(_e) {
				type = _e.type;
			}
			var value = userName.value;
			var box = userName.parentNode;
			var tip = box.nextElementSibling;
			var span = tip.lastElementChild;
			if(type=="focus") {
				if(value=="") {
					box.className = "box";
					tip.className = "tip default";
					span.innerHTML = "请申请一个中文名字";
					return false;
				}
			}
			if(type=="blur") {
				if(value=="") {
					box.className = "box";
					tip.className = "tip hide";
					return false;//不继续往下走
				}
			}

			if(value=="") {
				box.className = "box error";
				tip.className = "tip error";
				span.innerHTML = "用户名不能为空";
				return false;
			} else if(IsChinese(value)) {
				box.className = "box right";
				//tip.className = "tip hide";
				jquery.ajax({ type : "GET", url : CONTEXTPATH+"/check", async : false, data:{name:value}, success : function(result){
					span.innerHTML = result;
					if("可以注册"==result){
						tip.className = "tip default";	
					}else{
						tip.className = "tip error";	
						return false;
					}
			        }
			    });
				return true;
			} else {
				box.className = "box error";
				tip.className = "tip error";
				span.innerHTML = "格式错误，仅支持汉字的组合";
				return false;
			}
		}
		pwd.onkeyup=pwd.onfocus=pwd.onblur=function(evt) {
			var e = evt || window.event;
			checkPwd(e);
		}
		function checkPwd(_e) {
			var type;
			if(_e) {
				type = _e.type;
			}
			var value = pwd.value;
			var box = pwd.parentNode;
			var tip = box.nextElementSibling;
			var span = tip.lastElementChild;
			if(type=="focus") {
				if(value=="") {
					box.className = "box";
					tip.className = "tip default";
					span.innerHTML = "建议使用字母、数字和符号三种以上的组合,6-20个字符";
					return false;
				}
			}
			if(type=="blur") {
				if(value=="") {
					box.className = "box";
					tip.className = "tip hide";
					return false;
				}
			}

			if(value=="") {
				box.className = "box error";
				tip.className = "tip error";
				span.innerHTML = "密码不能为空";
				return false;
			} else if(regs.pwdReg.test(value)) {
				box.className = "box right";
				tip.className = "tip default";
				return true;
			} else {
				box.className = "box error";
				tip.className = "tip error";
				span.innerHTML = "密码长度应在6-20个字符之间";
				return false;
			}
		}
		pwd2.onkeyup=pwd2.onfocus=pwd2.onblur=function(evt) {
			var e = evt || window.event;
			checkPwd2(e);
		}
		function checkPwd2(_e) {
			var type;
			if(_e) {
				type = _e.type;
			}
			var value1 = pwd.value;
			var value = pwd2.value;
			var box = pwd2.parentNode;
			var tip = box.nextElementSibling;
			var span = tip.lastElementChild;
			if(type=="focus") {
				if(value=="") {
					box.className = "box";
					tip.className = "tip default";
					span.innerHTML = "请再次输入密码";
					return false;
				}
			}
			if(value == "") {
				box.className = "box error";
				tip.className = "tip error";
				span.innerHTML = "请再次输入密码";
				return false;
			} else if(value1 == value) {
				box.className = "box right";
				tip.className = "tip hide";
				return true;
			} else {
				box.className = "box error";
				tip.className = "tip error";
				span.innerHTML = "两次密码不一致";
				return false;
			}
		}
		btn.onclick = function() {
			var box = ck.parentNode;
			var tip = box.nextElementSibling;
			var span = tip.lastElementChild;
			if(ck.checked) {
				if(checkUserName()&&checkPwd()&&checkPwd2()) {
					jquery.ajax({ type : "GET", url : CONTEXTPATH+"/t", async : false, success : function(result){
								var value = jquery("#pwd2").val();
								var key = new RSAUtils.getKeyPair(empoent, "", module);
								value = value + result;
								value = RSAUtils.encryptedString(key,value);
								jquery("#pwd2,#pwd").val(value);
								debugger
								return true;
				          },error:function(){
				        	  return false;
				          }
				    }); 
				} else {
					return false;
				}
			} else {
				tip.className = "tip error";
				span.innerHTML = "请同意协议";
				return false;
			}
		}
		ck.onclick = function() {
			var box = ck.parentNode;
			var tip = box.nextElementSibling;
			var span = tip.lastElementChild;
			if(ck.checked) {
				tip.className = "tip hide";
			}
		}
	}
	
	
});
