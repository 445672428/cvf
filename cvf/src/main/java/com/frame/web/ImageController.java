package com.frame.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.frame.multil.service.ImageService;

@Controller
public class ImageController {
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
}
