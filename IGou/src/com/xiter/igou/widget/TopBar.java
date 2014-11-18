package com.xiter.igou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.xiter.igou.R;

public class TopBar extends RelativeLayout implements OnClickListener {

	private Context mContext;

	private Button mLeftBtn;
	private Button mRightBtn;

	private OnClickListener mLeftButtonOnClickListener;
	private OnClickListener mRightButtonOnClickListener;

	public TopBar(Context context) {
		this(context, null);
	}

	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);

		this.mContext = context;

		init();
	}

	public Button getLeftButton() {
		return mLeftBtn;
	}

	public Button getRightButton() {
		return mRightBtn;
	}

	/**
	 * 设置左边按钮的点击监听器
	 * 
	 * @param onClickListener
	 */
	public void setLeftButtonOnClickListener(OnClickListener onClickListener) {
		this.mLeftButtonOnClickListener = onClickListener;
	}

	public void setRightButtonOnClickListener(OnClickListener onClickListener) {
		this.mRightButtonOnClickListener = onClickListener;
	}

	/**
	 * 初始化
	 */
	private void init() {

		LayoutInflater.from(mContext).inflate(R.layout.topbar, this, true);

		mLeftBtn = (Button) this.findViewById(R.id.btn_topbar_let);
		mRightBtn = (Button) this.findViewById(R.id.btn_topbar_right);

		mLeftBtn.setOnClickListener(this);
		mRightBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		int buttonId = v.getId();

		if (buttonId == R.id.btn_topbar_let) {
			doLeftButtonClick(v);
		} else if (buttonId == R.id.btn_topbar_right) {
			doRightButtonClick(v);
		}
		/*
		 * switch (buttonId) {
		 * 
		 * case R.id.btn_topbar_let: doLeftButtonClick(v); break;
		 * 
		 * case R.id.btn_topbar_right: doRightButtonClick(v); break;
		 * 
		 * default: break; }
		 */
	}

	/**
	 * 左边按钮的点击事件
	 * 
	 * @param v
	 */
	private void doLeftButtonClick(View v) {
		if (null != mLeftButtonOnClickListener)
			mLeftButtonOnClickListener.onClick(v);
	}

	/**
	 * 右边按钮的点击事件
	 * 
	 * @param v
	 */
	private void doRightButtonClick(View v) {
		if (null != mRightButtonOnClickListener)
			mRightButtonOnClickListener.onClick(v);
	}

	/**
	 * 设置左边按钮的文字
	 * 
	 * @param resId
	 */
	public void setLeftButtonText(int resId) {
		this.mLeftBtn.setText(resId);
	}

	/**
	 * 设置右边按钮的文字
	 * 
	 * @param resId
	 */
	public void setRightButtonText(int resId) {
		this.mRightBtn.setText(resId);
	}

	public void setLeftButtonBackground(int resId) {
		this.mLeftBtn.setBackgroundDrawable(mContext.getResources()
				.getDrawable(resId));
	}

	public void setRightButtonBackground(int resId) {
		this.mRightBtn.setBackgroundDrawable(mContext.getResources()
				.getDrawable(resId));
	}

	public void showLeftButton(boolean flag) {

		// 显示
		if (flag) {
			// if(!mLeftBtn.isShown())
			this.mLeftBtn.setVisibility(View.VISIBLE);
		} else {
			// if(mLeftBtn.isShown())
			this.mLeftBtn.setVisibility(View.INVISIBLE);
		}
	}

	public void showRightButton(boolean flag) {
		// 显示
		if (flag) {
			this.mRightBtn.setVisibility(View.VISIBLE);
		} else {
			this.mRightBtn.setVisibility(View.INVISIBLE);
		}
	}

}
