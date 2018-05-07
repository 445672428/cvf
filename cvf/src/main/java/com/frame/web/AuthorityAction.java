package com.frame.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entities.ProgressInfo;
import com.hibernate.pojo.Sysuser;
import com.hibernate.service.SysuserService;
import com.utils.ComUtils;

import contant.Contant;

@Controller
@RequestMapping(value="auth")
public class AuthorityAction {
	@Autowired
	private SysuserService sysuserService; 
	/**
	 * 使用对象接收数据
	 * @param sysuser
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void addSysUser(Sysuser sysuser) {
		String uuid = ComUtils.getUuid();
		sysuser.setId(uuid);
		sysuserService.save(sysuser);
	}
	/**
	 * 使用对应参数接收
	 * @return
	 */
	@RequestMapping(value="add2",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String DbIdaddSysUser(String username,String userid,String pwd,String sex,String addr,
			String birth,String movephone,String email,String phone,String fax,String contact,String userstate,String remark,String sysid) {
		String uuid = ComUtils.getUuid();
		System.err.println(uuid);
		JSONObject obj = new JSONObject();
		obj.put("a", 1);
		return obj.toJSONString();
	}
	/**
	 * 使用json对象接收数据
	 * @param sysuser
	 */
	@RequestMapping(value="add3",method=RequestMethod.POST,consumes="application/json")
	public void addBodySysUser(@RequestBody Sysuser sysuser) {
		String uuid = ComUtils.getUuid();
		sysuser.setId(uuid);
		sysuserService.save(sysuser);
	}
    /**
     * 使用@ModelAttribute注解获取POST请求的FORM表单数据
     * @return
     */
    @RequestMapping(value="add4",method=RequestMethod.POST)
    public void addUser5(@ModelAttribute("sysuser") Sysuser sysuser) {
        System.out.println(sysuser);
    }
    
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
