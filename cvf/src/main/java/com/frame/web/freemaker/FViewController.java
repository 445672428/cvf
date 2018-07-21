package com.frame.web.freemaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.annotation.AccessColumn;

@Controller
@RequestMapping(value = "maker")
public class FViewController {
	
	
	@RequestMapping(value = "name", method = RequestMethod.GET)
	public String freeMakerPage(String name, Model model) {
		model.addAttribute("message", "hello");
		return name;
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String index(String name, Model model) {
		model.addAttribute("message", "hello");
		model.addAttribute("name", name);
		return "test";
	}
	@AccessColumn(operationName="当前mysql库freemaker模板")
	@RequestMapping(value = "mysql", method = RequestMethod.GET)
	public ModelAndView mysqlTable(String name) {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "hello");
		model.addObject("name", name);
		model.setViewName("mysql");
		return model;
	}
	
	
}
