/**
 * 
 */
package com.xiter.igou.app;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.xiter.igou.http.BaseHttpClient;
import com.xiter.igou.util.Config;

/**
 * Descriptionan：自管理Activity
 * 
 * @author liufeihua
 * @date 2014-11-17上午10:22:05
 * @version 1.0
 * 
 */
public class BaseApplication extends Application {

	private Stack<Activity> activityStack;

	private static BaseApplication instance;

	@Override
	public void onCreate() {
		instance = this;
		init();
	}

	public static BaseApplication getInstance() {
		return instance;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 获取版本号
	 */
	public int getAppVersionCode() {
		int version = 0;
		PackageManager pm = getPackageManager();
		PackageInfo pi;
		try {
			pi = pm.getPackageInfo(getPackageName(), 0);
			version = pi.versionCode;
		} catch (NameNotFoundException e) {
		}
		return version;
	}

	/**
	 * 获取版本号
	 */
	public String getAppVersionName() {
		String name = "";
		PackageManager pm = getPackageManager();
		PackageInfo pi;
		try {
			pi = pm.getPackageInfo(getPackageName(), 0);
			name = pi.versionName;
		} catch (NameNotFoundException e) {
		}
		return name;
	}

	private void init() {
		activityStack = new Stack<Activity>();

		// 初始化数据库管理器
		// new DBManager(this);
		// 初始化HttpClient,调用静态方法
		BaseHttpClient.initHttpClient();

	}

	public SharedPreferences getPrefrence() {
		SharedPreferences pre = getSharedPreferences(Config.PRE_CLIENT,
				Context.MODE_PRIVATE);
		return pre;
	}

	/**
	 * 退出应用程序
	 */
	@SuppressWarnings("deprecation")
	public void AppExit() {
		try {
			finishAllActivity();
			ActivityManager activityMgr = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(getPackageName());
			System.exit(0);
		} catch (Exception e) {

		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}
}
