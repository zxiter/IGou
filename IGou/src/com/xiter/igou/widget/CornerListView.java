/**
 * 
 */
package com.xiter.igou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xiter.igou.R;

/**
 * Description:自定义圆角listview
 * 
 * @author liufeihua
 * @date 2014-11-21下午2:33:05
 * @version 1.0
 * 
 */
public class CornerListView extends ListView {

	/**
	 * @param context
	 */
	public CornerListView(Context context) {
		super(context);

	}

	public CornerListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			int x = (int) ev.getX();
			int y = (int) ev.getY();

			int position = pointToPosition(x, y);

			if (position == AdapterView.INVALID_POSITION) {
				break;
			} else {
				if (position == 0) {
					if (position == getAdapter().getCount() - 1) {
						setSelector(R.drawable.corner_all);
					} else {// 有多条数据，那这项就是第一项
						setSelector(R.drawable.corner_top);
					}

				} else if (position == getAdapter().getCount() - 1) {
					setSelector(R.drawable.corner_bottom);
				} else {
					setSelector(R.drawable.corner_middle);
				}
			}
		}

		case MotionEvent.ACTION_UP:
			break;

		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}
}
