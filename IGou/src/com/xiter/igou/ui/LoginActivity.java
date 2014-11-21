package com.xiter.igou.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiter.igou.R;
import com.xiter.igou.model.User;
import com.xiter.igou.ui.base.BaseActivity;
import com.xiter.igou.util.Config;
import com.xiter.igou.util.JSONUtil;
import com.xiter.igou.util.MD5Util;
import com.xiter.igou.widget.TopBar;

/**
 * Description:登录
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class LoginActivity extends BaseActivity implements OnClickListener {

	// 用户名
	private EditText mEtxtUserName;
	// 密码
	private EditText mEtxtPwd;

	// 自定义标题栏
	public TopBar mTopBar;

	private List<User> users = new ArrayList<User>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	// 设置布局
	@Override
	public int setLayout() {

		return R.layout.activity_login;
	}

	// 初始化用户名和密码
	@Override
	public void findById() {
		mEtxtUserName = (EditText) findViewById(R.id.etxt_username);
		mEtxtPwd = (EditText) findViewById(R.id.etxt_password);

	}

	// 初始化请求路径
	@Override
	public void initView() {
		url = Config.LOGIN;
	}

	// 自定义标题栏
	@Override
	public void initBar() {
		mTopBar = (TopBar) findViewById(R.id.topbar_login);
		mTopBar.showLeftButton(false);
		mTopBar.setRightButtonBackground(R.drawable.icon_top_right_selector);
		mTopBar.setRightButtonText(R.string.login);

		mTopBar.getRightButton().setTextColor(Color.WHITE);
		mTopBar.setRightButtonOnClickListener(this);
	}

	// 验正账号和密码,返回true则验证通过，否失败
	public boolean validator(String userName, String password) {
		if (TextUtils.isEmpty(userName)) {
			toast("账号不能为空");
			return false;
		}
		if (TextUtils.isEmpty(password)) {
			toast("密码不能为空");
			return false;
		}
		return true;
	}

	// 设置请求的参数
	public void setParams() {
		params.clear();
		params.put("userName", getText(mEtxtUserName));
		params.put("password", MD5Util.getMD5Str(getText(mEtxtPwd)));

	}

	// 处理返回结果
	@Override
	public void taskResult(boolean status, String info, Object data) {
		if (status) {
			String userJson = JSONUtil.toJson(data);
			User user = new Gson().fromJson(userJson, User.class);
			// User user = (User) data;
			users.add(user);
			String json = JSONUtil.toJson(users);
			// 返回前先保存在share
			saveSharedPreferences(Config.PRE_USER, json);

			Intent intent = new Intent();
			// 把数据返回给上一个页面
			intent.putExtra(Config.PRE_USER, json);
			setResult(RESULT_OK, intent);
			finish();
		}

	}

	// 初始化按钮
	@Override
	public void onClick(View v) {
		if (v.getId() == mTopBar.getRightButton().getId()) {
			if (validator(getText(mEtxtUserName), getText(mEtxtPwd))) {
				if (isExUser(getText(mEtxtUserName))) {
					toast("用户已存在");
					return;
				}
				setParams();
				defaultTask();
			}

		}

	}

	/**
	 * 根据用户名判断是否存在在share 中,如果存在就返回true,则false
	 * 
	 * @param userName
	 * @return
	 */
	public boolean isExUser(String userName) {
		String json = loadStringSharedPreference(Config.PRE_USER, "");
		List<User> user = JSONUtil.fromJson(json, new TypeToken<List<User>>() {
		});

		if (null != user) {
			users = user;
			for (User u : user) {
				if (userName.equals(u.getUserName())) {
					return true;
				}
			}
		}
		return false;
	}
}
