package com.example.assis;






import com.example.R;
import com.example.service.gps_service.GPSService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends Activity {
	
	private static final String TAG = "WEB_TAG";

	
	private Button button1;
	
	//服务意图
	Intent intentForGps;
	
	Intent intentForWeather;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initIntent();
		init();
	}

	private void initIntent(){
		intentForGps = new Intent(MainActivity.this, GPSService.class);
		startService(intentForGps);
	}
	
	private void init() {
         button1 = (Button) findViewById(R.id.button1);
         button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(intentForGps);
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		//停止服务	
		super.onDestroy();
		stopService(intentForGps);
		stopService(intentForWeather);
	}
	
	
}
