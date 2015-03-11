package com.example.service.weather_service;

import java.util.Locale;

import com.example.AssisApplication;
import com.example.service.constants.ServiceConstants;
import com.example.weather.model.BaiduWeatherModel;
import com.example.weather.service.WeatherService;
import com.example.weather.service.impl.WeatherServiceImpl;
import com.example.weather.service.impl.WeatherServiceImpl.WeatherServiceCallBack;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

public class WeatherRemindActivity extends Activity {

	private static final String TAG = "Wea_TAG>>>>>>>>";

	private AssisApplication assisApplication = new AssisApplication();

	private static final WeatherService weatherService = new WeatherServiceImpl();

	private LocationReceive locationReceive = new LocationReceive();

	private IntentFilter intentFilter = new IntentFilter(
			ServiceConstants.LOCATION_BROADCAST_ACTION);

	private Ringtone ringtone;

	private TextToSpeech mSpeech;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		registerReceiver(locationReceive, intentFilter);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

	}

	public class LocationReceive extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// 接受到GPS定位信息就去查询天气情况
			String location = intent.getStringExtra("location");
			getWeatherInfo(location);
			unregisterReceiver(locationReceive);
		}

	}

	private void getWeatherInfo(String location) {
		weatherService.getBaiduWeatherModel(location,
				new WeatherServiceCallBack() {
					@Override
					public void callBack(BaiduWeatherModel baiduWeatherModel) {
						if (baiduWeatherModel == null) {
							return;
						} else {
							assisApplication = (AssisApplication) getApplication();
							assisApplication
									.setBaiduWeatherModel(baiduWeatherModel);
							openRemind();
						}
					}
				});
	}

	private void openRemind() {
		Uri defaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(
				this, RingtoneManager.TYPE_RINGTONE);
		BaiduWeatherModel baiduWeatherModel = assisApplication
				.getBaiduWeatherModel();
		if (baiduWeatherModel == null) {
			Log.i(TAG,
					"openRemind method is running , bun baiduWeatherModel is null");
			return;
		}
		TextToSpeech textToSpeech = new TextToSpeech(this,
				new OnInitListener() {
					@Override
					public void onInit(int status) {
						if (status == TextToSpeech.SUCCESS) {
							int result = mSpeech.setLanguage(Locale.CHINA);
							if (result == TextToSpeech.LANG_MISSING_DATA
									|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
								Log.e("bb", "not use");
							}
						}
					}
				});
		// MediaPlayer mediaPlayer = MediaPlayer.create(this,
		// defaultRingtoneUri);
		// mediaPlayer.start();
		// 启动提醒activity
		String weatherString = baiduWeatherModel.getWeather_data().get(0).getWeather();
		textToSpeech.speak("今天天气是"+weatherString, TextToSpeech.QUEUE_FLUSH, null);
		Intent remindIntent = new Intent();
	}
}
