package com.future.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil extends DateUtils {
	
	/** 缺省日期格式 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	/** 缺省时间格式 */
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	/** 缺省月格式 */
	public static final String DEFAULT_MONTH = "MONTH";

	/** 缺省年格式 */
	public static final String DEFAULT_YEAR = "YEAR";

	/** 缺省日格式 */
	public static final String DEFAULT_DATE = "DATE";

	/** 缺省小时格式 */
	public static final String DEFAULT_HOUR = "HOUR";

	/** 缺省分钟格式 */
	public static final String DEFAULT_MINUTE = "MINUTE";

	/** 缺省秒格式 */
	public static final String DEFAULT_SECOND = "SECOND";

	/** 缺省长日期格式 */
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH-mm";

	/** 缺省长日期格式,精确到秒 */
	public static final String DEFAULT_DATETIME_FORMAT_SEC = "yyyy-MM-dd HH:mm:ss";
	/** 生成年月日时分秒字符串格式 */
	public static final String DATETIME_2STR_FORMAT = "yyyyMMddHHmmss";

	/** 星期数组 */
	public static final String[] WEEKS = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	/** 日期格式 **/
	public static final String[] DATE_FORMAT_PATTERNS = { "yyyy-MM-dd", "yyyy年MM月dd日", "yyyy_MM_dd" };
	
	private static final String parsePatterns[] = {
			"yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy年MM月dd日",
			"yyyy-MM-dd HH", "yyyy年MM月dd日 HH时", 
			"yyyy-MM-dd HH:mm", "yyyy年MM月dd日 HH时mm分", 
			"yyyy-MM-dd HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒", 
			"yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss:SSS"
	};
	
	/**
	 * 取当前日期的字符串表示
	 * @return 当前日期的字符串 ,如2010-05-28
	 **/
	  public static String currentDate() {
	    return currentDate(DEFAULT_DATE_FORMAT);
	  }

	  /**
	   * 根据输入的格式得到当前日期的字符串
	   * @param strFormat 日期格式
	   * @return
	   */
	  public static String currentDate(String strFormat) {
	    return format(new Date(), strFormat);
	  }

	  /**
	   * 取当前时间的字符串表示,
	   * @return 当前时间,如:21:10:12
	   **/
	  public static String currentTime() {
	     return currentTime(DEFAULT_TIME_FORMAT);
	  }

	  /**
	   * 根据输入的格式获取时间的字符串表示
	   * @param 输出格式,如'hh:mm:ss'
	   * @return 当前时间,如:21:10:12
	   **/

	  public static String currentTime(String strFormat) {
	     return format(new Date(), strFormat);
	  }
	  
	  
	  /**
	   * 取当前时间的字符串表示,
	   * @return 当前时间,如:21:10:12
	   **/
	  public static String currentDateTime() {
	     return currentDateTime(DEFAULT_DATETIME_FORMAT_SEC);
	  }

	  /**
	   * 根据输入的格式获取时间的字符串表示
	   * @param 输出格式,如'hh:mm:ss'
	   * @return 当前时间,如:21:10:12
	   **/

	  public static String currentDateTime(String strFormat) {
	     return format(new Date(), strFormat);
	  }
	  
	  
	  /**
	    * 将java.util.date型按照缺省格式转为字符串
	    * @param date 源对象
	    * @return 如：2010-05-28
	    */
	   public static String format(Date date) {
	       return format(date, DEFAULT_DATE_FORMAT);
	   }
	  
	   /**
	    *  将java.util.date型按照指定格式转为字符串
	    * @param date  源对象
	    * @param format 想得到的格式字符串
	    * @return 如：2010-05-28
	    */
	   public static String format(Date date, String format) {
		   return DateFormatUtils.format(date, format);
	   }
	  
	  /**
	   * getCurDate 取当前日期
	   * @return java.util.Date型日期
	   **/
	  public static Date getCurrentDate() {
		  return (new Date());
	  }
	  
	  /**
	   *  得到当前日期的星期数
	   * @return 当前日期的星期的字符串
	   * @throws ParseException
	   */
	  public static String getWeekOfMonth() throws ParseException{
		   return getWeekOfMonth(null, null);
	  }
	  
	  /**
	   *  根据日期的到给定日期的在当月中的星期数
	   * @param date 给定日期
	   * @return
	   * @throws ParseException
	   */
	  public static String getWeekOfMonth(String date, String fromat) throws ParseException{
		  Calendar rightNow = Calendar.getInstance();
		  if(date != null && !"".equals(date.trim())){
			  rightNow.setTime(parseDate(date, fromat));
		  }
		  return WEEKS[rightNow.get(Calendar.WEEK_OF_MONTH)];
	  }
	  
	  
	  /**
	   *  根据日期的到给定日期的在当月中的星期数
	   * @param date 给定日期
	   * @return
	   * @throws ParseException
	   */
	  public static String getWeekOfMonth(Date date) throws ParseException{
		  Calendar rightNow = Calendar.getInstance();
		  if(date != null){
			  rightNow.setTime(date);
		  }
		  return WEEKS[rightNow.get(Calendar.WEEK_OF_MONTH)];
	  }
	  
	  /** 
	  * @Description: 毫秒值转换时分秒（应用场景：任务耗时） 
	  * @Param:  
	  * @return:  
	  * @Date: 2018/12/6
	  */ 
	  public static String msConvertHms(long ms){
          /**
           * 这里想要只保留分秒可以写成"mm:ss"
           */
		  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		  formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		  String hms = formatter.format(ms);
		  return hms;
	  }
	  
	 /**
	 * 	时间标准格式化
	 * 	@param date
	 * 	@return
	 */
	public static String format(String date, String format) {
		if(date == null || date.trim().isEmpty()) {
			return null;
		}
		try {
			Date temp = DateUtils.parseDate(date.trim(), parsePatterns);
			return DateFormatUtils.format(temp, format);
		} catch (ParseException e) {
			try {
				//容错处理
				date = date.trim().split("\\s")[0];
				Date temp = DateUtils.parseDate(date.trim(), parsePatterns);
				return DateFormatUtils.format(temp, format);
			} catch (ParseException e1) {
				return null;
			}
		}
	}

	/** 
	* @Description: 获取间隔时间 
	* @Param:  
	* @return:  
	* @Date: 2018/12/14
	*/ 
	public static String getIntervalTime(Date start,Date end){
		return msConvertHms(end.getTime()-start.getTime());
	}


    /**
    * @Description: 获取当前时间的前几天后后几天
    * @Param:  interval间隔天数（正数为当前时间的后几天、负数为当前时间的前几天）
    * @return:
    * @Date: 2018/12/26
    */
	public static String getIntervalDay(int interval){
		String day = currentDate();
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day1 = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day1 + interval);
		String beforeDay = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return beforeDay;
	}




}
