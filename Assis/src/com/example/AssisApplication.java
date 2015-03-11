package com.example;

import com.example.weather.model.BaiduWeatherModel;

import android.app.Application;

public class AssisApplication extends Application{

	private BaiduWeatherModel baiduWeatherModel;
	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	public BaiduWeatherModel getBaiduWeatherModel() {
		return baiduWeatherModel;
	}

	public void setBaiduWeatherModel(BaiduWeatherModel baiduWeatherModel) {
		this.baiduWeatherModel = baiduWeatherModel;
	}
	
	
}
