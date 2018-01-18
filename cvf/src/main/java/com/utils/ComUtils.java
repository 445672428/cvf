package com.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
	
	/*
	 * token 生成
	 */
	
}
