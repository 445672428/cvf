package com.frame.web;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.annotation.AccessColumn;
import com.base.BaseAction;
import com.hibernate.pojo.Sysuser;
import com.hibernate.service.SysuserService;
import com.pojo.ProgressInfo;
import com.utils.ComUtils;

import contant.Contant;
/**
 * 个人信息和权限页面
 * @author bobo
 *
 */
@Controller
@RequestMapping(value="auth")
public class AuthorityAction extends BaseAction{
	@Autowired
	private SysuserService sysuserService; 
	
	@AccessColumn(operationName="个人信息页面")
	@RequestMapping(value="module",method=RequestMethod.POST)
	public ModelAndView personalInfo(@RequestParam(value = "id", defaultValue = "basic") String id){
		ModelAndView v = new ModelAndView("/views/personal");
		v.addObject("id", id);
		v.addObject("d", "b3bo");
		v.addObject("e", "b2bo");
		v.addObject("f", "b1");
		return v;
	}
	
	@AccessColumn(operationName="上传进度条")    
	@ResponseBody  
	@RequestMapping(value = "admin/common/getProgress", method = RequestMethod.GET)  
	public String getProgress(HttpServletRequest request, HttpServletResponse response) {  
	    if (request.getSession().getAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO) == null) {  
	        return "";  
	    }  
	    ProgressInfo ps = (ProgressInfo) request.getSession().getAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO);  
	    Double percent = 0d;  
	    if (ps.getContentLength() != 0L) {  
	        percent = (double) ps.getBytesRead() / (double) ps.getContentLength() * 1.0d;  
	        if (percent != 0d) {  
	            DecimalFormat df = new DecimalFormat("0.00");  
	            percent = Double.parseDouble(df.format(percent));  
	        }  
	    }  
	    int pp = (int)(percent * 100);  
	    return String.valueOf(pp);  
	}  
}
