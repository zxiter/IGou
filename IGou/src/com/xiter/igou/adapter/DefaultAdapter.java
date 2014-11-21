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

	/**
	 * 传进来的数据
	 */
	private List<T> list;

	/**
	 * 上下文
	 */
	protected Context mContext;

	public DefaultAdapter(Context context, List<T> list) {
		this.mContext = context;
		this.list = list;
	}

	/**
	 * 计算返回list的siez()
	 */
	@Override
	public int getCount() {

		return list == null ? 0 : list.size();
	}

	/**
	 * 返回点击项的对象
	 */
	@Override
	public Object getItem(int position) {

		return list.get(position);
	}

	/**
	 * 返回点击的id
	 */
	@Override
	public long getItemId(int position) {

		return position;
	}

	/**
	 * 绘制view
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return createView(position, convertView, parent);
	}

	/**
	 * 让子类实现
	 * 
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

	/**
	 * 添加所有
	 */
	public void addAll(List<T> items) {
		if (null == list) {
			list = new ArrayList<T>();

			list.addAll(items);

			notifyDataSetChanged();
		}
		// TODO
	}

	/**
	 * 清空list
	 */
	public void clear() {
		list.clear();
		notifyDataSetChanged();
	}

	/**
	 * 按位置移除
	 */
	public void remove(int position) {
		list.remove(position);
		notifyDataSetChanged();
	}
}
