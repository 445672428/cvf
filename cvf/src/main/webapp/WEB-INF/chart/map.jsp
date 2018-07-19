<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="/res/favicon.ico" />
<title>铁路线</title>
<script type="application/javascript">
	
    function JSRunTrace() {
        window.parent.postMessage(["log", Array.prototype.join.call(arguments, ", ")], "*");
        console.log(arguments);
    }

    listeners = (function (_this) {
        return function (event) {
            var data, eventName;
            eventName = event.data[0];
            data = event.data[1];
            switch (eventName) {
                case "eval":
                    var result;
                    try {
                        result = eval(data);
                    } catch (e) {
                        result = e.toString();
                    } finally {
                        // 此处是出口语句
                    }
                    JSRunTrace(result);
                    break;
            }
        };
    })(this);
    window.addEventListener("message", listeners, false);

</script>
<link href="${CONTEXTPATH }/resources/lib/d3//tipsy.css" rel="stylesheet">  
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jQuery/jquery2.1.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/d3/d3.js" charset="utf-8"></script>
<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/d3/jquery.tipsy.js" charset="utf-8"></script>

<script type="text/javascript" src="${CONTEXTPATH }/resources/lib/jsplumb/jsPlumb-2.2.8-min.js" charset="utf-8"></script>
</head>
<body>
	<div id="map" style="width: 1900px;height: 1040px;"></div>
