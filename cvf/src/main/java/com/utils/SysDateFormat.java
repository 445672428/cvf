package com.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class SysDateFormat implements Serializable {
	
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
		String str = SysDateFormat.getDateStringAllFromSeconds(getCurrentDaySecond());
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
	public static String getCurrentTime() {
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
		String str = SysDateFormat.getDateStringAllFromSeconds(seconds);
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
       /* System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);*/
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
        
 /*       System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n",elapsedDays,
            elapsedHours, elapsedMinutes, elapsedSeconds);*/
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
	public static void main(String[] args) throws ParseException {
		int timeInt = 1199142900;
		System.out.println(SysDateFormat.getDateStringAllFromSeconds(timeInt));
		int time = getDayStartSecondFromInt(timeInt);
		String str = SysDateFormat.getDateStringAllFromSeconds(time);
		System.out.println(str);
		int time2 = getNextDayStartSecondFromInt(timeInt);
		String str2 = SysDateFormat.getDateStringAllFromSeconds(time2);
		System.out.println(str2);
		System.out.println(getDateStrMillsAll());
		System.out.println(getDateStrNaAll());
		System.out.println(getDateStrNaAll());
//		for(int i =0;i<10;i++){
//			System.out.println(getDateStrNaAll()+"------"+getDateStrMillsAll());
//		}
		String startDate = "2014-4-21 12:13:40" ;
		String endDate = "2014-4-21 12:15:40" ;
		 System.out.println("------------>"+strToDateNoSpace(endDate));
		//printDifference(startDate,endDate);
		//System.out.println(getCurrentDateStringAllNoSpace());
		//System.out.println(strToDateLong("02:40:25 Jun 11, 2014"));
		 int time3 = getNextDayStartSecondFromInt(timeInt);
	}
}
