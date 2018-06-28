package others.framework.flogger.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import others.framework.flogger.constants.Constant;

/**
 * 公用工具类
 */
public class CommUtil {
	
	/** 配置文件名 */
	private static final String CONFIG_FILE_NAME = "flogger.properties";
	
	/** 配置map */
	private static HashMap<String,Object[]> propsMap = new HashMap<String,Object[]>();
	
	/**
	 * 从配置文件中取得字符串的值，若无则返回默认值
	 * @param keyName 属性名
	 * @param defaultValue 默认值
	 * @return 属性值
	 */
	public static String getConfigByString(String keyName,String defaultValue){
		String value = getConfig(keyName);
		if(value != null && value.length() > 0){
			return value.trim();
		}else{
			return defaultValue;
		}
	}
	
	/**
	 * 从配置文件中取得长整型的值，若无则返回默认值
	 * @param keyName 属性名
	 * @param defaultValue 默认值
	 * @return 属性值
	 */
	public static long getConfigByLong(String keyName,long defaultValue) {
		String value = getConfig(keyName);
		if(value != null && value.length() > 0){
			return Long.parseLong(value.trim());
		}else{
			return defaultValue;
		}
	}
	/**
	 * 
	 * ########## 公共环境配置 ##########
		# 字符集
		CHARSET_NAME = UTF-8
		########## 日志信息配置 ##########
		# 日志级别   0:调试信息  1:普通信息   2:警告信息  3:错误信息  4:严重错误信息 
		LOG_LEVEL = 0,1,2,3,4
		# 日志文件存放路径
		LOG_PATH =/data/flogger
		# 日志写入文件的间隔时间(默认为1000毫秒)
		WRITE_LOG_INV_TIME = 1000
		# 单个日志文件的大小(默认为10M)
		SINGLE_LOG_FILE_SIZE = 10485760
		# 单个日志文件缓存的大小(默认为10KB)
		SINGLE_LOG_CACHE_SIZE = 10240
	 * 
	 */
	
	/**
	 * 从配置文件中读取字符串的值
	 * 配置文件查找顺序：
	 * 		1-项目根路径
	 * 		2-src/main/resources
	 * @param keyName 属性名
	 * @return 属性值
	 */
	private static String getConfig(String keyName) {
		Properties props = null;
		boolean bIsNeedLoadCfg = false;

		String filePath = CONFIG_FILE_NAME;
		File cfgFile = new File(filePath);
		if(!cfgFile.exists()){
			try{
				filePath = CommUtil.class.getClassLoader().getResource(CONFIG_FILE_NAME).getPath();
			}catch (Exception e) {
				return null;
			}
			cfgFile = new File(filePath);
			if(!cfgFile.exists()){
				return null;
			}
		}
		
		Object[] arrs = propsMap.get(filePath);
		if(arrs == null){
			bIsNeedLoadCfg = true ;
		}else{
			Long lastModify = (Long)arrs[0];
			if(lastModify.longValue() != cfgFile.lastModified()){
				bIsNeedLoadCfg = true;
			}else{
				props = (Properties)arrs[1];
			}
		}
		
		if(bIsNeedLoadCfg == true){
			FileInputStream fis = null;
			try{
				fis = new FileInputStream(cfgFile);
				props = new Properties();		
				props.load(fis);
				propsMap.put(filePath, new Object[]{cfgFile.lastModified(),props});
			}catch (Exception e) {
				return "";
			}finally{
				try{
					if(fis != null){
						fis.close();
					}
				}catch(Exception e){;}
			}
		}
		return props.getProperty(keyName, "");
	}
	
	/**
	 * 将字符串转为字节数组
	 * @param str 源字符串
	 * @return 字节数组
	 */
	public static byte[] StringToBytes(String str) {
		try{
			if(str == null || str.length() <= 0){
				return new byte[0];
			}else{
				return str.getBytes(Constant.CFG_CHARSET_NAME);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将异常的堆栈信息转为字符串
	 * @param e 异常
	 * @return 异常的字符串描述
	 */
	public static String getExpStack(Exception e) {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter pw = new PrintWriter(bo);
		e.printStackTrace(pw);
		pw.flush();
		pw.close();
		return bo.toString();
	}
	
}
