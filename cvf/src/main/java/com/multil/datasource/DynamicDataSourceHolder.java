package com.multil.datasource;
/***
 * ThreadLocal 保存当前线程 数据源的key
 * 
 * 进行数据库的切换
 * @author bobo
 *
 */
public class DynamicDataSourceHolder {
	 //写库对应的数据源key
    private static final String MASTER = "master";

    //读库对应的数据源key
    private static final String SLAVE = "slave";
    
    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 设置数据源key
     * @param key
     */
    public static void putDataSourceKey(String key) {
        holder.set(key);
    }

    /**
     * 获取数据源key
     * @return
     */
    public static String getDataSourceKey() {
    	System.out.println("当前库:"+holder.get());
        return holder.get();
    }
    
    /**
     * 标记写库
     */
    public static void markMaster(){
        putDataSourceKey(MASTER);
    }
    
    /**
     * 标记读库
     */
    public static void markSlave(){
        putDataSourceKey(SLAVE);
    }
}