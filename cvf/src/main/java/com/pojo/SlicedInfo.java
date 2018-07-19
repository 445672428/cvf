package com.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import com.frame.service.ConfigService;
import com.utils.SpringContextUtil;
/**
 * 分片信息
 * @author bobo
 *
 */
public class SlicedInfo {
	private static final long serialVersionUID = -297968415967865689L;

	private long blobSize;
	private byte[] blobCompleteDetail;

	private long lastBlobSize;
	private String fileId;
	private File file;
	private long currentFileSize=0;
	private long fileSize;
	private float completePercent;


	private SlicedInfo(FileInfo fileInfo){
		this.blobSize=ServerConfigEnum.config.getBlobSize();
		int n=0;
		if(fileInfo.getFileSize()%this.blobSize==0){
			n=(int) (fileInfo.getFileSize()/this.blobSize);
			this.lastBlobSize=this.blobSize;
		}else{
			n=(int) (fileInfo.getFileSize()/this.blobSize)+1;
			this.lastBlobSize=fileInfo.getFileSize()%this.blobSize;
		}

		this.blobCompleteDetail=new byte[n];

		for(int i=0;i<n;i++){
			this.blobCompleteDetail[i]=0;
		}
		this.fileId=fileInfo.getFileId();
		this.file=new File(ServerConfigEnum.config.getSavePath()+this.fileId+ServerConfigEnum.config.getSuFix());
		this.fileSize=fileInfo.getFileSize();
		this.completePercent=(float)currentFileSize/(float)fileSize;
	}
	public static SlicedInfo getInstance(FileInfo fileInfo){
		SlicedInfo slicedInfo=null;
		File file=new File(ServerConfigEnum.config.getSavePath()+fileInfo.getFileId()+ServerConfigEnum.config.getSuFix());
		if(file.exists()){
			slicedInfo=unSerializableFromDisk(file);
		}else{
			slicedInfo=new SlicedInfo(fileInfo).doSerializableToDisk();
		}
		return slicedInfo;
	}
	public void saveToDisk(){
		this.doSerializableToDisk();
	}
	private SlicedInfo doSerializableToDisk(){
		try{
			FileOutputStream out=new FileOutputStream(this.file);
			ObjectOutputStream objOut=new ObjectOutputStream(out);
			objOut.writeObject(this);
			objOut.close();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return this;
	}
	private static SlicedInfo unSerializableFromDisk(File file){
		SlicedInfo slicedInfo=null;
		try {
			FileInputStream in=new FileInputStream(file);
			ObjectInputStream objIn=new ObjectInputStream(in);
			slicedInfo=(SlicedInfo) objIn.readObject();
			objIn.close();
			in.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return slicedInfo;
	}
	private void blobLock(int index){
		this.blobCompleteDetail[index]=-1;
	}
	public void blobComplete(int index){
		this.blobCompleteDetail[index]=1;
	}
	public void blobUnComplete(int index){
		this.blobCompleteDetail[index]=0;
	}
	public synchronized SlicedInfo currentFileSizeAdd(long a){
		this.currentFileSize+=a;
		this.completePercent=(float)currentFileSize/(float)fileSize;
		return this;
	}
	public synchronized SlicedInfo currentFileSizeMinus(long a){
		this.currentFileSize-=a;
		this.completePercent=(float)currentFileSize/(float)fileSize;
		return this;
	}
	public UploadCommand getUploadCommandRandom(){
		UploadCommand uc=new UploadCommand();
		uc.setFileId(this.fileId);
		int len=this.blobCompleteDetail.length;
		if(len==1){
			if(this.blobCompleteDetail[0]==0){
				uc.setIndex(0);
				uc.setIndexStart(0);
				uc.setIndexEnd(this.lastBlobSize);
				uc.setBlobSize(this.lastBlobSize);
				uc.setCompletePercent(this.completePercent);
				this.blobLock(0);
			}else{
				uc.setIndex(-1);
				uc.setIndexStart(-1);
				uc.setIndexEnd(-1);
				uc.setBlobSize(-1);
				uc.setCompletePercent(1);
			}
		}else{
			int ranIndex=new Random().nextInt(len);
			if(this.blobCompleteDetail[ranIndex]==0){
				if(ranIndex==(len-1)){
					uc.setIndex(ranIndex);
					uc.setIndexStart(ranIndex*this.blobSize);
					uc.setIndexEnd(uc.getIndexStart()+this.lastBlobSize);
					uc.setBlobSize(this.lastBlobSize);
					uc.setCompletePercent(this.completePercent);
					this.blobLock(ranIndex);
				}else{
					uc.setIndex(ranIndex);
					uc.setIndexStart(ranIndex*this.blobSize);
					uc.setIndexEnd(uc.getIndexStart()+this.blobSize);
					uc.setBlobSize(this.blobSize);
					uc.setCompletePercent(this.completePercent);
					this.blobLock(ranIndex);
				}
			}else{
				int total=0;
				while(this.blobCompleteDetail[ranIndex]!=0){
					if(ranIndex==(len-1)){
						ranIndex=0;
						if(this.blobCompleteDetail[0]==0){
							uc.setIndex(ranIndex);
							uc.setIndexStart(ranIndex*this.blobSize);
							uc.setIndexEnd(uc.getIndexStart()+this.blobSize);
							uc.setBlobSize(this.blobSize);
							uc.setCompletePercent(this.completePercent);
							this.blobLock(ranIndex);
							break;
						}
					}else if(this.blobCompleteDetail[ranIndex+1]==0){
						ranIndex++;
						if(ranIndex==(len-1)){
							uc.setIndex(ranIndex);
							uc.setIndexStart(ranIndex*this.blobSize);
							uc.setIndexEnd(uc.getIndexStart()+this.lastBlobSize);
							uc.setBlobSize(this.lastBlobSize);
							uc.setCompletePercent(this.completePercent);
							this.blobLock(ranIndex);
							break;
						}else{
							uc.setIndex(ranIndex);
							uc.setIndexStart(ranIndex*this.blobSize);
							uc.setIndexEnd(uc.getIndexStart()+this.blobSize);
							uc.setBlobSize(this.blobSize);
							uc.setCompletePercent(this.completePercent);
							this.blobLock(ranIndex);
							break;
						}
					}else{
						if(total==len){
							uc.setIndex(-1);
							uc.setIndexStart(-1);
							uc.setIndexEnd(-1);
							uc.setBlobSize(-1);
							uc.setCompletePercent(1);
							break;
						}
						ranIndex++;
						total++;
					}
				}
			}
		}
		return uc;
	}
	public long getBlobSize() {
		return blobSize;
	}
	public void setBlobSize(long blobSize) {
		this.blobSize = blobSize;
	}
	public byte[] getBlobCompleteDetail() {
		return blobCompleteDetail;
	}
	public void setBlobCompleteDetail(byte[] blobCompleteDetail) {
		this.blobCompleteDetail = blobCompleteDetail;
	}
	public long getLastBlobSize() {
		return lastBlobSize;
	}
	public void setLastBlobSize(long lastBlobSize) {
		this.lastBlobSize = lastBlobSize;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public long getCurrentFileSize() {
		return currentFileSize;
	}
	public void setCurrentFileSize(long currentFileSize) {
		this.currentFileSize = currentFileSize;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public float getCompletePercent() {
		return completePercent;
	}
	public void setCompletePercent(float completePercent) {
		this.completePercent = completePercent;
	}
	
	public static enum ServerConfigEnum {
		config;
		private String savePath;
		private int blobSize;
		private int textSize;
		private String suFix;
		private ServerConfigEnum(){
//				WebApplicationContextUtils.getRequiredWebApplicationContext(webcxt);
//				WebApplicationContextUtils.getWebApplicationContext(webcxt);
//				(ApplicationContext) webcxt.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			ConfigService configService = (ConfigService)SpringContextUtil.getBean("configService");
			this.savePath=configService.W_FILE_PATH;
			this.blobSize=configService.W_FILE_BLOBSIZE;
			this.textSize=configService.W_FILE_TEXTSIZE;
			this.suFix=".si";
		}

		public int getTextSize() {
			return textSize;
		}

		public void setTextSize(int textSize) {
			this.textSize = textSize;
		}

		public String getSavePath() {
			return savePath;
		}
		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}
		public int getBlobSize() {
			return blobSize;
		}
		public void setBlobSize(int blobSize) {
			this.blobSize = blobSize;
		}
		public String getSuFix() {
			return suFix;
		}
		public void setSuFix(String suFix) {
			this.suFix = suFix;
		}
	}
	

public static class UploadCommand {
	private final String typeId="uploadCommand";
	private String fileId;
	private int index;
	private long indexStart;
	private long indexEnd;
	private long blobSize;
	private float completePercent;
	public static UploadCommand getSucccessCommand(String fileId){
		UploadCommand uc=new UploadCommand();
		uc.setBlobSize(-1);
		uc.setCompletePercent(1);
		uc.setFileId(fileId);
		uc.setIndex(-1);
		uc.setIndexEnd(-1);
		uc.setIndexStart(-1);
		return uc;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public long getIndexStart() {
		return indexStart;
	}
	public void setIndexStart(long indexStart) {
		this.indexStart = indexStart;
	}
	public long getIndexEnd() {
		return indexEnd;
	}
	public void setIndexEnd(long indexEnd) {
		this.indexEnd = indexEnd;
	}
	public long getBlobSize() {
		return blobSize;
	}
	public void setBlobSize(long blobSize) {
		this.blobSize = blobSize;
	}
	public float getCompletePercent() {
		return completePercent;
	}
	public void setCompletePercent(float completePercent) {
		this.completePercent = completePercent;
	}
	public String getTypeId() {
		return typeId;
	}
}
}
