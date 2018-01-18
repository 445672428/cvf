package others.demo.moredown;


public class DownloadInfo {
	private String url;
	private String filename;
	private String filepath;
	private int spliter;
	//下载默认的保存路径
	private static final String FILE_PATH = "D:/temp";
	//默认的分块数
	private static final int SPLITER_NUM = 5;
	public DownloadInfo() {
		super();
	}
	/**
     * @param url 下载地址
     */
    public DownloadInfo(String url) {
        this(url, null, null, SPLITER_NUM);
    }
    
    /**
     * @param url 下载地址url
     * @param splitter 分成多少段或是多少个线程下载
     */
    public DownloadInfo(String url, int splitter) {
        this(url, null, null, splitter);
    }
    
	
	 /***
     * @param url 下载地址
     * @param fileName 文件名称
     * @param filePath 文件保存路径
     * @param splitter 分成多少段或是多少个线程下载
     */
    public DownloadInfo(String url, String fileName, String filepath, int spliter) {
        super();
        if (url == null || "".equals(url)) {
            throw new RuntimeException("url is not null!");
        }
        this.url =  url;
        this.filename = (fileName == null || "".equals(fileName)) ? getFilename(url) : fileName;
        this.filepath = (filepath == null || "".equals(filepath)) ? FILE_PATH : filepath;
        this.spliter = (spliter < 1) ? SPLITER_NUM : spliter;
    }
    
    /**
     * <b>function:</b> 通过url获得文件名称
     * @author hoojo
     * @createDate 2011-9-30 下午05:00:00
     * @param url
     * @return
     */
    private String getFilename(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.length());
    }
    
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        if (url == null || "".equals(url)) {
            throw new RuntimeException("url is not null!");
        }
        this.url = url;
    }
 
    public String getFilename() {
        return filename;
    }
 
    public void setFilename(String filename) {
        this.filename = (filename == null || "".equals(filename)) ? getFilename(url) : filename;
    }
 
    public String getFilepath() {
        return filepath;
    }
 
    public void setFilepath(String filepath) {
        this.filepath = (filepath == null || "".equals(filepath)) ? FILE_PATH : filepath;
    }
 
    public int getSpliter() {
        return spliter;
    }
 
    public void setSpliter(int splitter) {
        this.spliter = (spliter < 1) ? SPLITER_NUM : spliter;
    }
    
    @Override
    public String toString() {
        return this.url + "#" + this.filename + "#" + this.filepath + "#" + this.spliter;
    }
	
}
