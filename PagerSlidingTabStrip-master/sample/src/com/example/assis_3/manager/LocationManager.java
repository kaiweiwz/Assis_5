package com.example.assis_3.manager;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.example.weather.contants.ServiceConstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LocationManager {

	public LocationClient mLocationClient = null;
	public LocationClientOption mLocationClientOption = null;
	public BDLocationListener myListener = new MyLocationListener();

	private Activity mActivity;

	public LocationManager() {
	}

	public LocationManager(Activity mActivity) {
		this.mActivity = mActivity;
	}

	public void init() {
		initLocationOption();
		initLocationClient();
	}

	private void initLocationClient() {
		mLocationClient = new LocationClient(mActivity);
		mLocationClient.setLocOption(mLocationClientOption);
		mLocationClient.registerLocationListener(myListener);
	}

	private void initLocationOption() {
		mLocationClientOption = new LocationClientOption();
		// 设置定位模式
		mLocationClientOption.setLocationMode(LocationMode.Battery_Saving);
		// 设置定位间隔时间
		mLocationClientOption.setScanSpan(8000);
	}

	public void startLocationService() {
		if (mLocationClient.isStarted()) {
			mLocationClient.stop();
		}
		mLocationClient.start();
		Log.i("location",   "location is starting<***************>");
	}

	// 回调获取定位信息
	public class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				return;
			}
			Intent intent = new Intent();
			intent.setAction(ServiceConstants.LOCATION_BROADCAST_ACTION);
			Bundle bundle = new Bundle();
			bundle.putParcelable("location", location);
			intent.putExtras(bundle);
			Log.i("location", location.getStreet() + "<***************>");
			mActivity.sendBroadcast(intent);
		}

	}

}
