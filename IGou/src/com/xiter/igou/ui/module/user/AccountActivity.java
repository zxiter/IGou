package com.xiter.igou.ui.module.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.gson.reflect.TypeToken;
import com.xiter.igou.R;
import com.xiter.igou.model.User;
import com.xiter.igou.ui.LoginActivity;
import com.xiter.igou.ui.base.BaseActivity;
import com.xiter.igou.util.Config;
import com.xiter.igou.util.JSONUtil;
import com.xiter.igou.widget.TopBar;

/**
 * Description:账号
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class AccountActivity extends BaseActivity implements OnClickListener {

	private ListView mListView;
	private List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();

	private SimpleAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int setLayout() {
		return R.layout.activity_account;
	}

	@Override
	public void findById() {
		mListView = (ListView) findViewById(R.id.lv_accounts);

		// 从share中查询数据
		String json = loadStringSharedPreference(Config.PRE_USER, "");

		datas = parseData(json);
		mAdapter = new SimpleAdapter(this, datas, R.layout.template_list_arrow,
				new String[] { "username" }, new int[] { android.R.id.text1 });

	}

	@Override
	public void initView() {
		mListView.setAdapter(mAdapter);
	}

	@Override
	public void initBar() {
		mTopBar = (TopBar) findViewById(R.id.topbar_account);
		mTopBar.showLeftButton(false);
		mTopBar.setRightButtonBackground(R.drawable.icon_top_right_selector);
		mTopBar.setRightButtonText(R.string.login);

		mTopBar.getRightButton().setTextColor(Color.WHITE);
		mTopBar.setRightButtonOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == mTopBar.getRightButton().getId()) {
			startActivityForResult(new Intent(this, LoginActivity.class), 1);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			// 拿到页面的返回值
			String json = data.getStringExtra(Config.PRE_USER);
			datas.clear();
			datas.addAll(parseData(json));
			// 通知listview更新界面
			mAdapter.notifyDataSetChanged();
		}
	}

	private List<HashMap<String, Object>> parseData(String json) {

		List<User> users = JSONUtil.fromJson(json, new TypeToken<List<User>>() {
		});
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		if (null != users && users.size() > 0) {
			for (User u : users) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("username", u.getUserName());
				data.add(map);
			}
		}
		return data;
	}
}
