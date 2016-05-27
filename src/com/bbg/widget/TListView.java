package com.bbg.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;

public class TListView extends ListView implements OnScrollListener {
	private List<OnScrollListener> mOnScrollListeners;
	private boolean unScroll;

	public TListView(Context context) {
		this(context, null);
	}

	public TListView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public TListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		this.mOnScrollListeners = new ArrayList<OnScrollListener>();
		this.unScroll = false;
		super.setOnScrollListener(this);
		setOverScrollMode(2);

	}

	public void setOnScrollListener(OnScrollListener l) {

		this.mOnScrollListeners.add(l);
	}

	public void removeOnScrollListener(OnScrollListener l) {

		if (l != null) {
			this.mOnScrollListeners.remove(l);
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		for (OnScrollListener l : this.mOnScrollListeners) {
			l.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
		}

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		for (OnScrollListener l : this.mOnScrollListeners) {
			if (l != null) {
				l.onScrollStateChanged(view, scrollState);
			}
		}

	}

}
