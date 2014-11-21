/**
 * 
 */
package com.xiter.igou.ui.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiter.igou.app.BaseApplication;
import com.xiter.igou.task.BaseAsyncTask.AsyncTaskListener;
import com.xiter.igou.task.DefaultAsyncTask;
import com.xiter.igou.widget.TopBar;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2014-11-17上午11:58:54
 * @version 1.0
 * 
 */
public class BaseActivity extends Activity implements AsyncTaskListener {

	/**
	 * 请求的路径
	 */
	public String url;
	/**
	 * 请求的参数
	 */
	public Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * 自定义bar
	 */
	public TopBar mTopBar;

	/**
	 * 查询界面存在的id
	 */
	public void findById() {

	}

	/**
	 * 初始化
	 */
	public void initView() {

	}

	/**
	 * 初始化自定义bar
	 */
	public void initBar() {

	}

	/**
	 * 设置布局文件
	 */
	public int setLayout() {
		return 0;
	}

	/**
	 * 日志
	 * 
	 * @param msg
	 */
	protected void log(String msg) {
		Log.d(this.getClass().getName(), msg);
	}

	/**
	 * 异步请求
	 * 
	 * @param task
	 * @param map
	 */
	protected void defaultTask() {
		new DefaultAsyncTask(this, params, url).startTask();
	}

	/**
	 * 异步请求
	 * 
	 * @param task
	 * @param map
	 */
	protected void defaultTask(AsyncTaskListener task, Map<String, Object> map) {
		new DefaultAsyncTask(task, map, url).startTask();
	}

	/**
	 * 异步请求
	 * 
	 * @param task
	 * @param path
	 * @param map
	 */
	protected void defaultTask(AsyncTaskListener task, String path,
			Map<String, Object> map) {
		new DefaultAsyncTask(task, map, path).startTask();
	}

	/**
	 * 获取编辑框值
	 * 
	 * @param str
	 * @return
	 */
	public String getText(EditText str) {
		return str.getText().toString();
	}

	/**
	 * 添加activity到自定义管理器中
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (0 != setLayout()) {
			setContentView(setLayout());
		}
		findById();
		initView();
		initBar();
		getAppContext().addActivity(this);
	}

	/**
	 * 销毁activity
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		getAppContext().finishActivity(this);
	}

	/**
	 * 获取application
	 */
	public BaseApplication getAppContext() {
		return (BaseApplication) getApplication();
	}

	/**
	 * 获取共享
	 * 
	 * @return
	 */
	public SharedPreferences getPrefrence() {

		SharedPreferences pre = getAppContext().getPrefrence();
		return pre;
	}

	/**
	 * toast显示text字符串
	 */
	public void toast(String text) {
		if (text == null) {
			text = "";
		}
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
				.show();
	}

	/**
	 * 处理返回结果
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public void taskResult(boolean status, String info, Object data) {

	}

	// -------findview---------------------------
	/**
	 * 按id查询按钮
	 * 
	 * @param id
	 * @return
	 */
	protected Button findButtonById(int id) {
		return (Button) this.findViewById(id);
	}

	/**
	 * 按id查询列表
	 * 
	 * @param id
	 * @return
	 */
	protected ListView findListViewById(int id) {
		return (ListView) this.findViewById(id);
	}

	/**
	 * 按id查询ImageView
	 * 
	 * @param id
	 * @return
	 */
	protected ImageView findImageViewById(int id) {
		return (ImageView) this.findViewById(id);
	}

	/**
	 * 按id查询SurfaceView
	 * 
	 * @param id
	 * @return
	 */
	protected SurfaceView findSurfaceViewById(int id) {
		return (SurfaceView) this.findViewById(id);
	}

	/**
	 * 按id查询ProgressBar
	 * 
	 * @param id
	 * @return
	 */
	protected ProgressBar findProgressBarById(int id) {
		return (ProgressBar) this.findViewById(id);
	}

	/**
	 * 按id查询TextView
	 * 
	 * @param id
	 * @return
	 */
	protected TextView findTextViewById(int id) {
		return (TextView) this.findViewById(id);
	}

	/**
	 * 按id查询EditText
	 * 
	 * @param id
	 * @return
	 */
	protected EditText findEditTextById(int id) {
		return (EditText) this.findViewById(id);
	}

	/**
	 * 按id查询LinearLayout
	 * 
	 * @param id
	 * @return
	 */
	protected LinearLayout findLinearLayoutById(int id) {
		return (LinearLayout) this.findViewById(id);
	}

