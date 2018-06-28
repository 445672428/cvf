package com.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class ComUtils {
	
	private static ComUtils me = new ComUtils();  
    private static String hostAddr;  
    private static Random random = new SecureRandom();  
    private static UniqTimer timer = new UniqTimer();  
      
    private static boolean isOutputInfo = false;  
      
    private ComUtils() {  
        try {  
            final InetAddress addr = InetAddress.getLocalHost();  
  
            hostAddr = addr.getHostAddress();  
        }  
        catch (final IOException e) {  
            System.err.println("[UniqID] Get HostAddr Error"+e);  
            hostAddr = String.valueOf(System.currentTimeMillis());  
        }  
  
        if (null == hostAddr || hostAddr.trim().length() == 0 || "127.0.0.1".equals(hostAddr)) {  
            hostAddr = String.valueOf(System.currentTimeMillis());  
              
        }  
        hostAddr = hostAddr.substring(hostAddr.length()-2).replace(".", "0");  
          
        if(isOutputInfo){  
            System.out.println("[UniqID]hostAddr is:" + hostAddr + "----length:"+hostAddr.length());  
        }  
    }  
      
      
    /** 
     * 获取UniqID实例 
     *  
     * @return UniqId 
     */  
    public static ComUtils getInstance() {  
        me.isOutputInfo = false;  
        return me;  
    }  
      
    /** 
     * 获取UniqID实例 
     *  
     * @return UniqId 
     */  
    public static ComUtils getInstanceWithLog() {  
        me.isOutputInfo = true;  
        return me;  
    }  
  
  
    /** 
     * 获得不会重复的毫秒数 
     *  
     * @return 不会重复的时间 
     */  
    public static String getUniqTime() {  
        String time = timer.getCurrentTime();  
        if(isOutputInfo){  
            System.out.println("[UniqID.getUniqTime]" + time +"----length:"+ time.length());  
        }  
        return time;  
    }  
      
    /** 
     * 获得UniqId 
     *  
     * @return uniqTime-randomNum-hostAddr-threadId 
     */  
    public static String getUniqID() {  
        final StringBuffer sb = new StringBuffer();  
        final String t = getUniqTime();  
        int randomNumber = random.nextInt(8999999) + 1000000;  
        sb.append(t);  
        sb.append(hostAddr);  
        sb.append(getUniqThreadCode());  
        sb.append(randomNumber);  
        if (isOutputInfo) {  
            System.out.println("[UniqID.randomNumber]" + randomNumber+"----length:"+String.valueOf(randomNumber).length());  
            System.out.println("[UniqID.getUniqID]" + sb.toString()+"----length:"+String.valueOf(sb).length());  
        }  
        return sb.toString();  
    }  
      
    public static String getUniqThreadCode(){  
        String threadCode = StringUtils.left(String.valueOf(Thread.currentThread().hashCode()),9);  
        if (isOutputInfo) {  
            System.out.println("[UniqID.getUniqThreadCode]" +threadCode+"----length:"+threadCode.length());  
        }  
        return StringUtils.leftPad(threadCode, 9, "0");  
    }  
      
    /** 
     * 实现不重复的时间 
     */  
    private static class UniqTimer {  
        private final AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());  
  
        public String getCurrentTime() {  
            if(!timestamp2Date(this.lastTime.incrementAndGet()).equals(timestamp2Date(System.currentTimeMillis()))){  
                lastTime.set(System.currentTimeMillis()+random.nextInt(10000));  
            }  
            return timestamp2Datetimes(this.lastTime.incrementAndGet());  
        }  
    }  
      
    /** 
     * 规范化日期，规范成yyyy-MM-dd 
     * @param timestamp 
     * @return 
     */  
    public static String timestamp2Date(long timestamp){  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        return dateFormat.format(new Date(timestamp * 1000));  
    }  
      
    private static String timestamp2Datetimes(long timestamp){  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
        return dateFormat.format(new Date(timestamp));  
    }  
    
	
	/**
	 * 获取UUID 32 位
	 * @return
	 */
	public static String getUuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static Timestamp getTimestamp() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		Timestamp timestamp = Timestamp.valueOf(date);
		return timestamp;
	}
	  /**
     * 深拷贝
     *
     * @return 深拷贝得到的新实例
     */
    public static Object deepClone( final Object object)throws Exception {
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(object);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }
	/*
	 * 是否是图片
	 */
    public static boolean isImage(File tempFile)
            throws Exception {
        ImageInputStream is= ImageIO.createImageInputStream(tempFile);
        return is!=null;
    }
    public static StringBuilder createMd5( final MultipartFile file)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        //生成MD5实例
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        InputStream inputStream = file.getInputStream();
        int available = inputStream.available();
        byte[] bytes = new byte[available];
        md5.update(bytes);
        for (byte by : md5.digest()) {
            //将生成的字节MD5值转换成字符串
            sb.append(String.format("%02X", by));
        }
        return sb;
    }


}
