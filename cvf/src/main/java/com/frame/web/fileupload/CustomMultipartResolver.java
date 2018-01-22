package com.frame.web.fileupload;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CustomMultipartResolver extends CommonsMultipartResolver{
	 @Autowired  
	 private CustomProgressListener progressListener;
	 public void setFileUploadProgressListener(CustomProgressListener progressListener){  
	        this.progressListener = progressListener;  
	 }
	 /**
	  * 获取spring 里面的文件
	  * @param fileSizeMax
	  */
	 public void setFileSizeMax(long fileSizeMax) {  
	        getFileUpload().setFileSizeMax(fileSizeMax);  
	 }
	 @Override
	protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
		String encoding = determineEncoding(request);
		FileUpload fileUpload = prepareFileUpload(encoding);  
		return super.parseRequest(request);
	}
}
