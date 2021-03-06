package com.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.annotation.AccessColumn;
import com.frame.service.ConfigService;
import com.utils.HttpUtils;
/**
 * 页面基础数据类
 * @author bobo
 *
 */
@Controller
public class BasicConfigureAction {
	
	@Autowired
	private ConfigService configService;

	@AccessColumn(operationName="全国信息树形结构")
	@RequestMapping(value="china",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryChinaDict(String id) {
		JSONArray list = configService.queryChinaCode(id);
		return list.toString();
	}
	
	@AccessColumn(operationName="当前用户所在地天气访问")
	@RequestMapping(value="weather",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryWeather(String city) {
		String result = configService.queryWeather(city);
		return result;
	}
	


}
