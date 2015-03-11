package com.example.service.gps_service;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.example.common.constants.CommonContants;
import com.example.service.constants.ServiceConstants;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * ���ȳ��Ի�ȡGPS�����ź�, ��Ϊ�������A-GPS��վ��Ϣ��λ, ����ȡ���ľ�γ����Ϣ�㲥
 * 
 * @author Administrator
 * 
 */
public class GPSService extends Service {

	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener();

	// ��ȡ��γ����Ϣ
	private double latitude;

	// ��ȡ�ľ�����Ϣ
	private double longitude;

	// ��һ�δ���ʱ���õķ���
	@Override
	public void onCreate() {
		super.onCreate();
		// ��ʼ����λ����
		init();
		start();
	}

	private void init() {
		mLocationClient = new LocationClient(getApplicationContext());
		mLocationClient.registerLocationListener(myListener); // ע���������
		// ������λ����������
		LocationClientOption option = new LocationClientOption();
		// ���ö�λģʽ
		option.setLocationMode(LocationMode.Battery_Saving);
		// ���ö�λ���ʱ��
		option.setScanSpan(8000);
		mLocationClient.setLocOption(option);
	}

	private void start() {
		// ����baidu��λSDK
	    CommonContants.EXECUTOR_SERVICE.submit(new Runnable(){
			@Override
			public void run() {
				mLocationClient.start();
			}
	    });
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	// �ص���ȡ��λ��Ϣ
	public class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				return;
			}
			// �趨����
			setLongitude(location.getLongitude());
			// �趨γ��
			setLatitude(location.getLatitude());
			StringBuilder sBuilder = new StringBuilder(ServiceConstants.INT_64);
			sBuilder.append(String.valueOf(longitude));
			sBuilder.append(",");
			sBuilder.append(String.valueOf(latitude));
			Intent intent = new Intent();
			intent.setAction(ServiceConstants.LOCATION_BROADCAST_ACTION);
			intent.putExtra("location", sBuilder.toString());
			sendBroadcast(intent);
		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
