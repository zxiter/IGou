package com.xiter.igou.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.xiter.igou.R;

public class MainTabActivity extends TabActivity implements OnClickListener {

	private TabHost mTabHost;
	private TabWidget mTabWidget;

	private RelativeLayout mHomeIndicator, mMoreIndicator, mCameraIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_tab);

		findById();

		initIndicator();

		initTabSpec();

		initView();
	}

	private void initIndicator() {
		mHomeIndicator = (RelativeLayout) LayoutInflater.from(this).inflate(
				R.layout.tab_indicator, mTabWidget, false);

		TextView homeTv = (TextView) mHomeIndicator
				.findViewById(R.id.tabitem_title);
		ImageView homeIconView = (ImageView) mHomeIndicator
				.findViewById(R.id.tabitem_icon);
		homeTv.setText(R.string.home);
		homeIconView.setBackgroundResource(R.drawable.selector_main_tab_home);

		mCameraIndicator = (RelativeLayout) LayoutInflater.from(this).inflate(
				R.layout.tab_indicator_camera, mTabWidget, false);

		ImageView cameraIconView = (ImageView) mCameraIndicator
				.findViewById(R.id.tabitem_icon);
		cameraIconView
				.setBackgroundResource(R.drawable.selector_main_tab_camera);

		mMoreIndicator = (RelativeLayout) LayoutInflater.from(this).inflate(
				R.layout.tab_indicator, mTabWidget, false);

		TextView moreTv = (TextView) mMoreIndicator
				.findViewById(R.id.tabitem_title);
		ImageView moreIconView = (ImageView) mMoreIndicator
				.findViewById(R.id.tabitem_icon);
		moreTv.setText(R.string.more);
		moreIconView.setBackgroundResource(R.drawable.selector_main_tab_more);
	}

	private void initTabSpec() {
		TabSpec homesSpec = mTabHost.newTabSpec("home");
		homesSpec.setIndicator(mHomeIndicator);
		homesSpec.setContent(new Intent(this, HomeActivity.class));

		TabSpec moresSpec = mTabHost.newTabSpec("more");
		moresSpec.setIndicator(mMoreIndicator);
		moresSpec.setContent(new Intent(this, MoreActivity.class));

		TabSpec cameraSpec = mTabHost.newTabSpec("camera");
		cameraSpec.setIndicator(mCameraIndicator);
		cameraSpec.setContent(new Intent(this, ScanActivity.class));

		mTabHost.addTab(homesSpec);
		mTabHost.addTab(cameraSpec);
		mTabHost.addTab(moresSpec);

	}

	private void initView() {
		View view = mTabWidget.getChildAt(1);
		view.setOnClickListener(this);

	}

	private void findById() {
		mTabHost = getTabHost();
		mTabWidget = getTabWidget();

	}

	@Override
	public void onClick(View arg0) {
		Toast.makeText(this, "you click camera button ", 3000).show();
	}

}
