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
import com.annotation.AccessColumn;
import com.base.BaseAction;
import com.frame.service.ConfigService;
import com.pojo.TAdmin;
import com.utils.TimeUtils;

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
	
	@AccessColumn(operationName="访问页")
	@RequestMapping(value="/rest",method=RequestMethod.GET)
	public String restPage(@RequestParam("page")String page){
		return page;
	}
	
	@AccessColumn(operationName="个人页")
	@RequestMapping(value="/personal",method=RequestMethod.GET)
	public ModelAndView toPersonal(){
		ModelAndView view = new ModelAndView("/views/personal");
		view.addObject("id", "basic");
		return view;
	}
	
	@AccessColumn(operationName="主页访问")
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
			 TimeUtils.getCurrentDateString();
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
	@AccessColumn(operationName="首页访问")
	@RequestMapping(value={"","/","/first","/login"})
	public String toLogin(){
		return "login";
	}
	@AccessColumn(operationName="注册页面访问")
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String toRegister(){
		return "register";
	}
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String toIndex(){
		return "index";
	}
	@AccessColumn(operationName="作者信息页访问")
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
