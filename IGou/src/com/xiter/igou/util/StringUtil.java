package com.xiter.igou.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:字符串帮助类,判断符串是否为空,md5字符,邮件格式或电话格式 gps格式化
 * 
 * @author liufeihua
 * @date 2014-11-19上午9:07:10
 * @version 1.0
 * 
 */
public class StringUtil {

	/**
	 * 判断符串是否为空
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {
		if (input == null || "".equals(input))
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取md5加密字符串
	 */
	public static String md5_16(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// System.out.println("result: " + buf.toString());// 32位的加密
			return buf.toString().substring(8, 24);// 16位的加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static final String EMAIL_PATTERN_CHECK = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	private static final String CELLPHONE_PATTERN_CHECK = "^(13|15|18|14|16|17|19)\\d{9}$";

	/**
	 * 验证邮箱格式是否正确
	 */
	public static boolean emailFormat(String str) {
		boolean result = false;
		if (str == null) {
			str = "";
		}
		if (!str.equals("")) {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN_CHECK,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(str);
			result = matcher.matches();
		}
		return result;
	}

	/**
	 * 判断是不是手机号码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean phoneFormat(String str) {
		boolean result = false;
		if (str == null) {
			str = "";
		}
		result = str.matches(CELLPHONE_PATTERN_CHECK);
		return result;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param input
	 * @return
	 */
	public static boolean empty(String input) {
		return isEmpty(input);
	}

	/**
	 * gps格式化
	 * 
	 * @param gps
	 * @return
	 */
	public static String formatLocation(double gps) {
		return new DecimalFormat(".##########").format(gps);
	}
}
