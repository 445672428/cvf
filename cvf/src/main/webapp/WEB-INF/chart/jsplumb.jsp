<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />  
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"/>  
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">  
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">  
<link href="//fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/d3/d3.v4.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jsplumb/dagre-d3.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jsplumb/jsPlumb-2.2.8-min.js" charset="utf-8"></script>
<style type="text/css">

/*禁用复制等操作*/

html,
body {
    -webkit-user-select: none;
    user-select: none;
}
.flowchart-demo {
    width: 800px;
    height: 600px;
    border: 1px solid #000;
}
.flowchart-demo .window {
    border: 1px solid #346789;
    box-shadow: 2px 2px 19px #aaa;
    -o-box-shadow: 2px 2px 19px #aaa;
    -webkit-box-shadow: 2px 2px 19px #aaa;
    -moz-box-shadow: 2px 2px 19px #aaa;
    -moz-border-radius: 0.5em;
    border-radius: 0.5em;
    opacity: 0.8;
    filter: alpha(opacity=80);
    text-align: center;
    position: absolute;
    background-color: #eeeeef;
    color: black;
    font-family: helvetica;
    font-size: 0.9em;
    line-height: 60px;
    width: 60px;
    height: 60px;
}
.flowchart-demo .window:hover {
    box-shadow: 2px 2px 19px #444;
    -o-box-shadow: 2px 2px 19px #444;
    -webkit-box-shadow: 2px 2px 19px #444;
    -moz-box-shadow: 2px 2px 19px #444;
    opacity: 0.6;
    filter: alpha(opacity=60);
}
.flowchart-demo .active {
    border: 1px dotted green;
}
.flowchart-demo .hover {
    border: 1px dotted red;
}
#flowchartWindow1 {
    top: 34em;
    left: 5em;
}
#flowchartWindow2 {
    top: 7em;
    left: 36em;
}
#flowchartWindow3 {
    top: 27em;
    left: 48em;
}
#flowchartWindow4 {
    top: 23em;
    left: 22em;
}



</style>
</head>
<body>
    <div id="main">  
        <div class="flowchart-demo" id="flowchart-demo">  
            <div class="window" id="flowchartWindow1"><strong>1</strong>  
            </div>  
            <div class="window" id="flowchartWindow2"><strong>2</strong>  
            </div>  
            <div class="window" id="flowchartWindow3"><strong>3</strong>  
            </div>  
            <div class="window" id="flowchartWindow4"><strong>4</strong>  
            </div>  
        </div>  
    </div> 
    <div class="map">
        <c:forEach items="${results}" var="key">
        	<div id="${key.code}" class="station" style="position:absolute;top:${key.y*100}px; left: ${key.x*100}px;width:10px;height:10px;border-radius:5px;border:solid rgb(100,100,100) 1px;"></div>
        </c:forEach>
    </div> 

</body>
<script type="text/javascript">
//https://www.cnblogs.com/leomYili/p/6346526.html?utm_source=itdadao&utm_medium=referral  学习地址
/* var firstInstance = jsPlumb.getInstance();
firstInstance.importDefaults({
 Connector : [ "Bezier", { curviness: 150 } ],
 Anchors : [ "TopCenter", "BottomCenter" ]
});

firstInstance.connect({
  source:"element1", 
  target:"element2", 
  scope:"someScope" 
}); */
/* 
var canvas = document.createElement('canvas');
context = canvas.getContext('2d');
cw = 800;
ch = 500;
toggle = true;

canvas.width = cw;
canvas.height = ch;

function generateNoise(context) {
	var imageData = context.createImageData(cw, ch),
	    buffer32 = new Uint32Array(imageData.data.buffer);
	    len = buffer32.length;
	    i = 0;
	
	for (; i < len;)
	    buffer32[i++] = ((255 * Math.random()) | 0) << 24;
	
	context.putImageData(imageData, 0, 0);
}

(function loop() {
	toggle = !toggle
	if (toggle) {
	    requestAnimationFrame(loop);
	    return
	}
	generateNoise(context);
	requestAnimationFrame(loop);
})()

document.body.appendChild(canvas);
 */
var canvas = document.createElement('canvas');
canvas.width = window.outerWidth;
canvas.height = window.outerHeight;
var cxt=canvas.getContext("2d");

//画一个空心圆
cxt.beginPath();
cxt.arc(200,200,50,0,360,false);
cxt.lineWidth=5;
cxt.strokeStyle="green";
cxt.stroke();//画空心圆
cxt.closePath();
//画一个实心圆
cxt.beginPath();
cxt.arc(200,100,50,0,360,false);
cxt.fillStyle="black";//填充颜色,默认是黑色
cxt.fill();//画实心圆
cxt.closePath();
//空心和实心的组合
cxt.beginPath();
cxt.arc(300,300,50,0,360,false);
cxt.fillStyle="red";
cxt.fill();
cxt.strokeStyle="green";
cxt.stroke();
cxt.closePath();
//document.body.appendChild(canvas);

