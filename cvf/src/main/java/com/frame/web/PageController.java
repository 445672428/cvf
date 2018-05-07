package com.frame.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.mapper.CHARACTER_SETSMapper;
import com.mybatis.pojo.CHARACTER_SETS;


@Controller
public class PageController {
	@Autowired
	private CHARACTER_SETSMapper cHARACTER_SETSMapper;
	@RequestMapping(value="page.do")
	public String page(@RequestParam("page")String page){
		return page;
	}
	@RequestMapping(value="/rest/code",method=RequestMethod.GET)
	@ResponseBody
	public String restTest(@RequestParam("code")String code){
		List<CHARACTER_SETS>  list = cHARACTER_SETSMapper.selectByExample(null);
		System.out.println("restful"+list);
		return code;
	}
	@RequestMapping(value="/rest",method=RequestMethod.GET)
	public String restPage(@RequestParam("page")String page){
		System.out.println("restful");
		return page;
	}
}
