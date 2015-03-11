package com.example.assis_3.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.example.weather.contants.CommonContants;


/**
 * 
 * @author Administrator
 * 
 */
public class StreamUtils {

	
	public static String inputStream2String(InputStream inputStream) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		byte[] buffer = new byte[CommonContants.INT_1024];
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos.toString();
	}
}
