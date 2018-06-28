var zTree;
var isFirst = true;
var setting = {
	async:{autoParam:["id"],enable:true,type:"GET",url:CONTEXTPATH+"/china",dataFilter:filter},
    check : {chkStyle: "radio",enable: false,chkboxType : { "Y" : "s", "N" : "ps" },radioType : "level"}, 
	view: {dblClickExpand: false,showLine: true,selectedMulti: false},
	data: {simpleData: {enable:true,idKey: "id",pIdKey: "pId",rootPId: "0"}},
	callback: {
		beforeExpand: function(treeId,treeNode){
			if (!treeNode.isAjaxing) {
	            return true;
	        } else {
	            alert("zTree 正在下载数据中，请稍后展开节点。。。");
	            return false;
	        }
		},
		beforeClick: function(treeId, treeNode) {},
		onAsyncSuccess: onAsyncSuccess,
		asyncSuccess: onAsyncSuccess,//异步加载成功   
		asyncError: zTreeOnAsyncError,
		onClick : onclick
	}
};
function onclick(event, treeId, treeNode){
	
}
function filter(treeId, parentNode, childNodes) {
     if (!childNodes) return null;    
     for (var i=0, l=childNodes.length; i<l; i++) {    
         childNodes[i].name = childNodes[i].name.replace('','');    
     }
     return childNodes;    
}
function onAsyncSuccess(event,treeId,e){
	 if(isFirst){
		 zTree = $.fn.zTree.getZTreeObj("tree");
		 var nodeList = zTree.getNodes();
		 zTree.expandNode(nodeList[0],true);
		 isFirst = false;
	 }
}
function zTreeOnAsyncError(){
}
$(document).ready(function(){
	$.ajax({type: "GET",url: CONTEXTPATH+"/china.do",data: {},cache: false,async : false,dataType: "json",
        success: function (data ,textStatus, jqXHR)
        {	
        	zTree = $.fn.zTree.init($("#tree"), setting, data);
			var nodes = zTree.getNodes();
			firstNode=nodes[0];
			zTree.selectNode(firstNode);
			zTree.expandNode(firstNode,true,false,false);
			setting.callback.onClick(null,"tree",firstNode);
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {      
        }
     });
});