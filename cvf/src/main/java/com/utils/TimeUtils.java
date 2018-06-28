package com.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TimeUtils {
	@Test
	public static long getNow(){
		//long n = Calendar.getInstance().getTimeInMillis(); 
		long n = System.currentTimeMillis();
		return n;
	}
	
	/*************************************
	 * 获取当前时间的今年的第一天日期
	 * 
	 * @return
	 ************************************/
	public static Date getCurrYearFirst() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}
	/*************************************
	 * 获取今年
	 * 
	 * @return
	 ************************************/
	public static String getCurrYear() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return String.valueOf(currentYear);
	}
	
	
	/**************************************
	 * 获取指定年的第一天日期
	 * 
	 * @param year
	 *            指定某年
	 * @return 某年的第一天日期
	 ************************************/
	public static Date getYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}
	/**
	 * 获取当前的时间
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(new Date());
	}
	/**
	 * 获取当前的时间
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return simpleDateFormat.format(new Date());
	}
	
	/**
	 * 获取格式之后的时间
	 * @param date
	 * @param regular
	 * @return
	 */
	public static String format(Date date,String regular) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(regular);
		return simpleDateFormat.format(date);
	}
}
