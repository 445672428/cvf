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
	/**
	 * 高德地图信息查询
	 * *
	 */
	public static final String GD_AMP_QUERY_API = "https://www.amap.com/service/poiInfo?query_type=TQUERY&keywords=@keywords@";
	
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
