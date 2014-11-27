package com.xiter.igou.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiter.igou.R;
import com.xiter.igou.adapter.DefaultAdapter;
import com.xiter.igou.adapter.GoodsAdapter;
import com.xiter.igou.model.Goods;
import com.xiter.igou.ui.base.BaseListActivity;
import com.xiter.igou.ui.module.good.GoodDetailActivity;
import com.xiter.igou.util.Config;
import com.xiter.igou.util.DateUtil;
import com.xiter.igou.util.JSONUtil;

/**
 * Description:主页
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class HomeActivity extends BaseListActivity {

	// private ListView mListView;

	private DefaultAdapter<Goods> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int setLayout() {

		return R.layout.activity_home;
	}

	@Override
	public void initListView() {
		url = Config.FIND_GOODS;
	}

	@Override
	public void taskResult(boolean status, String info, Object data) {

		if (status) {

			if (data != null) {
				ui(data);
			} else {
				switchStop();
			}

		}
	}

	/**
	 * @param data
	 */
	private void ui(Object data) {
		String userJson = JSONUtil.toJson(data);
		List<Goods> goods = new Gson().fromJson(userJson,
				new TypeToken<List<Goods>>() {
				}.getType());

		if (goods.size() >= 1) {
			switchResult(goods);
		} else {

			switchStop();
		}

	}

	/**
	 * @param goods
	 */
	private void switchResult(List<Goods> goods) {
		switch (pageNormal) {
		case 0:
			mAdapter = new GoodsAdapter(this, goods);
			mListView.setAdapter(mAdapter);
			break;
		case 1:
			mAdapter.clear();
			mAdapter.addAll(goods);
			mListView.setRefreshTime(DateUtil.getDateToString());
			mListView.stopRefresh();
			break;
		case 2:
			mAdapter.addAll(goods);
			if (goods.size() == Config.PAGE_SIZE) {
				mListView.stopLoadMore();
			} else {
				mListView.stopMyLoadMore();
			}

			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Goods goods = (Goods) parent.getAdapter().getItem(position);

		Intent intent = new Intent(this, GoodDetailActivity.class);

		Bundle bundle = new Bundle();
		bundle.putSerializable("goods", goods);
		intent.putExtras(bundle);

		startActivity(intent);
	}

}
