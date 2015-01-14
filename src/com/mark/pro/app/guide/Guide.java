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
 * ViewPager的实现，实现左右滑动的引导页面效果
 * (主要用于初次安装app，打开时效果)
 * 
 * @author Mark
 */
@SuppressLint("InflateParams")
public class Guide extends Activity implements OnPageChangeListener{

	// 多 页 面 滑 动 切 换 承 载 对 象
	private ViewPager viewPager;
	
	// 滑 动 页 面 适 配 器
	private ViewPagerAdapter viewPagerAdapter;
	
	// 集 合 页 面 存 放
	private List<View> views;
	
	// 滑 动 页 面 点
	private ImageView[] points;
	// 小 图 标 点 集 合
	private int[] ids = { R.id.iv1, R.id.iv2, R.id.iv3 };
	
	// 定 义 进 入 应 用 主 页 面 的 按 钮
	private Button start_btn;
	
	/** 
	 * 创 建 引 导 页  主 函 数
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		
		initViews();
		
		initDots();
		
	}
	
	/**
	 * 初 始 化 三 个 页 面 活 动 图 片
	 */
	private void initViews(){
		// LayoutInflater 类 似 于 findViewById()
		// 不 同 点 是 LayoutInflater 是 用 来 找 res/layout/ 下 的 xml 布 局 文 件，并 且 实 例 化
		// findViewById() 是 找 xml 布 局 文 件 下 的 具 体 widget 控 件 如 Button、TextView
		LayoutInflater inflater = LayoutInflater.from(this);
		views = new ArrayList<View>();// 加 载 三 个 view 页 面
		views.add(inflater.inflate(R.layout.one, null));
		views.add(inflater.inflate(R.layout.two, null));
		views.add(inflater.inflate(R.layout.three, null));
		
		// 将 三 个 页 面 放 置 到 滑 动 页 面 适 配 器
		viewPagerAdapter = new ViewPagerAdapter(views, this);
		
		// 将 适 配 器放置到 滑 动 切 换 承 载 对 象
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		
		// 将 滑 动 空 间  放 置 在 展 现 的 ViewPager 中 显 示
		viewPager.setAdapter(viewPagerAdapter);
		
		// 初 始 化 引 导 页 的 按 钮
		start_btn = (Button) views.get(2).findViewById(R.id.start_btn);
		// 为 按 钮 绑 定 事 件 监 听 器
		start_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0){
				// 传 递 Intent 进 行 页 面 的 跳 转
				Intent i = new Intent(Guide.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		// 监 听 页 面 被 选 定 时 调 用
		viewPager.setOnPageChangeListener(this);
	}
	
	// 初 始 化 滑 动 原 点 小 图 标
	private void initDots() {
		points = new ImageView[views.size()];
		// 从 集 合 中 迭 代 出 来  然 后 初 始 化
		for (int i = 0; i < views.size(); i++) {
			points[i] = (ImageView) findViewById(ids[i]);
		}
	}

	// 当 滑 动 状 态 改 变 时 调 用
	@Override
	public void onPageScrollStateChanged(int arg0){
	}

	// 当 页 面 被 滑 动 时 调 用
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2){
	}
	
	// 当 前 新 的 页 面 被 选 定 时 调 用
	@Override
	public void onPageSelected(int arg0){
		// 小 图 标 点 的 集 合
		for (int i = 0; i < ids.length; i++) {
			if (arg0 == i) {// 当 选 中 时   图 片 是 亮 色
				points[i].setImageResource(R.drawable.login_point_selected);
			} else {// 当 划 过 时  图 片 是 暗 色
				points[i].setImageResource(R.drawable.login_point);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
