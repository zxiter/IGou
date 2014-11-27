package com.xiter.igou.ui.module.good;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiter.igou.R;
import com.xiter.igou.model.Goods;
import com.xiter.igou.ui.base.DefaultActivity;
import com.xiter.igou.util.ImageUtil;
import com.xiter.igou.widget.TopBar;

public class GoodDetailActivity extends DefaultActivity {

	private ImageView mImgPhoto;
	private TextView mTxtGoodsName;
	private TextView mTxtShopName;
	private TextView mTxtPrice;
	private TextView mTxtWeight;
	private TextView mTxtColor;
	private TextView mTxtProducer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int setLayout() {

		return R.layout.activity_good_detail;
	}

	@Override
	public void findById() {
		mImgPhoto = this.findImageViewById(R.id.img_photo);
		mTxtGoodsName = this.findTextViewById(R.id.txt_goods_name);
		mTxtShopName = this.findTextViewById(R.id.txt_shop_name);
		mTxtPrice = this.findTextViewById(R.id.txt_price);
		mTxtWeight = this.findTextViewById(R.id.txt_weight);
		mTxtColor = this.findTextViewById(R.id.txt_color);
		mTxtProducer = this.findTextViewById(R.id.txt_producer);
	}

	@Override
	public void initView() {

		Goods goods = (Goods) getIntent().getSerializableExtra("goods");

		if (null == goods)
			toast("商品信息为空");
		else {
			ImageUtil.setImage(goods.getThumbnail(), mImgPhoto);
			mTxtGoodsName.setText(goods.getName());
			mTxtShopName.setText(goods.getShopId());
			mTxtPrice.setText(goods.getPrice());
			mTxtWeight.setText(goods.getWeight());
			mTxtColor.setText(goods.getColor());
			mTxtProducer.setText(goods.getProducer());

		}
	}

	@Override
	public void initBar() {
		this.mTopBar = (TopBar) this.findViewById(R.id.topbar);
		mTopBar.showLeftButton(true);
		mTopBar.showRightButton(false);
		mTopBar.setLeftButtonBackground(R.drawable.icon_top_left_selector);
		mTopBar.setLeftButtonText(R.string.back);
		mTopBar.getLeftButton().setTextColor(Color.WHITE);

		mTopBar.setLeftButtonOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		this.finish();

	}

}
