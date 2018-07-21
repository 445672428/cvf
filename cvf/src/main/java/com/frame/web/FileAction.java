package com.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.annotation.AccessColumn;
import com.frame.service.FileService;
@Controller
public class FileAction {
	
	@Autowired
	private FileService fileService;
	
	@AccessColumn(operationName="创建文件夹")
	@RequestMapping(value="filecreate",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String filecreate(String userid,String filename,String parentid,Integer level,String uuid) {
		JSONObject object = new JSONObject();
		try {
			object = fileService.saveFileName(userid, filename, parentid, level,uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	@AccessColumn(operationName="查询当前用户的文件夹 和文件")
	@RequestMapping(value="queryfiles",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String querycreate(String userid,String parentid,Integer level) {
		JSONObject	object = fileService.queryFileByUUid(userid, parentid, level);
		return object.toString();
	}
	
	@AccessColumn(operationName="查询当前用户的文件夹 和文件")
	@RequestMapping(value="delfiles",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delCurrentFile(String userid,String parentid,Integer level) {
		JSONObject	object = fileService.deleteFileByUUid(userid, parentid, level);
		return object.toString();
	}
	
	@AccessColumn(operationName="查询当前用户的文件夹 和文件")
	@RequestMapping(value="savename",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateFolderName(String id,String name) {
		boolean flag = true;
		try {
			int	count = fileService.updateFileNameById(id, name);
			if (count == 0) {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
		}
		JSONObject object = new JSONObject();
		if (flag) {
			object.put("succ", flag);
		}else{
			object.put("succ", flag);
		}
		return object.toString();
	}
}
