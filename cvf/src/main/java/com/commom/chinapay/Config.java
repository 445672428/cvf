package com.commom.chinapay;
import java.io.File;
import java.util.Properties;


public class Config {
	public Config(){}
	
	
	public static String MerKeyPath = "";
	
	
	public static String PubKeyPath="";
	
	public static String pay_url = "";
	
	
	public static String SinPay_url="";
	
	public static String BatchOrderQuery_url="";
	
	
	public static String merId = "";
	static {
		Properties propertyFile = new Properties();
		try {
		} catch (Exception e) {
			System.err.println(e);
		}

		if (propertyFile != null) {
			MerKeyPath = getRootPath("MerPrK.key");
			PubKeyPath=getRootPath("PgPubk.key");
			pay_url = (String)propertyFile.get("chinapay.payment.url");
			SinPay_url= (String)propertyFile.get("chinapay.query.url");
			BatchOrderQuery_url= (String)propertyFile.get("chinapay.BatchOrderQuery.url");
			merId = (String)propertyFile.get("chinapay.merid");
		}
		
	}
	
	public static String getRootPath(String FileName) {
		  String classPath = Config.class.getClassLoader().getResource("/").getPath();
		  String rootPath  = "";
		  //windows下
		  if("\\".equals(File.separator)){   
		   rootPath  = classPath.substring(1,classPath.indexOf("/WEB-INF/classes"));
		   rootPath = rootPath.replace("/", "\\")+File.separator+"key"+File.separator+FileName;
		  }
		  //linux下
		  if("/".equals(File.separator)){   
		   rootPath  = classPath.substring(0,classPath.indexOf("/WEB-INF/classes"));
		   rootPath = rootPath.replace("\\", "/")+File.separator+"key"+File.separator+FileName;
		  }
		  return rootPath;
	}
	
}