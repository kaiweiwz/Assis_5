package com.example.assis_3.adapter;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragments;
	private FragmentManager fm;
	
    private String [] titles = null;
    
	public NewsFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fm = fm;
	}

	public NewsFragmentPagerAdapter(FragmentManager fm,
			List<Fragment> fragments, String [] titles) {
		super(fm);
		this.fm = fm;
		this.fragments = fragments;
		this.titles = titles;
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}
	
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	public void setFragments(ArrayList<Fragment> fragments) {
		if (this.fragments != null) {
			FragmentTransaction ft = fm.beginTransaction();
			for (Fragment f : this.fragments) {
				ft.remove(f);
			}
			ft.commit();
			ft = null;
			fm.executePendingTransactions();
		}
		this.fragments = fragments;
		notifyDataSetChanged();
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		Object obj = super.instantiateItem(container, position);
		return obj;
	}

}
