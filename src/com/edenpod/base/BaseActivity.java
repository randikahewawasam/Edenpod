package com.edenpod.base;

import com.actionbarsherlock.app.SherlockActivity;
import com.edenpod.EdenpodLogin;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public abstract class BaseActivity extends SherlockActivity{
	protected Handler uiUpdateHandler;
	private Thread refreshThread = null;
	public static Context currentContext;
	protected abstract void initializeUI();
	protected abstract void refreshUI();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		uiUpdateHandler = new Handler();
		initializeUI();	
	}

	protected void refreshViewInTheUIThread() {
		uiUpdateHandler.post(new Runnable() {
			@Override
			public void run() {						
				refreshUI();				
			}
		});
	}


	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}


	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	@TargetApi (11)
	protected void hideActionbar() {
		ActionBar edenpodActionbar = getActionBar();
		edenpodActionbar.hide();
	}

}