</body>
<script type="text/javascript">
            
    $(function(){
    	var name = "china";
    	newMap(name);
    })
    
     function getCenters(features){
         var longitudeMin = 100000;//最小经度值
         var latitudeMin = 100000;//最小纬度值
         var longitudeMax = 0;//最大经度值
         var latitudeMax = 0;//最大纬度值
         features.forEach(function(e){  
             var a = d3.geo.bounds(e);//[为某个对象计算经纬度  d3.geo.bounds - compute the latitude-longitude bounding box for a given feature]
             if(a[0][0] < longitudeMin) {
                 longitudeMin = a[0][0];
             }
             if(a[0][1] < latitudeMin) {
                 latitudeMin = a[0][1];
             }
             if(a[1][0] > longitudeMax) {
                 longitudeMax = a[1][0];
             }
             if(a[1][1] > latitudeMax) {
                 latitudeMax = a[1][1];
             }
         });
      
         var a = (longitudeMax + longitudeMin)/2;
         var b = (latitudeMax + latitudeMin)/2;
      
         return [a, b];
    }
    
    //设置地图的大小 获得 scale
    function getZoomScale(features, width, height){
           var longitudeMin = 100000;//最小经度值
           var latitudeMin = 100000;//最小纬度值
           var longitudeMax = 0;//最大经度值
           var latitudeMax = 0;//最大纬度值
           features.forEach(function(e){  
               var a = d3.geo.bounds(e);//[为某个对象计算经纬度  d3.geo.bounds - compute the latitude-longitude bounding box for a given feature]
               if(a[0][0] < longitudeMin) {
                   longitudeMin = a[0][0];
               }
               if(a[0][1] < latitudeMin) {
                   latitudeMin = a[0][1];
               }
               if(a[1][0] > longitudeMax) {
                   longitudeMax = a[1][0];
               }
               if(a[1][1] > latitudeMax) {
                   latitudeMax = a[1][1];
               }
           });
        
           var a = longitudeMax-longitudeMin;
           var b = latitudeMax-latitudeMin;
        
           return Math.min(width/a, height/b);
    }
	function linearTop(svg,defs,maxdata,middata){
	    //定义颜色  
	    var b=d3.rgb(130, 140, 20);  
	    var a=d3.rgb(255, 255, 180);
	    //线性比例初始值	//中间值	//最大值
	    var mindata=0; 
	  //颜色渐变方向  
	    var linearGradient = defs.append("linearGradient").attr("id","linearColor").attr("x1","0%").attr("y1","0%").attr("x2","100%").attr("y2","0%");  
		//设置矩形条开始颜色  
		var stop1 = linearGradient.append("stop").attr("offset","0%").attr("stop-color",a.toString());  
		//设置结束颜色  
		var stop2 = linearGradient.append("stop").attr("offset","100%").attr("stop-color",b.toString());  
		//x,y 矩形的左上角坐标  矩形的宽高     引用上面的id 设置颜色  
		var colorRect = svg.append("rect").attr("x",50).attr("y",50).attr("width",200).attr("height",20).style("fill","url(#"+linearGradient.attr("id")+")");
	    //定义一个线性比例尺  
	    var linear = d3.scale.linear().domain([mindata,maxdata]).range([0,1]);  
	    
	    //设置文字  
	    
	    //数据初值  
	    var startText = svg.append("text").attr("x",50).attr("y",45).text(mindata);   
	    //数据中间值  d3.mean(middata)//平均值  
	    var middleText =svg.append("text").attr("x",125).attr("y",45).text(d3.median(middata));  //中间值  
	    //数据末值  
	    var endText =svg.append("text").attr("x",250).attr("y",45).text(maxdata);  
	}
	
    
	function newMap(name){

		var o = document.getElementById("map");
		var height = o.offsetHeight;
		var width = o.offsetWidth;

		d3.select("svg").remove();
		var svg = d3.select("#map").append('svg').attr("width", width).attr("height", height).
		append("g").attr('id', "gmap").attr("transform", "translate(0,0)");
		
		var defs = svg.append("defs");  
		//颜色设置
		var color = d3.scale.category20();
		d3.json("resources/json/china/"+name+".json", function(error, root) {
			if (error) {
				return console.error(error);
			}
			var middata = [];
			var center = getCenters(root.features);//最优中心点需要优化
			var zoomScale = getZoomScale(root.features, width, height);//最优缩放值需要优化 
			var scaleVal = Math.max(width,height);
			var v = Math.round(scaleVal / zoomScale);//最优缩放比需要优化
			var projection = d3.geo.mercator().center(center).translate([ width / 2, height / 2 ]).scale(zoomScale*35 );
			//projection.rotate([-30,0]);
			d3.geo.gnomonic();
			//projection.rotate([-49.7,-27.4,-20]);
			//创建地图线
			var path = d3.geo.path().projection(projection);
			
			for(var i=0;i<root.features.length;i++)
			{		
			 	$.extend(root.features[i],{"value":Math.ceil(Math.random()*5000)});
			 	middata.push(root.features[i]['value']);
			}
			var maxdata = d3.max(middata,function(v){
				return v;
			})
			linearTop(svg,defs,maxdata,middata);
			
			svg.selectAll("path").data(root.features).enter().append("path").attr("stroke", "#000").attr("stroke-width", 1).attr("id",
			function(d) {
				return "path" + d.properties.id;
			}).attr("fill", function(d, i) {
				return color(i);
			}).attr("d", path).on("mouseover", function(d, i) {
				d3.select(this).attr("fill", "yellow");
			}).on("mouseout", function(d, i) {
				d3.select(this).attr("fill", color(i));
			}).on("click",function(d, i) {
				//if(d.properties.id.length == 2){
					newMap(d.properties.id);
				//}
			});
			
			var location = svg.selectAll(".pin")
			  .data(root.features)
			  .enter().append("circle", ".pin")
			  .attr("r", 2)
			  .attr("transform", function(d) {
				return "translate(" + projection([
				  d.properties.cp[0], d.properties.cp[1]
				]) + ")";
			  });		
			
			svg.selectAll(".location")
			  .data(root.features)
			  .enter().append("image", ".location")
			  .attr("x", function (d) {
		            var local = projection([d.properties.cp[0], d.properties.cp[1]])
		            return local[0]
		        })
			  .attr("y",function (d) {
		            var local = projection([d.properties.cp[0], d.properties.cp[1]])
		            return local[1]
		        })
			  .attr("width",24)
			  .attr("height",20)
			  .attr("xlink:href","${pageContext.request.contextPath}/resources/images/10.png");
			  /* .attr("transform", function(d) {
				return "translate(" + projection([
					d.properties.cp[0], d.properties.cp[1]
				]) + ")";
			  }) */	
			
			
			initText(svg,projection,root.features);
	        $('svg path').tipsy({ 
	            gravity: 'w', 
	            html: true, 
	            title: function() {
	              var d = this.__data__;
	              return 'Hi there! My color is <span style="color:"></span>'; 
	            }
	          });
		});
	}
	//自定义提示tooltip
    var draw = function(id, data, toolTip){
         function mouseOver(d){
             d3.select("#tooltip").transition().duration(200).style("opacity", .9);
 
             d3.select("#tooltip").html(toolTip(d.n, data[d.id]))
                 .style("left", (d3.event.pageX) + "px")
                 .style("top", (d3.event.pageY - 28) + "px");
         }
 
         function mouseOut(){
             d3.select("#tooltip").transition().duration(500).style("opacity", 0);
         }
 
         d3.select(id).selectAll(".state")
             .data(uStatePaths).enter().append("path").attr("class","state").attr("d",function(d){ return d.d;})
             .style("fill",function(d){ return data[d.id].color; })
             .on("mouseover", mouseOver).on("mouseout", mouseOut);
     }

	//添加文字
	function initText(svg,projection,features) {
		svg.selectAll("text").data(features).enter().append("svg:text").attr("class", function(d){
        	if (d.properties.id.length > 2) {
				return "location";
			} else {
				return "distribution";
			}
		}).text(function (d, i) {
            return d.properties.name
        }).attr("fill", "#000000")
		.attr('font-size', '14px')
		.attr("style","cursor:pointer;")
        .attr("x", function (d) {
            var local = projection([d.properties.cp[0], d.properties.cp[1]])
            return local[0]
        })
        .attr("y", function (d) {
            var local = projection([d.properties.cp[0], d.properties.cp[1]])
            return local[1]
        })
        .attr("fill", "#000000")
        .style("font-size", "10px");

	}

</script>

<script type="text/javascript">
(function (root,factory){
	root["initMap"] = factory();
})(this,function(){
	return (function(){
		var factory = {
			
		};
		return factory;
	})();
});

</script>
</html>