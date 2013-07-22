package com.edenpod.connection;

import java.net.URL;
import com.edenpod.common.Constants;
import com.edenpod.common.EdenpodApplication;
import com.edenpod.common.SharedMethods;
import com.edenpod.managers.FlickrManager;
import com.gmail.yuyang226.flickr.Flickr;
import com.gmail.yuyang226.flickr.auth.Permission;
import com.gmail.yuyang226.flickr.oauth.OAuthToken;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

public class EdenpodConnection extends AsyncTask<Void, Integer, String>{
	
	private static final Uri OAUTH_CALLBACK_URI = Uri.parse(Constants.EDENPOD_FLICKR_SCHEME
			+ "://oauth");
	private Context context;
	
	public EdenpodConnection(Context ctx) {
		// TODO Auto-generated constructor stub
		this.context = ctx;
	}

	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		try {
			Flickr f = FlickrManager.getSharedInstance().getFlickr();
			OAuthToken oauthToken = f.getOAuthInterface().getRequestToken(
					OAUTH_CALLBACK_URI.toString());
			
			
			Activity activity = (Activity) context;
			EdenpodApplication edenApp = (EdenpodApplication) activity.getApplication();
			edenApp.saveFlickrData(oauthToken.getOauthTokenSecret(), oauthToken.getOauthToken());
			URL oauthUrl = f.getOAuthInterface().buildAuthenticationUrl(
					Permission.WRITE, oauthToken);
			return oauthUrl.toString();
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null && !result.startsWith("error") ) {
			context.startActivity(new Intent(Intent.ACTION_VIEW, Uri
					.parse(result)));
		} else {
			SharedMethods.logError("Error : "+result);
			Toast.makeText(context, result, Toast.LENGTH_LONG).show();
		}
	}

}
