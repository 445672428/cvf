Ext.Loader.setConfig({enabled: true});

Ext.onReady(function () {
	init3();
});

function init3(){
	 var searchAction = Ext.create('Ext.Button', {
        text: '查询',
        height:44,
        width:50,
        layout:{ 
             type:"column", 
             columns:1 
        }, 
        style:'margin-left:68.2%;margin-top:-44px;',
        name: 'QueryBtn',
        handler: function () {
        	search();
            // 设置搜索条件
        }
    });
	var shipMgrToolBarPanel = Ext.create('Ext.form.Panel',{
		width: '100%',
	    renderTo: Ext.getBody(),
	    height: window.innerHeight,
	    bodyBorder: false,
	    border: false,
	    region:'center',
	    layout:{ 
             type:"vbox",
             pack:"center",   //控制子组件如何被打包在一起，start：左边（默认）；center：居中；end：右边 
             align:"center"   //对齐方式 center、left、right：居中、左对齐、右对齐；stretch：延伸；stretchmax：以最大的元素为标准延伸 
         }, 
	    items: [{
		    width: window.innerWidth,
		    height: window.innerHeight,
		    items:[
		    	{	
		    		 width: '36%',
		    		 height: 44,
		    		 flex:1, 
		    		 region:'center',
		    		 style:'margin:0 auto;background:#000000;margin-top:12%;',
		    		 xtype:'textfield', 
		    		 enableKeyEvents: true,
			         listeners: {
			            keyup: function (thisControl, e, eOpts) {
			                if (e.button == 12) {  // 若敲的键为回车，就执行【查询】搜索
			                	//调用 按钮方法
			                    shipMgrToolBarPanel.down('[name=QueryBtn]').handler();
			                    search();
			                }
			            }
			         },
        			 name:'search'
		    	},searchAction,resultPanel
		    ]
		}]
	});
	Ext.on('resize', function (width, height)
	{	
	    shipMgrToolBarPanel.setWidth(width);
	    shipMgrToolBarPanel.setHeight(height);
	});
	var myStore = new Ext.create('Ext.data.Store',{
		 proxy: {
	     type: 'ajax',
	     url: '/users.json',
	     reader: {
	         	type: 'json',
	         	root: 'users'
		     }
		 },
     	autoLoad: false
	});
	//数据查询
	function search(){
		var params = shipMgrToolBarPanel.getForm().getValues();
//		shipMgrToolBarPanel.getForm().load({
//			params: params,  
//	        url: CONTEXTPATH+"/search.do",  
//	        method: "GET",  
//	        waitMsg:"加载中，请稍后……",  
//	        success: function (form, action)  
//	        {  
//	            //加载成功的处理  
//	            Ext.MessageBox.alert("提示", "产品简介加载成功");  
//	        },  
//	        failure: function (form, action)  
//	        {  
//	            //加载失败的处理  
//	            Ext.MessageBox.alert("提示", "产品简介加载失败<br/>原因是:" + action.result.info);  
//	        }
//		});
		Ext.Ajax.request({   
            url:CONTEXTPATH+"/search.do",
            params: params,
            method:'GET',    
            waitMsg:'数据加载中，请稍后....',    
            success:function(response,opts){  
            	var store = Ext.create('Ext.data.Store',{ 
            		fields : json.fieldsNames,//把json的fieldsNames赋给fields    
           			data : json.data          //把json的data赋给data    
            	});
            	Ext.getCmp("configGrid").reconfigure(store, json.columModle);  //定义grid的store和column    
           		Ext.getCmp("configGrid").render();
            },    
            failure:function(response,opts){    
            }  
		});
	};
	//查询返回列表
   resultPanel = Ext.create("Ext.grid.Panel",{    
       id : 'configGrid',    
       name : 'configGrid',    
       columns : [],    
       displayInfo : true,    
       emptyMsg : "没有数据显示",    
       items : [],    
       renderTo:'grid'    
    });    
	var sm = new Ext.grid.CheckboxSelectionModel();
	var cm = [new Ext.grid.RowNumberer(),sm,{header:'内容',dataIndex:'content',width:100,hidden:true},
			 {header:'内容',dataIndex:'content',width:100,hidden:true},
			 {header:'内容',dataIndex:'content',width:100,hidden:true},
			 {header:'内容',dataIndex:'content',width:100,hidden:true},
			 {header:'内容',dataIndex:'content',width:100,hidden:true},
			 {header:'内容',dataIndex:'content',width:100,hidden:true},
			 {header:'内容',dataIndex:'content',width:100,hidden:true}];
}



function init2(){
	shipMgrToolBarPanel = Ext.create('Ext.panel.Panel', {
	    width: '100%',
	    renderTo: Ext.getBody(),
	    height: window.innerHeight,
	    bodyBorder: false,
	    border: false,
	    region:'center',
	    layout:'border',
	    tbar: [
	        Ext.create('Ext.form.field.Text', {
	            name: 'SearchTxt',
	            emptyText: '',
	            width: 546,
	            height:36,
	            enableKeyEvents: true,
	            listeners: {
	                keyup: function (thisControl, e, eOpts) {
	                    if (e.button == 12) {  // 若敲的键为回车，就执行【查询】搜索
	                        shipMgrToolBarPanel.down('[name=QueryBtn]').handler();
	                    }
	                }
	            }
	        }),
	        Ext.create('Ext.Action', {
	            text: '查询',
	            height:36,
	            width:50,
	            name: 'QueryBtn',
	            handler: function () {
	                // 设置搜索条件
	                searchConditionObj.SearchTxt = shipMgrToolBarPanel.down('[name=SearchTxt]').value;
	                shipMgrStore.loadPage(1);
	            }
	        })
	    ]
	});
	
}

