package com.example.weather.service;

import java.io.InputStream;
import java.util.List;
import android.os.Handler;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.assis_3.util.HttpUtils;
import com.example.assis_3.util.StreamUtils;
import com.example.weather.contants.CommonContants;
import com.example.weather.contants.WeatherContants;
import com.example.weather.model.BaiduWeatherModel;

public class WeatherServiceImpl implements WeatherService {

    
	@Override
	public void getBaiduWeatherModel(String location, final WeatherServiceCallBack weatherServiceCallBack) {
		final String path = WeatherContants.PATH + WeatherContants.LOCATION
				+ location + WeatherContants.OUTPUT_TYPE + CommonContants.JSON
				+ WeatherContants.AK+"&mcode=4C:7E:55:BC:0C:2F:71:91:78:B1:01:E6:CC:B5:60:CE:EE:9F:CC:9D;com.example.assis_3";
		final Handler mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				weatherServiceCallBack.callBack((BaiduWeatherModel)msg.obj);
			}
		};
		CommonContants.EXECUTOR_SERVICE.submit(new Runnable() {
			@Override
			public void run() {
				BaiduWeatherModel baiduWeatherModel = null;
				try {
					InputStream inputStream = HttpUtils.getInputStreamByHttpURL(path);
					String baiduWeatherJsonString = StreamUtils.inputStream2String(inputStream);
					JSONObject jsonObject = JSON.parseObject(baiduWeatherJsonString);
					List<BaiduWeatherModel> listBaiduModel = JSON.parseArray(jsonObject.getString("results"),
							BaiduWeatherModel.class);
					baiduWeatherModel = listBaiduModel.get(0);
				} finally {
					mHandler.sendMessage(mHandler.obtainMessage(0, baiduWeatherModel));
				}
			}
		});
	}
	
	public interface WeatherServiceCallBack{
		public void callBack(BaiduWeatherModel baiduWeatherModel);
	}

}


