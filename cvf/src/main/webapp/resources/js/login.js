require.config({
    paths:{
	        'jquery': PATH+'/resources/lib/jQuery/jquery-1.7.1.min',
	        'qrcode': PATH+'/resources/lib/jQuery/jquery.qrcode.min',
	        'security': PATH+'/resources/lib/security',
	        'sockjs': PATH+'/resources/lib/sockjs',
	        'common':PATH+'/resources/js/common'
    	},
        shim:{
            "jquery": { exports: "jquery" },  
            'qrcode':{
                deps:['jquery']
            },
            'sockjs':{
            	deps:['jquery']
            }
    	}
});
require(['jquery','qrcode','security','sockjs','common'], function() {
	(function() {
		  var _hmt = _hmt || [];
		  var hm = document.createElement("script");
		  hm.src = "https://hm.baidu.com/hm.js?382f81c966395258f239157654081890";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		  $("#onlogin").bind("click",doLogin);
		  $("#imgCode").bind("click",refreashCode);
		  GetLocalIPAddr();
		  getYourIP();
	})();
	
	var websocket,empoent,module;
	var ip = window.location.host;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://"+ip+PATH+"/websocket/bobo");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://"+ip+PATH+"/websocket/bobo");
    }
    else {
        websocket = new SockJS("ws://"+ip+PATH+"/websocket/bobo");
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

	
	function doLogin(){
		verification();
	}
	function refreashCode(){
		$(this).attr("src",PATH+"/servlet/validateCodeServlet?s="+new Date().getTime());
	}
	var regs = {
			userNameReg: /^(([\u4e00-\u9fa5])|[a-zA-Z0-9-_]){4,20}$/,
			pwdReg: /^.{6,20}$/,
			numReg: /\d/,
			strReg: /[a-zA-Z]/,
			tsReg: /[^\u4e00-\u9fa5a-zA-Z0-9]/
		}
	
	function verification(){
		if(typeof(empoent) == 'undefined' || typeof(module) =='undefined'){
			refreashCode();
			return;
		}
		var n = $("#username").val();
		var statu = IsChinese(n);
		if(statu){
			var passwd = $("#userpwd").val();
			var flag = regs.pwdReg.test(passwd);//checkPwdStandard(passwd);
			//pwdReg: /^.{6,20}$/,
			if(flag){
				 $.get(PATH+"/t", function(result){
						var key = new RSAUtils.getKeyPair(empoent, "", module);
						passwd = passwd + result;
						passwd = RSAUtils.encryptedString(key,passwd);
						$("#userpwd").val(passwd);
						$("#userform").submit();
				 });
			}
		}
		refreashCode();
	}
	$(document).ready(function () {
		function fixHeight() {
			var headerHeight = $("#switcher").height();
			$("#iframe").attr("height", $(window).height()-54+ "px");
		}
		$(window).resize(function () {
			fixHeight();
		}).resize();
	});
	jQuery('#output').qrcode({width:150,height: 150,text: window.location.href});
	
	
    var canvas=document.getElementById("logo");
    var ctx=canvas.getContext("2d");
    var gradient=ctx.createLinearGradient(0,0,canvas.width,0);
    gradient.addColorStop("0","magenta");
    gradient.addColorStop("0.5","blue");
    gradient.addColorStop("1.0","red");
    ctx.fillStyle=gradient;
    ctx.font="30px Verdana";
    ctx.fillText("波波欢迎你!",30,30);
    
    function GetLocalIPAddr(){
    	var oSetting = null;
    	var ip = null; 
    	try{
    		oSetting = new ActiveXObject("rcbdyctl.Setting"); 
    		ip = oSetting.GetIPAddress; 
    		if (ip.length == 0){ 
    			return "没有连接到Internet"; 
    		}
    		oSetting = null; 
    	}catch(e){ 
    	} 
    		return ip; 
    	} 
    
    function getYourIP(){
        var RTCPeerConnection = window.RTCPeerConnection || window.webkitRTCPeerConnection || window.mozRTCPeerConnection;
        if (RTCPeerConnection) (function () {
            var rtc = new RTCPeerConnection({iceServers:[]});
            if (1 || window.mozRTCPeerConnection) {     
                rtc.createDataChannel('', {reliable:false});
            };
            
            rtc.onicecandidate = function (evt) {
            	try{
            		if (evt.candidate) grepSDP("a="+evt.candidate.candidate);
            	}catch(e){}
                
            };
            rtc.createOffer(function (offerDesc) {
                grepSDP(offerDesc.sdp);
                rtc.setLocalDescription(offerDesc);
            }, function (e) { console.warn("offer failed", e); });
            
            
            var addrs = Object.create(null);
            addrs["0.0.0.0"] = false;
            function updateDisplay(newAddr) {
                if (newAddr in addrs) return;
                else addrs[newAddr] = true;
                var displayAddrs = Object.keys(addrs).filter(function (k) { return addrs[k]; });
                for(var i = 0; i < displayAddrs.length; i++){
                    if(displayAddrs[i].length > 16){
                        displayAddrs.splice(i, 1);
                        i--;
                    }
                }
                try{
                	document.getElementById('list').textContent = displayAddrs[0];
                }catch(e){
                	
                }
                
            }
            
            function grepSDP(sdp) {
                var hosts = [];
                sdp.split('\r\n').forEach(function (line, index, arr) { 
                   if (~line.indexOf("a=candidate")) {    
                        var parts = line.split(' '),       
                            addr = parts[4],
                            type = parts[7];
                        if (type === 'host') updateDisplay(addr);
                    } else if (~line.indexOf("c=")) {       
                        var parts = line.split(' '),
                            addr = parts[2];
                        updateDisplay(addr);
                    }
                });
            }
        })();
        else{
            document.getElementById('list').textContent = "请使用主流浏览器：chrome,firefox,opera,safari";
        }
    }
    
    function getBrowserInfo(){
        var agent = navigator.userAgent.toLowerCase() ;
        console.log(agent);
        var arr = [];
        var system = agent.split(' ')[1].split(' ')[0].split('(')[1];
        arr.push(system);
        var regStr_edge = /edge\/[\d.]+/gi;
        var regStr_ie = /trident\/[\d.]+/gi ;
        var regStr_ff = /firefox\/[\d.]+/gi;
        var regStr_chrome = /chrome\/[\d.]+/gi ;
        var regStr_saf = /safari\/[\d.]+/gi ;
        var regStr_opera = /opr\/[\d.]+/gi;
        //IE
        if(agent.indexOf("trident") > 0){
            arr.push(agent.match(regStr_ie)[0].split('/')[0]);
            arr.push(agent.match(regStr_ie)[0].split('/')[1]);
            return arr;
        }
        //Edge
        if(agent.indexOf('edge') > 0){
            arr.push(agent.match(regStr_edge)[0].split('/')[0]);
            arr.push(agent.match(regStr_edge)[0].split('/')[1]);
            return arr;
        }
        //firefox
        if(agent.indexOf("firefox") > 0){
            arr.push(agent.match(regStr_ff)[0].split('/')[0]);
            arr.push(agent.match(regStr_ff)[0].split('/')[1]);
            return arr;
        }
        //Opera
        if(agent.indexOf("opr")>0){
            arr.push(agent.match(regStr_opera)[0].split('/')[0]);
            arr.push(agent.match(regStr_opera)[0].split('/')[1]);
            return arr;
        }
        //Safari
        if(agent.indexOf("safari") > 0 && agent.indexOf("chrome") < 0){
            arr.push(agent.match(regStr_saf)[0].split('/')[0]);
            arr.push(agent.match(regStr_saf)[0].split('/')[1]);
            return arr;
        }
        //Chrome
        if(agent.indexOf("chrome") > 0){
            arr.push(agent.match(regStr_chrome)[0].split('/')[0]);
            arr.push(agent.match(regStr_chrome)[0].split('/')[1]);
            return arr;
        }else{
            arr.push('请更换主流浏览器，例如chrome,firefox,opera,safari,IE,Edge!')
            return arr;
        }
    }
    
    function selectProvince(){
    	/**
    	 * 省市区级连
    	 */
    	$(function(){
    	//init(); // 省级方法
    		// 省
    	$("#province").change(function(){
    		var provinceId = $("#province").val()
    		citySelectInit(provinceId, 2, -1, "city");
    		$("#area").html("<option value='-1'>--请选择--</option>");
    	});
    	// 市
    	$("#city").change(function(){
    		var cityId = $("#city").val()
    		citySelectInit(cityId, 3, -1, "area")
    	});
    	   // 提交表单
    	$("#bn_save").click(function(){
    		param["paramMap.id"]=$("#id").val();
    		param["paramMap.realname"] = $("#realname").val();
    		param["paramMap.emial"] = $("#email").val();
    		param["paramMap.card"] = $("#card").val();
    		param["paramMap.nickname"]=$("#nickname").val();
    		param["paramMap.sex"] = $("input[name='sex']:checked").val();
    		param["paramMap.province"] = $("#province").val();
    		param["paramMap.cityId"] = $("#city").val();
    		param["paramMap.areaId"] = $("#area").val();
    		param["paramMap.address"] = $("#address").val();
    		param["paramMap.contacts"] = $("#contacts").val();
    		
    	// $.shovePost("updateUserInfo.do",param,function(data){
    	// if(data.msg==1){
    	// alert("修改成功");
    	// window.location.href = "userDetail.do";
    	// return ;
    	// }
    	// alert(data.msg);
    	// });
    		return false;
    	});		
    	});
    }
});
