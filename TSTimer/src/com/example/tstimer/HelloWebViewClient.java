package com.example.tstimer;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HelloWebViewClient extends WebViewClient {	
	private ProgressDialog mProgress1;
	
	public void onPageFinished(WebView View, String url) {
		if(mProgress1.isShowing()) {
			mProgress1.dismiss();
		}
	}
	public CharSequence getString(String string) {
		String strings = string;
		return strings;
	}
	public void onReceiveError(WebView view, int errorCode, String description, String failingUrl) {
		if(mProgress1.isShowing()) {
			mProgress1.dismiss();
		}
		finish();
	}
	private void finish() {
				
	}
	
	// http://blog.naver.com/ninace/80209629604
}
