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
 * ��ӭҳ��������
 * 
 * @author Mark
 */
@SuppressLint("HandlerLeak")
public class WelcomeAct extends Activity{

	private boolean isFirstIn = false;//�� �� �� �� �� �� ��
	private static final int TIME = 3000;//ҳ �� �� ת ʱ �� ˯ ʱ ��
	private static final int GO_HOME = 1000;//�� �� �� ҳ ҳ ��
	private static final int GO_GUIDE = 1001;//�� �� �� �� ҳ ��
	
	// �� �� �� �� �� Ϣ �� �� ��(Android--Handler)
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
	
	// �� ʼ �� �� ӭ ҳ ��
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		init();
	}
	
	// �� �� �� �� �� �� �� ҳ ��
	private void init(){
		//(Android---SharedPreferences) �� �� �� �� �� �� Ϣ
		SharedPreferences perPreferences = getSharedPreferences("mark", MODE_PRIVATE);//MODE_PRIVATE��ΪĬ�ϲ���ģʽ��������ļ���˽�����ݣ�ֻ�ܱ�Ӧ�ñ������
		isFirstIn = perPreferences.getBoolean("isFirstIn", true);
		if (!isFirstIn){
			mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else{
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			// �� �� �� �� �� �� �� �� �� ҳ �� �� �� ��
			Editor editor = perPreferences.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}
	}
	
	// �� �� �� �� �� �� �� �� �� ������ �� ֻ �� �� �� ӭ ҳ ��
	private void goHome(){
		//(Android---Intent) �� �� ҳ �� �� ת
		Intent i = new Intent(WelcomeAct.this,MainActivity.class);
		startActivity(i);
		finish();
	}
	
	// �� �� �� �� �� �� �� �� װ���� �� ʱ �� �� �� �� �� ҳ ��
	private void goGuide(){
		//(Android---Intent) �� �� ҳ �� �� ת
		Intent i = new Intent(WelcomeAct.this,Guide.class);
		startActivity(i);
		finish();
	}
}
