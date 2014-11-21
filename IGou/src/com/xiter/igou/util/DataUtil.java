/**
 * 
 */
package com.xiter.igou.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:数据源
 * 
 * @author liufeihua
 * @date 2014-11-21上午10:08:50
 * @version 1.0
 * 
 */
public class DataUtil {

	public static List<HashMap<String, String>> getData() {
		List<HashMap<String, String>> datas = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> d1 = new HashMap<String, String>(1);
		d1.put("name", "我的账户");

		HashMap<String, String> d2 = new HashMap<String, String>(1);
		d2.put("name", "自动更新");

		HashMap<String, String> d3 = new HashMap<String, String>(1);
		d3.put("name", "关于");

		datas.add(d1);
		datas.add(d2);
		datas.add(d3);
		return datas;
	}

	public static List<HashMap<String, String>> getData1() {
		List<HashMap<String, String>> datas = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> d1 = new HashMap<String, String>(1);
		d1.put("name", "清理缓存");

		datas.add(d1);

		return datas;
	}
}
