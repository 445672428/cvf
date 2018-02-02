package com.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.springframework.web.multipart.MultipartFile;

public class ComUtils {
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
