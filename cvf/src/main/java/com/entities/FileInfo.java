package com.entities;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
public class FileInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -894759518303934049L;
	private String fileName;
	private String MD5;
	//private Date uploadDate;
	private Timestamp uploadDate;
	
	private String fileId;
	private long fileSize;
	private String fileInfo;
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}
	@Override
	public String toString() {
		return "File{" +
				"fileName='" + fileName + '\'' +
				", MD5='" + MD5 + '\'' +
				", uploadDate=" + uploadDate +
				'}';
	}

	public FileInfo(String fileName, String MD5, Timestamp uploadDate) {
		this.fileName = fileName;
		this.MD5 = MD5;
		this.uploadDate = uploadDate;
	}

	public FileInfo() {
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMD5() {
		return MD5;
	}

	public void setMD5(String MD5) {
		this.MD5 = MD5;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
}
