package com.mark.pro.app.guide;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * �ؼ��Ļ���Ч��
 * @author Mark
 */
public class ViewPagerAdapter extends PagerAdapter{
	
	private List<View> views;//����ҳ���View����
	@SuppressWarnings("unused")
	private Context context;//������
	
	public ViewPagerAdapter(List<View> views,Context context){
		this.views = views;
		this.context = context;
	}
	
	//�����ѷϳ���View
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	//����view�ķ���
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager) container).addView(views.get(position));
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}

	//�жϵ�ǰ��View�Ƿ�����Ҫ�Ķ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}

}
