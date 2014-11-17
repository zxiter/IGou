/**
 * 
 */
package com.xiter.igou.task;

import java.util.Map;

import com.xiter.igou.http.BaseHttpClient;
import com.xiter.igou.util.StringUtil;

/**
 * Description:基本任务的默认实现类
 * 
 * @author liufeihua
 * @date 2014-11-17上午11:16:47
 * @version 1.0
 * 
 */
public class DefaultAsyncTask extends BaseAsyncTask {

	private Map<String, Object> map;
	private String url;

	public DefaultAsyncTask(AsyncTaskListener asyncTaskListener,
			Map<String, Object> map, String url) {
		super(asyncTaskListener);
		this.map = map;
		this.url = url;
	}

	@Override
	protected void doInBackground() {
		String result = "";
		try {
			result = BaseHttpClient.post(url, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!StringUtil.isEmpty(result)) {
			processHttpResult(result);
		} else {
			status = false;
		}
	}
}