jsPlumb.ready(function() {
    var DragFlow = function() {
        var connectorPaintStyle = {
                lineWidth: 4,
                strokeStyle: "#61B7CF",
                joinstyle: "round",
                outlineColor: "#000",
                outlineWidth: 2
            },
            connectorHoverStyle = {
                lineWidth: 4,
                strokeStyle: "#216477",
                outlineWidth: 2,
                outlineColor: "#000"
            },
            endpointHoverStyle = {
                fillStyle: "#216477",
                strokeStyle: "#216477"
            },
            sourceEndpoint = {
                endpoint: "Dot",
                paintStyle: {
                    strokeStyle: "#7AB02C",
                    stroke: "#567567",
                    strokeWidth: 2,
                    fillStyle: "#000",
                    radius: 7,
                    lineWidth: 3
                },
                isSource: true,

                connector: ["Flowchart", { stub: [40, 60], gap: 10, cornerRadius: 5, alwaysRespectStubs: true }],
                // connectorStyle: connectorPaintStyle,
                hoverPaintStyle: endpointHoverStyle,
                connectorHoverStyle: connectorHoverStyle,
                dragOptions: {},
                // overlays: [
                //     ["Label", {
                //         location: [0.5, 1.5],
                //         label: "Drag",
                //         cssClass: "endpointSourceLabel"
                //     }]
                // ]
            },
            targetEndpoint = {
                endpoint: "Dot",
                paintStyle: {
                    strokeStyle: "#7AB02C",
                    stroke: "#000",
                    strokeWidth: 2,
                    fillStyle: "#000",
                    radius: 7,
                    lineWidth: 3
                },
                isTarget: true,
                connector: ["Flowchart", { stub: [40, 60], gap: 10, cornerRadius: 5, alwaysRespectStubs: true }],
                hoverPaintStyle: endpointHoverStyle,
                connectorHoverStyle: connectorHoverStyle,
            };
        // 初始化，返回流程图的对象
        this.init = function(_id) {
            var instance = jsPlumb.getInstance({
                DragOptions: {
                    cursor: 'pointer',
                    zIndex: 2000
                },
                ConnectionOverlays: [
                    ["Arrow", { location: 1 }],
                    ["Label", {
                        location: 0.1,
                        id: "label",
                        cssClass: "aLabel"
                    }]
                ],
                ReattachConnections: true,
                deleteEndpointsOnDetach: false,
                Container: "flowchart-demo"
            });

            instance.doWhileSuspended(function() {
                instance.draggable(jsPlumb.getSelector(".flowchart-demo .window"), { grid: [20, 20] });
            });

            instance.bind("click", function(conn, originalEvent) {
                if (confirm("Delete connection from " + conn.sourceId + " to " + conn.targetId + "?")) {
                    // 官网文档太不靠谱了！！！！，这是源码暴露的方法，
                    // 官网文档那个detach不能用！！！！源码都没有暴露这个方法好吗！！！！
                    instance.deleteConnection(conn);
                }
            });

            instance.bind("connection", function(info) {
                info.connection.getOverlay("label").setLabel(info.connection.id);
                //当连接成功后，将箭头上的label改为连接ID
            });

            instance.bind("connectionDrag", function(connection) {
                console.log("connection " + connection.id + " is being dragged. suspendedElement is ", connection.suspendedElement, " of type ", connection.suspendedElementType);
            });

            instance.bind("connectionDragStop", function(connection) {
                console.log("connection " + connection.id + " was dragged");
            });

            instance.bind("connectionMoved", function(params) {
                console.log("connection " + params.connection.id + " was moved");
            });

            // 立即生效
            instance.fire("jsPlumbDemoNodeAdded", instance);

            return instance;

        };
        /**
         * [addEndpoint 添加端点]
         * @param {[type]} _instance      [流程图对象，必传]
         * @param {[type]} _id            [目标块id 可以是字符串或者id数组，必传]
         * @param {[type]} _sourceAnchors [起点位置，数组，可不传]
         * @param {[type]} _targetAnchors [终点位置，数组，可不传]
         */
        this.addEndpoint = function(_instance, _id, _sourceAnchors, _targetAnchors) {
            if (!_sourceAnchors) {
                _sourceAnchors = ["Top", "Bottom"];
            }
            if (!_targetAnchors) {
                _targetAnchors = ["Left", "Right"];
            }

            var deal = function(_id) {
                for (var i = 0; i < _sourceAnchors.length; i++) {
                    var sourceUUID = _id + _sourceAnchors[i];
                    _instance.addEndpoint(_id, sourceEndpoint, { anchor: _sourceAnchors[i], uuid: sourceUUID });
                }
                for (var j = 0; j < _targetAnchors.length; j++) {
                    var targetUUID = _id + _targetAnchors[j];
                    _instance.addEndpoint(_id, targetEndpoint, { anchor: _targetAnchors[j], uuid: targetUUID });
                }
            }

            if (typeof _id == 'string') {
                deal(_id);
            } else if (typeof _id == 'object') {
                $.each(_id, function(i, _id) {
                    deal(_id);
                });
            }

        };
        this.connect = function(_instance, _uuids) {
            _instance.connect({ uuids: _uuids, editable: true });
        };
    };

    var instance = new DragFlow();
    var instanceInit = instance.init();


    instance.addEndpoint(instanceInit, ['flowchartWindow1', 'flowchartWindow2']);
    instance.addEndpoint(instanceInit, 'flowchartWindow3');
    instance.connect(instanceInit, ["flowchartWindow3Bottom", "flowchartWindow1Left"]);
});
</script>
</html>