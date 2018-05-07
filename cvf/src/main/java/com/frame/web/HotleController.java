package com.frame.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseAction;
import com.entities.PageBean;
import com.frame.facets.imp.SearchEtlImp;
import com.frame.multil.service.HotleService;
import com.frame.service.SysService;
import com.hibernate.service.SysLogService;
/**
 * 酒店人员信息
 * @author bobo
 *
 */
@Controller
public class HotleController extends BaseAction{
	@Autowired
	private SearchEtlImp searchEtlImp;
	@Autowired
	private HotleService hotleService;
	@Autowired
	private SysService sysService;
	@Autowired
	private SysLogService sysLogService;
	
	/**
		lucene查询
	 * @throws IOException 
	 */
	@RequestMapping(value="t.do",method=RequestMethod.GET)
	public void dasds(HttpServletRequest request,HttpServletResponse response,String search) throws IOException {
		sysService.name();
		sysLogService.insertmysave();
	}
	/**
		lucene查询
	 * @throws IOException 
	 */
	@RequestMapping(value="search.do",method=RequestMethod.GET)
	public void startLunce(HttpServletRequest request,HttpServletResponse response,String search) throws IOException {
		search = new String(search.trim().getBytes("ISO-8859-1"),"UTF-8");
		List<JSONObject> list = searchEtlImp.queryMatchSuitValue(search);
		//response.setContentType("text/html;charset=utf-8");
		logger.info("list length:"+list.size());
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String datas = JSONArray.toJSONString(list);
		out.print(datas);
		out.flush();
		out.close();
	}

	/**
	 * 酒店人员信息
	 * @return
	 */
	@RequestMapping(value="guessinfo.do",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryHotlePage(int pagesize,int start) {
		//sysService.groupAdd();
		PageBean pageBean = hotleService.queryHotleMsg(pagesize,start);
		return JSON.toJSONString(pageBean);
	}
}
