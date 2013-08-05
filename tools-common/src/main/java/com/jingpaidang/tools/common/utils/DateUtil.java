package com.jingpaidang.tools.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class DateUtil {
	
	public static final String DATA_STRING = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 当前日期转为字符串
	 * @param formate "yyyy-mm-dd hh:MM:ss"
	 * @return String
	 */
	public static String date2str(String formate){
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(formate);
		return sf.format(date);
	}
	
	/**
	 * 入参是秒
	 * @param times
	 * @return
	 */
	public static String date2str(long times){
	      GregorianCalendar gc = new GregorianCalendar();
          gc.setTimeInMillis(times * 1000);
          SimpleDateFormat format = new SimpleDateFormat(DATA_STRING);
          return format.format(gc.getTime());
	}

	public static String date2shortStr(long times){
	      GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(times * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(gc.getTime());
	}
	
	public static String date2str(Date date){
		SimpleDateFormat sf = new SimpleDateFormat(DATA_STRING);
		return sf.format(date);
	}
	
	public static String date2shortStr(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}
	
	public static String date2str(Date date,String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	
	public static Date StrToDate(String dateStr){
		SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = dd.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
