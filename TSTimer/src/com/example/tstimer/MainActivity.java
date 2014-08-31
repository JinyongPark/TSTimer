package com.example.tstimer;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private WebView webview;
	private TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		// 웹뷰 생성
		webview = (WebView) findViewById(R.id.webview);
		
		// 자바스크립트 > 안드로이드  호출여부 확인 (textView 변경)
		textview = (TextView) findViewById(R.id.textview);
		
		// 프로그레스바 호출
		webview.setWebViewClient(new HelloWebViewClient());
		webview.setWebChromeClient(new WebChromeClient());
		
		// 자바스크립트 허용
		webview.getSettings().setJavaScriptEnabled(true);
		
		// 클래스 별칭 지정
		webview.addJavascriptInterface(new JadyJavaScriptInterface(), "CallMethodNameIsJady");
		
		webview.loadUrl("http://ggstroy.com/test.php");				
	}
	
	// 안드로이드 > 자바스크립트 호출
	public void jsCall(View v) {
		webview.loadUrl("javascript:callJs()");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
}
