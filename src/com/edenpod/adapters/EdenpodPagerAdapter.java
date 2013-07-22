package com.edenpod.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edenpod.ui.EdenpodPhotos;
import com.edenpod.ui.EdenpodUploder;

public class EdenpodPagerAdapter extends FragmentPagerAdapter{

	final int PAGE_COUNT = 2;

	public EdenpodPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			EdenpodPhotos fragmenttab1 = new EdenpodPhotos();
			return fragmenttab1;
		case 1:
			EdenpodUploder fragmenttab2 = new EdenpodUploder();
			return fragmenttab2;
		}
		return null;
	}
}
