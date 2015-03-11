package com.example.weather.service;

import com.example.weather.service.WeatherServiceImpl.WeatherServiceCallBack;



public interface WeatherService {
	
	public void getBaiduWeatherModel(String location, WeatherServiceCallBack weatherServiceCallBack);

}
