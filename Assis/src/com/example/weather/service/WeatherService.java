package com.example.weather.service;

import com.example.weather.service.impl.WeatherServiceImpl.WeatherServiceCallBack;


public interface WeatherService {
	
	public void getBaiduWeatherModel(String location, WeatherServiceCallBack weatherServiceCallBack);

}
