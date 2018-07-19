package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class TimeUtils {
	
	public static int getCurrentSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();// 格里高利历
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getCurrentDaySecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static long getCurrentDayStartMilli() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return gCalendar.getTimeInMillis();
	}

	
	public static int getCurrentMonthSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.set(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getCurrentSeasonSecond() {
		String str = TimeUtils.getDateStringAllFromSeconds(getCurrentDaySecond());
		str = str.substring(5, 7);
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis((long) getCurrentDaySecond() * 1000);
		if (str.equals("01") || str.equals("02") || str.equals("03")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
		} else if (str.equals("04") || str.equals("05") || str.equals("06")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.JUNE);
		} else if (str.equals("07") || str.equals("08") || str.equals("09")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.JULY);
		} else if (str.equals("10") || str.equals("11") || str.equals("12")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
		}
		gCalendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
		gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 12);
		gCalendar.set(GregorianCalendar.MINUTE, 0);
		gCalendar.set(GregorianCalendar.SECOND, 0);
		gCalendar.set(GregorianCalendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getCurrentYearSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.set(Calendar.MONTH, 0);
		gCalendar.set(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getLastDaySecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.DATE, -1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getNextDaySecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static long getNextDayStartMilli() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return gCalendar.getTimeInMillis();
	}
	
	
	public static int getLastMonthSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.MONTH, -1);
		gCalendar.set(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getNextMonthSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.MONTH, 1);
		gCalendar.set(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getLastYearSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.YEAR, -1);
		gCalendar.set(Calendar.MONTH, 0);
		gCalendar.set(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getNextYesrSecond() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.YEAR, 1);
		gCalendar.set(Calendar.MONTH, 0);
		gCalendar.set(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getDayStartSecondFromInt(int second) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis((long) second * 1000);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getNextDayStartSecondFromInt(int second) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis((long) second * 1000);
		gCalendar.add(Calendar.DATE, 1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static int getLastDayStartSecondFromInt(int second) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis((long) second * 1000);
		gCalendar.add(Calendar.DATE, -1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	
	public static long getLastDayStartMilliFromInt(long milli) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(milli);
		gCalendar.add(Calendar.DATE, -1);
		gCalendar.set(Calendar.HOUR, 0);
		gCalendar.set(Calendar.MINUTE, 0);
		gCalendar.set(Calendar.SECOND, 0);
		gCalendar.set(Calendar.MILLISECOND, 0);
		return gCalendar.getTimeInMillis();
	}

	// 获得当前日期的字符串表示
	public static String getCurrentDateString() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		return sFormat.format(gCalendar.getTime());
	}

	// 获得当前日期的完整字符串表示
	public static String getCurrentDateStringAll() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gCalendar = new GregorianCalendar();
		return sFormat.format(gCalendar.getTime());
	}
	// 获得当前日期的完整字符串表示
	public static String getCurrentDateStringAllNoSpace() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		GregorianCalendar gCalendar = new GregorianCalendar();
		return sFormat.format(gCalendar.getTime());
	}
	// 获得当前时间的字符串表示
	public static String getCurrentTimeHHMMSS() {
		SimpleDateFormat sFormat = new SimpleDateFormat("kk:mm:ss");
		GregorianCalendar gCalendar = new GregorianCalendar();
		return sFormat.format(gCalendar.getTime());
	}

	// 获得当前日期前一天的字符串表示
	public static String getYesterdayTimeString() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.add(Calendar.DATE, -1);
		return sFormat.format(gCalendar.getTime());
	}

	// 获得指定日期字符串的毫秒数
	public static long getMilliFromString(String dateStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gCalendar = new GregorianCalendar();
		try {
			Date date = sFormat.parse(dateStr);
			gCalendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return gCalendar.getTimeInMillis();
	}

	// 获得指定数值的日期字符串表示……毫秒
	public static String getDateStringFromMilliSeconds(long minSeconds) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(minSeconds);
		return sFormat.format(gCalendar.getTime());
	}

	// 获得指定数值的日期字符串全表示……毫秒
	public static String getDateStringAllFromMilliSeconds(long minSeconds) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(minSeconds);
		return sFormat.format(gCalendar.getTime());
	}

	// 获得指定数值的日期字符串表示……秒
	public static String getDateStringFromSeconds(long seconds) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(seconds * 1000);
		return sFormat.format(gCalendar.getTime());
	}

	// 获得指定数值的日期字符串全表示……秒
	public static String getDateStringAllFromSeconds(long seconds) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(seconds * 1000);
		return sFormat.format(gCalendar.getTime());
	}

	// 获得指定日期字符串的日期(当天起始点0时0分0秒)……秒
	public static int getStartSecondFromStr(String dateStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		int result = 0;
		try {
			Date date = sFormat.parse(dateStr);
			gCalendar.setTime(date);
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			result = (int) (gCalendar.getTimeInMillis() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 获得指定日期字符串的日期(当天起始点0时0分0秒)……毫秒
	public static long getStartMillisFromStr(String dateStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		long result = 0;
		try {
			Date date = sFormat.parse(dateStr);
			gCalendar.setTime(date);
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			result = gCalendar.getTimeInMillis();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 获得指定日期字符串的日期(当天中午12点0分0秒)……秒
	public static int getMiddleSecondFromStr(String dateStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		int result = 0;
		try {
			Date date = sFormat.parse(dateStr);
			gCalendar.setTime(date);
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 12);
			gCalendar.set(GregorianCalendar.MINUTE, 0);
			gCalendar.set(GregorianCalendar.SECOND, 0);
			result = (int) (gCalendar.getTimeInMillis() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 获得指定日期字符串的日期(当天最后点23时59分59秒)……秒
	public static int getEndSecondFromStr(String dateStr) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gCalendar = new GregorianCalendar();
		int result = 0;
		try {
			Date date = sFormat.parse(dateStr);
			gCalendar.setTime(date);
			gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 23);
			gCalendar.set(GregorianCalendar.MINUTE, 59);
			gCalendar.set(GregorianCalendar.SECOND, 59);
			result = (int) (gCalendar.getTimeInMillis() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 获得指定日期（秒）所在月份第一天中午12点的秒数
	public static int getStartDayOfMonthFromSecond(long seconds) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(seconds * 1000);
		gCalendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
		gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 12);
		gCalendar.set(GregorianCalendar.MINUTE, 0);
		gCalendar.set(GregorianCalendar.SECOND, 0);
		gCalendar.set(GregorianCalendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	// 获得指定日期（秒）所在季度第一天中午12点的秒数
	public static int getStartDayOfSeasonFromSecond(long seconds) {
		String str = TimeUtils.getDateStringAllFromSeconds(seconds);
		str = str.substring(5, 7);
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(seconds * 1000);
		if (str.equals("01") || str.equals("02") || str.equals("03")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
		} else if (str.equals("04") || str.equals("05") || str.equals("06")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.JUNE);
		} else if (str.equals("07") || str.equals("08") || str.equals("09")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.JULY);
		} else if (str.equals("10") || str.equals("11") || str.equals("12")) {
			gCalendar.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
		}
		gCalendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
		gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 12);
		gCalendar.set(GregorianCalendar.MINUTE, 0);
		gCalendar.set(GregorianCalendar.SECOND, 0);
		gCalendar.set(GregorianCalendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}

	// 获得指定日期（秒）所在年份第一天中午12点的秒数
	public static int getStartDayOfYearFromSecond(long seconds) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTimeInMillis(seconds * 1000);
		gCalendar.set(GregorianCalendar.DAY_OF_YEAR, 1);
		gCalendar.set(GregorianCalendar.HOUR_OF_DAY, 12);
		gCalendar.set(GregorianCalendar.MINUTE, 0);
		gCalendar.set(GregorianCalendar.SECOND, 0);
		gCalendar.set(GregorianCalendar.MILLISECOND, 0);
		return (int) (gCalendar.getTimeInMillis() / 1000);
	}
	
	public static String getDateStrMillsAll() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		return gCalendar.getTimeInMillis()+"";
	}
	
	public static String getDateStrNaAll() {
		return System.nanoTime()+"";
	}
	  //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    public static Map<String,Object> printDifference(String startDateStr, String endDateStr) throws ParseException{
    	Map<String,Object> timeMap = new HashMap<String,Object>();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Date startDate = sdf.parse(startDateStr);
    	Date endDate = sdf.parse(endDateStr);
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        timeMap.put("DIFF_ALL",different);
        timeMap.put("DAY_ALL",different/ daysInMilli);
        timeMap.put("HOUR_ALL",different/ hoursInMilli);
        timeMap.put("MINUTE_ALL",different/ minutesInMilli );
        timeMap.put("SECOND_ALL",different/ secondsInMilli );
        
        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;
        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;
        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;
        long elapsedSeconds = different / secondsInMilli;
        timeMap.put("DIFF",different);
        timeMap.put("DAY",elapsedDays );
        timeMap.put("HOUR",elapsedHours );
        timeMap.put("MINUTE",elapsedMinutes );
        timeMap.put("SECOND",elapsedSeconds );
        
        return timeMap;
    }
    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    public static Map<String,Object> printDifferenceByMilliStr(Long startDateMilliStr, Long endDateMilliStr) throws ParseException{
    	Map<String,Object> timeMap = new HashMap<String,Object>();
        //milliseconds
        long different = endDateMilliStr - startDateMilliStr ;
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        timeMap.put("DIFF_ALL",different);
        timeMap.put("DAY_ALL",different/ daysInMilli);
        timeMap.put("HOUR_ALL",different/ hoursInMilli);
        timeMap.put("MINUTE_ALL",different/ minutesInMilli );
        timeMap.put("SECOND_ALL",different/ secondsInMilli );
        
        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;
        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;
        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;
        long elapsedSeconds = different / secondsInMilli;
        timeMap.put("DIFF",different);
        timeMap.put("DAY",elapsedDays );
        timeMap.put("HOUR",elapsedHours );
        timeMap.put("MINUTE",elapsedMinutes );
        timeMap.put("SECOND",elapsedSeconds );
        return timeMap;
    }
    public static long  strToDateInMilli(String dateStr) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	return sdf.parse(dateStr).getTime();
    }
    public static String  strToDateNoSpace(String dateStr) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	return sdf.format(dateStr);
    }
    
  public static Date strToDateLong(String strDate) throws ParseException {
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date strtodate = formatter.parse(strDate);
     return strtodate;
  }
	
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
	
	/**
	 * 获取开始日期到结束日期的上期开始日期到结束日期
	 * @param sMth 开始日期
	 * @param eMth 结束日期
	 */
	public static String[] getPreviousPeriod(String sMth,String eMth){
		return getPreviousPeriod(sMth,eMth,"-");
	}

	/**
	 * 获取开始日期到结束日期的同期开始日期到结束日期
	 * @param sMth
	 * @param eMth
	 * @return
	 */
	public static String[] getCorrespondPeriod(String sMth,String eMth){
		return getCorrespondPeriod(sMth,eMth,"-");
	}

	public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
		return getMonthBetween(minDate, maxDate, "");
	}

	/**
	 * 获取两个月份之间间隔的月份
	 * @param minDate 开始月份
	 * @param maxDate 结束月份
	 * @param split 返回的月份之间的间隔
	 * @return
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate,String split) throws ParseException {
		List<String> result = new ArrayList<String>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+split+"MM");//格式化为年月
			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();
			min.setTime(sdf.parse(minDate.replaceAll("年", split).replaceAll("月", "").replaceAll("/", split).replaceAll("-", split)));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
			max.setTime(sdf.parse(maxDate.replaceAll("年", split).replaceAll("月", "").replaceAll("/", split).replaceAll("-", split)));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
			Calendar curr = min;
			while (curr.before(max)) {
				result.add(sdf.format(curr.getTime()));
				curr.add(Calendar.MONTH, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取开始日期到结束日期的上期
	 * @param sDate 开始日期
	 * @param eDate 结束日期
	 */
	public static String[] getPreviousPeriod2(String sDate,String eDate,String split){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+split+"MM"+split+"dd");//格式化为年月
			Calendar min = Calendar.getInstance();
			min.setTime(sdf.parse(sDate.replaceAll("年", split).replaceAll("月", "").replaceAll("日", "").replaceAll("/", split).replaceAll("-", split)));
			Calendar max = Calendar.getInstance();
			max.setTime(sdf.parse(eDate.replaceAll("年", split).replaceAll("月", "").replaceAll("日", "").replaceAll("/", split).replaceAll("-", split)));
			long sm = min.getTimeInMillis();
			long em = max.getTimeInMillis();
			long eem = sm - 24 * 60 * 60 * 1000;
			long sem = eem - (em - sm);
			min.setTimeInMillis(sem);
			max.setTimeInMillis(eem);
			return new String[]{sdf.format(min.getTime()),sdf.format(max.getTime())};
		} catch (Exception e) {
			e.printStackTrace();
			return new String[]{"",""};
		}
	}

	/**
	 * 获取开始月份到结束月份的上期
	 * @param sMth 开始月份
	 * @param eMth 结束月份
	 */
	public static String[] getPreviousPeriod(String sMth,String eMth,String split){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+split+"MM");//格式化为年月
			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();
			min.setTime(sdf.parse(sMth.replaceAll("年", split).replaceAll("月", "").replaceAll("/", split).replaceAll("-", split)));
			max.setTime(sdf.parse(eMth.replaceAll("年", split).replaceAll("月", "").replaceAll("/", split).replaceAll("-", split)));

			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

			int sm = min.get(Calendar.YEAR)*12 + min.get(Calendar.MONTH);
			int em = max.get(Calendar.YEAR)*12 + max.get(Calendar.MONTH);
			int syear2 = (sm-(em-sm+1))/12;
			int smoth2 = (sm-(em-sm+1))%12;
			int eyear2 = (sm-1)/12;
			int emoth2 = (sm-1)%12;
			if(smoth2==0){
				syear2 = syear2-1;
				smoth2 = 12;
			}
			if(emoth2==0){
				eyear2 = eyear2-1;
				emoth2 = 12;
			}
			min.set(syear2, smoth2,1);
			max.set(eyear2, emoth2,1);
			return new String[]{sdf.format(min.getTime()),sdf.format(max.getTime())};
		} catch (Exception e) {
			e.printStackTrace();
			return new String[]{"",""};
		}
	}

	/**
	 * 获取开始月份到结束月份的同期
	 * @param sMth 传入的月份需要
	 * @param eMth
	 * @param split 返回值的间隔附
	 * @return
	 */
	public static String[] getCorrespondPeriod(String sMth,String eMth,String split){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+split+"MM");//格式化为年月
			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();
			min.setTime(sdf.parse(sMth.replaceAll("年", split).replaceAll("月", "").replaceAll("/", split).replaceAll("-", split)));
			max.setTime(sdf.parse(eMth.replaceAll("年", split).replaceAll("月", "").replaceAll("/", split).replaceAll("-", split)));
			int year = min.get(Calendar.YEAR);
			int year2 = max.get(Calendar.YEAR);
			min.set(year-1, min.get(Calendar.MONTH), 1);
			max.set(year2-1, max.get(Calendar.MONTH), 1);
			return new String[]{sdf.format(min.getTime()),sdf.format(max.getTime())};
		} catch (Exception e) {
			e.printStackTrace();
			return new String[]{"",""};
		}
	}

	/**
	 * 获取开始日期到结束日期的同期
	 * @param sDate 传入的月份需要
	 * @param eDate
	 * @param split 返回值的间隔附
	 * @return
	 */
	public static String[] getCorrespondPeriod2(String sDate,String eDate,String split){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+split+"MM"+split+"dd");//格式化为年月
			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();
			min.setTime(sdf.parse(sDate.replaceAll("年", split).replaceAll("月", "").replaceAll("日", "").replaceAll("/", split).replaceAll("-", split)));
			max.setTime(sdf.parse(eDate.replaceAll("年", split).replaceAll("月", "").replaceAll("日", "").replaceAll("/", split).replaceAll("-", split)));
			int year = min.get(Calendar.YEAR);
			min.set(year-1, min.get(Calendar.MONTH), min.get(Calendar.DAY_OF_MONTH));
			max.set(year-1, max.get(Calendar.MONTH), max.get(Calendar.DAY_OF_MONTH));
			return new String[]{sdf.format(min.getTime()),sdf.format(max.getTime())};
		} catch (Exception e) {
			e.printStackTrace();
			return new String[]{"",""};
		}
	}

	/**
	 * 获取月份时间
	 * @param jssj
	 * @return
	 */
	public static String getMonthValue(String jssj,int count) {
		String parttern = "yyyyMM";
		Date dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat(parttern).parse(jssj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateFormat);
		calendar.add(Calendar.MONTH, count);
		dateFormat = calendar.getTime();
		String day = new SimpleDateFormat(parttern).format(dateFormat);
		return day;
	}

	public static String[] getCorrespondPeriod_Day(String sMth,String eMth,String format){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);//格式化为年月
			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();
			min.setTime(sdf.parse(sMth));
			max.setTime(sdf.parse(eMth));
			int syear = min.get(Calendar.YEAR);
			int eyear = max.get(Calendar.YEAR);
			min.set(syear-1, min.get(Calendar.MONTH), min.get(Calendar.DATE));
			max.set(eyear-1, max.get(Calendar.MONTH), max.get(Calendar.DATE));
			return new String[]{sdf.format(min.getTime()),sdf.format(max.getTime())};
		} catch (Exception e) {
			e.printStackTrace();
			return new String[]{"",""};
		}
	}
}
