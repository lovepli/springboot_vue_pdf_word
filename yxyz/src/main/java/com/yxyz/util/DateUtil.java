/**
 * DateUtil.java   1.00    2004/01/14
 *
 * Sinyee Framework.
 * Copyright 2004-2006 SINYEE I.T. Co., Ltd. All rights reserved.
 * @author SINYEE I.T. Co., Ltd.
 *
 * History:
 * 2004/01/14   Ura         New
 * 2004/01/14   Ura         Comment modify
 */
package com.yxyz.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 */

/**
 * Date utility
 * 
 * @version 1.00
 * @author Ura
 */
public class DateUtil {
	/**
	 * Date format: "YY"
	 */
	public static final String YY = "yy";

	/**
	 * Date format: "YYYY"
	 */
	public static final String YYYY = "yyyy";

	/**
	 * Date format: "MM"
	 */
	public static final String MM = "MM";

	/**
	 * Date format: "DD"
	 */
	public static final String DD = "dd";

	/**
	 * Date format: "MM/DD"
	 */
	public static final String MM_DD = "MM/dd";

	/**
	 * Date format: "YYYYMM"
	 */
	public static final String YYYYMM = "yyyyMM";

	public static final String YYYYMMDD = "yyyyMMdd";

	/**
	 * Date format: "YYYY/MM"
	 */
	public static final String YYYY_MM = "yyyy/MM";

	/**
	 * Date format: "YY/MM/DD"
	 */
	public static final String YY_MM_DD = "yy/MM/dd";

	/**
	 * Date format: "YYYY/MM/DD"
	 */
	public static final String YYYY_MM_DD = "yyyy/MM/dd";

	/**
	 * Date format: "YYYY-MM"
	 */
	public static final String OYYYY_MM = "yyyy-MM";
	
	/**
	 * Date format: "YYYY-MM-DD"
	 */
	public static final String OYYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * Date format: "YYYY-MM-DD HH:MI" Add By YEHOOHAHA
	 */
	public static final String OYYYY_MM_DD_HH24 = "yyyy-MM-dd HH";

	/**
	 * Date format: "YYYY-MM-DD HH:MI" Add By YEHOOHAHA
	 */
	public static final String OYYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";
	/**
	 * Date format: "YYYY-MM-DD HH:MI:SS"
	 */
	public static final String OYYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd hh:mm:ss";
	/**
	 * Date format: "YYYY-MM-DD HH24:MI:SS"
	 */
	public static final String OYYYY_MM_DD_HH24_MI_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * Date format: "YYYY-MM-DD HH24:MI:SS.SSS"
	 */
	public static final String OYYYY_MM_DD_HH24_MI_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	

	/**
	 * Date format: "HH:MI"
	 */
	public static final String HH_MI = "HH:mm";

	/**
	 * Date format: "HHMI"
	 */
	public static final String HHMI = "HHmm";

	/**
	 * Date format: "YY/MM/DD HH:MI"
	 */
	public static final String YY_MM_DD_HH_MI = "yy/MM/dd HH:mm";

	/**
	 * Date format: "YYYY/MM/DD HH:MI"
	 */
	public static final String YYYY_MM_DD_HH_MI = "yyyy/MM/dd HH:mm";

	/**
	 * Date format: "YYYY/MM/DD HH:MI:SS"
	 */
	public static final String YYYY_MM_DD_HH_MI_SS = "yyyy/MM/dd HH:mm:ss";

	/**
	 * Date format: "HH:MI:SS"
	 */
	public static final String HH_MI_SS = "HH:mm:ss";

	/**
	 * Date format: "YYYYMMDDHHMISS"
	 */
	public static final String YYYYMMDDHHMI = "yyyyMMddHHmm";

	/**
	 * Date format: "YYYYMMDDHHMISS"
	 */
	public static final String YYYYMMDDHHMISS = "yyyyMMddHHmmss";

	/**
	 * Date format: "YYYYMMDD_HHMISS"
	 */
	public static final String YYYYMMDD_HHMISS = "yyyyMMdd-HHmmss";

	/**
	 * Date format YYYY年MM月DD日
	 */
	public static final String YYYY$MM$DD$ = "yyyy年MM月dd日";

