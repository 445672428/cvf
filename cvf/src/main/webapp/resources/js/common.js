/**
 * 方法作用：【格式化时间】
 * 使用方法
 * 示例：
 *      使用方式一：
 *      var now = new Date();
 *      var nowStr = now.dateFormat("yyyy-MM-dd hh:mm:ss");
 *      使用方式二：
 *      new Date().dateFormat("yyyy年MM月dd日");
 *      new Date().dateFormat("MM/dd/yyyy");
 *      new Date().dateFormat("yyyyMMdd");
 *      new Date().dateFormat("yyyy-MM-dd hh:mm:ss");
 * @param format {date} 传入要格式化的日期类型
 * @returns {2015-01-31 16:30:00}
 */
Function.prototype.overwrite = function(f) {
    var result = f;
    if (!result.original) {
        result.original = this;
    }
    return result;
}
Date.prototype.toString = Date.prototype.toString.overwrite(
	function(format){
		var result = new String();
		if(typeof(format) == 'string'){
			result = format;
			result = result.replace(/yyyy|YYYY/, this.getFullYear());
	        result = result.replace(/yy|YY/, this.getFullYear().toString().substr(2, 2));
	        result = result.replace(/MM/, this.getMonth() >= 9 ? this.getMonth() + 1 : "0" + (this.getMonth() + 1));
	        result = result.replace(/M/, this.getMonth());
	        result = result.replace(/dd|DD/, this.getDate() > 9 ? this.getDate() : "0" + this.getDate());
	        result = result.replace(/d|D/, this.getDate());
	        result = result.replace(/hh|HH/, this.getHours() > 9 ? this.getHours() : "0" + this.getHours());
	        result = result.replace(/h|H/, this.getHours());
	        result = result.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes() : "0" + this.getMinutes());
	        result = result.replace(/m/, this.getMinutes());
	        result = result.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds() : "0" + this.getSeconds());
	        result = result.replace(/s|S/, this.getSeconds());
		}
		return result;
	}
);
	
Date.prototype.dateFormat = function (format){
    var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if(new RegExp("("+ k +")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        }
    }
    return format;
}
/***********************************************************************
 *                           日期时间工具类                            *
 *                     注：调用方式，deteUtil.方法名                   *
 * ********************************************************************/
var dateUtil = {
    /*
     * 方法作用：【取传入日期是星期几】
     * 使用方法：dateUtil.nowFewWeeks(new Date());
     * @param date{date} 传入日期类型
     * @returns {星期四，...}
     */
    nowFewWeeks:function(date){
        if(date instanceof Date){
            var dayNames = new Array("星期天","星期一","星期二","星期三","星期四","星期五","星期六");
            return dayNames[date.getDay()];
        } else{
            return "Param error,date type!";
        }
    },
    /*
     * 方法作用：【字符串转换成日期】
     * 使用方法：dateUtil.strTurnDate("2010-01-01");
     * @param str {String}字符串格式的日期，传入格式：yyyy-mm-dd(2015-01-31)
     * @return {Date}由字符串转换成的日期
     */
    strTurnDate:function(str){
        var   re   =   /^(\d{4})\S(\d{1,2})\S(\d{1,2})$/;
        var   dt;
        if   (re.test(str)){
            dt   =   new   Date(RegExp.$1,RegExp.$2   -   1,RegExp.$3);
        }
        return dt;
    },
    /*
     * 方法作用：【计算2个日期之间的天数】
     * 传入格式：yyyy-mm-dd(2015-01-31)
     * 使用方法：dateUtil.dayMinus(startDate,endDate);
     * @startDate {Date}起始日期
     * @endDate {Date}结束日期
     * @return endDate - startDate的天数差
     */
    dayMinus:function(startDate, endDate){
        if(startDate instanceof Date && endDate instanceof Date){
            var days = Math.floor((endDate-startDate)/(1000 * 60 * 60 * 24));
            return days;
        }else{
            return "Param error,date type!";
        }
    }
};


/*
 * 保留二位小数
 * */
function toDecimal2(x) { 
	var f_x = parseFloat(x);
	if(f_x=="Infinity"){
		return x;
	}
	if (isNaN(f_x)) {
		return x;
	}
	return f_x.toFixed(3);
}
/***********************************************************************
 *                           加载工具类                                *
 *                     注：调用方式，loadUtil.方法名                   *
 * ********************************************************************/
var loadUtil = {
    /*
     * 方法说明：【动态加载js文件css文件】
     * 使用方法：loadUtil.loadjscssfile("http://libs.baidu.com/jquery/1.9.1/jquery.js","js")
     * @param fileurl 文件路径，
     * @param filetype 文件类型，支持传入类型，js、css
     */
    loadjscssfile:function(fileurl,filetype){
        if(filetype == "js"){
            var fileref = document.createElement('script');
            fileref.setAttribute("type","text/javascript");
            fileref.setAttribute("src",fileurl);
        }else if(filetype == "css"){

            var fileref = document.createElement('link');
            fileref.setAttribute("rel","stylesheet");
            fileref.setAttribute("type","text/css");
            fileref.setAttribute("href",fileurl);
        }
        if(typeof fileref != "undefined"){
            document.getElementsByTagName("head")[0].appendChild(fileref);
        }else{
            alert("loadjscssfile method error!");
        }
    }
};

/***********************************************************************
 *                           字符串操作工具类                          *
 *                     注：调用方式，strUtil.方法名                   *
 * ********************************************************************/
var strUtil = {
    /*
     * 判断字符串是否为空
     * @param str 传入的字符串
     * @returns {}
     */
    isEmpty:function(str){
        if(str != null && str.length > 0){
            return true;
        }else{
            return false;
        }
    },
    /*
     * 判断两个字符串子否相同
     * @param str1
     * @param str2
     * @returns {Boolean}
     */
    isEquals:function(str1,str2){
        if(str1==str2){
            return true;
        }else{
            return false;
        }
    },
    /*
     * 忽略大小写判断字符串是否相同
     * @param str1
     * @param str2
     * @returns {Boolean}
     */
    isEqualsIgnorecase:function(str1,str2){
        if(str1.toUpperCase() == str2.toUpperCase()){
            return true;
        }else{
            return false;
        }
    },
    /**
     * 判断是否是数字
     * @param value
     * @returns {Boolean}
     */
    isNum:function (value){
        if( value != null && value.length>0 && isNaN(value) == false){
            return true;
        }else{
            return false;
        }
    },
    /**
     * 判断是否是中文
     * @param str
     * @returns {Boolean}
     */
    isChine:function(str){
        var reg = /^([u4E00-u9FA5]|[uFE30-uFFA0])*$/;
        if(reg.test(str)){
            return false;
        }
        return true;
    }
};

/****************************************************************************************************************************************************/
/****************************************************************************************************************************************************/
/****************************************************************************************************************************************************/
/****************************************************************************************************************************************************/
//判断输入内容是否为空    
function IsNull(){    
    var str = document.getElementById('str').value.trim();    
    if(str.length==0){    
        alert('对不起，文本框不能为空或者为空格!');//请将“文本框”改成你需要验证的属性名称!    
    }    
}    
   
//判断日期类型是否为YYYY-MM-DD格式的类型    
function IsDate(){     
    var str = document.getElementById('str').value.trim();    
    if(str.length!=0){    
        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
        var r = str.match(reg);     
        if(r==null)    
            alert('对不起，您输入的日期格式不正确!'); //请将“日期”改成你需要验证的属性名称!    
        }    
}     
   
//判断日期类型是否为YYYY-MM-DD hh:mm:ss格式的类型    
function IsDateTime(){     
    var str = document.getElementById('str').value.trim();    
    if(str.length!=0){    
        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;     
        var r = str.match(reg);     
        if(r==null)    
        alert('对不起，您输入的日期格式不正确!'); //请将“日期”改成你需要验证的属性名称!    
    }    
}     
   
//判断日期类型是否为hh:mm:ss格式的类型    
function IsTime()     
{     
    var str = document.getElementById('str').value.trim();    
    if(str.length!=0){    
    reg=/^((20|21|22|23|[0-1]\d)\:[0-5][0-9])(\:[0-5][0-9])?$/     
        if(!reg.test(str)){    
            alert("对不起，您输入的日期格式不正确!");//请将“日期”改成你需要验证的属性名称!    
        }    
    }    
}     
   
//判断输入的字符是否为英文字母    
function IsLetter()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[a-zA-Z]+$/;     
        if(!reg.test(str)){    
            alert("对不起，您输入的英文字母类型格式不正确!");//请将“英文字母类型”改成你需要验证的属性名称!    
        }    
        }    
}     
   
