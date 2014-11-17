package com.xiter.igou.ui;

import java.util.HashMap;

import android.os.Bundle;

import com.xiter.igou.R;
import com.xiter.igou.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		initView();
	}

	@Override
	public void initView() {
		url = "base/syuser!doMobile_Login.gx";
		setParams("admin", "1");
		defaultTask();
	}

	public void setParams(String userName, String password) {
		params = new HashMap<String, Object>();
		params.put("username", userName);
		params.put("password", password);

	}

	@Override
	public void taskResult(boolean status, String info, Object data) {
		log(status + "");
	}
}
