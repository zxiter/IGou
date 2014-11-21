/**
 * 
 */
package com.xiter.igou.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.xiter.igou.model.Goods;

/**
 * Description:自定义商品适配器
 * 
 * @author liufeihua
 * @date 2014-11-21下午3:49:54
 * @version 1.0
 * 
 */
public class GoodsAdapter extends DefaultAdapter<Goods> {

	/**
	 * @param context
	 * @param list
	 */
	public GoodsAdapter(Context context, List<Goods> list) {
		super(context, list);

	}

	@Override
	public View createView(int position, View convertView, ViewGroup parent) {

		return null;
	}

}
