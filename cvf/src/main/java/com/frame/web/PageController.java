package com.frame.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	@RequestMapping(value="home.do")
	public String index(){
		return "home";
	}
	
	@RequestMapping(value="page.do")
	public String page(@RequestParam("page")String page){
		return page;
	}
	@RequestMapping(value="/rest/{page}")
	@ResponseBody
	public String restPage(@RequestParam("page")String page){
		System.out.println("restful");
		return page;
	}
	
}
