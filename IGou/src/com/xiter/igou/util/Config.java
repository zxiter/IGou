/**
 * 
 */
package com.xiter.igou.util;

/**
 * Description:配置
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class Config {

	public final static String PRE_CLIENT = "";

	public final static String PRE_USER = "user";

	/**
	 * 页面显示的条数
	 */
	public final static int PAGE_SIZE = 5;
	/**
	 * 请求的基本路径
	 */
	// public final static String STRURL =
	// "http://192.168.2.116:8080/igouserv/";
	public final static String STRURL = "http://42.96.204.191:8080/igouserv/";

	/**
	 * 登录接口
	 */
	public final static String LOGIN = "userController/login.do";

	public static final String FIND_GOODS = "goodsController/findGoods.do";
	public final static String FIND_MESSAGE = "base/tRdSPMessage!doMobile_MessageGrid.gx";
}
