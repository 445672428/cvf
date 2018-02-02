package com.frame.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entities.PageBean;
import com.frame.facets.imp.SearchEtlImp;
import com.frame.multil.service.HotleService;
import com.hibernate.service.SysService;

@Controller
public class HotleController {
	@Autowired
	private SearchEtlImp searchEtlImp;
	
	/**
		lucene
	 * @throws IOException 
	 */
	@RequestMapping(value="startpoint.do",method=RequestMethod.GET)
	public void startLunce(HttpServletRequest request,HttpServletResponse response ) throws IOException {
		String time = "";
		try {
			time = searchEtlImp.startDataChange();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(time);
		out.flush();
		out.close();
	}
	
	
	@Autowired
	private HotleService hotleService;
	@Autowired
	private SysService sysService;
	/**
	 * 酒店人员信息
	 * @return
	 */
	@RequestMapping(value="guessinfo.do",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryHotlePage(int pagesize,int start) {
		sysService.groupAdd();
		PageBean pageBean = hotleService.queryHotleMsg(pagesize,start);
		return JSON.toJSONString(pageBean);
	}
}
