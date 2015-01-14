package com.mark.pro.app;

import com.mark.pro.app.guide.Guide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;

/**
 * 欢迎页面程序入口
 * 
 * @author Mark
 */
@SuppressLint("HandlerLeak")
public class WelcomeAct extends Activity{

	private boolean isFirstIn = false;//是 否 已 经 查 看 过
	private static final int TIME = 3000;//页 面 跳 转 时 沉 睡 时 间
	private static final int GO_HOME = 1000;//进 入 主 页 页 面
	private static final int GO_GUIDE = 1001;//进 入 引 导 页 面
	
	// 定 义 发 送 消 息 的 处 理(Android--Handler)
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			case GO_GUIDE:
				 goGuide();
				break;
			}
		};
	};
	
	// 初 始 化 欢 迎 页 面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		init();
	}
	
	// 存 储 以 查 看 过 的 页 面
	private void init(){
		//(Android---SharedPreferences) 简 单 数 据 的 信 息
		SharedPreferences perPreferences = getSharedPreferences("mark", MODE_PRIVATE);//MODE_PRIVATE：为默认操作模式，代表该文件是私有数据，只能被应用本身访问
		isFirstIn = perPreferences.getBoolean("isFirstIn", true);
		if (!isFirstIn){
			mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else{
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			// 将 已 经 查 看 过 的 引 导 页 保 存 起 来
			Editor editor = perPreferences.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}
	}
	
	// 如 果 程 序 已 经 被 打 开 过，以 后 只 进 入 欢 迎 页 面
	private void goHome(){
		//(Android---Intent) 传 入 页 面 跳 转
		Intent i = new Intent(WelcomeAct.this,MainActivity.class);
		startActivity(i);
		finish();
	}
	
	// 如 果 程 序 是 初 次 安 装，打 开 时 将 进 入 引 导 页 面
	private void goGuide(){
		//(Android---Intent) 传 入 页 面 跳 转
		Intent i = new Intent(WelcomeAct.this,Guide.class);
		startActivity(i);
		finish();
	}
}