	/**
	 * Date format YYYY年MM月DD日HH时MI分
	 */
	public static final String YYYY$MM$DD$HH$MI$ = "yyyy年MM月dd日HH时mm分";

	/**
	 * Date format YYYY年MM月
	 */
	public static final String YYYY$MM$ = "yyyy年MM月";

	/**
	 * Date format MM月DD日
	 */
	public static final String MM$DD$ = "MM月dd日";

	/**
	 * Date format HH时mm分
	 */
	public static final String HH$MI$ = "HH时mm分";

	/**
	 * Date format DD日
	 */
	public static final String DD$ = "dd日";

	// modified 2004/06/10 詳細情報修正
	/**
	 * Date format: "ERAYYMMDD"
	 */
	public static final String ERAYYMMDD = "ERAYYMMDD";

	/**
	 * Date format: "ERAYYMM"
	 */
	public static final String ERAYYMM = "ERAYYMM";

	/**
	 * Date format: "HH"
	 */
	public static final String HH = "HH";

	/**
	 * Date format: "MI"
	 */
	public static final String MI = "mm";

	/**
	 * Field value: Year
	 */
	public static final int YEAR = 1;

	/**
	 * Field value: Month
	 */
	public static final int MONTH = 2;

	/**
	 * Field value: Day
	 */
	public static final int DAY = 3;

	/**
	 * Field value: Hour
	 */
	public final static int HOUR = 10;

	/**
	 * Field value: Hour of Day
	 */
	public final static int HOUR_OF_DAY = 11;

	/**
	 * Field value: Minute
	 */
	public final static int MINUTE = 12;

	/**
	 * Field value: Second
	 */
	public final static int SECOND = 13;

	/**
	 * Get current date
	 * 
	 * @return current date
	 */
	public static Date getCurrent() {
		Date currentDate = new Date();
		return currentDate;
	}

	/**
	 * Get current date
	 * 
	 * @return current date
	 */
	public static Date getCurrentdate() {
		String currentDate = DateUtil.getFormatDate(DateUtil.YYYYMMDD, new Date());
		Date date = DateUtil.getDate(DateUtil.YYYYMMDDHHMISS, currentDate + "000000");
		return date;
	}

	/**
	 * Function : Get current date end,such as 23:59:59
	 * 
	 * @return current date end
	 */
	public static Date getCurrentdateEnd() {
		String currentDate = DateUtil.getFormatDate(DateUtil.YYYYMMDD, new Date());
		Date date = DateUtil.getDate(DateUtil.YYYYMMDDHHMISS, currentDate + "235959");
		return date;
	}

	/**
	 * Function : 得到日期的最后时间
	 * 
	 * @return current date end
	 */
	public static Date getDateEnd(Date date) {
		String currentDate = DateUtil.getFormatDate(DateUtil.YYYYMMDD, date);
		Date date1 = DateUtil.getDate(DateUtil.YYYYMMDDHHMISS, currentDate + "235959");
		return date1;
	}
	
