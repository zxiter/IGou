package com.xiter.igou.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

import com.xiter.igou.R;
import com.xiter.igou.ui.base.BaseActivity;
import com.xiter.igou.ui.module.user.AccountActivity;
import com.xiter.igou.util.DataUtil;
import com.xiter.igou.util.ListViewUtil;
import com.xiter.igou.widget.CornerListView;
import com.xiter.igou.widget.TopBar;

/**
 * Description:更多
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class MoreActivity extends BaseActivity {

	private CornerListView mListView1;
	private CornerListView mListView2;

	private SimpleAdapter mAdapter1;
	private SimpleAdapter mAdapter2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int setLayout() {

		return R.layout.activity_more;
	}

	@Override
	public void findById() {
		mListView1 = (CornerListView) findViewById(R.id.lv_appmanage);
		mListView2 = (CornerListView) findViewById(R.id.lv_other);

		mAdapter1 = new SimpleAdapter(this, DataUtil.getData(),
				R.layout.template_list_arrow, new String[] { "name" },
				new int[] { android.R.id.text1 });
		mAdapter2 = new SimpleAdapter(this, DataUtil.getData1(),
				R.layout.template_list_arrow, new String[] { "name" },
				new int[] { android.R.id.text1 });
	}

	@Override
	public void initView() {
		mListView1.setAdapter(mAdapter1);
		mListView2.setAdapter(mAdapter2);
		mListView1.setOnItemClickListener(new ListViewOnClick1());
		mListView2.setOnItemClickListener(new ListViewOnClick2());
		ListViewUtil.setListViewHeightBasedOnChildren(mListView1);
		ListViewUtil.setListViewHeightBasedOnChildren(mListView2);
	}

	@Override
	public void initBar() {
		mTopBar = (TopBar) findViewById(R.id.topbar_more);
		mTopBar.showLeftButton(false);
		mTopBar.showRightButton(false);
	}

	class ListViewOnClick1 implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			log(position + "mListView1");
			switch (position) {
			case 0:
				Intent intent = new Intent(MoreActivity.this,
						AccountActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}

		}

	}

	class ListViewOnClick2 implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			log(arg2 + "mListView2");

		}

	}

}
