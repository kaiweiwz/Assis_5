package com.example.assis.tab;

import com.example.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AlarmFragment extends Fragment {
	/**param
	 * inflater: 用来装载进入fragment中的布局文件
	 * container: fragment标签对应的父标签对象的ViewGroup对象
	 * savedInstanceState: 用来保存fragment的状态
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.alarm_fragment, null);
		
		return null;
	}
}