	/**
	 * Function : 得到日期的开始时间
	 * 
	 * @return current date end
	 */
	public static Date getDateStart(Date date) {
		String currentDate = DateUtil.getFormatDate(DateUtil.YYYYMMDD, date);
		Date date1 = DateUtil.getDate(DateUtil.YYYYMMDDHHMISS, currentDate + "000000");
		return date1;
	}
	/**
	 * Function: 指定月の週の個数を取る<br>
	 * 
	 * Produce Describe:
	 * 
	 * @return
	 */
	public static int getMonthWeekCount(Date date) {
		Date monthenddate = getMonthEndDay(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(monthenddate);
		return cal.get(Calendar.WEEK_OF_MONTH);
		// // Month Begin
		// cal.setTime(date);
		// int beginweekday = cal.get(Calendar.DAY_OF_WEEK);
		//	    
		// // Month End
		// cal.setTime(getMonthEndDay(date));
		// int endweekday = cal.get(Calendar.DAY_OF_WEEK);
		//	    
		// // Month day count
		// int monthdaycount = cal.get(Calendar.DATE);
		//	    
		// return (monthdaycount + beginweekday + (6-endweekday))/7;

	}

	/**
	 * Get current month's first day
	 * 
	 * @return current month's first day
	 * 
	 */
	public static Date getCurrentMonth() {
		return getMonthFirstDay(new Date());
	}

	/**
	 * get the first day of month the date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthFirstDay(Date date) {
		String month = getFormatDate(DateUtil.YYYYMM, date) + "01";
		Date firstday = null;

		firstday = getDate(DateUtil.YYYYMMDD, month);

		return firstday;
	}

	/**
	 * 
	 * Function: 得到当前日期的本周的第一天
	 * 
	 * Produce describe:
	 * 
	 * @param date
	 * @return
	 * 
	 * @author semwar 2008-4-18 下午01:42:46
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	
	public static String getWeekFirstDayStr(Date date) {
		String str = DateUtil.getFormatDate(DateUtil.YYYY_MM_DD, getFirstDayOfWeek(date));
		String strArr = str.replace("/", "-");
		return strArr + " 00:00:00";
	}

	/**
	 * 取得当前日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	public static String getWeekEndDayStr(Date date) {
		String str = DateUtil.getFormatDate(DateUtil.YYYY_MM_DD, getFirstDayOfWeek(date));
		String strArr = str.replace("/", "-");
		return strArr + " 23:59:59";
	}

	/**
	 * get the end day of month the date
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthEndDay(Date date) {
		Date endday = DateUtil.dateAdd(DateUtil.DAY, -1, DateUtil.dateAdd(DateUtil.MONTH, 1, getMonthFirstDay(date)));
		return endday;
	}

	/**
	 * Get 2999/12/31
	 * 
	 * @return
	 */
	public static Date getEndDate() {

		return getDate(DateUtil.YYYYMMDD, "29991231");

	}

	/**
	 * Get 9999/12/31
	 * 
	 * @return
	 */
	public static Date getServiceEndDate() {

		return getDate(DateUtil.YYYYMMDD, "99991231");

	}

	/**
	 * Get 1990/01/01
	 * 
	 * @return
	 */
	public static Date getStartDate() {

		return getDate(DateUtil.YYYYMMDD, "19900101");

	}

	/**
	 * 
	 * @param month
	 * @return
	 */
	public static Date getSelectMonth(String month) {
		SimpleDateFormat sdf;
		Date time = new Date();
		sdf = new SimpleDateFormat("yyyy");
		String date = sdf.format(time);
		date = date + "-" + month + "-01 00:00:00.0";
		sdf.applyPattern("yyyy-MM");
		Date curDate = null;
		try {
			curDate = sdf.parse(date);
		} catch (ParseException e) {
		}

		return curDate;
	}

	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public static String getAge(String birthday) {
		if (birthday == null || "".equals(birthday))
			return "0";
		Date timenow = new Date();
		Date birth = null;

		birth = getDate(DateUtil.YYYYMMDD, birthday);
		int byear = Integer.parseInt(getFormatDate(DateUtil.YYYY, birth));
		int nyear = Integer.parseInt(getFormatDate(DateUtil.YYYY, timenow));
		int bmonth = Integer.parseInt(getFormatDate(DateUtil.MM, birth));
		int nmonth = Integer.parseInt(getFormatDate(DateUtil.MM, timenow));
		int age = nyear - byear;
		if (age < 0)
			return "0";
		if (nmonth < bmonth)
			age--;
		return String.valueOf(age);

	}

	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public static String getAge(Date birthday) {

		if (birthday == null)
			return "0";
		Date timenow = new Date();
		int byear = Integer.parseInt(getFormatDate(DateUtil.YYYY, birthday));
		int nyear = Integer.parseInt(getFormatDate(DateUtil.YYYY, timenow));
		int bmonth = Integer.parseInt(getFormatDate(DateUtil.MM, birthday));
		int nmonth = Integer.parseInt(getFormatDate(DateUtil.MM, timenow));
		int age = nyear - byear;
		if (age < 0)
			return "0";
		if (nmonth < bmonth)
			age--;
		return String.valueOf(age);

	}

	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public static String getAge(Date birthday, Date curDate) {

		if (birthday == null)
			return "0";
		Date timenow = curDate;
		int byear = Integer.parseInt(getFormatDate(DateUtil.YYYY, birthday));
		int nyear = Integer.parseInt(getFormatDate(DateUtil.YYYY, timenow));
		int bmonth = Integer.parseInt(getFormatDate(DateUtil.MM, birthday));
		int nmonth = Integer.parseInt(getFormatDate(DateUtil.MM, timenow));
		int age = nyear - byear;
		if (age < 0)
			return "0";
		if (nmonth < bmonth)
			age--;
		return String.valueOf(age);

	}

	/**
	 * Get formatted date through custom format
	 * 
	 * @param sFormat
	 *            Format
	 * @param date
	 *            Date which need to be formatted
	 * @return Formatted date
	 */
	public static String getFormatDate(String sFormat, Date date) {
		if (date == null) {
			return null;
		}
		if (sFormat == DateUtil.YY || sFormat == DateUtil.YYYY || sFormat == DateUtil.MM || sFormat == DateUtil.DD || sFormat == DateUtil.MM_DD || sFormat == DateUtil.YYYYMM
				|| sFormat == DateUtil.YYYYMMDD || sFormat == DateUtil.YYYY_MM || sFormat == DateUtil.YY_MM_DD || sFormat == DateUtil.YYYY_MM_DD || sFormat == DateUtil.OYYYY_MM_DD
				|| sFormat == DateUtil.OYYYY_MM_DD_HH_MI || sFormat == DateUtil.OYYYY_MM_DD_HH_MI_SS || sFormat == DateUtil.OYYYY_MM_DD_HH24_MI_SS || sFormat == DateUtil.HH_MI || sFormat == DateUtil.HHMI || sFormat == DateUtil.YY_MM_DD_HH_MI
				|| sFormat == DateUtil.YYYY_MM_DD_HH_MI_SS || sFormat == DateUtil.YYYYMMDDHHMISS || sFormat == DateUtil.HH$MI$ || sFormat == DateUtil.YYYY$MM$DD$ || sFormat == DateUtil.YYYY$MM$DD$HH$MI$ || sFormat == DateUtil.YYYY$MM$ || sFormat == DateUtil.MM$DD$
				|| sFormat == DateUtil.DD$ || sFormat == DateUtil.HH || sFormat == DateUtil.MI || sFormat == DateUtil.HH_MI_SS || sFormat == DateUtil.YYYY_MM_DD_HH_MI || sFormat == DateUtil.OYYYY_MM_DD_HH24
				|| sFormat == DateUtil.OYYYY_MM ) {
			SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
			return formatter.format(date);
		} else {
			return null;
		}
	}

	public static Date getDate(String sFormat, String date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		if (sFormat == DateUtil.YY || sFormat == DateUtil.YYYY || sFormat == DateUtil.MM || sFormat == DateUtil.DD || sFormat == DateUtil.MM_DD || sFormat == DateUtil.YYYYMM
				|| sFormat == DateUtil.YYYYMMDD || sFormat == DateUtil.YYYY_MM || sFormat == DateUtil.YY_MM_DD || sFormat == DateUtil.YYYY_MM_DD || sFormat == DateUtil.OYYYY_MM_DD
				|| sFormat == DateUtil.HH_MI || sFormat == DateUtil.YY_MM_DD_HH_MI || sFormat == DateUtil.OYYYY_MM_DD_HH_MI_SS || sFormat == DateUtil.OYYYY_MM_DD_HH24_MI_SS || sFormat == DateUtil.OYYYY_MM_DD_HH24  || sFormat == DateUtil.OYYYY_MM_DD_HH_MI || sFormat == DateUtil.YYYY_MM_DD_HH_MI_SS
				|| sFormat == DateUtil.YYYYMMDDHHMI || sFormat == DateUtil.YYYYMMDDHHMISS || sFormat == DateUtil.YYYYMMDD_HHMISS || sFormat == DateUtil.YYYY$MM$DD$ || sFormat == DateUtil.YYYY$MM$
				|| sFormat == DateUtil.MM$DD$ || sFormat == DateUtil.DD$ || sFormat == DateUtil.HH || sFormat == DateUtil.MI) {
			SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
			try {
				return formatter.parse(date);
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 月末日取得
	 * 
	 * @return
	 */
	public static Date getLastDay(Date date) {
		if (date == null) {
			return null;
		} else {
			return dateAdd(DateUtil.DAY, -1, dateAdd(DateUtil.MONTH, 1, date));
		}
	}

	/**
	 * Get current formatted date through custom format
	 * 
	 * @param sFormat
	 *            Format
	 * @return Formatted date
	 */
	public static String getFormatDate(String sFormat) {
		return getFormatDate(sFormat, getCurrent());
	}

	/**
	 * Add value on special field of date
	 * 
	 * @param iField
	 *            Field which need add value
	 * @param iValue
	 *            Value which will be added
	 * @param date
	 *            Basic date
	 * @return New date
	 */
	public static Date dateAdd(int iField, int iValue, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (iField) {
		case DateUtil.YEAR:
			cal.add(Calendar.YEAR, iValue);
			break;
		case DateUtil.MONTH:
			cal.add(Calendar.MONTH, iValue);
			break;
		case DateUtil.DAY:
			cal.add(Calendar.DATE, iValue);
			break;
		case DateUtil.HOUR:
			cal.add(Calendar.HOUR, iValue);
			break;
		case DateUtil.HOUR_OF_DAY:
			cal.add(Calendar.HOUR_OF_DAY, iValue);
			break;
		case DateUtil.MINUTE:
			cal.add(Calendar.MINUTE, iValue);
			break;
		case DateUtil.SECOND:
			cal.add(Calendar.SECOND, iValue);
			break;
		default:
			break;
		}
		return cal.getTime();
	}

	/**
	 * Date diff
	 * 
	 * @param iField
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long dateDiff(int iField, Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		// long startTime = startDate.getTime();
		// long endTime = endDate.getTime();
		// long diffTime = endTime - startTime;
		int startYear = Integer.parseInt(getFormatDate(YYYY, startDate));
		int endYear = Integer.parseInt(getFormatDate(YYYY, endDate));
		int startMonth = Integer.parseInt(getFormatDate(MM, startDate)) - 1;
		int endMonth = Integer.parseInt(getFormatDate(MM, endDate)) - 1;
		int startDay = Integer.parseInt(getFormatDate(DD, startDate));
		int endDay = Integer.parseInt(getFormatDate(DD, endDate));
		int startHour = Integer.parseInt(getFormatDate(HH, startDate));
		int endHour = Integer.parseInt(getFormatDate(HH, endDate));
		int startMinute = Integer.parseInt(getFormatDate(MI, startDate));
		int endMinute = Integer.parseInt(getFormatDate(MI, endDate));

		switch (iField) {
		case DateUtil.YEAR:
			return endYear - startYear;
		case DateUtil.MONTH:
			long yearDiff = endYear - startYear;
			long monthDiff = endMonth - startMonth;
			return yearDiff * 12 + monthDiff;
		case DateUtil.DAY:
			start.set(startYear, startMonth, startDay, 0, 0, 0);
			end.set(endYear, endMonth, endDay, 0, 0, 0);
			return (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		case DateUtil.HOUR:
			start.set(startYear, startMonth, startDay, startHour, 0, 0);
			end.set(endYear, endMonth, endDay, endHour, 0, 0);
			return (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60);
		case DateUtil.HOUR_OF_DAY:
			start.set(startYear, startMonth, startDay, startHour, 0, 0);
			end.set(endYear, endMonth, endDay, endHour, 0, 0);
			return (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60);
		case DateUtil.MINUTE:
			start.set(startYear, startMonth, startDay, startHour, startMinute, 0);
			end.set(endYear, endMonth, endDay, endHour, endMinute, 0);
			return (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60);
		default:
			break;
		}
		return end.getTimeInMillis() - start.getTimeInMillis();
	}

	/**
	 * Add value on special field of current date
	 * 
	 * @param iField
	 *            iField Field which need add value
	 * @param iValue
	 *            Value which will be added
	 * @return New date
	 */
	public static Date dateAdd(int iField, int iValue) {
		return dateAdd(iField, iValue, getCurrent());
	}

	/**
	 * Trunc the date
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateTrunc(Date date) {

		return DateUtil.getDate(DateUtil.YYYYMMDD, DateUtil.getFormatDate(DateUtil.YYYYMMDD, date));

	}

	/**
	 * Get the day count of the month
	 * 
	 * @param date
	 * @return
	 */
	public static long getMonthDayCount(Date date) {
		Date start = getMonthFirstDay(date);
		Date end = getMonthEndDay(date);
		return DateUtil.dateDiff(DateUtil.DAY, start, end) + 1;
	}

	/**
	 * 
	 * Function: 返回第几周
	 * 
	 * Produce describe:
	 * 
	 * @param type
	 *            DateUtil.YEAR ： 一年中第几周 DateUtil.MONTH ： 一月中第几周
	 * @param date
	 * @return
	 * 
	 * @author: Louis Apr 15, 2008
	 */
	public static int getWeekNum(int type, Date date) {

		Date monthenddate = getMonthEndDay(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(monthenddate);

		if (type == DateUtil.YEAR) {

			return cal.get(Calendar.WEEK_OF_YEAR);

		} else if (type == DateUtil.MONTH) {

			return cal.get(Calendar.WEEK_OF_MONTH);

		}

		return 0;
	}

	/**
	 * Function: return date by specified year,month,day,hour,minute,second<br>
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @param month
	 * @param day
	 * @param year
	 * @return - Date
	 */
	public static Date mktime(int hour, int minute, int second, int month, int day, int year) {

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day, hour, minute, second);
		return cal.getTime();

	}

	/**
	 * Get timestamp
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 获取系统当前Timestamp格式的时间
	 * 
	 * @return
	 */
	public static Timestamp getCurrentDateTimestamp() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp createDttm = Timestamp.valueOf(df.format(new Date()));
		return createDttm;
	}

	/**
	 * Private Constructor
	 */
	private DateUtil() {
	}

	/**
	 * Function: 取得两个时间之间的距离
	 * 
	 * Produce describe:
	 * 
	 * @param startDate
	 * @param endDate
	 * @return 时间距离列表(天,小时,秒)
	 * 
	 * @author: JT 2008-4-7
	 */
	public static long[] dateDiffEx(Date startDate, Date endDate) {

		long[] diffTime = new long[3];

		long minuteDiff = 0;
		long hourDiff = 0;
		long dayDiff = 0;

		long diff = dateDiff(MINUTE, startDate, endDate);

		if (diff > 0) {
			// 分钟
			minuteDiff = diff % 60;
			diff = diff / 60;
		}

		if (diff > 0) {
			// 小时
			hourDiff = diff % 24;
			diff = diff / 24;
		}

		if (diff > 0) {
			// 天
			dayDiff = diff;
		}

		diffTime[0] = dayDiff;
		diffTime[1] = hourDiff;
		diffTime[2] = minuteDiff;

		return diffTime;
	}

	/**
	 * 
	 * Function:取得两个时间的相差值,精确到秒</br>
	 * 
	 * Produce Describe: 返回 int[6]数组,int[0]为年份差值,int[1]为月份差值......</br>
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @author: You 2008-4-10
	 */
	public static int[] getTimeDiff(Date startTime, Date endTime) {
		int[] ret = new int[6];
		if (startTime == null || endTime == null)
			return null;
		int syear = 0;
		if (DateUtil.getFormatDate(DateUtil.YYYY, startTime) != null)
			syear = Integer.parseInt(DateUtil.getFormatDate(DateUtil.YYYY, startTime));
		int eyear = 0;
		if (DateUtil.getFormatDate(DateUtil.YYYY, endTime) != null)
			eyear = Integer.parseInt(DateUtil.getFormatDate(DateUtil.YYYY, endTime));

		int smonth = 0;
		if (DateUtil.getFormatDate(DateUtil.MM, startTime) != null)
			smonth = Integer.parseInt(DateUtil.getFormatDate(DateUtil.MM, startTime));
		int emonth = 0;
		if (DateUtil.getFormatDate(DateUtil.MM, endTime) != null)
			emonth = Integer.parseInt(DateUtil.getFormatDate(DateUtil.MM, endTime));
		int sday = 0;
		if (DateUtil.getFormatDate(DateUtil.DD, startTime) != null)
			sday = Integer.parseInt(DateUtil.getFormatDate(DateUtil.DD, startTime));
		int eday = 0;
		if (DateUtil.getFormatDate(DateUtil.DD, endTime) != null)
			eday = Integer.parseInt(DateUtil.getFormatDate(DateUtil.DD, endTime));
		int shour = 0;
		if (DateUtil.getFormatDate(DateUtil.HH, startTime) != null)
			shour = Integer.parseInt(DateUtil.getFormatDate(DateUtil.HH, startTime));
		int ehour = 0;
		if (DateUtil.getFormatDate(DateUtil.HH, endTime) != null)
			ehour = Integer.parseInt(DateUtil.getFormatDate(DateUtil.HH, endTime));
		int sminute = 0;
		if (DateUtil.getFormatDate("mm", startTime) != null)
			sminute = Integer.parseInt(DateUtil.getFormatDate("mm", startTime));
		int eminute = 0;
		if (DateUtil.getFormatDate("mm", endTime) != null)
			eminute = Integer.parseInt(DateUtil.getFormatDate("mm", endTime));

		int ssecond = 0;
		if (DateUtil.getFormatDate("ss", endTime) != null)
			ssecond = Integer.parseInt(DateUtil.getFormatDate("ss", startTime));
		int esecond = 0;
		if (DateUtil.getFormatDate("ss", endTime) != null)
			esecond = Integer.parseInt(DateUtil.getFormatDate("ss", endTime));

		int secondDif = esecond - ssecond;

		int minuteDif = eminute - sminute;

		int hourDif = ehour - shour;

		int dayDif = eday - sday;

		int monthDif = emonth - smonth;

		int yearDif = eyear - syear;

		if (secondDif < 0) {
			secondDif += 60;
			minuteDif--;
		}
		if (minuteDif < 0) {
			minuteDif += 60;
			hourDif--;
		}
		if (hourDif < 0) {
			hourDif += 24;
			dayDif--;
		}

		// 月份天数
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endTime);
		int days = calendar.getMaximum(Calendar.DATE);

		if (dayDif < 0) {
			dayDif += days;
			monthDif--;
		}
		if (monthDif < 0) {
			monthDif += 12;
			yearDif--;
		}

		ret[0] = yearDif;
		ret[1] = monthDif;
		ret[2] = dayDif;
		ret[3] = hourDif;
		ret[4] = minuteDif;
		ret[5] = secondDif;

		return ret;

	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 
	 * function: 根据一个日期，返回是星期几的字符串
	 * 
	 * @param date
	 * @return
	 * 
	 * @author Rain Stars Sep 8, 2009 2:16:11 AM
	 */
	public static String getWeekStr(Date date) {
		String str = "";
		str = getWeek(date);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	/**
	 * 判断当前日期是星期几<br>
	 * <br>
	 * 
	 * @param pTime
	 *            修要判断的时间<br>
	 * @return dayForWeek 判断结果<br>
	 * @Exception 发生异常
	 *                <br>
	 */
	public static int getDayForWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	
	/**
	 * 
	 * function: 替换日期的天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 * 
	 * @author Rain Stars Jan 15, 2010 8:17:52 PM
	 */
	public static Date replaceDay(Date date,long day){
		
		String dayStr = "";

		// 当前的日期
		String cutDateStr = DateUtil.getFormatDate(DateUtil.YYYYMM,date);

		if (day < 10) {
			dayStr = "0" + day;
		}else{
			dayStr = day+"";
		}

		Date currentDate = DateUtil.getDate(DateUtil.YYYYMMDD, cutDateStr + dayStr);
		
		return currentDate;
	}
	
	/**
	 * 计算时长
	 * @param date
	 * @param now
	 * @return
	 */
	public static String getDuration(Date date,Date now){
			
	   long l;
	   Calendar c1 = Calendar.getInstance();

	   Calendar c2 = Calendar.getInstance();

	   c1.setTime(date);

	   c2.setTime(now);

	   int result=c1.compareTo(c2);

	   if(result < 0){
		   l = now.getTime() - date.getTime();
	   }else if(result > 0){
		   l = date.getTime() - now.getTime();
	   }else{
		   return "0天0小时";
	   }

	   long day=l/(24*60*60*1000);

	   long hour=(l/(60*60*1000)-day*24);

	   String duration = day+"天"+hour+"小时";

	   return duration;
	}

	/**
	 * 指定年份月份的天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth( int year, int month ) 
    {
        int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if( 2 == month && 0 == (year % 4) && ( 0 != (year % 100) || 0 == (year % 400) ) ) {
            days[1] = 29;
        }
        return( days[month -1] );
    }
	
	public static void printTime(Date time){
		SimpleDateFormat sf = new SimpleDateFormat(OYYYY_MM_DD_HH24_MI_SS_SSS);
		System.out.println(sf.format(time));
		
	}
}