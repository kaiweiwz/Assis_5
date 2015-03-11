package com.example.weather.model;

import java.util.List;

import com.example.weather.model.domain.WeatherDomain;
import com.example.weather.model.domain.WeatherSuggestDomain;


public class BaiduWeatherModel {
	
	private String currentCity;

	private String pm25;


	/**
	 * �������ÿ��ĳ��н���
	 * 0:����, 1:����, 2:����:, 3:�����
	 */
	private List<WeatherSuggestDomain> index;
	
	/**
	 * �������ÿ����������
	 * 0:����, 1:����, 2:����:, 3:�����
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
