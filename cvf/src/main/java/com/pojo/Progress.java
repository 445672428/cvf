package com.pojo;

public class Progress {
	private long bytesRead;  
    private long contentLength;  
    private int itemSeq;  
      
    public long getBytesRead() {  
        return bytesRead;  
    }  
    public void setBytesRead(long bytesRead) {  
        this.bytesRead = bytesRead;  
    }  
    public long getContentLength() {  
        return contentLength;  
    }  
    public void setContentLength(long contentLength) {  
        this.contentLength = contentLength;  
    }  
    public int getItemSeq() {  
        return itemSeq;  
    }  
    public void setItemSeq(int itemSeq) {  
        this.itemSeq = itemSeq;  
    }  
}
