package com.mark.pro.app.guide;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * 控件的滑动效果
 * @author Mark
 */
public class ViewPagerAdapter extends PagerAdapter{
	
	private List<View> views;//承载页面的View集合
	@SuppressWarnings("unused")
	private Context context;//上下文
	
	public ViewPagerAdapter(List<View> views,Context context){
		this.views = views;
		this.context = context;
	}
	
	//销毁已废除的View
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	//加载view的方法
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager) container).addView(views.get(position));
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}

	//判断当前的View是否是需要的对象
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}

}
