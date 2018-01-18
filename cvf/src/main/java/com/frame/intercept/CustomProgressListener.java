package com.frame.intercept;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import contant.Contant;
import pojo.ProgressInfo;

public class CustomProgressListener implements ProgressListener{

	private HttpSession session;    
	   
    public void setSession(HttpSession session){  
        this.session = session;  
        ProgressInfo ps = new ProgressInfo();  
        this.session.setAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO, ps);  
    }  
      
    @Override  
    public void update(long pBytesRead, long pContentLength, int pItems) {  
        ProgressInfo ps = (ProgressInfo) session.getAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO);  
        ps.setBytesRead(pBytesRead);  
        ps.setContentLength(pContentLength);  
        ps.setItemSeq(pItems);  
    }  

}
