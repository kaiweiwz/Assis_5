package com.example.assis_3.extensions.sample;

import com.example.assis_3.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

public class SettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.settings);
	}

	private void initActionBar() {
		getActionBar().setTitle("设置");
		//getActionBar().setLogo(R.drawable.btn_back_normal);
		int color = Color.parseColor("#FFC74B46");
		Drawable colorDrawable = new ColorDrawable(color);
		getActionBar().setBackgroundDrawable(colorDrawable);
		getActionBar().setDisplayShowTitleEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			SettingActivity.this.finish();
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
			return true;
		default:
			return true;
		}
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
}
