package com.xiter.igou.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author liufeihua
 * @version 2014-11-27
 */
public class DateUtil {

	private static String[] parsePatterns = { "yyyy-MM-dd",
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

	public static SimpleDateFormat getInstance() {
		return new SimpleDateFormat(parsePatterns[1]);
	}

	public static String getDateToString() {
		return getInstance().format(new Date());
	}
}
