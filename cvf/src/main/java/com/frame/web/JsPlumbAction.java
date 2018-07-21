package com.frame.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.annotation.AccessColumn;
import com.base.BaseAction;
import com.frame.service.JsPlumbService;
import com.frame.service.SysService;
import com.pojo.ResultMeta;
import com.pojo.UpTable;
import com.pojo.UpTable.Data;

@Controller
@RequestMapping(value="jsplumb")
public class JsPlumbAction extends BaseAction{
	@Autowired
	private JsPlumbService jsPlumbService;
	@Autowired
	private SysService sysService;
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	@AccessColumn(operationName="jsPlumb测试页面")
	@RequestMapping(value="plumb",method=RequestMethod.GET)
	public ModelAndView welcomeJsPlumb(){
		JSONArray results = jsPlumbService.queryWelcomeJsPlumb();
		ModelAndView view = new ModelAndView("d3");
		view.addObject("results", results);
		return view;
	}
	@AccessColumn(operationName="表的字段信息")
	@RequestMapping(value="tableinfo",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryOneTableDetail(@RequestParam String dbname,@RequestParam String tableName,@RequestParam String schema ){
		JSONArray array = sysService.querySelectOneTable(dbname,tableName,schema);
		return array.toJSONString();
	}
	@AccessColumn(operationName="库里面所有表信息")
	@RequestMapping(value="dbtables",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryDBAllTables(@RequestParam String dbname,@RequestParam Integer limit,@RequestParam Integer offset,
			@RequestParam String order,@RequestParam String search){
		
		int total = sysService.querySchema();
		List<Map<String, Object>> list = sysService.queryByDBAllTables(dbname,limit,offset,order,search,total);
        JSONArray array = new JSONArray();
        int count = 1;
        for(Map<String, Object> map: list){
        	String db = (String)map.get("TABLE_SCHEMA");
        	String tableName = (String)map.get("TABLE_NAME");
        	String sql = "show table status from "+db+" where name='"+tableName+"' ";
        	Map<String, Object> m = mysqlJdbcTemplate.queryForMap(sql);
        	
        	JSONObject o = new JSONObject();
        	o.put("xh", count);
        	o.put("orderDB", db);
        	o.put("typeDB", dbname);
        	o.put("createTable", map.get("CREATE_TIME"));
        	o.put("nameTable", tableName);
        	o.put("commontTable", map.get("TABLE_COMMENT"));
        	o.put("countTable", m.get("Rows"));//数量
        	o.put("chartTable", map.get("TABLE_COLLATION"));
        	o.put("enginDB", m.get("Engine"));//引擎
        	count ++;
        	array.add(o);
        }
        JSONObject object = new JSONObject();
        object.put("total", total);
        object.put("rows", array);
        object.put("page", offset);
		return object.toJSONString();
	}
	
	@AccessColumn(operationName="表是否存在当前库")
	@RequestMapping(value="tableindb",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public ResultMeta checkTableInDB(String tableName,String dbName){
		int cnt = sysService.queryIsInDB(tableName,dbName);
		ResultMeta meta = new ResultMeta();
		meta.failure("存在同名表");
		if(cnt==0){
			meta.success("ok");
		}
		return meta;
	}
	@AccessColumn(operationName="在当前库创建表信息")
	@RequestMapping(value="createtable",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public ResultMeta createTableInDB(HttpServletRequest request,@RequestBody UpTable upTable){
		List<Data> datas = upTable.getDatas();
		executeToTable(datas,upTable.getTableName());
		ResultMeta meta = new ResultMeta();
		meta.failure("存在同名表");
		return meta;
	}
}