	/**
	 * 按id查询RelativeLayout
	 * 
	 * @param id
	 * @return
	 */
	protected RelativeLayout findRelativeLayoutById(int id) {
		return (RelativeLayout) this.findViewById(id);
	}

	// -----------------share--------------------
	/**
	 * 保存String值到share
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean saveSharedPreferences(String key, String value) {
		SharedPreferences.Editor editor = getPrefrence().edit();
		try {
			editor.putString(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editor.commit();
	}

	/**
	 * 从share中获取key对应的值
	 * 
	 * @param key
	 * @param defaultStr默认值
	 * @return
	 */
	public String loadStringSharedPreference(String key, String defaultStr) {
		String str = null;
		try {
			str = getPrefrence().getString(key, defaultStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 保存int值到share
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean saveSharedPreferences(String key, int value) {
		SharedPreferences.Editor editor = getPrefrence().edit();
		editor.putInt(key, value);
		return editor.commit();
	}

	/**
	 * 从share中获取key对应的值
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public int loadIntSharedPreference(String key) {
		return getPrefrence().getInt(key, 0);
	}

	/**
	 * 保存float值到share
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean saveSharedPreferences(String key, float value) {
		SharedPreferences.Editor editor = getPrefrence().edit();
		editor.putFloat(key, value);
		return editor.commit();
	}

	/**
	 * 从share中获取key对应的值
	 * 
	 * @param key
	 * @param value默认值0f
	 * @return
	 */
	public float loadFloatSharedPreference(String key) {
		return getPrefrence().getFloat(key, 0f);
	}

	/**
	 * 保存Long值到share
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean saveSharedPreferences(String key, Long value) {
		SharedPreferences.Editor editor = getPrefrence().edit();
		editor.putLong(key, value);
		return editor.commit();
	}

	/**
	 * 从share中获取key对应的值
	 * 
	 * @param key
	 * @param value默认值0l
	 * @return
	 */
	public long loadLongSharedPreference(String key) {
		return getPrefrence().getLong(key, 0l);
	}

	/**
	 * 保存Boolean值到share
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean saveSharedPreferences(String key, Boolean value) {
		SharedPreferences.Editor editor = getPrefrence().edit();
		editor.putBoolean(key, value);
		return editor.commit();
	}

	/**
	 * 从share中获取key对应的值
	 * 
	 * @param key
	 * @param value默认值false
	 * @return
	 */
	public boolean loadBooleanSharedPreference(String key) {
		return getPrefrence().getBoolean(key, false);
	}

	/**
	 * 保存List<?> list值到share
	 * 
	 * @param key
	 * @param List
	 *            <?> list
	 * @return
	 */
	public boolean saveAllSharePreference(String keyName, List<?> list) {
		int size = list.size();
		if (size < 1) {
			return false;
		}
		SharedPreferences.Editor editor = getPrefrence().edit();
		if (list.get(0) instanceof String) {
			for (int i = 0; i < size; i++) {
				editor.putString(keyName + i, (String) list.get(i));
			}
		} else if (list.get(0) instanceof Long) {
			for (int i = 0; i < size; i++) {
				editor.putLong(keyName + i, (Long) list.get(i));
			}
		} else if (list.get(0) instanceof Float) {
			for (int i = 0; i < size; i++) {
				editor.putFloat(keyName + i, (Float) list.get(i));
			}
		} else if (list.get(0) instanceof Integer) {
			for (int i = 0; i < size; i++) {
				editor.putLong(keyName + i, (Integer) list.get(i));
			}
		} else if (list.get(0) instanceof Boolean) {
			for (int i = 0; i < size; i++) {
				editor.putBoolean(keyName + i, (Boolean) list.get(i));
			}
		}
		return editor.commit();
	}

	/**
	 * 从share中获取key对应的值
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, ?> loadAllSharePreference(String key) {
		return getPrefrence().getAll();
	}

	/**
	 * 从share中移除一个key和value
	 * 
	 * @param key
	 * @return
	 */
	public boolean removeKey(String key) {
		SharedPreferences.Editor editor = getPrefrence().edit();
		editor.remove(key);
		return editor.commit();
	}

	/**
	 * 从share中移除所有key和value
	 * 
	 * @return
	 */
	public boolean removeAllKey() {
		SharedPreferences.Editor editor = getPrefrence().edit();
		editor.clear();
		return editor.commit();
	}
}
