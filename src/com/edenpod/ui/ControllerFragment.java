package com.edenpod.ui;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.edenpod.R;
import com.edenpod.adapters.EdenpodPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ControllerFragment extends Fragment{
	private ActionBar mActionBar;
	private ViewPager mPager;
	private Tab tab;

/*	@Override
	public SherlockFragmentActivity getSherlockActivity() {
		return super.getSherlockActivity();
	}*/

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.edenpod_picture_list, container, false);
		mActionBar = getSupportActionBar();
		// Locate ViewPager in activity_main.xml
		mPager = (ViewPager) view.findViewById(R.id.pager);

		// Activate Fragment Manager
		FragmentManager fm = getFragmentManager();

		// Capture ViewPager page swipes
		ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				// Find the ViewPager Position
				getActivity().getActionBar().setSelectedNavigationItem(position);
				//mActionBar.setSelectedNavigationItem(position);
			}
		};

		mPager.setOnPageChangeListener(ViewPagerListener);
		// Locate the adapter class called ViewPagerAdapter.java
		EdenpodPagerAdapter viewpageradapter = new EdenpodPagerAdapter(fm);
		// Set the View Pager Adapter into ViewPager
		mPager.setAdapter(viewpageradapter);

		// Capture tab button clicks
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab,
					android.support.v4.app.FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabUnselected(Tab tab,
					android.support.v4.app.FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabReselected(Tab tab,
					android.support.v4.app.FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};

		// Create first Tab
		tab = mActionBar.newTab().setText(getResources().getString(R.string.TAB1)).setTabListener(tabListener);
		mActionBar.addTab(tab);

		// Create second Tab
		tab = mActionBar.newTab().setText(getResources().getString(R.string.TAB2)).setTabListener(tabListener);
		mActionBar.addTab(tab);
		return view;
	}

	private ActionBar getSupportActionBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		setUserVisibleHint(true);
	}

}
