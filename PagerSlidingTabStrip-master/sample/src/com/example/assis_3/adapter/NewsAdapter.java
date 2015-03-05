package com.example.assis_3.adapter;

import com.example.assis_3.fragment.NewsFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NewsAdapter extends FragmentPagerAdapter {
	
    protected static final String[] CONTENT = new String[] { "This", "Is", "A", "Test", };
    
	public NewsAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return CONTENT[position];
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return CONTENT.length;
	}


	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return  NewsFragment.newInstance(position);
	}


}
