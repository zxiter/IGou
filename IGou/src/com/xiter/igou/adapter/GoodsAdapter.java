/**
 * 
 */
package com.xiter.igou.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiter.igou.R;
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

		ViewHolder holder;

		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.tempelet_goods_list, null);

			holder = new ViewHolder();
			holder.img_photo = (ImageView) convertView
					.findViewById(R.id.imgv_goods_photo);
			holder.txt_title = (TextView) convertView
					.findViewById(R.id.txt_goods_title);
			holder.txt_desc = (TextView) convertView
					.findViewById(R.id.txt_goods_desc);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Goods g = getData(position);
		holder.txt_title.setText(g.getName());
		holder.txt_desc.setText(g.getDescribes());
		return convertView;
	}

	static class ViewHolder {

		ImageView img_photo;

		TextView txt_title;

		TextView txt_desc;
	}

}
