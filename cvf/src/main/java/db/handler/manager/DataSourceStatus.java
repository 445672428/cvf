package db.handler.manager;
/**
 * 保持当前使用的数据库key
 * @author bobo
 *
 */
public class DataSourceStatus {
	private final static ThreadLocal<String> currentKey = new ThreadLocal<String>();
	public static void setCurrentKey(String key) {
		currentKey.set(key);
	}
	public static String getCurrentKey() {
		return currentKey.get();
	}
}
