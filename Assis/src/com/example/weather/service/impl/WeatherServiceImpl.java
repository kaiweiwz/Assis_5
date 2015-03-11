package com.example.weather.service.impl;

import java.io.InputStream;
import java.util.List;
import android.os.Handler;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.constants.CommonContants;
import com.example.utils.convert.StreamUtils;
import com.example.utils.http.HttpUtils;
import com.example.weather.constants.WeatherContants;
import com.example.weather.model.BaiduWeatherModel;
import com.example.weather.service.WeatherService;

public class WeatherServiceImpl implements WeatherService {

    
	@Override
	public void getBaiduWeatherModel(String location, final WeatherServiceCallBack weatherServiceCallBack) {
		final String path = WeatherContants.PATH + WeatherContants.LOCATION
				+ location + WeatherContants.OUTPUT_TYPE + CommonContants.JSON
				+ WeatherContants.AK+"&mcode=74:78:DB:DF:F9:B5:FC:BE:AB:20:63:FF:19:E2:95:AC:10:52:87:5F;com.example.assis";
		// 用于子线程与主线程通信的Handler
		final Handler mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				//将msg转换为BaiduWeatherModel 回调
				weatherServiceCallBack.callBack((BaiduWeatherModel)msg.obj);
			}
		};
		// 开启线程去访问WebService
		CommonContants.EXECUTOR_SERVICE.submit(new Runnable() {
			@Override
			public void run() {
				BaiduWeatherModel baiduWeatherModel = null;
				try {
					// 通过百度天气URL获取输入流
					InputStream inputStream = HttpUtils.getInputStreamByHttpURL(path);
					String baiduWeatherJsonString = StreamUtils.inputStream2String(inputStream);
					JSONObject jsonObject = JSON.parseObject(baiduWeatherJsonString);
					List<BaiduWeatherModel> listBaiduModel = JSON.parseArray(jsonObject.getString("results"),
							BaiduWeatherModel.class);
					baiduWeatherModel = listBaiduModel.get(0);
				} finally {
					// 将获取的消息利用Handler发送到主线程
					mHandler.sendMessage(mHandler.obtainMessage(0, baiduWeatherModel));
				}
			}
		});
	}
	
	public interface WeatherServiceCallBack{
		public void callBack(BaiduWeatherModel baiduWeatherModel);
	}

}


