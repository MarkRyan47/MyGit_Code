package com.mark.pro.app.guide;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.mark.pro.app.MainActivity;
import com.mark.pro.app.R;

/**
 * ViewPager��ʵ�֣�ʵ�����һ���������ҳ��Ч��
 * (��Ҫ���ڳ��ΰ�װapp����ʱЧ��)
 * 
 * @author Mark
 */
@SuppressLint("InflateParams")
public class Guide extends Activity implements OnPageChangeListener{

	// �� ҳ �� �� �� �� �� �� �� �� ��
	private ViewPager viewPager;
	
	// �� �� ҳ �� �� �� ��
	private ViewPagerAdapter viewPagerAdapter;
	
	// �� �� ҳ �� �� ��
	private List<View> views;
	
	// �� �� ҳ �� ��
	private ImageView[] points;
	// С ͼ �� �� �� ��
	private int[] ids = { R.id.iv1, R.id.iv2, R.id.iv3 };
	
	// �� �� �� �� Ӧ �� �� ҳ �� �� �� ť
	private Button start_btn;
	
	/** 
	 * �� �� �� �� ҳ  �� �� ��
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		
		initViews();
		
		initDots();
		
	}
	
	/**
	 * �� ʼ �� �� �� ҳ �� �� �� ͼ Ƭ
	 */
	private void initViews(){
		// LayoutInflater �� �� �� findViewById()
		// �� ͬ �� �� LayoutInflater �� �� �� �� res/layout/ �� �� xml �� �� �� ������ �� ʵ �� ��
		// findViewById() �� �� xml �� �� �� �� �� �� �� �� widget �� �� �� Button��TextView
		LayoutInflater inflater = LayoutInflater.from(this);
		views = new ArrayList<View>();// �� �� �� �� view ҳ ��
		views.add(inflater.inflate(R.layout.one, null));
		views.add(inflater.inflate(R.layout.two, null));
		views.add(inflater.inflate(R.layout.three, null));
		
		// �� �� �� ҳ �� �� �� �� �� �� ҳ �� �� �� ��
		viewPagerAdapter = new ViewPagerAdapter(views, this);
		
		// �� �� �� �����õ� �� �� �� �� �� �� �� ��
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		
		// �� �� �� �� ��  �� �� �� չ �� �� ViewPager �� �� ʾ
		viewPager.setAdapter(viewPagerAdapter);
		
		// �� ʼ �� �� �� ҳ �� �� ť
		start_btn = (Button) views.get(2).findViewById(R.id.start_btn);
		// Ϊ �� ť �� �� �� �� �� �� ��
		start_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0){
				// �� �� Intent �� �� ҳ �� �� �� ת
				Intent i = new Intent(Guide.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		// �� �� ҳ �� �� ѡ �� ʱ �� ��
		viewPager.setOnPageChangeListener(this);
	}
	
	// �� ʼ �� �� �� ԭ �� С ͼ ��
	private void initDots() {
		points = new ImageView[views.size()];
		// �� �� �� �� �� �� �� ��  Ȼ �� �� ʼ ��
		for (int i = 0; i < views.size(); i++) {
			points[i] = (ImageView) findViewById(ids[i]);
		}
	}

	// �� �� �� ״ ̬ �� �� ʱ �� ��
	@Override
	public void onPageScrollStateChanged(int arg0){
	}

	// �� ҳ �� �� �� �� ʱ �� ��
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2){
	}
	
	// �� ǰ �� �� ҳ �� �� ѡ �� ʱ �� ��
	@Override
	public void onPageSelected(int arg0){
		// С ͼ �� �� �� �� ��
		for (int i = 0; i < ids.length; i++) {
			if (arg0 == i) {// �� ѡ �� ʱ   ͼ Ƭ �� �� ɫ
				points[i].setImageResource(R.drawable.login_point_selected);
			} else {// �� �� �� ʱ  ͼ Ƭ �� �� ɫ
				points[i].setImageResource(R.drawable.login_point);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
