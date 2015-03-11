package com.example.utils.http;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.common.constants.CommonContants;

/**
 * Http���ʹ�����
 * @author Administrator
 *
 */
public class HttpUtils {
	
	public HttpUtils() {
	}

	public static InputStream getInputStreamByHttpURL(String path){
		InputStream inputStream = null;
		try {
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(8000);
			connection.setDoInput(true);
			int code = connection.getResponseCode();
			if (code == CommonContants.SUCCESS_CODE) {
				inputStream = connection.getInputStream();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}

}
