package com.frame.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.base.BaseAction;
import com.frame.multil.service.ImageService;
import com.utils.TimeUtils;

@Controller
public class ImageController extends BaseAction{
	@Autowired
	private ImageService imageService;
	@RequestMapping(value="images.do",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody()
	public String showImages(int index,int size) {
		List<Map<String, Object>> list = imageService.queryForPageImages(index,size);
		JSONObject object = new JSONObject();
		object.put("list", list);
		return JSONObject.toJSONString(object,SerializerFeature.WriteMapNullValue); 
	}
	
	/**
	 * 记忆轴
	 */
	@RequestMapping("/memory.do")
	public ModelAndView yourMemoryPage(String year,String user) {
		if (null==year) {
			year = TimeUtils.getCurrYear();
		}
		if (null==user) {
			user = "bobo";
		}
		System.out.println(configService.IMG_SRC1);
		List<Map<String, Object>> list = imageService.queryForYourMemory(year,user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("views/memory");
		mav.addObject("year", year);
		mav.addObject("list",list);
		return mav;
	}
}
