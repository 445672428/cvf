package others.demo.jsajax;

public class Ajax {
	/**
	* 结构层：HTML标签
	* DOM对象和jQuery对象
		* DOM对象：通过DOM解析HTML页面元素，所得到的DOM元素
		* jQuery对象(底层还是DOM对象)：通过jQuery包装DOM对象后产生的对象
		* DOM对象转换成jQuery对象：$(DOM对象)
		* jQuery对象转换成DOM对象：
			* jQuery对象是数组对象：jQuery对象[索引值]
			* jQuery提供了get(index)方法
		* DOM对象与jQuery对象互操作?不可以
	* jQuery相对于DOM来讲，具有比较完善的事情处理机制
	* 选择器
		* 选择器是jQuery中的根基
		* jQuery的九大选择器(分类)
		* 建议：
			* 一定要将九个页面强加练习
			* 熟悉jQuery的帮助文档
	* DOM操作：对比原生DOM操作来学习
		* 获取节点：
			* 元素节点：所有选择器
			* 文本节点：text()
			* 属性节点：
				* attr()
				* removeAttr()
		* 创建节点：
			* 元素节点：$(HTML代码),注意标签的闭合
			* 文本节点：text()
			* 属性节点：attr()
		* 删除节点：
			* remove()：删除自身节点及后代节点
			* empty()：删除后代节点，保留自身节点
		* 插入节点：
			* 内部插入节点：插入标签内部
			* 外部插入节点：插入标签外部
		* 复制节点：
			* 原生js的复制节点：cloneNode(Boolean),true参数表示复制后代节点
			* jQuery的复制节点：clone(Boolean),true参数表示复制事件
		* 替换节点：
			* replaceAll()：前面的元素是替换元素；后面的元素是被替换元素
				* replaceAll()就是颠倒了的replaceWith()
			* replaceWith()：前面的元素是被替换元素；后面的元素是替换元素
		* html()方法就相当于DOM中的innerHTML属性
		* 遍历节点：
			* 父节点：parent()
			* 子节点：children()
			* 兄弟节点
				* 上一个兄弟节点：prev()
				* 下一个兄弟节点：next()
				* 所有兄弟节点：siblings()
			* find(expr)
		* 包裹节点：
			* wrap()：分别包裹
			* wrapAll()：一起包裹
			* wrapInner()：包裹指定标签内部
	* 事件
		* 常规事件：click()\dblclick()等
		* 特殊事件：
			* ready()：面试
				$(docment).ready(function(){}) == window.onload
				* ready的执行效率高
				* ready在一个页面可以有多个
				* ready的简写方法：
					* $().ready(function(){})
					* $(function(){})
			* bind()与unbind()：绑定事件与解绑定事件
				* 绑定事件：
					* 将页面元素绑定到具体事件上
					* $(expr).click()
				* 绑定事件与解绑定事件
					* 绑定与解绑单个事件
					* 绑定与解绑多个事件
				* 绑定与解绑支持多少事件：blur, focus, focusin, focusout, load,
				resize, scroll, unload, click, dblclick, mousedown, mouseup, 
				mousemove, mouseover, mouseout, mouseenter, mouseleave, change, 
				select, submit, keydown, keypress, keyup, error 。 
				* 其实常规事件就是绑定事件的简写方式。
			* 事件切换
				* hover(over, out)：模拟一个鼠标悬停事件(over,out)
					* over:mouseover
					* out:mouseout

					* 为什么要这样做：
						* 实现鼠标悬停更简单
						* 多用于页面效果
				* toggle()：多用于页面效果
	* Ajax
		* $.ajax()：最复杂、最灵活，最接近原生Ajax的用法
		* load()：最简单、最不灵活
		* $.get()：请求类型是GET
		* $.post()：请求类型是POST
		* $.getScript()：获取脚本代码
		* $.getJSON()：返回的数据格式是JSON格式

		* 序列化元素：
			* serialize()
				* 序列化的是JSON格式中的key/value格式
				* 返回的是JSON字符串
			* serializeArray()
				* 序列化的是JSON格式中的数组格式
				* 返回的是JSON对象
	* 插件
	* 
	* JQuery 对 Ajax 操作进行了封装
在 jQuery 中最底层的方法时 $.ajax()
第二层是 load(), $.get() 和 $.post()
第三层是 $.getScript() 和 $.getJSON()
jQuery:
	* Ajax
		* $.ajax()
		* load()
		* $.get()
		* $.post()
		* $.getScript()：动态获取脚本代码
		* $.getJSON()：返回数据格式一定是JSON
		* 实现跨域请求
	* Firebug工具：
		* 脚本功能：
			* 如果行标是绿色的，说明代码是可用的
			* 行标前出现红点，表示断点处
		* HTML功能：页面快速定位
			* 选择对应HTML代码，快速定位对应页面效果中
			* 选择对应页面效果中的元素，快速定位对应HTML代码中
	* 插件
		* 研究jQuery插件机制
			* 目的：
				* 为了将来实际开发中，快速上手新的插件
				* 为了将来大家面试的：独立制作插件
			* 机制（分类）：
				* 封装对象方法的插件
					* $(expr).each()：对象方法
					* jQuery.fn.extend(object) == jQuery.extend($.fn,object)
				* 封装全局函数的插件
					* $.each()：全局函数
					* jQuery.extend(object)
				* 选择器插件：这一类插件，现在几乎不用了。例如XPath插件
			* 使用：
				* 先引入jQuery文件
				* 再引入jQuery的插件文件
		* this的用法：（了解）
			* 作用：
				* 指代DOM对象：明确指代页面中的具体元素
				* 指代jQuery对象：在插件中使用，基本都是jQuery对象
			* 注意：尽量不用
		* 举例：表单验证插件
			* 使用：插件指定对应的jQuery版本（换版本可能导致插件失效）
var id=3;//首先定义全局变量id=3
	function aa(){
		this.id=0;
		this.func=null;
	}
	var a1=new aa();//然后a1继承aa而在a1初始化时运行aa(),此时的a1.id=0，a1的func等于null
	a1.id=1;//修改a1的属性
	a1.func = bb;
	var a2=new aa();//a2继承aa
	a2.id=2;
	a2.func=bb;
	alert(a1.func==a2.func);//都等于bb
	a1.func();//a1的id在前面设过为1
	a2.func();//a2的id在前面设过为2
	alert(a1.func==bb);
	bb();//闭包特性，局部函数访问全局变量，id为3
	function bb(){
		alert(this.id);
	}
 <script type="text/javascript">
			function Fun(){
		  		this.name="hp"
		  		function fun(){
		  			this.name="hehe"
		  		}
		  	fun();
		  	alert(this.name);
			}
			Fun.prototype.name1="hiahia";
			var a=new Fun();//输出hp
			alert(a.name1);//输出hiahia
		  	alert(Fun.name);//输出undefined
			alert(window.name);//输出hehe
			alert(a.name);//输出hp
  </script>
  
  
  javascript面向对象：
	* 函数
		* Arguments对象：
			* Arguments对象是数组对象
			* Arguments对象的length属性可以获取参数的个数
			* 利用Arguments对象模拟函数的重载效果（javascript中不存在函数重载）
		* 变量的作用域：
			* 全局变量与局部变量
				* 全局变量：全局域与函数域（局部域）
				* 局部变量：当前函数域
			* 全局域与函数域
			* 定义局部变量时，不使用"var"，局部变量变成全局变量
			* 定义全局变量与局部变量同名时，函数域中只能访问局部变量
		* 几种特殊函数：
			* 匿名函数：没有名的函数
			* 回调函数：把一个函数作为参数传递给另一个函数，而作为参数的函数叫做回调函数
			* 自调函数：定义即调用
				* 第一个小括号：封装函数
				* 第二个小括号：调用函数（传参）
			* 内部函数：Java中的内部类
			* 返回函数的函数
	* 闭包
	* 对象
		* 定义对象：
			* 普通对象
				* new Object()
				* var 对象名 = {
					属性名 : 属性值,
					方法名 : function(参数){}
				}
			* 函数对象
				function 对象名(参数){
					this.属性名 = 属性值;
					this.方法名 = function(参数){}
				}
		* 调用对象：
			* 普通对象：
				* 调用：
					* 第一种：
						* 对象名.属性名;
						* 对象名.方法名();
					* 第二种：
						* 对象名['属性名'];
						* 对象名['方法名']();
				* 增加：
					* 对象名.新的属性名 = 新的属性值;
					* 对象名.新的方法名 = 新的function(){}
				* 修改：
					* 对象名.属性名 = 新的属性值;
					* 对象名.方法名 = 新的function(){}
				* 删除：
					* delete 对象名.属性名;
					* delete 对象名.方法名;
			* 函数对象：
				* 概念性理解：
					* 函数对象的概念，实际上是不存在的
					* 函数对象实际上是叫做构造器
					* var 对象名 = new 构造器();
				* 获取到函数对象(构造器)的属性和方法
					* var 对象名 = new 构造器();
					* 调用、修改、删除及增加与操作普通对象一致。
		* 内建对象：
			* 数据封装类对象
				* String、Array、Number等
			* 工具类对象
				* Date、Math等
			* 错误类对象
				* Error、异常对象等
	* 在javascript中，只有对象（变量、方法、集合等）
		* javascript是更纯粹的面向对象
	* 原型(prototype)：及其重要(作用)
		* 定义：原型就是一个函数对象的属性。
		* 作用：
			* 利用原型为函数对象增加属性和方法
			* 函数对象的属性或方法与原型的属性或方法同名时:
				* 函数对象本身的属性和方法的优先级要高于原型上的熟悉感和方法
				* 利用函数对象的属性和方法重写原型上的属性和方法
			* 内建对象(应该都是函数对象)：都有prototype属性
				* 可以扩展内建对象的属性和方法
			* 实现继承
	* 继承
		* 定义：如果两个类都是同一个实例的类型，那么它们之间存在着某些关系，
		        我们把同一个实例的类型之间的泛化关系称为“继承”。
		* 问题：
			* 在javascript中，是不存在继承的关系的（关键字 extend）！
			* 在javascript中，没有类的概念。
			* javascript就不是一个直接的面向对象语言。
		* "继承"：
			* javascript中函数对象与函数对象之间的继承。
			* (了解)javascript中的普通对象之间，是否也存在"继承"关系呢?存在

*/



}
