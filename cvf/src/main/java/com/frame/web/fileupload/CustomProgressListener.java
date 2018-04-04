package com.frame.web.fileupload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import com.entities.Progress;

import contant.Contant;

public class CustomProgressListener implements ProgressListener{

	private HttpSession session;    
	   
    public void setSession(HttpSession session){  
        this.session = session;  
        Progress ps = new Progress();  
        this.session.setAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO, ps);  
    }  
      
    @Override  
    public void update(long pBytesRead, long pContentLength, int pItems) {  
        Progress ps = (Progress) session.getAttribute(Contant.SESSION_KEY_UPLOAD_PROGRESS_INFO);  
        ps.setBytesRead(pBytesRead);  
        ps.setContentLength(pContentLength);  
        ps.setItemSeq(pItems);  
    }  

}
