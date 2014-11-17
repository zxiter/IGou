/**
 * 
 */
package com.xiter.igou.task;

import java.util.Map;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.xiter.igou.util.StringUtil;

/**
 * Description:异步处理的基类
 * 
 * @author liufeihua
 * @date 2014-11-17上午10:40:12
 * @version 1.0
 * 
 */
public abstract class BaseAsyncTask extends AsyncTask<Void, Void, Void> {

	protected boolean status;// 返回的状态true or false

	protected String info;// 返回的备注

	protected Object object;// 返回的数据

	private AsyncTaskListener asyncTaskListener;// 回调接口

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public AsyncTaskListener getAsyncTaskListener() {
		return asyncTaskListener;
	}

	public void setAsyncTaskListener(AsyncTaskListener asyncTaskListener) {
		this.asyncTaskListener = asyncTaskListener;
	}

	public BaseAsyncTask(AsyncTaskListener asyncTaskListener) {
		this.asyncTaskListener = asyncTaskListener;
	}

	@Override
	protected Void doInBackground(Void... arg0) {
		if (!isCancelled()) {
			doInBackground();
		}
		return null;
	}

	/**
	 * 后台执行的任务
	 */
	protected abstract void doInBackground();

	@Override
	protected void onPostExecute(Void result) {
		isFinished = true;
		if (!isCancelled()) {
			this.asyncTaskListener.taskResult(status, info, object);
		}
	}

	private boolean isFinished = false;

	public boolean isFinished() {
		if (isCancelled()) {
			return true;
		} else {
			return isFinished;
		}
	}

	protected void setNetWorkError() {
		status = false;
		info = "网络异常，请稍后再试";
		object = null;
	}

	@SuppressWarnings("unchecked")
	protected void processHttpResult(String result) {

		if (StringUtil.isEmpty(result)) {
			setNetWorkError();
		} else {
			Map<String, Object> map = null;
			try {
				map = new Gson().fromJson(result, Map.class);
			} catch (Exception e) {
			}
			if (map != null) {
				if (map.containsKey("success")) {
					status = (Boolean) map.get("success");
				}
				if (map.containsKey("msg")) {
					info = (map.get("msg") + "");
				} else {
					info = "解释map错误";
				}
				if (status) {
					object = map.get("obj");
				}
			}
		}
	}

	/**
	 * 停止任务
	 */
	public void stopTask() {
		cancel(true);
	}

	/**
	 * 开始任务
	 */
	public void startTask() {
		execute();
	}

	/**
	 * 异步任务处理的内部接口
	 * 
	 * @author liufeihua
	 * @date 2014-11-17上午10:46:00
	 * @version 1.0
	 * 
	 */
	public interface AsyncTaskListener {

		void taskResult(boolean status, String info, Object data);

	}

}
