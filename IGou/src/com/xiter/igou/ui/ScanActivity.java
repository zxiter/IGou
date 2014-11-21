package com.xiter.igou.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.xiter.igou.R;

/**
 * Description:扫描
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class ScanActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scan, menu);
		return true;
	}

}
