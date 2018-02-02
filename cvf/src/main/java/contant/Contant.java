package contant;

import java.util.HashMap;
import java.util.Map;


public class Contant {
	public static final String USER_KEY = "USER";
	public static final String DBONE = "DBONE";
	public static final String DBTWO = "DBTWO";
	public static final String DBTHRID = "DBTHRID";
	public static final String SESSION_KEY_UPLOAD_PROGRESS_INFO = "SESSION_KEY_UPLOAD_PROGRESS_INFO";
	public static final String LOGIN_URL = "/index.do";
	public static final String SERVER_DIR_URL = "http:192.168.121.128:80";
	public static final String HOTLE_REDIS_COUNT = "HOTLE_COUNT";
	
	public static final String DEFAULT_USER = "bobo";
	
	public static final String TMP_DIR = "D:\\temp\\upload\\";
	public static final String USR_DIR = "D:\\temp\\upload\\";
	public static final String TMP_PRE = "precent";
	// 定义允许上传的文件扩展名
	public static Map<String, String> FileNameMap = new HashMap<String, String>(){
	private static final long serialVersionUID = -514869036211441097L;
	{
		put("image", "gif,jpg,jpeg,png,bmp");
		put("flash", "swf,flv");
		put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,mp4");
		put("file", "doc,docx,xls,xlsx,ppt,htm,html,xml,txt,zip,rar,gz,bz2,apk,ipa");
		put("xls", "xls,xlsx");
		put("pdf", "pdf,PDF");
		put("zip", "zip,rar");
		put("pdfFile", "pdf,PDF,doc,docx,xls,xlsx,ppt,htm,html,xml,txt,zip,rar,gz,bz2,apk,ipa");
	}};
	
}
