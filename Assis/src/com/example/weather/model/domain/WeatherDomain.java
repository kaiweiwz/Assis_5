package com.example.weather.model.domain;

public class WeatherDomain {
	
    private String data;
    
    private String weather;
    
    private String wind;
    
    private String temperature;

    private String dayPictureUrl;
    
    private String nightPictureUrl;
    
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDayPictureUrl() {
		return dayPictureUrl;
	}

	public void setDayPictureUrl(String dayPictureUrl) {
		this.dayPictureUrl = dayPictureUrl;
	}

	public String getNightPictureUrl() {
		return nightPictureUrl;
	}

	public void setNightPictureUrl(String nightPictureUrl) {
		this.nightPictureUrl = nightPictureUrl;
	}

	@Override
	public String toString() {
		return "WeatherDomain [data=" + data + ", weather=" + weather
				+ ", wind=" + wind + ", temperature=" + temperature
				+ ", dayPictureUrl=" + dayPictureUrl + ", nightPictureUrl="
				+ nightPictureUrl + "]";
	}
    
}
