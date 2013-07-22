package com.edenpod.common;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class EdenpodApplication extends Application{
	private String flickrToken;
	private String flickrTokenScret;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	public String getFlickrToken() {
		SharedPreferences sharedPreferance = getSharedPreferences(Constants.FLICKR_SHARED_PREF_NAME,
				Context.MODE_APPEND);
		flickrToken = sharedPreferance.getString(Constants.FLICKR_TOKEN, null);
		return flickrToken;
	}

	public String getFlickrTokenScret() {
		SharedPreferences sharedPreferance = getSharedPreferences(Constants.FLICKR_SHARED_PREF_NAME,
				Context.MODE_APPEND);
		flickrToken = sharedPreferance.getString(Constants.FLICKR_TOKEN_SECRET, null);
		return flickrTokenScret;
	}
	
	
	public void saveFlickrData(String tokenSecrent,String token) {
		SharedPreferences sharedPreferance = getSharedPreferences(Constants.FLICKR_SHARED_PREF_NAME,
				Context.MODE_PRIVATE);
		Editor editor = sharedPreferance.edit();
		editor.putString(Constants.FLICKR_TOKEN_SECRET, tokenSecrent);
		editor.putString(Constants.FLICKR_TOKEN, token);
		editor.commit();
	}
}
