function Map() {
　　this.keys = new Array();
　　this.data = new Array();
　　//添加键值对
　　this.set = function (key, value) {
　　　　if (this.data[key] == null) {//如键不存在则身【键】数组添加键名
　　　　　　this.keys.push(value);
　　　　}
　　　　this.data[key] = value;//给键赋值
　　};
　　//获取键对应的值
　　this.get = function (key) {
　　　　return this.data[key];
　　};
　　//去除键值，(去除键数据中的键名及对应的值)
　　this.remove = function (key) {
　　　　this.keys.remove(key);
　　　　this.data[key] = null;
　　};
　　//判断键值元素是否为空
　　this.isEmpty = function () {
　　　　return this.keys.length == 0;
　　};
　　//获取键值元素大小
　　this.size = function () {
　　　　return this.keys.length;
　　};
　　//遍历Map,执行处理函数. 回调函数 function(key,value,index){..}  
　　this.each = function(fn){   
　　　　if(typeof fn != 'function'){   
　　　　　　return;   
　　　　}   
　　　　var len = this.keys.length;   
　　　　for(var i=0;i<len;i++){   
　　　　　　var k = this.keys[i];   
　　　　　　fn(k,this.data[k],i);   
　　　　}   
　　};  
　　//获取键值数组,返回键值对象{key,value}的数组
　　this.entrys = function() {     
　　　　var len = this.keys.length;     
　　　　var entrys = new Array(len);     
　　　　for (var i = 0; i < len; i++) {     
　　　　　　entrys[i] = {     
　　　　　　　　key : this.keys[i],     
　　　　　　　　value : this.data[i]     
　　　　　　};     
　　　　}             
　　　　return entrys;     
　　}; 
　　//重写toString方法  
　　this.toString = function(){     
　　　　var s = "{";     
　　　　for(var i=0;i<this.keys.length;i++,s+=','){     
　　　　　　var k = this.keys[i];     
　　　　　　s += k+"="+this.data[k];     
　　　　}     
　　　　s+="}";     
　　　　return s;     
　　};   
}