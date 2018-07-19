package others.framework.flogger;

import others.framework.flogger.constants.Constant;
import others.framework.flogger.strategy.LogManager;
import others.framework.flogger.utils.CommUtil;
import others.framework.flogger.utils.TimeUtil;

/**
 * 日志工具类
 */
public class FLogger {
	
	private static FLogger instance;
	private static LogManager logManager;
	
	static {
		logManager = LogManager.getInstance();
	}
	
	public FLogger(){
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				close();
			}
		}));
	}
	
	public static synchronized FLogger getInstance(){
		if(instance == null){
			instance = new FLogger();
		}
		return instance;
	}
	
	/**
	 * 写调试日志
	 * @param logMsg 日志内容
	 */
	public void debug(String logMsg){
		writeLog("debug",Constant.DEBUG,logMsg);
	}
	
	/**
	 * 写普通日志
	 * @param logMsg 日志内容
	 */
	public void info(String logMsg){
		writeLog("info",Constant.INFO,logMsg);
	}
	
	/**
	 * 写警告日志
	 * @param logMsg 日志内容
	 */
	public void warn(String logMsg){
		writeLog("warn",Constant.WARN,logMsg);
	}
	
	/**
	 * 写错误日志
	 * @param logMsg 日志内容
	 */
	public void error(String logMsg){
		writeLog("error",Constant.ERROR,logMsg);
	}
	
	/**
	 * 写严重错误日志
	 * @param logMsg 日志内容
	 */
	public void fatal(String logMsg){
		writeLog("fatal",Constant.FATAL,logMsg);
	}
	
	/**
	 * 写系统日志
	 * @param level 日志级别
	 * @param logMsg 日志内容
	 */
	public void writeLog(int level,String logMsg){
		writeLog(Constant.LOG_DESC_MAP.get(String.valueOf(level)).toLowerCase(),level,logMsg);
	}
	
	/**
	 * 写日志
	 * @param logFileName 日志文件名
	 * @param level 日志级别
	 * @param logMsg 日志内容
	 */
	public void writeLog(String logFileName, int level, String logMsg){
		if(logMsg != null && Constant.CFG_LOG_LEVEL.indexOf(""+level) >= 0){
			StringBuffer sb = new StringBuffer(logMsg.length() + 100);
			sb.append("[");
			sb.append(Constant.LOG_DESC_MAP.get(String.valueOf(level)));
			sb.append("] ");
			sb.append(TimeUtil.getFullDateTime());
			sb.append(" [");
			sb.append(Thread.currentThread().getName());
			sb.append("] ");
			sb.append(logMsg);
			sb.append("\n");
			logManager.addLog(logFileName, sb);
			
			//错误信息同时打印到控制台
			if(Constant.ERROR == level || Constant.FATAL == level){
				try{
					System.err.print(new String(sb.toString().getBytes(Constant.CFG_CHARSET_NAME),Constant.CFG_CHARSET_NAME));
				}catch(Exception e){
					System.err.print(CommUtil.getExpStack(e));
				}
			}
		}
	}
	
	/**
	 * 优雅关闭
	 */
	private void close(){
		logManager.close();
	}
	
}
