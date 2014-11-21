/**
 * 
 */
package com.xiter.igou.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Description:重新计算listview的高度=所有项高度+获取子项间分隔符占用的高度
 * 
 * @author liufeihua
 * @date 2014-11-21上午11:22:58
 * @version 1.0
 * 
 */
public class ListViewUtil {
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null)
			return;

		int totalHeight = 0;
		// listAdapter.getCount()返回数据项的数目

		int listCount = listAdapter.getCount();
		for (int i = 0; i < listCount; i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // 计算子项View 的宽高
			totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);
	}
}
