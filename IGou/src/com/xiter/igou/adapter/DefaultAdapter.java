/**
 * 
 */
package com.xiter.igou.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Description:适配器的基类
 * 
 * @author liufeihua
 * @date 2014-11-21下午3:16:57
 * @version 1.0
 * 
 */
public abstract class DefaultAdapter<T> extends BaseAdapter {

	private List<T> list;

	protected Context mContext;

	public DefaultAdapter(Context context, List<T> list) {
		this.mContext = context;
		this.list = list;
	}

	@Override
	public int getCount() {

		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {

		return list.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return createView(position, convertView, parent);
	}

	/**
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	public abstract View createView(int position, View convertView,
			ViewGroup parent);

	public List<T> getList() {
		return list;
	}

	public void addAll(List<T> items) {
		if (null == list) {
			list = new ArrayList<T>();

			list.addAll(items);

			notifyDataSetChanged();
		}
	}

	public void clear() {
		list.clear();
		notifyDataSetChanged();
	}

	public void remove(int position) {
		list.remove(position);
		notifyDataSetChanged();
	}
}
