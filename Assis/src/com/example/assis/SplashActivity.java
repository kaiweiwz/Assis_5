package com.example.assis;

import com.example.MainScreenActivity;
import com.example.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//    	requestWindowFeature(Window.FEATURE_NO_TITLE);
//    	getWindow().setFormat(PixelFormat.RGB_565);
//    //	getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.splash_screen);
    	new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent toMainActvity = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(toMainActvity);
				finish();
			}
		},2000);
    }
}
