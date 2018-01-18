package com.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entities.PageBean;
import com.frame.multil.service.HotleService;
import com.hibernate.service.SysService;

@Controller
public class HotleController {
	
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