//判断输入的字符是否为整数    
function IsInteger()     
{       
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[-+]?\d*$/;     
        if(!reg.test(str)){    
            alert("对不起，您输入的整数类型格式不正确!");//请将“整数类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
//判断输入的字符是否为双精度    
function IsDouble(val)     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[-\+]?\d+(\.\d+)?$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的双精度类型格式不正确!");//请将“双精度类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
   
//判断输入的字符是否为:a-z,A-Z,0-9    
function IsString()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[a-zA-Z0-9_]+$/;     
        if(!reg.test(str)){    
            alert("对不起，您输入的字符串类型格式不正确!");//请将“字符串类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
//判断输入的字符是否为中文    
function IsChinese()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[\u0391-\uFFE5]+$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的字符串类型格式不正确!");//请将“字符串类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
//判断输入的EMAIL格式是否正确    
function IsEmail()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的字符串类型格式不正确!");//请将“字符串类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
//判断输入的邮编(只能为六位)是否正确    
function IsZIP()     
{     
        var str = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^\d{6}$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的字符串类型格式不正确!");//请将“字符串类型”要换成你要验证的那个属性名称！    
        }    
        }    
}     
   
//判断输入的数字不大于某个特定的数字    
function MaxValue()     
{     
    var val = document.getElementById('str').value.trim();    
        if(str.length!=0){    
        reg=/^[-+]?\d*$/;     
        if(!reg.test(str)){//判断是否为数字类型    
            if(val>parseInt('123')) //“123”为自己设定的最大值    
            {     
                alert('对不起，您输入的数字超出范围');//请将“数字”改成你要验证的那个属性名称！    
            }     
        }    
    }    
}     
 /*********************************************************************************************************************/
 /*********************************************************************************************************************/
 
/*


/**
	输入日期 星期
*/	
function docWriter(){
	var today = new Date();
	var d = new initArray("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	var year = today.getYear();
	if ($.browser.mozilla) {
		year = year + 1900;
	}
	var arr = [];
	arr.push(year + "年", (today.getMonth() + 1) + "月", today.getDate() + "日  " + d[today.getDay() + 1]);
	$("#divHtml").text(arr.join(""));
}


// onkeyup='keyUp(this)'
// onafterpaste='afterpaste(this)'
 // 只能输入正整数
function afterpaste(ob) {
   ob.value=ob.value.replace(/[^\d]/g,'');
}
// 数字：小数
function keyUp(ob) {
   ob.value=ob.value.replace(/[^\d\.]/g,'')
}

// 数字只能输入2位小数
function preserveTwoNum(ob){
	var value=$(ob).val(); 
	if(value == null || value == ''){ 
		return false; 
	}
	if(!isNaN(value)){
			var userreg=/^[0-9]+([.]{1}[0-9]{1,2})?$/; 
			if(userreg.test(value)){ 
				if(parseInt(value).toString().length > 6){ 
					// $(ob).val("");
					alert("输入的整数不得大于6位数"); 
					return false; 
				} 
			}else{ 
				var numindex = parseInt(value.indexOf("."),10); 
				if(numindex == 0){ 
					// $(ob).val("");
					alert("输入的数字不规范"); 
					return false; 
				}
				var head = value.substring(0,numindex); 
				var bottom = value.substring(numindex,numindex+3); 
				var fianlNum = head+bottom; 
				$(ob).val(fianlNum); 
			} 
	}else{ 
		$(ob).val(""); 
		alert("请输入数字");
		return false; 
		} 
}


/*
 * 验证用户名 ob:输入用户名的对象（input） min: 最少几位减1，max：最多几位 减1 return flag; true or false
 * 
 */
 function isUsername(username,min,max) {
	// var username=$.trim($(ob).val());
	var flag=false;
	var pattern1 = new RegExp("^[a-zA-Z][a-zA-Z0-9_]{"+min+","+max+"}$","gi");
	 if(pattern1.test(username)==true){
		flag=true;
	}
	return flag;
}

 /*
  * 验证用户名 ob:输入用户名的对象（input） min: 最少几位减1，max：最多几位 减1 return flag; true or false
  * 
  */
  function isProjectNbr(username,min,max) {
 	// var username=$.trim($(ob).val());
 	var flag=false;
 	var pattern1 = new RegExp("^[a-zA-Z0-9-_][a-zA-Z0-9-_]{"+min+","+max+"}$","gi");
 	 if(pattern1.test(username)==true){
 		flag=true;
 	}
 	return flag;
 }


/*
 * 验证邮箱 ob:输入邮箱的对象 return flag; true or false
 */
 function isEmail(email) {
	var flag=false;
	// var email=$.trim($(ob).val());
	if(email.search(/^[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*@([A-Za-z0-9]+[-.])+[A-Za-z0-9]{2,5}$/)==-1){
	}else{
		flag=true;
	}
	return flag;
}
/*
 * 验证手机号码 ob:输入手机号的对象（input） return flag; true or false
 */
 function isMobile(mobile) {
	var flag=false;
	// var mobile=$.trim($(ob).val());
	if(mobile.search(/^1[3,4,5,7,8]\d{9}$/)==-1){
	}else{
		flag=true;
	}
	return flag;
}

/*
 * 验证固话号码 ob:输入固话号的对象（input） return flag; true or false
 * 
 * 匹配格式： 11位手机号码 3-4位区号，7-8位直播号码，1－4位分机号 如：12345678901、1234-12345678-1234
 */
 function isPhone(phone) {
	var flag=false;
	// var phone=$.trim($(ob).val());
	if(phone.search(/((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/)==-1){
	}else{
		flag=true;
	}
	return flag;
}

/*
 * 验证QQ号码 ob:输入QQ号码的对象（input） return flag; true or false
 * 
 */
 function checkQQ(QQNum) {
	var flag=false;
	// var QQNum=$.trim($(ob).val());
	if(QQNum.search(/^[1-9][0-9]{4,9}$/)==-1){
	}else{
		flag=true;
	}
	return flag;
}

/*
 * 验证邮政编码 ob:输入邮政编码号码的对象（input） return flag; true or false
 */
 function isPostalCode(postalCode) {
	var flag=false;
	// var postalCode=$.trim($(ob).val());
	if(postalCode.search(/^[1-9][0-9]{5}$/)==-1){
	}else{
		flag=true;
	}
	return flag;
}


/*
 * 验证身份证号码 ob:输入身份证号的对象（input） return flag; true or false
 */
function isCardNo(card)  
{  
   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
   // var card=$.trim($(obj).val());
	var flag=false;
   if(reg.test(card) == true)  
   {  
       flag=true;  
   }  
	return flag;
}

function checkIdcard(num){
    num = num.toUpperCase();
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
    if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))){
        //alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。');
        return false;
    }
    // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
    // 下面分别分析出生日期和校验位
    var len, re;
    len = num.length;
    if (len == 15){
        re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
        var arrSplit = num.match(re);
 
        // 检查生日日期是否正确
        var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
        var bGoodDay;
        bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
        if (!bGoodDay) {
            // alert('输入的身份证号里出生日期不对！');
            return false;
        }else{
                // 将15位身份证转成18位
                // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
                var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
                var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
                var nTemp = 0, i;
                num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
                for(i = 0; i < 17; i ++)
                {
                    nTemp += num.substr(i, 1) * arrInt[i];
                }
                num += arrCh[nTemp % 11];
                return true;
        }
    }
    if (len == 18){
        re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
        var arrSplit = num.match(re);
 
        // 检查生日日期是否正确
        var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
        var bGoodDay;
        bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
        if (!bGoodDay) {
            // alert('输入的身份证号里出生日期不对！');
            return false;
        }else{
        // 检验18位身份证的校验码是否正确。
        // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
        var valnum;
        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
        var nTemp = 0, i;
        for(i = 0; i < 17; i ++){
            nTemp += num.substr(i, 1) * arrInt[i];
        }
        valnum = arrCh[nTemp % 11];
        if (valnum != num.substr(17, 1)){
            // alert('18位身份证的校验码不正确！应该为：' + valnum);
            return false;
        }
        return true;
    }
    }
    return false;
}

function isIp(ip)  {  
   var reg = /^([1-9]{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;  
	var flag=false;
   if(reg.test(ip) == true) {  
       flag=true;  
   }
	return flag;
}
/**
 * 验证是否是URL
 */
function isURL(url){
	var strRegex =  "^((https|http|ftp|rtsp|mms)?://)"
		+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
		+ "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
		+ "|" // 允许IP和DOMAIN（域名）
		+ "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
		+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
		+ "[a-z]{2,6})" // first level domain- .com or .museum
		+ "(:[0-9]{1,4})?" // 端口- :80
		+ "((/?)|" // a slash isn't required if there is no file name
		+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	var re = new RegExp(strRegex);
	if (re.test(url)) {
	   // alert("成功");
		return true;
	} else {
		// alert("失败");
		 return false;
	}
}

/*
 * 验证密码 ob:输入密码的对象 min: 最少几位，max：最多几位 return flag; true or false
 */
 function checkPassword(password,min,max) {
	var flag=false;
	 if(password.length >= min && password.length <=max && password!=''){
		flag=true;
	}
	return flag;
}

/*
 * 验证确认密码 ob:输入确认密码的对象 min: 最少几位，max：最多几位 pwdID:第一个密码的id return flag; true or
 * false
 */
 function checkConfirmPassword(confirmPassword,min,max,pwd) {
// var pwd=$("#"+pwdID).val();
	var flag=false;
	 if(confirmPassword.length >= min && confirmPassword.length <=max && confirmPassword!='' && confirmPassword ==$.trim(pwd)){
		flag=true;
	}
	return flag;
}

/*
 * 用途：字符1是否以字符串2结束 输入：str1：字符串；str2：被包含的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isLastMatch(str1,str2) {  
	var index = str1.lastIndexOf(str2); 
	if(str1.length==index+str2.length) return true; 
	return false; 
}

  
/*
 * 用途：字符1是否以字符串2开始 输入：str1：字符串；str2：被包含的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isFirstMatch(str1,str2) {  
	var index = str1.indexOf(str2); 
	if(index==0) return true; 
	return false; 
}

/*
 * 用途：字符1是包含字符串2 输入：str1：字符串；str2：被包含的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isMatch(str1,str2) {  
	var index = str1.indexOf(str2); 
	if(index==-1) return false; 
	return true; 
} 

// 判断输入是否为中文的函数
function ischinese(s){ 
var ret=true; 
for(var i=0;i<s.length;i++) 
	ret=ret && (s.charCodeAt(i)>=10000); 
return ret; 
}


/*******************************************************************************
 * 判斷一個字符串是否是數值格式 numStr:输入需判断的字符串
 */
function isNumber(numStr){
   return !isNaN(numStr);
}

/** 驗證是否是正整數 */
function isPositiveInteger( str ){
	 var regu = /^[1-9][0-9]*$/;  
	 return regu.test(str);
}  

/*******************************************************************************
 * 判斷一個字符串中是否含有下列非法字符
 */
function isValidString(szStr){
	voidChar = "'\"><@#$%^&*~!+()。，,.‘、[]`;|";
   for(i = 0 ; i < voidChar.length; i ++){
     var aChar = voidChar.substring(i, i + 1);
     if(szStr.indexOf(aChar) > -1){
       return true;
     }
   }
   return false;
}
/*
 * 是否包含系统禁用的字符 包含就返回true
 */   
function   isIncSym(ui)   {   
  	var   valid=/[\'\"\,\<\>\+\-\*\/\%\^\=\\\!\&\|\(\)\[\]\{\}\:\;\~\`\#\$]+/;   
  	return   (valid.test(ui));	  
}
/*******************************************************************************
 * 判斷一個字符串是否包含空字符串
 */
function isBlank(szStr){
   if(szStr.length < 1){
     return true;
   }
   for(i = 0; i < szStr.length; i ++){
     if(szStr.substring(i, i + 1) == ' '){
       return true;
     }
   }
   return false;
}
/*******************************************************************************
 * 去掉一個字符串兩端的空格
 */
function trim(szStr){
   // 去掉字符串頭部的空格
   while(szStr.length > 0){
     if( szStr.substring(0, 1) != ' '){
       break;
     }else{
       szStr = szStr.substring(1);
     }
   }
   // 去掉字符串尾部的空格
   while(szStr.length > 0){
     if( szStr.substring(szStr.length - 1, szStr.length) != ' '){
       break;
     }else{
       szStr = szStr.substring(0,szStr.length - 1);
     }
   }
   return szStr;
}
/*******************************************************************************
 * 判斷一個字符串是否爲合法的日期格式：YYYY-MM-DD HH:MM:SS 或 YYYY-MM-DD 或 HH:MM:SS
 */
function isDateStr(ds){
   parts = ds.split(' ');
   switch(parts.length){
     case 2:
       if(isDatePart( parts[0] ) == true && isTimePart( parts[1] )){
         return true;
       }else{
         return false;
       }
     case 1:
       aPart = parts[0];
       if(aPart.indexOf(':') > 0 ){
         return isTimePart(aPart);
       }else{
         return isDatePart(aPart);
       }
     default:
       return false;
   }
}
/*******************************************************************************
 * 判斷一個字符串是否爲合法的日期格式：YYYY-MM-DD
 */
function isDatePart(dateStr){
   var parts;
   if(dateStr.indexOf("-") > -1){
     parts = dateStr.split('-');
   }else if(dateStr.indexOf("/") > -1){
     parts = dateStr.split('/');
   }else{
     return false;
   }
   if(parts.length < 3){
   // 日期部分不允許缺少年、月、日中的任何一項
     return false;
   }
   for(i = 0 ;i < 3; i ++){
   // 如果構成日期的某個部分不是數字，則返回false
     if(isNaN(parts[i])){
       return false;
     }
   }
   y = parts[0];// 年
   m = parts[1];// 月
   d = parts[2];// 日
   if(y > 3000){
     return false;
   }
   if(m < 1 || m > 12){
     return false;
   }
   switch(d){
     case 29:
       if(m == 2){
       // 如果是2月份
         if( (y / 100) * 100 == y && (y / 400) * 400 != y){
           // 如果年份能被100整除但不能被400整除 (即閏年)
         }else{
           return false;
         }
       }
       break;
     case 30:
       if(m == 2){
       // 2月沒有30日
         return false;
       }
       break;
     case 31:
       if(m == 2 || m == 4 || m == 6 || m == 9 || m == 11){
       // 2、4、6、9、11月沒有31日
         return false;
       }
       break;
     default:
   }
   return true;
}
/*******************************************************************************
 * 判斷一個字符串是否爲合法的時間格式：HH:MM:SS
 */
function isTimePart(timeStr){
   var parts;
   parts = timeStr.split(':');
   if(parts.length < 2){
   // 日期部分不允許缺少小時、分鐘中的任何一項
     return false;
   }
   for(i = 0 ;i < parts.length; i ++){
   // 如果構成時間的某個部分不是數字，則返回false
     if(isNaN(parts[i])){
       return false;
     }
   }
   h = parts[0];// 年
   m = parts[1];// 月
   if( h < 0 || h > 23){
   // 限制小時的範圍
     return false;
   }
   if( m < 0 || h > 59){
   // 限制分鐘的範圍
     return false;
   }
   if(parts.length > 2){
     s = parts[2];// 日
     if( s < 0 || s > 59){
     // 限制秒的範圍
       return false;
     }
   }
   return true;
}

// 判斷字符串是否是中文
function isChinese(str)
{
   var lst = /[u00-uFF]/;      
   return !lst.test(str);     
}
// 精確判斷字符串長度
function strlen(str){
   var strlength=0;
   for (i=0;i<str.length;i++)
{
     if (isChinese(str.charAt(i))==true)
         strlength=strlength + 2;
     else
         strlength=strlength + 1;
}
return strlength;
}

// 判斷字符串中是否存在空格
function isKong(szStr)
{
	// trim方法爲上面去掉字符串首尾空格的方法，不是系統方法
	var str=trim(szStr);
	if(strlen(str)>0)
	{
	  if(str.indexOf(' ')>=0){
		 return true;
	  }
	}
	return false;
}

 /* 用户输入字符串长度是否在两值之间 */   
 function  isLenBetween(szStr,minl,maxl){
  	  szStr =$.trim(szStr);
      return   (szStr.length>=minl&&szStr.length<=maxl);
 }
  
 /*
	 * 用途：检查输入字符串是否只由英文字母和数字组成 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
	 * 
	 */ 
function isNumberOrLetter(s){// 判断是否是数字或字母
	var regu = "^[0-9a-zA-Z]+$"; 
	var re = new RegExp(regu); 
	if (re.test(s)) { 
		return true; 
	}else{ 
		return false; 
	} 
}

/*
 * 用途：检查输入字符串是否只由汉字、字母、数字组成 输入： value：字符串 返回： 如果通过验证返回true,否则返回false
 */ 
function isChinaOrNumbOrLett(s){// 判断是否是汉字、字母、数字组成
	var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";   
	var re = new RegExp(regu); 
	if (re.test(s)) { 
		return true; 
	}else{ 
		return false; 
	} 
} 

/*
 * 返回某年某月的最大天数
 */
function getMaxDay(year,month) { 
	if(month==4||month==6||month==9||month==11) 
		return "30"; 
	if(month==2) 
		if(year%4==0&&year%100!=0 || year%400==0) 
		return "29"; 
	else 
		return "28"; 
		return "31"; 
}

/*
 * 用途：检查复选框被选中的数目 输入： checkboxID：字符串 返回： 返回该复选框中被选中的数目
 * 
 */ 
function checkSelectNum(checkboxID) { 
	var check = 0; 
	var i=0; 
	if( document.all(checkboxID).length > 0 ) { 
		for(  i=0; i<document.all(checkboxID).length; i++ ) { 
			if( document.all(checkboxID).item( i ).checked ) { 
				check += 1; 
			}
		}
	}else{ 
		if( document.all(checkboxID).checked ) 
			check = 1; 
	}
	return check; 
}

// 驗證瀏覽器
function checkBrowser() {
 if (window.navigator.userAgent.indexOf("MSIE") >= 1) {  
  return "IE";  
 } else {  
  if (window.navigator.userAgent.indexOf("Firefox") >= 1) {  
   return "FF";  
  } else {  
   return "other";  
  }  
 }  
}  

// 驗證瀏覽器是IE6，還是IE7
function checkIE(){  
    var b_v = navigator.appVersion;   
    var IE6 = b_v.search(/MSIE 6/i) != -1;   
    var IE7 = b_v.search(/MSIE 7/i) != -1;   
    if(IE6){  
        return "IE6";  
    }else if(IE7){  
        return "IE7";  
    }else{  
        return "other";  
    }  
}

// 驗證是否由英文、數字、-、_組成
function isLetterNumHyphen(value){ 
 var reg =/^[A-Za-z0-9-_]+$/;  
 return reg.test(value);  
}


//特殊字符.
function invalidWord(s){
	var reg = /^((\w|([\u4E00-\u9FA5])*))+$/;
	return reg.test(s);
	
}
   
// 選擇復選框
function checkSelect(formObj, eleName){
 var checked = false;  
 for (var i = 0; i < formObj.elements.length; i++) {  
	if ((formObj.elements[i].name == eleName) && (formObj.elements[i].checked)) {  
		checked = true;  
	break;  
  }
 }  
 if (!checked) {  
	alert("请选择要刪除的记录!");  
 }  
 return checked;  
}  
  
function checkSelectNoAlert(formObj, eleName) {  
 var checked = false;  
 for (var i = 0; i < formObj.elements.length; i++) {  
  if ((formObj.elements[i].name == eleName) && (formObj.elements[i].checked)) {  
   checked = true;  
   break;  
  }  
 }
 return checked;   
}  
  
 // 全选或取消選擇復選框 selfObj：点击全选的复选框对象 checkboxObj传入的要选中的复选框对象数组
	// 如：$("input[name='merchantBox']")
function selectOrNotAll(selfObj,checkboxObj) { 
	var selectOrNotSelect = false;
	if($(selfObj).attr("checked")=="checked"){
		selectOrNotSelect = true;
	}
	 for (var i = 0; i < checkboxObj.length; i++) {  
		 checkboxObj[i].checked = selectOrNotSelect;  
	 }
}
  
// 反选復選框
function reverseSelect(formObj, eleName){
 for (var i = 0; i < formObj.elements.length; i++) {  
  if (formObj.elements[i].name == eleName) {  
   formObj.elements[i].checked = !formObj.elements[i].checked;  
  }
 }
}

// 获取选中Checkbox的值
function getSelectedCheckboxValue(checkboxName){
	var str="";
		$("input[name='"+checkboxName+"']:checkbox").each(function(){
		     if($(this).attr("checked")=="checked"){
		         str += $(this).val()+","
		     }
		 });
	if(""!=str){
		str = str.substring(0, str.length-1);
	}
	return str;  
}

/*
 * 市、区级联动 parentId:父ID regionType：地区级别 id：绑定ID element：绑定元素
 */
function citySelectInit(parentId, regionType, id, element){
	var _array = [];
	_array.push("<option value='-1'>--请选择--</option>");
// $.ajax({
// url:"ajaxqueryRegion.do",
// async:false,
// data:"&regionType="+regionType+"&parentId="+parentId,
// success:function(data){
// for(var i = 0; i < data.length; i ++){
// _array.push("<option
// value='"+data[i].regionId+"'>"+data[i].regionName+"</option>");
// }
// $("#" + element).html(_array.join(""));
// if(id != -1){
// $("#" + element).val(id);
// }
// }
// });
}

/**
 * 输出时间倒计时。
 */
function lxfEndtime(){
   $(".lxftime").each(function(){
	var lxfday=$(this).attr("lxfday");// 用来判断是否显示天数的变量
	var endtime = new Date($(this).attr("endtime")).getTime();// 取结束日期(毫秒值)
	var nowtime = new Date().getTime();	// 今天的日期(毫秒值)
	var youtime = endtime-nowtime;// 还有多久(毫秒值)
	var seconds = youtime/1000;
	var minutes = Math.floor(seconds/60);
	var hours = Math.floor(minutes/60);
	var days = Math.floor(hours/24);
	var CDay= days ;
	var CHour= hours % 24;
	var CMinute= minutes % 60;
	var CSecond= Math.floor(seconds%60);// "%"是取余运算，可以理解为60进一后取余数，然后只要余数。
	if(endtime<=nowtime){
		$(this).html(new Date($(this).attr("endtime")).format("yyyy-MM-dd hh:mm:ss")+"（已过期）")// 如果结束日期小于当前日期就提示过期啦
		}else{
			if($(this).attr("lxfday")=="no"){
				$(this).html("<i>剩余时间：</i><span>"+CHour+"</span>时<span>"+CMinute+"</span>分<span>"+CSecond+"</span>秒");	  // 输出没有天数的数据
				}else{
		$(this).html("<i>剩余时间：</i><span>"+days+"</span><em>天</em><span>"+CHour+"</span><em>时</em><span>"+CMinute+"</span><em>分</em><span>"+CSecond+"</span><em>秒</em>");	  // 输出有天数的数据
			}
		}
  });
   setTimeout("lxfEndtime()",1000);
};


/**
 * 时间对象的格式化
 */ 
Date.prototype.format = function(format) 
{ 
/*
 * format="yyyy-MM-dd hh:mm:ss";
 */ 
	var o = { 
	"M+" : this.getMonth() + 1, 
	"d+" : this.getDate(), 
	"h+" : this.getHours(), 
	"m+" : this.getMinutes(), 
	"s+" : this.getSeconds(), 
	"q+" : Math.floor((this.getMonth() + 3) / 3), 
	"S" : this.getMilliseconds() 
	} 
	
	if (/(y+)/.test(format)) 
	{ 
	format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 
	- RegExp.$1.length)); 
	} 
	
	for (var k in o) 
	{ 
	if (new RegExp("(" + k + ")").test(format)) 
	{ 
	format = format.replace(RegExp.$1, RegExp.$1.length == 1 
	? o[k] 
	: ("00" + o[k]).substr(("" + o[k]).length)); 
	} 
	} 
	return format; 
} 


// 判断是否有选中项
function checked(str){
	var c = 0;
	$(".cart_xz").each( function(i, n){
		if(n.checked){
			c = 1;
		}
	});
	if(c==0){
		alert("请先选中您要"+str+"的项！");
		return false;
	}
	return true;
}

 

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
	

// 判断时间格式是否为：yyyy-MM-dd HH:mm:ss
function isDateTime(dateTime){     
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;     
    if(dateTime.length > 0){    
        var r = dateTime.match(reg);     
        if(r == null){
        	return false;
        }else{
        	return true;
        }
    }else{
    	return false;
    }
}


// 判断是否为数值类型
function isDouble(myNum){
	var rep = /^[1-9][0-9]*\.[0-9]+$/;
	var rep1 = /^[0]\.[0-9]+$/;
	if(myNum.match(rep) == null && myNum.match(rep1) == null){
		return false;
	}else{
		return true;
	}
}

function validatePassword(password){
	
	var rep = /^([a-zA-Z0-9]|[_.,;:""?!@#=\{\}>\|\<\-\+\~$%^&\*\(\)]){6,16}$/;
	if(password.match(rep) == null){
		return false;
	}else{
		return true;
	}
}

function validateUpdatePassword(password){
	
	var rep = /^([a-zA-Z0-9]|[_.,;:""?!@#=\{\}>\|\<\-\+\~$%^&\*\(\)]){6,100}$/;
	if(password.match(rep) == null){
		return false;
	}else{
		return true;
	}
}

//验证用户名.
function checkLoginName(str){
  var re = /^[a-zA-z_][a-zA-Z0-9_]{5,15}$/;
    if(re.test(str)){
        return true;
    }else{
        return false;
    }          
}

function checkPlatformLoginName(str){
	var re = /^[a-zA-z0-9_][a-zA-Z0-9_]{3,7}$/;
	if(re.test(str)){
	   return true;
	}else{
	   return false;
	}          
}

function getTextareaStrLength(str) {
  var realLength = 0, len = str.length, charCode = -1;
  for (var i = 0; i < len; i++) {
     charCode = str.charCodeAt(i);
     if (charCode >= 0 && charCode <= 128) realLength += 1;
     else realLength += 2;
  }
  return realLength;
}

/**
 * 验证银行账号.
 * @param account
 * @return
 */
//bankno为银行卡号 banknoInfo为显示提示信息的DIV或其他控件
function luhmCheck(bankno){
	var reg = /^[0-9]{10,30}$/;
	if(bankno.match(reg) == null){
		return false;
	}else{
		return true;
	}
}




Array.prototype.remove = function(dx){
	if(isNaN(dx)||dx>this.length){
		return false;
	}
	for(var i=0,n=0;i<this.length;i++)
	{
		if(this[i]!=this[dx])
		{
			this[n++]=this[i];
		}
	}
		this.length-=1;
}

String.prototype.stringToDate = function(){
	return new Date(Date.parse(this.replace(/-/g, "/")));
}

/**
 * 保留两位有效数字.
 */
function clearOnlyNum(obj){
	obj.value = obj.value.replace(/^0+/g,"0");
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
	var t = obj.value.split(".");
	if(t[0] > 0){
		obj.value = obj.value.replace(/^0+/g,"");
	}
}
/**
 * UUID 生成
 */
function getUuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);
    s[8] = s[13] = s[18] = s[23] = "-";
 
    var uuid = s.join("");
    return uuid.replace(/-/g,'');
}


/*********************************************************************

 Phone : /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/    
 Mobile : /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/    
 Url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/   
 IdCard : /^\d{15}(\d{2}[A-Za-z0-9])?$/   
 QQ : /^[1-9]\d{4,8}$/   
 某种特殊金额：/^((\d{1,3}(,\d{3})*)|(\d+))(\.\d{2})?$/               //说明：除“XXX    XX,XXX    XX,XXX.00”格式外

//为上面提供各个JS验证方法提供.trim()属性   
String.prototype.trim=function(){   
        return this.replace(/(^\s*)|(\s*$)/g, "");    
    }

调用：
<input type="text" name="str" >
<input type="button" value=" 确定 " onClick="">    //onClick中写自己要调用的JS验证函数

<script language="javascript" type="text/javascript">
var patterms = new Object();
//验证IP
patterms.ip = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;
//验证EMAIL
patterms.email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
//验证日期格式2009-07-13
patterms.date = /^\d{4}-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
//验证时间格式16:55:39
patterms.time = new RegExp("^([0-1]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$");
//验证函数
function verify(str,pat)
{
    var thePat;
    thePat = patterms[pat];
    if(thePat.test(str))
    {
        return true;
    }
    else
    {
        return false;
    }
}
//测试
alert(verify("asidycom@163.com","email")+","+verify("192.168.1.1","ip")+
    ","+verify("16:55:39","time")+","+verify("2009-07-13","date")+","+verify("192.168","ip"));

 

验证数字：^[0-9]*$ 

验证n位的数字：^\d{n}$  

验证至少n位数字：^\d{n,}$ 

验证m-n位的数字：^\d{m,n}$ 

验证零和非零开头的数字：^(0|[1-9][0-9]*)$ 

验证有两位小数的正实数：^[0-9]+(.[0-9]{2})?$ 

验证有1-3位小数的正实数：^[0-9]+(.[0-9]{1,3})?$ 

验证非零的正整数：^\+?[1-9][0-9]*$ 

验证非零的负整数：^\-[1-9][0-9]*$ 

验证非负整数（正整数 + 0） ^\d+$ 

验证非正整数（负整数 + 0） ^((-\d+)|(0+))$ 

验证长度为3的字符：^.{3}$ 

验证由26个英文字母组成的字符串：^[A-Za-z]+$ 

验证由26个大写英文字母组成的字符串：^[A-Z]+$ 

验证由26个小写英文字母组成的字符串：^[a-z]+$ 

验证由数字和26个英文字母组成的字符串：^[A-Za-z0-9]+$ 

验证由数字、26个英文字母或者下划线组成的字符串：^\w+$ 

验证用户名或昵称经常用到: ^[\u4e00-\u9fa5A-Za-z0-9-_]*$  只能中英文，数字，下划线，减号

验证用户密码:^[a-zA-Z]\w{5,17}$ 正确格式为：以字母开头，长度在6-18之间，只能包含字符、数字和下划线。 

验证是否含有 ^%&',;=?$\" 等字符：[^%&',;=?$\x22]+ 

验证汉字：^[\u4e00-\u9fa5],{0,}$ 

验证Email地址：^\w+[-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$ 

验证InternetURL：^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$ ；^[a-zA-z]+://(w+(-w+)*)(.(w+(-w+)*))*(?S*)?$ 

验证电话号码：^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$：--正确格式为：XXXX-XXXXXXX，XXXX-XXXXXXXX，XXX-XXXXXXX，XXX-XXXXXXXX，XXXXXXX，XXXXXXXX。 

验证身份证号（15位或18位数字）：^\d{15}|\d{}18$ 

验证一年的12个月：^(0?[1-9]|1[0-2])$ 正确格式为：“01”-“09”和“1”“12” 

验证一个月的31天：^((0?[1-9])|((1|2)[0-9])|30|31)$ 正确格式为：01、09和1、31。 

整数：^-?\d+$ 

非负浮点数（正浮点数 + 0）：^\d+(\.\d+)?$ 

正浮点数 ^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$ 

非正浮点数（负浮点数 + 0） ^((-\d+(\.\d+)?)|(0+(\.0+)?))$ 

负浮点数 ^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$ 

浮点数 ^(-?\d+)(\.\d+)?$


* 	afterpaste(ob)          ：只能输入数字(ob:对象)
	keyUp(ob)               ：只能输入数字(ob:对象)
boolean isUsername(username,min,max)  ：验证用户名 字母开头字母或数字结尾  username:用户名 min: 最少几位，max：最多几位 
boolean isEmail(email) 		：验证邮箱
boolean isMobile(mobile) 	：验证手机号码
boolean isPhone(phone)		：验证固话号码
boolean checkQQ(QQNum) 		：验证QQ号码
boolean isPostalCode(postalCode)	：验证邮政编码
boolean isCardNo(card)		：验证身份证号码
boolean checkIdcard(card)	：验证身份证号码（验证出生日期和校验位）
boolean isURL(url) 			：验证是否是URL
boolean isIp(ip) 		：验证IP
boolean checkPassword(password,min,max)      		：验证密码长度
boolean checkConfirmPassword(confirmPassword,min,max,pwd)  ：验证确认密码长度 pwdID第一个密码
boolean isNull(str)		：检查输入字符串是否为空或者全部都是空格 
boolean isLastMatch(str1,str2)  : 检查字符1是否以字符串2结束
boolean isFirstMatch(str1,str2) : 检查字符1是否以字符串2开始 
boolean isMatch(str1,str2)     	: 检查字符1是包含字符串2 
boolean ischinese(str)		: 检查输入是否为中文的函数 
boolean isNumber(numStr)	: 判断一個字符串是否是数值格式
boolean  isPositiveInteger(str)   : 判断是否是正整數
boolean isValidString(szStr)    ：判断字符串中是否含有非法字符"'\"><@#$%^&*~!+()。，,.‘、[]`;|"
boolean isIncSym(szStr)		：是否包含系统禁用的字符
boolean isBlank(szStr)          ：判断字符串是否爲空字符串（或不包含除空格外的其他字符）
String  trim(szStr)              ：去掉字符串兩端的空格
boolean isDateStr(ds)           ：判断字符串是否爲合法的日期格式：YYYY-MM-DD HH:MM:SS
                                    或 YYYY-MM-DD 或 HH:MM:SS
boolean isDatePart(dateStr)       ：判断字符串是否爲合法的日期格式：YYYY-MM-DD
boolean isTimePart(dateStr)       ：判断字符串是否爲合法的時間格式：HH:MM:SS
int 	strlen(str) 		  : 精确判断字符串長度，包括中文和英文混合 
boolean isKong（szStr）		  ：判断字符串中是否含有空格（去掉字符串前後空格後）
boolean isLenBetween(szStr,minl,maxl)   ：用户输入字符串长度是否在两值之间
boolean isNumberOrLetter(str)		：判断输入字符串是否只由英文字母和数字组成 
boolean isChinaOrNumbOrLett(str)	：判断输入字符串是否只由汉字、字母、数字组成
String  getMaxDay(year,month)		：返回某年某月的最大天数
int     checkSelectNum( checkboxID )       ：检查复选框被选中的数目 checkboxID ：复选框id
String	checkBrowser() 					: 验证是什么浏览器
String	 checkIE()						：验证浏览器是IE6，还是IE7
boolean isLetterNumHyphen(value)  		：验证是否由英文、数字、-、_組成
boolean checkSelect(formObj, eleName)  	：验证是否有选择复选框，（formObj: form对象 	eleName：复选框name）
		selectOrNotAll(formObj, eleName, selectOrNotSelect)      ：全选或取消选择复选框  （formObj: form对象 	eleName：复选框name    selectOrNotSelect：true或false）
		reverseSelect(formObj, eleName)  						 ：反择复选框，（formObj: form对象 	eleName：复选框name）
boolean 
int 	getTextareaStrLength(str)     ：验证输入框/文本框 字节数。。
*******************************************************************************/