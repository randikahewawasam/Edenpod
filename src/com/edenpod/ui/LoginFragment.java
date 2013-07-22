package com.edenpod.ui;

import com.edenpod.R;
import com.edenpod.common.Constants;
import com.edenpod.common.EdenpodApplication;
import com.edenpod.common.SharedMethods;
import com.edenpod.connection.EdenpodConnection;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends Fragment{

	/* progress bar and error message*/
	private ViewStub stubErrorMsg;
	private View inflatedErrorMsg;
	private ViewStub stubProgress;	
	private View inflatedProgress;	
	private TextView txtErrorMsg;
	private Button loginButton;
	private boolean isProgressDisplaying;

	/**
	 * the handler.
	 */
	private Handler mHandler = new Handler();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View loginView = inflater.inflate(R.layout.edenpod_login, null);
		loginButton = (Button) loginView.findViewById(R.id.loginBtn);

		/* progress bar/ default error initialization */
		if (stubErrorMsg == null) {
			stubErrorMsg = (ViewStub) loginView.findViewById(R.id.loginStubErrorMsg);
			inflatedErrorMsg = stubErrorMsg.inflate();
			txtErrorMsg = (TextView) inflatedErrorMsg.findViewById(R.id.loginTVError);
		}

		if (stubProgress == null) {
			stubProgress = (ViewStub) loginView.findViewById(R.id.loginStubProgress);
			inflatedProgress = stubProgress.inflate();
			int x = (isProgressDisplaying)?View.VISIBLE:View.GONE;
			inflatedProgress.setVisibility(x);
		}
		buttonClickListeners();
		return loginView;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		inflatedProgress.setVisibility(View.GONE);
		SharedMethods.logError("Returned");
		EdenpodApplication app = (EdenpodApplication) getActivity().getApplication();
		if(app.getFlickrToken() != null && app.getFlickrTokenScret() != null){
			FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			fm.addOnBackStackChangedListener(new OnBackStackChangedListener() {
				@Override
				public void onBackStackChanged() {
					
				}
			});
		}
	}

	private void buttonClickListeners() {
		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EdenpodApplication app = (EdenpodApplication) getActivity().getApplication();
				if(app.getFlickrToken() == null && app.getFlickrTokenScret() == null){
					inflatedProgress.setVisibility(View.VISIBLE);
					EdenpodConnection edConnection = new EdenpodConnection(getActivity());
					edConnection.execute();
				}else{
					FragmentManager fm = getFragmentManager();
					FragmentTransaction ft = fm.beginTransaction();
					fm.addOnBackStackChangedListener(new OnBackStackChangedListener() {
						@Override
						public void onBackStackChanged() {
							
						}
					});
				}
			}
		});
	}
}
