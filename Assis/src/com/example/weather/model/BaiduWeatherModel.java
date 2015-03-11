package com.example.weather.model;

import java.util.List;

import com.example.weather.model.domain.WeatherDomain;
import com.example.weather.model.domain.WeatherSuggestDomain;


public class BaiduWeatherModel {
	
	private String currentCity;

	private String pm25;


	/**
	 * 索引今后每天的出行建议
	 * 0:今天, 1:明天, 2:后天:, 3:大后天
	 */
	private List<WeatherSuggestDomain> index;
	
	/**
	 * 索引今后每天的天气情况
	 * 0:今天, 1:明天, 2:后天:, 3:大后天
	 */
	private List<WeatherDomain> weather_data;

	
	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public void setIndex(List<WeatherSuggestDomain> index) {
		this.index = index;
	}

	public List<WeatherDomain> getWeather_data() {
		return weather_data;
	}

	public void setWeather_data(List<WeatherDomain> weather_data) {
		this.weather_data = weather_data;
	}

	public List<WeatherSuggestDomain> getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "BaiduWeatherModel [currentCity=" + currentCity + ", pm25="
				+ pm25 + ", index=" + index + ", weather_data=" + weather_data
				+ "]";
	}

}
