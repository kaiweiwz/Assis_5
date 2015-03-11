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
 * 首先尝试获取GPS卫星信号, 若为空则调用A-GPS基站信息定位, 将获取到的经纬度信息广播
 * 
 * @author Administrator
 * 
 */
public class GPSService extends Service {

	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener();

	// 获取的纬度信息
	private double latitude;

	// 获取的经度信息
	private double longitude;

	// 第一次创建时调用的方法
	@Override
	public void onCreate() {
		super.onCreate();
		// 初始化定位参数
		init();
		start();
	}

	private void init() {
		mLocationClient = new LocationClient(getApplicationContext());
		mLocationClient.registerLocationListener(myListener); // 注册监听函数
		// 创建定位属性配置类
		LocationClientOption option = new LocationClientOption();
		// 设置定位模式
		option.setLocationMode(LocationMode.Battery_Saving);
		// 设置定位间隔时间
		option.setScanSpan(8000);
		mLocationClient.setLocOption(option);
	}

	private void start() {
		// 启动baidu定位SDK
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

	// 回调获取定位信息
	public class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				return;
			}
			// 设定经度
			setLongitude(location.getLongitude());
			// 设定纬度
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
