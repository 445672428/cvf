package com.frame.web.fileupload;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Progress;

import contant.Contant;

public class BigMultiHandlerAction {
	@ResponseBody  
	@RequestMapping(value = "common/getProgress.do", method = RequestMethod.GET)  
	public String getProgress(HttpServletRequest request, HttpServletResponse response) {
	   if (request.getSession().getAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO) == null) {  
	        return "";  
	    }
	   Progress ps = (Progress) request.getSession().getAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO);
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
