package contant;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Contant {
	
	static{
		Properties props=System.getProperties(); //获得系统属性集    
		String osName = props.getProperty("os.name"); //操作系统名称    
		String osArch = props.getProperty("os.arch"); //操作系统构架    
		String osVersion = props.getProperty("os.version"); //操作系统版本 
		String osUser= System.getProperty("user.name"); 
		System.err.println(osName+","+osArch+""+osVersion+""+osUser);
	}
	
	/**
	 * 用户session ID
	 */
	public static final String USER_KEY = "USER";
	public static final String DBONE = "DBONE";
	public static final String DBTWO = "DBTWO";
	public static final String DBTHRID = "DBTHRID";
	public static final String SESSION_KEY_UPLOAD_PROGRESS_INFO = "SESSION_KEY_UPLOAD_PROGRESS_INFO";
	public static final String LOGIN_URL = "/index.do";
	public static final String SERVER_DIR_URL = "http:192.168.121.128:80";
	public static final String HOTLE_REDIS_COUNT = "HOTLE_COUNT";
	/**
	 * 登录首页
	 */
	public static final String WELCOME_URL = "index.jsp";
	/**
	 * AES对称加密常量
	 */
	public static final String SECURITY = "1234567890";
	/**
	 * 登录时间搓加密设置
	 */
	public static final String TIME = "T";
	
	public static final String DEFAULT_USER = "bobo";
	
	public static final String TMP_DIR = "D:\\temp\\upload\\";
	public static final String USR_DIR = "D:\\temp\\upload\\";
	public static final String TMP_PRE = "precent";
	
	/**
	 * 系统图片大小设置
	 */
	public static final int W = 60;
	public static final int H = 60;
	
	/**
	 * 12306 车次信息查询
	 * *
	 */
	public static final String carUrl_TRAIN = "https://kyfw.12306.cn/otn/queryTrainInfo/init";
	
	/**
	 * 12306 车次信息查询
	 */
	//train_date=2018-05-04  from_station=IZQ  to_station=WHN
	public static final String QUERY_TRAIN = "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=@train_date@&leftTicketDTO.from_station=@from_station@&leftTicketDTO.to_station=@to_station@&purpose_codes=ADULT";
	
	/**
	 * 12306车次信息
	 * *
	 */
	public static final String URL_TRAIN = "https://kyfw.12306.cn/otn/resources/js/query/train_list.js?scriptVersion=1.0";
	/**
	 * 12306 站点
	 * *
	 */
	public static final String stationUrl_TRAIN = "https://kyfw.12306.cn/otn/resources/js/framework/station_name.js";
	
	public static final String URL_GAP = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo?train_no=4e000G11030K&from_station_telecode=WHN&to_station_telecode=IZQ&depart_date=2018-05-25";
	/**
	 * 高德地图信息查询
	 * *
	 */
	public static final String GD_AMP_QUERY_API = "https://www.amap.com/service/poiInfo?query_type=TQUERY&keywords=@keywords@";
	
	public static final String WEATHER_API_WSDL ="http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
	
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
