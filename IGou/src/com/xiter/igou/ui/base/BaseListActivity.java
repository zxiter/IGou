/**
 * 
 */
package com.xiter.igou.ui.base;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.xiter.igou.R;
import com.xiter.igou.util.Config;
import com.xiter.igou.widget.TopBar;
import com.xiter.xlistview.XListView;
import com.xiter.xlistview.XListView.IXListViewListener;

/**
 * Description:listview基础工具activity,实现它来获得基本的方法使用
 * 
 * @author liufeihua
 * @date 2014-11-17上午11:58:54
 * @version 1.0
 * 
 */
public class BaseListActivity extends BaseActivity implements
		IXListViewListener, OnItemClickListener {

	protected XListView mListView;

	protected int pageIndex = 1;// 起始页面

	protected int pageNormal = 0;// 表示请求的方式0表示正常请求,1下拉请求,2加载更多请求（下拉）

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initView() {
		initListView();
		norMal();

	}

	public void initListView() {

	}

	@Override
	public void findById() {
		mListView = (XListView) findViewById(R.id.lv_goodslist);
		mListView.setPullRefreshEnable(true);
		mListView.setPullLoadEnable(true);
		mListView.setXListViewListener(this);
		mListView.setOnItemClickListener(this);
	}

	@Override
	public void initBar() {
		mTopBar = (TopBar) findViewById(R.id.topbar);
		mTopBar.showLeftButton(false);
		mTopBar.showRightButton(false);
	}

	public void norMal() {
		getParams(pageIndex, 0);
		defaultTask();
	}

	/**
	 * 下拉操作
	 */
	@Override
	public void onRefresh() {
		getParams(pageIndex = 1, 1);
		defaultTask();
	}

	/**
	 * 下拉（加载更多）
	 */
	@Override
	public void onLoadMore() {
		getParams(++pageIndex, 2);
		defaultTask();
	}

	public void getParams(int pageIndex, int pagenormal) {
		pageNormal = pagenormal;
		params.put("pageIndex", pageIndex);
		params.put("pageSize", Config.PAGE_SIZE);
	}

	public void switchStop() {
		switch (pageNormal) {

		case 1:
			mListView.stopRefresh();
			// mListView.setPullRefreshEnable(false);
			break;
		case 2:
			mListView.stopMyLoadMore();

			// mListView.setPullLoadEnable(false);
			break;

		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}
}
