package com.xiter.igou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.xiter.igou.ui.MainTabActivity;

public class AppStart extends Activity implements AnimationListener {

	private ImageView mImgAlpha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appstart);

		findById();

		initView();
	}

	public void findById() {
		mImgAlpha = (ImageView) findViewById(R.id.img_alpha);
	}

	public void initView() {
		Animation animation = AnimationUtils.loadAnimation(this,
				R.anim.alpha_anim);
		animation.setAnimationListener(this);
		mImgAlpha.startAnimation(animation);
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		Intent intent = new Intent(this, MainTabActivity.class);
		startActivity(intent);
		Toast.makeText(this, "the end", 3000);

	}

	@Override
	public void onAnimationRepeat(Animation arg0) {

	}

	@Override
	public void onAnimationStart(Animation arg0) {

	}

}