function init1(){
	var resultsPanel = Ext.create('Ext.panel.Panel', {
	    title: 'Results',
	    width: 600,
	    height: 400,
	    renderTo: Ext.getBody(),
	    layout: {
	        type: 'vbox',       // Arrange child items vertically
	        align: 'stretch',    // Each takes up full width
	        padding: 5
	    },
	    items: [{               // Results grid specified as a config object with an xtype of 'grid'
	        xtype: 'grid',
	        columns: [{header: 'Column One'}],            // One header just for show. There's no data,
	        store: Ext.create('Ext.data.ArrayStore', {}), // A dummy empty data store
	        flex: 1                                       // Use 1/3 of Container's height (hint to Box layout)
	    }, {
	        xtype: 'splitter'   // A splitter between the two child items
	    }, {                    // Details Panel specified as a config object (no xtype defaults to 'panel').
	        title: 'Details',
	        bodyPadding: 5,
	        items: [{
	            fieldLabel: 'Data item',
	            xtype: 'textfield'
	        }], // An array of form fields
	        flex: 2             // Use 2/3 of Container's height (hint to Box layout)
	    }]
	});
	var filterPanel = Ext.create('Ext.panel.Panel', {
    	bodyPadding: 5,  // Don't want content to crunch against the borders
	    width: 300,
	    title: 'Filters',
	    items: [{
	        xtype: 'datefield',
	        fieldLabel: 'Start date'
	    }, {
	        xtype: 'datefield',
	        fieldLabel: 'End date'
	    }],
	    renderTo: Ext.getBody()
	});
    var grid = Ext.create('Ext.form.Panel',{
    	renderTo: Ext.getBody(),
    	title: '点击一下，了解更多',
        width: 800,
        height:1000,
        layout: {
		    type: 'vbox',
		    align: 'left'
		},
        bodyPadding: 10,
        pageSize: 10,
        region: 'north',
        tar:[
        	 Ext.create('Ext.form.field.Text', {
	            name: 'SearchTxt',
	            emptyText: '请输入船舶名称',
	            width: 200,
	            enableKeyEvents: true,
	            listeners: {
	                keyup: function (thisControl, e, eOpts) {
	                    if (e.button == 12) {  // 若敲的键为回车，就执行【查询】搜索
	                        shipMgrToolBarPanel.down('[name=QueryBtn]').handler();
	                    }
	                }
	            }
	        }),
	        Ext.create('Ext.Action', {
	            icon: 'Resources/icon/find.png',
	            text: '查询',
	            name: 'QueryBtn',
	            handler: function () {
	                // 设置搜索条件
	                searchConditionObj.SearchTxt = shipMgrToolBarPanel.down('[name=SearchTxt]').value;
	                shipMgrStore.loadPage(1);
	            }
	        })
        ],
		items:[{
			xtype: 'combo',
			height:80,
			displayField: 'title',
            typeAhead: false,
            hideLabel: true,
            hideTrigger:true,
            anchor: '100%',
			listConfig: {
				emptyText: 'No matching posts found.',
				loadingText: 'searching...',
				getInnerTpl: function() {
                    return '<a class="search-item" href="http://www.sencha.com/forum/showthread.php?t={topicId}&p={id}">' +
                        '<h3><span>{[Ext.Date.format(values.lastPost, "M j, Y")]}<br />by {author}</span>{title}</h3>' +
                        '{excerpt}' +
                    '</a>';
                }
			}
		},{
            xtype: 'button',
            style: 'margin:10px',
            html: 'search'
        }]
    });
	
}

function init() {
 	Ext.create('Ext.form.Panel', {
	    title: 'Simple Form',
	    bodyPadding: 5,
	    width: 350,
	    layout: 'anchor',
	    defaults: {
	        anchor: '100%'
	    },
	    defaultType: 'textfield',
	    items: [{
	        fieldLabel: 'First Name',
	        name: 'first',
	        allowBlank: false
	    },{
	        fieldLabel: 'Last Name',
	        name: 'last',
	        allowBlank: false
	    }],
	    buttons: [{
	        text: 'Reset',
	        handler: function() {
	            this.up('form').getForm().reset();
	        }
	    }, {
	        text: 'Submit',
	        formBind: true,
	        disabled: true,
	        handler: function() {
	            var form = this.up('form').getForm();
	            if (form.isValid()) {
	                form.submit({
	                    success: function(form, action) {
	                       Ext.Msg.alert('Success', action.result.msg);
	                    },
	                    failure: function(form, action) {
	                        Ext.Msg.alert('Failed', action.result.msg);
	                    }
	                });
	            }
	        }
	    }],
	    renderTo: Ext.getBody()
	});
}
