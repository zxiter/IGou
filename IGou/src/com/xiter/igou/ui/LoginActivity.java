package com.xiter.igou.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.google.gson.Gson;
import com.xiter.igou.R;
import com.xiter.igou.ui.base.BaseActivity;
import com.xiter.igou.widget.TopBar;

public class LoginActivity extends BaseActivity implements OnClickListener {

	private EditText muserName;
	private EditText mpassword;

	public TopBar mTopBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public int setLayout() {

		return R.layout.activity_login;
	}

	@Override
	public void findById() {
		muserName = (EditText) findViewById(R.id.etxt_username);
		mpassword = (EditText) findViewById(R.id.etxt_password);

	}

	@Override
	public void initView() {
		url = "base/syuser!doMobile_Login.gx";
		setParams("admin", "1");
		defaultTask();
	}

	@Override
	public void initBar() {
		mTopBar = (TopBar) findViewById(R.id.topbar_login);
		mTopBar.showLeftButton(false);
		mTopBar.setRightButtonBackground(R.drawable.icon_top_right_selector);
		mTopBar.setRightButtonText(R.string.login);

		mTopBar.getRightButton().setTextColor(Color.WHITE);
		mTopBar.setRightButtonOnClickListener(this);
	}

	public void setParams(String userName, String password) {
		params.put("username", userName);
		params.put("password", password);

	}

	@Override
	public void taskResult(boolean status, String info, Object data) {
		log(status + "");
		if (!"".equals(info)) {
			toast("请求成功");
			log(status + new Gson().toJson(data).toString());
		}
	}

	public void onClickBtn(View view) {
		url = "base/tRdSPMessage!doMobile_MessageGrid.gx";
		map(1, 5);
		defaultTask();
	}

	public void map(int pageIndex, int pageSize) {
		params.clear();
		params.put("msgType", "3");
		params.put("page", pageIndex);
		params.put("rows", pageSize);
	}

	@Override
	public void onClick(View arg0) {
		toast("点击了登录了");

	}
}
