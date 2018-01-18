package com.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
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
