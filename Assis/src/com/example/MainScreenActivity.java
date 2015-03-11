package com.example;


import com.example.assis.tab.AlarmFragment;
import com.example.assis.tab.RemindFragment;
import com.example.assis.tab.TraceFragment;
import com.example.assis.tab.TabListener;


import android.support.v4.view.ViewPager;

import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainScreenActivity extends Activity{

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;
	private SectionsPagerAdapter mViewPagerAdapter;
	
	private static final int FRAG_SUM = 3;
	private static final int ALARM = 0;
	private static final int REMIND = 1;
	private static final int TRACE = 2;
	
    private AlarmFragment  alarmFragment;
    private RemindFragment remindFragment;
    private TraceFragment traceFragment;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		initFragment();
		initActionBar();
		initViewPager();
	}

	private void initFragment() {
		alarmFragment = new AlarmFragment();
		remindFragment = new RemindFragment();
		traceFragment = new TraceFragment();
	}

	@SuppressWarnings("deprecation")
	private void initActionBar() {
		// Set up the action bar.
		final ActionBar actionBar = getActionBar();	
		//����title��
		actionBar.setDisplayShowTitleEnabled(false);
		//����ͼ��
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Tab tab = actionBar
				.newTab()
				.setText(R.string.action_alarm)
				.setTabListener(
						new TabListener<AlarmFragment>(this, "alarm",
								AlarmFragment.class));
		actionBar.addTab(tab);
		tab = actionBar
				.newTab()
				.setText(R.string.action_remind)
				.setTabListener(
						new TabListener<RemindFragment>(this, "remind",
								RemindFragment.class));
		actionBar.addTab(tab);
		tab = actionBar
				.newTab()
				.setText(R.string.action_trace)
				.setTabListener(
						new TabListener<TraceFragment>(this, "trace",
								TraceFragment.class));
		actionBar.addTab(tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//����Menu��Դ
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}

	 private void initViewPager() {  
	        mViewPagerAdapter = new SectionsPagerAdapter(getFragmentManager());  
	        mViewPager = (ViewPager)this.findViewById(R.id.pager);  
	        mViewPager.setAdapter(mViewPagerAdapter);  
	        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {  
	        	
	            @Override  
	            public void onPageSelected(int position) {  
	                final ActionBar actionBar = getActionBar();  
	                actionBar.setSelectedNavigationItem(position);  
	            }  
	              
	            @Override  
	            public void onPageScrollStateChanged(int state) {  
	                switch(state) {  
	                //���ڻ���
	                    case ViewPager.SCROLL_STATE_IDLE:  
	                        //TODO  
	                        break;  
	                //��������ֹͣ
	                    case ViewPager.SCROLL_STATE_DRAGGING:  
	                        //TODO  
	                        break;
	                //������ȫֹͣ
	                    case ViewPager.SCROLL_STATE_SETTLING:  
	                        //TODO  
	                        break;  
	                    default:  
	                        //TODO  
	                        break;  
	                }  
	            }  
	        });  
	    }  
	
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			switch (position) {
			case ALARM:
				return  alarmFragment;
			case REMIND:
				return  remindFragment;
			case TRACE:
			    return  traceFragment;
			}
			throw new IllegalStateException("No fragment at position: "
					+ position);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return FRAG_SUM;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			String tabLabel = null;
			switch (position) {
			case ALARM:
				tabLabel = getString(R.string.action_alarm);
				break;
			case REMIND:
				tabLabel = getString(R.string.action_remind);
				break;
			case TRACE:
				tabLabel = getString(R.string.action_trace);
				break;
			}
			return tabLabel;
		}
	}



}
