var position = {left:0,top:0,currentX:0,currentY:0,flag:false};
var getCurrentStyle = function(target,key){
	return target.currentStyle ? target.currentStyle[key] : document.defaultView.getComputedStyle(key);
}
/**
 * DIV拖拽
 * */
var addDrag = function(bar, target, callback){
	if(getCurrentStyle(target, "left")!="auto"){
		position.left = getCurrentStyle(target, "left");
	}
	if(getCurrentStyle(target, "top")!="auto"){
		position.top = getCurrentStyle(target, "top");
	}
	bar.onmousedown = function(event){
		position.flag = true;
		if(!event){
			event = window.event;
			bar.onselectstart = function(){
				return false;
			}
		}
		position.currentX = event.clientX;
		position.currentY = event.clientY;
	}
	document.onmouseup  = function(event){
		position.flag = false;
		if(getCurrentStyle(target, "left") !== "auto"){
			position.left = getCurrentStyle(target, "left");
		}
		if(getCurrentStyle(target, "top") !== "auto"){
			position.top = getCurrentStyle(target, "top");
		}
	}
	document.onmousemove = function(event){
		var e = event ? event : window.event;
		if(position.flag){
			var nowX = e.clientX, nowY = e.clientY;
			var disX = nowX - position.currentX, disY = nowY - position.currentY;
			target.style.left = parseInt(position.left) + disX + "px";
			target.style.top = parseInt(position.top) + disY + "px";
			if (event.preventDefault) {
				event.preventDefault();
			}
			return false;
		}
		if (typeof callback == "function") {
			callback(parseInt(position.left) + disX, parseInt(position.top) + disY);
		}
	}
}