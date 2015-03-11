package com.example.weather.model;

/**
 * ����������, ������彨��
 * @author Administrator
 *
 */
public class WeatherSuggestDomain {

	/**
	 * ���嶯��, ��ϴ����
	 */
	private String title;

	/**
	 * ִ�г̶�, �粻��ϴ��
	 */
	private String zs;
	
	/**
	 * ָ��
	 */
	private String tipt;

	/**
	 * ���彨��
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
