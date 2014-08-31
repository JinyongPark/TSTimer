package com.example.tstimer;

import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class JadyJavaScriptInterface {
	
	private final Handler handler = new Handler();
	private TextView textview;
		
	public JadyJavaScriptInterface() {
		
	}
	
	public void callAndroid(final String str) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				textview.setText("안드로이드님, 부르셨나요? 자바스크립트입니다.");
				Toast.makeText(MainActivity.this , str + "자바스크립트가 찾아왔아요!!", Toast.LENGTH_SHORT).show();
				
			}

				
		});
	}
}
