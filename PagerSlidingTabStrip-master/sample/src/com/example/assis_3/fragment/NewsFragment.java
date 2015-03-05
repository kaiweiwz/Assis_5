package com.example.assis_3.fragment;


import com.astuetz.viewpager.extensions.sample.R;
import com.astuetz.viewpager.extensions.sample.SuperAwesomeCardFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsFragment extends Fragment {

	private Activity mActivity;

	private static final String ARG_POSITION = "position";

	private int position;

	public static NewsFragment newInstance(int position) {
		NewsFragment mNewsFragment = new NewsFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		mNewsFragment.setArguments(b);
		return mNewsFragment;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.mActivity = activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.news_list_view, container,
				false);
		TextView textView = (TextView) rootView
				.findViewById(R.id.news_text_view);
		textView.setText("Text");
		return rootView;
	}
}
