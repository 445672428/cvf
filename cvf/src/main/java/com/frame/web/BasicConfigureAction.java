package com.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.frame.service.ConfigService;
/**
 * 页面基础数据类
 * @author bobo
 *
 */
@Controller
public class BasicConfigureAction {
	
	@Autowired
	private ConfigService configService;
	/**
	 * 全国信息树形结构
	 * @param code
	 * @param level
	 * @return
	 */
	@RequestMapping(value="china.do",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryChinaDict(String id) {
		JSONArray list = configService.queryChinaCode(id);
		return list.toString();
	}
}
