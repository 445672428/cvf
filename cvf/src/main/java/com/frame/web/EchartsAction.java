package com.frame.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.annotation.AccessColumn;
import com.base.BaseAction;

@Controller
@RequestMapping(value="/echart")
public class EchartsAction extends BaseAction{
	
	@AccessColumn(operationName="对echart 图片进行处理")
	@RequestMapping(value="/upimg",method=RequestMethod.POST)
	public void solvedUploadImage(String content,HttpServletRequest request,HttpServletResponse response) throws IOException {
			OutputStream out = response.getOutputStream();
	        try {
	            String fileName = "";
	            response.reset();
	            response.setContentType("application/octec-stream");
	            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
	            out = response.getOutputStream();
	        } catch (Exception e) {
	        	logger.error("echart图片上传出错", e);
	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
		
	}
}
