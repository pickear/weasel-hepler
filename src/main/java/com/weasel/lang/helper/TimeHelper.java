package com.weasel.lang.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author Dylan
 * @time 2013-8-14
 */
public final class TimeHelper {

	

	/**
	 * 得到100年后的时间，100年即为永恒
	 * @return
	 */
	public static Date getForeverTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 100);
		return calendar.getTime();
	}
	
	/**
	 * 获得n小时后的时间
	 * @param hour
	 * @return
	 */
	public static Date getAfterHourTime(int hour){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}
	
	/**
	 * @param hour
	 * @return
	 */
	public static Date getBeforeHourTime(int hour){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, -hour);
		return calendar.getTime();
	}
	
	/**
	 * 获得n分钟后的时间
	 * @param minute
	 * @return
	 */
	public static Date getAfterMinuteTime(int minute){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	/**
	 * @param minute
	 * @return
	 */
	public static Date getBeforeMinuteTime(int minute){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -minute);
		return calendar.getTime();
	}
	/**
	 * 获得n分钟后的时间
	 * @param minute
	 * @return
	 */
	public static Date getAfterDayTime(int day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	
	/**
	 * @param day
	 * @return
	 */
	public static Date getBeforeDayTime(int day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -day);
		return calendar.getTime();
	}
	/**
	 * 
	 * @return
	 */
	public static Date getCurrentDate(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	/**
	 * 
	 * @return
	 */
	public static String getCurrentTime(){
		return dateToString(getCurrentDate());
	}
	
	/**
	 * 比较两个日期的大小,不比较小时、分钟、秒
	 * <p>
	 * date1大于date2返回1,date1等于date2返回0,date1小于date2返回-1.
	 * 
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return 日期的大小
	 */
	public static int compareTo(Date date1, Date date2) {
		String strDate1 = getStandardDate(date1);
		String strDate2 = getStandardDate(date2);
		date1 = parse(strDate1, "yyyy-MM-dd");
		date2 = parse(strDate2, "yyyy-MM-dd");
		return date1.compareTo(date2);
	}
	
	/**
	 * 获取标准日期（年-月-日）
	 * 
	 * @param date
	 *            日期对象
	 * @return 标准日期字符串
	 */
	public static String getStandardDate(Date date) {
		if (date == null)
			date = new Date();
		SimpleDateFormat smdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = new String(smdf.format(date));
		return strDate;
	}
	
	/**
	 * 将指定格式的时间字符串解析成时间对象
	 * 
	 * @param strDate
	 *            时间字符串
	 * @param format
	 *            时间格式,默认格式为"yyyy-MM-dd HH:mm:ss"
	 * @return 时间对象
	 */
	public static Date parse(String strDate, String format) {
		if (format == null || format.equals("")) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取年份
	 * @param date
	 * @return
	 */
	public static int getYear(Date date){
		if (date == null) date = new Date();
		Calendar calendar = Calendar.getInstance();		
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getCurrentDate());
	}
}
