package com.example.weather.model.domain;

/**
 * 根据天气情况, 给出具体建议
 * @author Administrator
 *
 */
public class WeatherSuggestDomain {

	/**
	 * 具体动则, 如洗车等
	 */
	private String title;

	/**
	 * 执行程度, 如不宜洗车
	 */
	private String zs;
	
	/**
	 * 指数
	 */
	private String tipt;

	/**
	 * 具体建议
	 */
	private String des;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getZs() {
		return zs;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

	public String getTipt() {
		return tipt;
	}

	public void setTipt(String tipt) {
		this.tipt = tipt;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "WeatherSuggestDomain [title=" + title + ", zs=" + zs
				+ ", tipt=" + tipt + ", des=" + des + "]";
	}

}
