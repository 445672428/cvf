package com.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.base.BaseAction;
import com.frame.service.JsPlumbService;

@Controller
@RequestMapping(value="jsplumb")
public class JsPlumbAction extends BaseAction{
	@Autowired
	private JsPlumbService jsPlumbService;
	
	@RequestMapping(value="plumb",method=RequestMethod.GET)
	public ModelAndView welcomeJsPlumb(){
		System.out.println("ok");
		JSONArray results = jsPlumbService.queryWelcomeJsPlumb();
		ModelAndView view = new ModelAndView("d3");
		view.addObject("results", results);
		return view;
	}
}
