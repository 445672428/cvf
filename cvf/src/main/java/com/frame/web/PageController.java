package com.frame.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseAction;
import com.entities.TAdmin;
import com.frame.service.ConfigService;
import com.utils.SysDateFormat;

import contant.Contant;

/**
 * 页面跳转控制器
 * @author bobo
 *
 */
@Controller
public class PageController extends BaseAction{
	@Autowired
	private ConfigService configService;
	
	
	@RequestMapping(value="/rest",method=RequestMethod.GET)
	public String restPage(@RequestParam("page")String page){
		return page;
	}
	
	@RequestMapping(value="/personal",method=RequestMethod.GET)
	public ModelAndView toPersonal(){
		ModelAndView view = new ModelAndView("/views/personal");
		view.addObject("id", "basic");
		return view;
	}
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView toHome(HttpServletRequest request,HttpServletResponse response){
		TAdmin tUser = (TAdmin)request.getSession().getAttribute(Contant.USER_KEY);
		String area = tUser.getArea();
		if (null==area) {
			String ip = tUser.getLast_login_ip();
			/**
			 * TODO进行IP解析当前地址
			 */
		}
		area = "武汉";
		ModelAndView view = new ModelAndView("home");
		try {
			JSONObject object = configService.httpToWeather(area);
			 SysDateFormat.getCurrentDateString();
			 view.addObject("weather", object.getString("range"));
			 view.addObject("type", object.getString("brief"));
			 view.addObject("quality", "100");
			 view.addObject("img", object.getString("img"));
			 view.addObject("dict", object.getString("dict"));
		} catch (Exception e) {
			logger.error("登录天气请求异常",e);
		}
		return view;
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String toRegister(){
		return "register";
	}
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String toIndex(){
		return "index";
	}
	@RequestMapping(value="/author",method=RequestMethod.GET)
	public String toAuthor(){
		return "author";
	}
	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String toError(){
		return "error";
	}
	@RequestMapping(value="/warn",method=RequestMethod.GET)
	public String toWarn(){
		return "warn";
	}
}
